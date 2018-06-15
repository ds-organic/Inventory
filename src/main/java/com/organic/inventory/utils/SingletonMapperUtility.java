package com.organic.inventory.utils;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public enum SingletonMapperUtility {

    ObjectMapper;
        public static ObjectMapper getObjectMapper(){
        	ObjectMapper mapper=	new ObjectMapper();
        			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            return mapper;
        }
}
