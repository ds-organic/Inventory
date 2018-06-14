package com.organic.inventory.utils;

import java.io.IOException;

import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.search.SearchHit;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class ElasticSearchUtils {
	
	ObjectMapper mapper = SingletonMapperUtility.getObjectMapper();

	public <T> T getObject(SearchResponse response, Class<T> classType)
	{
		for(SearchHit hit:response.getHits().getHits()){
			return getObject(hit, classType);
		}
		return null;
	}
	
	private <T> T getObject(SearchHit hit, Class<T> classType)
	{
		try {
			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			return mapper.readValue(hit.getSourceAsString(), classType);
		} catch (IOException e) {
		}
		return null;
	}
	
}
