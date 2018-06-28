package com.organic.inventory.controller;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.organic.inventory.entity.Product;
import com.organic.inventory.entity.Products;
import com.organic.inventory.entity.UpdateProductRequest;
import com.organic.inventory.svc.InventoryService;


@RestController
@RequestMapping(value = "/")
public class InventoryController {
	
	
	@Autowired
	InventoryService inventoryService;
	
	
	@RequestMapping(value = "/product/loadXmlToES", method = RequestMethod.GET, produces = javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public void loadXmlToElasticSearch(@RequestParam(value = "filePath", required = false) String filePath) {
		
		Products products = null;
		//Read Xml file from the given path
		products = inventoryService.readXmlFile(filePath);
		
		//Load Data Into Elastic Search
		inventoryService.loadDataIntoEs(products);
	   
	}
	
	@RequestMapping(value = "/product/{productId}", method = RequestMethod.GET, produces = javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public Product getProductByProductId(@PathVariable(value = "productId", required = true) String productId) {
		return inventoryService.getProductByProductId(productId);
	}
	
	@RequestMapping(value = "/products/", method = RequestMethod.GET, produces = javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public List<Product> getListOfProducts() {
		return inventoryService.getListOfProducts();
	}
	
	@RequestMapping(value = "/products/", method = RequestMethod.PUT, produces = javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public void updateProductByProductId(@RequestBody UpdateProductRequest updateProductRequest) {
		if(updateProductRequest!=null && StringUtils.isNotEmpty(updateProductRequest.getSkuid())){
			
		}else{
			// Throw Exception
		}
	}

}
