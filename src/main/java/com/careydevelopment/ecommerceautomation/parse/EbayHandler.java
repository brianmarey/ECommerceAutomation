package com.careydevelopment.ecommerceautomation.parse;

import java.util.HashMap;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.careydevelopment.ecommerceautomation.clean.ProductExportFile;
import com.careydevelopment.ecommerceautomation.entity.Category;
import com.careydevelopment.ecommerceautomation.entity.Product;
import com.careydevelopment.ecommerceautomation.service.ProductPersistenceService;
import com.careydevelopment.ecommerceautomation.util.EbayUrlHelper;
import com.careydevelopment.ecommerceautomation.util.UrlHelper;


public class EbayHandler extends BaseHandler {

	private static final Logger LOGGER = LoggerFactory.getLogger(EbayHandler.class);
	
	private static final String VENDOR_NAME = "eBay";
		
	private int totalPages = 0;
	private Category category;
	private String keyword = "";
	private String currentPrice = "";
	private String buyItNowPrice = "";
	
	private HashMap<String,Product> allProducts = new HashMap<String,Product>();
	
	private Float minPrice = null;
	
	private ProductExportFile pef;

	private String content;
	private int counter = 0;
	private String appId;
	private String exclude;
	
	public EbayHandler(Category category, String keyword, String outputFile,String appId,String exclude) {
		this.category = category;
		this.keyword = keyword;
		this.appId = appId;
		
		if (exclude != null) {
			this.exclude = exclude.toLowerCase();	
		}
		
		pef = new ProductExportFile(outputFile, false);					
	}
	

	public Float getMinPrice() {
		return minPrice;
	}


	public void setMinPrice(Float minPrice) {
		this.minPrice = minPrice;
	}


	public void startElement(String uri, String localName, String qName, 
			Attributes attributes) throws SAXException {
	
		if (qName.equals("item")) {
			//System.err.println("creating new product");
			product = new Product();
			product.setProgramName(VENDOR_NAME);
			product.setVendor(VENDOR_NAME);
			product.setCatalogName(VENDOR_NAME);
			product.setInStock("instock");
			//product.setCondition("new");
			product.setAdvertiserCategory(category);
		} 
	}

	
	public void characters(char[] ch, int start, int length) throws SAXException {
		if (content == null) content = String.copyValueOf(ch, start, length).trim();
		else content +=  String.copyValueOf(ch, start, length).trim();
	}
		
	
	public void endElement(String uri, String localName, String qName) 
				throws SAXException {
		
		if (qName.equals("viewItemURL")) {
			content = content.replace("&amp;", "&");
			//System.err.println("URL is " + content);
			product.setBuyUrl(content);
		} else if (qName.equals("currentPrice")) {
			product.setPrice(content);
			currentPrice = content;
			//LOGGER.debug("currentPrice is " + content);
		} else if (qName.equals("buyItNowPrice")) {
			product.setPrice(content);
			buyItNowPrice = content;
			//LOGGER.debug("buyitnow price is " + content);
		} else if (qName.equals("pictureURLLarge")) {
			product.setImageUrl(content);
		} else if (qName.equals("itemId")) {
			product.setSku(content);
		} else if (qName.equals("title")) {
			//System.err.println(content);
			product.setName(content);
			product.setDescription(content);
		} else if (qName.equals("item")) {
			if (product.getName() != null && product.getName().toLowerCase().indexOf("junior") == -1
					&&product.getName().toLowerCase().indexOf("sample") == -1) {
				if (product.getPrice() != null && !product.getPrice().trim().equals("")) {
					
					//keep out lots
					if (product.getName().toLowerCase().indexOf("lot ") == -1) {
						if(exclude == null || product.getName().toLowerCase().indexOf(exclude) == -1) {
							if (!allProducts.keySet().contains(product.getName())) {
								getAdditionalInfo(product.getSku());
								
								if (!currentPrice.equals("") && !buyItNowPrice.equals("")) {
									product.setPrice(buyItNowPrice);
								}
								currentPrice = "";
								buyItNowPrice = "";
								//System.err.println(product.getName());
								
								Float priceF = new Float(product.getPrice());
								
								if (minPrice == null || priceF >= minPrice) {
									pef.writeProduct(product);
									
									if (!allProducts.containsKey(product.getName())) {
										allProducts.put(product.getName(), product);
									}
									counter++;	
								}						
							} else {
								LOGGER.info("Skipping 4");
							}
						} else {
							LOGGER.info("Skipping 3 " + exclude);
						}
					} else {
						LOGGER.debug("Skipping because price is " + product.getPrice() + " " + product.getName());
					}
				} else {
					LOGGER.info("Skipping 2");
				}
			} else {
				LOGGER.info("Skipping 1");
			}
		} else if (qName.equals("findItemsAdvancedResponse")) {
			pef.close(false);
			int prodcount = 0;
			for (Product p : allProducts.values()) {
				//if (prodcount<6) {
				product = p;
				LOGGER.info("Writing " + product.getName() + " " + product.getPrice() + " " + product.getAdvertiserCategory());
				writeToDatabase(p);
				prodcount++;
				//}
			}
		}
		
		content = null;
	}
	
	
	private void writeToDatabase (Product p) {
		try {
			ProductPersistenceService service = new ProductPersistenceService();
			service.saveProduct(product);
		} catch (Exception e) {
			LOGGER.error("Can't write product " + p.getName());
			e.printStackTrace();
		}
	}
	
	
	public void getAdditionalInfo(String sku) {
		try {
			String url = EbayUrlHelper.getSpecificItemUrl(sku,appId);
			LOGGER.info("Specific item url is " + url);
			SAXParserFactory parserFactor = SAXParserFactory.newInstance();
			SAXParser parser = parserFactor.newSAXParser();
			EbayItemHandler handler = new EbayItemHandler(product);
			
			InputSource ins = UrlHelper.getInputSource(url);
		    ins.setEncoding("US-ASCII");
			
			parser.parse(ins, handler); 
			
			String brand = handler.getBrand();
			/*String sizes = handler.getSizes();
			String colors = handler.getColors();
			
			product.setSizes(sizes);
			product.setColors(colors);*/
			//product.setManufacturer(brand);
			
			//System.err.println("Brand is " + product.getManufacturer());
			
			if (product.getImageUrl() == null || product.getImageUrl().trim().equals("")) {
				//System.err.println("Setting img url to " + handler.getImageUrl() + " from item read");
				product.setImageUrl(handler.getImageUrl());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public int getTotalPages() {
		return totalPages;
	}
	
}
