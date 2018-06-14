package com.organic.inventory.querybuilder;

import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.client.Requests;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.organic.inventory.datamodel.ProductModel;
import com.organic.inventory.utils.SingletonMapperUtility;

@Component
public class QueryBuilderHelper {

	ObjectMapper mapper = SingletonMapperUtility.getObjectMapper();

	// Index Query to insert ProductModel into Elastic Search
	public IndexRequest indexRequestForProducts(ProductModel productModel) {
		String productModelJsonString;
		IndexRequest updateRequestForProductModel = null;
		try {
			productModelJsonString = mapper.writeValueAsString(productModel);
			updateRequestForProductModel = Requests.indexRequest("cat-product");
			updateRequestForProductModel.type("models");
			updateRequestForProductModel.id(productModel.getSkuid());
			updateRequestForProductModel.source(productModelJsonString, XContentType.JSON);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return updateRequestForProductModel;
	}

	//SearchQuery to search Product by Product Id
	public SearchRequest searchQueryForProductById(String productId) {
		SearchRequest searchRequest = new SearchRequest("cat-product");
		try {
			SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
			BoolQueryBuilder qb = QueryBuilders.boolQuery();
			qb.filter(QueryBuilders.termQuery("skuId", productId));
			sourceBuilder.query(qb);
			searchRequest.source(sourceBuilder);
		} catch (Exception e) {
			// Need to throw exception
		}
		return searchRequest;
	}

}
