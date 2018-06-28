package com.organic.inventory.svc.impl;

import static org.elasticsearch.common.xcontent.XContentFactory.jsonBuilder;

import java.io.File;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.apache.http.entity.ContentType;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HTTP;
import org.dozer.DozerBeanMapper;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.organic.inventory.dao.InventoryDao;
import com.organic.inventory.datamodel.ProductModel;
import com.organic.inventory.entity.Product;
import com.organic.inventory.entity.Products;
import com.organic.inventory.entity.UpdateProductRequest;
import com.organic.inventory.querybuilder.QueryBuilderHelper;
import com.organic.inventory.svc.InventoryService;
import com.organic.inventory.utils.ResponseMappingHelper;

@Component("inventoryService")
public class InventoryServiceImpl implements InventoryService{

	@Autowired
	DozerBeanMapper beanMapper;
	
	@Autowired
	RestHighLevelClient highLevelRestclient;
	
	@Autowired
	QueryBuilderHelper builderHelper; 
	
	@Autowired
	InventoryDao inventoryDao;
	
	@Autowired
	ResponseMappingHelper responseMapper;

	@Override
	public Products readXmlFile(String filePath) {
		Products products = null;
		JAXBContext jaxbContext;
		try {
			jaxbContext = JAXBContext.newInstance(Products.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		    products = (Products) jaxbUnmarshaller.unmarshal( new File(filePath));
	
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return products;
	}

	
	@Override
	public void loadDataIntoEs(Products products) {
		for (Product product : products.getProducts()) {
			ProductModel productModel = beanMapper.map(product,
					ProductModel.class);
				IndexRequest updateRequestForProductModel = builderHelper.indexRequestForProducts(productModel);
				IndexResponse updateResponseForIlsProms = inventoryDao.insertProductModelIntoDataSource(updateRequestForProductModel);
				System.out.println("Successfully Loaded: "+updateResponseForIlsProms);
			}
	}

	
	@Override
	public Product getProductByProductId(String productId) {
		SearchRequest searchRequest = builderHelper.searchQueryForProductById(productId);
		SearchResponse productResponse = inventoryDao.getProductResponseFromDataSource(searchRequest);
		return responseMapper.getProductFromJson(productResponse);
	}


	@Override
	public List<Product> getListOfProducts() {
		SearchRequest searchRequest = builderHelper.searchQueryForAllProducts();
		SearchResponse productResponse = inventoryDao.getProductResponseFromDataSource(searchRequest);
		return responseMapper.getProductListFromJson(productResponse);
	}
	
	@Override
	public void updateProductByProductId(UpdateProductRequest updateProductRequest) {
		/*UpdateRequest updateRequest = builderHelper.updateRequestForProducts(updateProductRequest);
		UpdateResponse updateResponse = restClient.update(updateRequest,new BasicHeader(HTTP.CONTENT_TYPE, ContentType.APPLICATION_JSON.toString()));
		UpdateRequest updateRequest22 = new UpdateRequest(Constants.CATALOG_VERSION.get(), Constants.ES_DOCUMENTTYPE_MODELS, bundleId)
		        .doc(jsonBuilder()
		            .startObject()
		            .endObject());

		
		restClient.update(updateRequest22);*/
	}
	
	
}
