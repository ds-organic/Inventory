package com.organic.inventory.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;

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
	
	public <T> List<T> getListOfObject(SearchResponse response, Class<T> classType)
	{
		List<T> res=new ArrayList<>();
		List<SearchHit> searchHitList = new ArrayList<>(Arrays.asList(response.getHits().getHits()));
		CompletableFuture<List<T>> future0 = getCompatibleFutureObject(searchHitList,
				new ArrayList<T>(), classType);
		try {
			res = future0.get();
		} catch (Exception e) {
		}
		return res;
	}
	
	private <U> CompletableFuture<List<U>> getCompatibleFutureObject(List<SearchHit> searchHitList,
			List<U> result, Class<U> classType) 
	{
		return CompletableFuture.supplyAsync(() -> {
			searchHitList.forEach(hit -> result.add(getObject(hit, classType)));
			return result;
		});
	}
	
}
