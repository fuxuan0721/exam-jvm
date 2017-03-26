package com.fuxuan.utils;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

/**
 * 
 * @author Fuxuan
 *
 */
public class JsonUtils {

    private static final ObjectMapper MAPPER = new ObjectMapper();
    private static final XmlMapper XMLMAPPER = new XmlMapper();

    public static String objectToJson(Object data) {
    	try {
			String string = MAPPER.writeValueAsString(data);
			return string;
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
    	return null;
    }
    
    public static <T> T jsonToPojo(String jsonData, Class<T> beanType) {
        try {
            T t = MAPPER.readValue(jsonData, beanType);
            return t;
        } catch (Exception e) {
        	e.printStackTrace();
        }
        return null;
    }

    public static <T> T xmlToBean(String xml, Class<T> beanType) throws JsonParseException, JsonMappingException, IOException{
        T obj = XMLMAPPER.readValue(xml, beanType);
        return obj;
    }

    public static <T> String beanToXml(T bean) throws JsonProcessingException {
        String string = XMLMAPPER.writeValueAsString(bean);
        return string;
    }
    
}
