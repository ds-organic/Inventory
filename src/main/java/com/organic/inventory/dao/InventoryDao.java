package com.organic.inventory.dao;

import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;

public interface InventoryDao {

	IndexResponse insertProductModelIntoDataSource(IndexRequest updateRequestForProductModel);

	SearchResponse getProductResponseFromDataSource(SearchRequest searchRequest);

}
