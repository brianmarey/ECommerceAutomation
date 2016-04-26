package com.careydevelopment.ecommerceautomation.util;

import com.careydevelopment.ecommerceautomation.entity.Attribute;
import com.careydevelopment.ecommerceautomation.entity.AttributeValue;

public class AttributeHelper {

	public static final AttributeValue getAttributeValue(String name, String value) {
		Attribute att = new Attribute(name);
		AttributeValue val = new AttributeValue(value);
		val.setAttribute(att);
		return val;
	}
}
