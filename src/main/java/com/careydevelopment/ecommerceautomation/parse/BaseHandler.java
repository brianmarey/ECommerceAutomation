package com.careydevelopment.ecommerceautomation.parse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.helpers.DefaultHandler;

import com.careydevelopment.ecommerceautomation.entity.AttributeValue;
import com.careydevelopment.ecommerceautomation.entity.Product;
import com.careydevelopment.ecommerceautomation.service.AttributeValueService;
import com.careydevelopment.ecommerceautomation.service.EcommerceServiceException;
import com.careydevelopment.ecommerceautomation.util.AttributeHelper;

public abstract class BaseHandler extends DefaultHandler {
	private static final Logger LOGGER = LoggerFactory.getLogger(BaseHandler.class);
	
	protected Product product;
	
	protected void addAttribute(String att, String value) {
		if (value.indexOf(",") > -1) {
			String[] vals = value.split(",");
			for (String val : vals) {
				persistAttributeIfNecessary(att,val);
			}
		} else {
			persistAttributeIfNecessary(att,value);
		}
	}

	
	protected void persistAttributeIfNecessary(String att, String value) {
		LOGGER.info("Adding " + att + " " + value);
		
		if (value.indexOf(",") == -1) {
			AttributeValue colAtt = AttributeHelper.getInstance().getAttributeValue(att,value);
			if (colAtt == null) {
				LOGGER.info(colAtt + " does not exist - adding");
				
				try {
					AttributeValueService service = new AttributeValueService();
					colAtt = service.findAttributeValue(colAtt);
				} catch (EcommerceServiceException e) {
					LOGGER.error("Problem persisting attribute " + value,e);
				}				
			}
			
			product.getAttributes().add(colAtt);
		}
	}
	
}
