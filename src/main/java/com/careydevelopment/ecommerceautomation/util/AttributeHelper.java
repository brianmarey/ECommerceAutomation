package com.careydevelopment.ecommerceautomation.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.careydevelopment.ecommerceautomation.entity.Attribute;
import com.careydevelopment.ecommerceautomation.entity.AttributeValue;
import com.careydevelopment.ecommerceautomation.service.AttributeValueService;

public class AttributeHelper {
	private static final Logger LOGGER = LoggerFactory.getLogger(AttributeHelper.class);
	
	private Map<String,List<AttributeValue>> attMap = new HashMap<String,List<AttributeValue>>();
	
	private static AttributeHelper INSTANCE;
	
	private AttributeHelper(){}
	
	public static AttributeHelper getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new AttributeHelper();
		}
		
		return INSTANCE;
	}
	
	
	public AttributeValue getAttributeValue(String name, String value) {
		List<AttributeValue> list = attMap.get(name);
		AttributeValue val = null;
		
		if (list != null) {
			for (AttributeValue av : list) {
				if (av.getName().equals(value)) {
					val = av;
					break;
				}
			}
		}

		return val;
	}
	
	
	public void populateMap(String ref) {
		AttributeValueService service = new AttributeValueService();
		List<AttributeValue> list = service.fetchAllAttributeValuesByName(ref);
		attMap.put(ref, list);
	}
	
}
