package com.organic.inventory.dao.impl;

import java.io.IOException;

import org.apache.http.entity.ContentType;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HTTP;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.organic.inventory.dao.InventoryDao;

@Component
public class InventoryDaoImpl implements InventoryDao {

	@Autowired
	RestHighLevelClient highLevelRestclient;

	@Override
	public IndexResponse insertProductModelIntoDataSource(IndexRequest updateRequestForProductModel) {
		IndexResponse updateResponseForIlsProms = null;
		try {
			updateResponseForIlsProms = highLevelRestclient.index(updateRequestForProductModel,
					new BasicHeader(HTTP.CONTENT_TYPE, ContentType.APPLICATION_JSON.toString()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return updateResponseForIlsProms;
	}

	@Override
	public SearchResponse getProductResponseFromDataSource(SearchRequest searchRequest) {
		SearchResponse response = null;
		try {
			response = highLevelRestclient.search(searchRequest,
					new BasicHeader(HTTP.CONTENT_TYPE, ContentType.APPLICATION_JSON.toString()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}

}
