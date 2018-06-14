package com.organic.inventory.utils;

import org.elasticsearch.action.search.SearchResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.organic.inventory.entity.Product;

@Component
public class ResponseMappingHelper {

	@Autowired
	ElasticSearchUtils elasticSearchUtils;
	
	
	public Product getProductFromJson(SearchResponse searchResponse) {

		Product product = new Product();
		try {
			
			product = elasticSearchUtils.getObject(searchResponse, Product.class);
		} catch (Exception e) {
		}
		return product;
	
	}
}
