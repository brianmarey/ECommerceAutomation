package com.careydevelopment.ecommerceautomation.parse;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.careydevelopment.ecommerceautomation.util.ColorTranslator;
import com.careydevelopment.ecommerceautomation.util.SizeTranslator;

public class EbayItemHandler extends DefaultHandler {
	
	private String brand;
	private String color;
	private String size;
	
	private boolean inBrand = false;
	private boolean inColor = false;
	private boolean inSize = false;
	private String imageUrl = "";
	private boolean hasImage = false;
	private String content;
	
	public EbayItemHandler() {
		//super (db);
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
				color = ColorTranslator.getColor(content);
				inColor = false;
			} else if (inSize) {
				size = SizeTranslator.getSize(content);
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

	public String getColors() {
		return color;
	}
	
	public String getSizes() {
		return size;
	}
	
	public String getImageUrl() {
		return imageUrl;
	}
}

