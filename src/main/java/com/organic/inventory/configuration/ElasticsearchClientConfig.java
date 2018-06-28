package com.organic.inventory.configuration;

import java.io.IOException;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.apache.http.HttpHost;
import org.apache.http.client.config.RequestConfig;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestClientBuilder.RequestConfigCallback;
import org.elasticsearch.client.RestHighLevelClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class ElasticsearchClientConfig {

	private static final Logger logger = LoggerFactory.getLogger(ElasticsearchClientConfig.class);
	
	private RestClient restClient;
	
	private RestHighLevelClient highLevelRestclient;
    
    @PostConstruct
    public void init() throws UnknownHostException, MalformedURLException {
    	/*highLevelRestclient = new RestHighLevelClient(
    	        RestClient.builder(
    	                new HttpHost("localhost", 9200, "http")));*/
    	try {
			InetAddress address = InetAddress.getByName(new URL("https://search-ds-test-env-nan6gniktxmqoo5z5h3ptm72i4.eu-west-1.es.amazonaws.com").getHost());
			highLevelRestclient= new RestHighLevelClient(RestClient.builder(new HttpHost(address, address.getHostName(),-1, "https")));
		} catch (UnknownHostException | MalformedURLException e) {
		}
    }

    @PreDestroy
    public void destroy() throws IOException {
    	restClient.close();
    	highLevelRestclient.close();
        logger.info("Closing Elastic Search Client:::");
    }

    @Bean
	public RestClient getRestClient() {
		return restClient;
	}

    @Bean
	public RestHighLevelClient getHighLevelRestclient() {
		return highLevelRestclient;
	}
	
}
