package com.careydevelopment.ecommerceautomation.parse;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.careydevelopment.ecommerceautomation.entity.AttributeValue;
import com.careydevelopment.ecommerceautomation.entity.Product;
import com.careydevelopment.ecommerceautomation.process.ProductAttributes;
import com.careydevelopment.ecommerceautomation.service.AttributeValueService;
import com.careydevelopment.ecommerceautomation.service.EcommerceServiceException;
import com.careydevelopment.ecommerceautomation.util.AttributeHelper;
import com.careydevelopment.ecommerceautomation.util.ColorTranslator;
import com.careydevelopment.ecommerceautomation.util.SizeTranslator;

public class EbayItemHandler extends BaseHandler {
	private static final Logger LOGGER = LoggerFactory.getLogger(EbayItemHandler.class);
	
	private String brand;
	private List<String> colors = new ArrayList<String>();
	private List<String> sizes = new ArrayList<String>();
	
	
	private boolean inBrand = false;
	private boolean inColor = false;
	private boolean inSize = false;
	private boolean inName = false;
	private String imageUrl = "";
	private boolean hasImage = false;
	private String content;
	
	public EbayItemHandler(Product product) {
		this.product = product;
	}
	
	public void startElement(String uri, String localName, String qName, 
		Attributes attributes) throws SAXException {
		
		
	
	}
	
	public void characters(char[] ch, int start, int length) throws SAXException {
		if (content == null) content = String.copyValueOf(ch, start, length).trim();
		else content +=  String.copyValueOf(ch, start, length).trim();
	}
		
	public void endElement(String uri, String localName, String qName) 
				throws SAXException {
		
		if (qName.equals("Name")) {
			if (content.equals("Brand")) {
				inBrand = true;
			} else if (content.startsWith("Size (")) {
				inSize = true;
			} else if (content.equals("Color")) {
				inColor = true;
			}
		} else if (qName.equals("Value")) {
			if (inBrand) {
				brand = content;
				inBrand = false;
			} else if (inColor) {
				String color = ColorTranslator.getColor(content);
				if (color != null && !colors.contains(color)) {
					colors.add(color);
					addAttribute(ProductAttributes.COLOR,color);
				}
				inColor = false;
			} else if (inSize) {
				String size = SizeTranslator.getSize(content);
				if (size != null && !sizes.contains(size)) {
					sizes.add(size);
					addAttribute(ProductAttributes.SIZE,size);
				}
				inSize = false;
			}
		} else if (qName.equals("PictureURL")) {
			if (!hasImage) {
				imageUrl = content;
				hasImage = true;
			}
		}
		
		content = null;
	}
	
	
	public String getBrand() {
		return brand;
	}
	
	public String getImageUrl() {
		return imageUrl;
	}
}

