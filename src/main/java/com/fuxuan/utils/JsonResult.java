package com.fuxuan.utils;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
/**
 * 
 * @author Fuxuan
 * 
 *
 */
public class JsonResult implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1754719221906733438L;
	public Map<String,Object> json = new HashMap<String,Object>();

	public String setJson(boolean message,Object obj){
		json.put("success", message);
		json.put("entity", obj);
		return JsonUtils.objectToJson(json);
	}
	
	
}
