package com.careydevelopment.ecommerceautomation.parse;

import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.InputSource;

import com.careydevelopment.ecommerceautomation.entity.Category;
import com.careydevelopment.ecommerceautomation.util.AmazonUrlHelper;
import com.careydevelopment.ecommerceautomation.util.Node;
import com.careydevelopment.ecommerceautomation.util.UrlHelper;

public class AmazonParseProcessor {

	private static final Logger LOGGER = LoggerFactory.getLogger(AmazonParseProcessor.class);

	private String brand;
	private String node;
	private Category category;
	private String keyword;
	private String sort;
	private String mustInclude;
	private String outputFile;
	private boolean amazonOnly = true;
	private float minimumPrice = -1f;
	
	private int maxPages = 10;
	
	private Map<String,String> fixedAttributes = new HashMap<String,String>();
	
	public AmazonParseProcessor(String brand, String node, Category category,String keyword,String outputFile) {
		this.brand = brand;
		this.node = node;
		this.category=category;
		this.keyword=keyword;
		this.outputFile = outputFile;
	}
	
	public AmazonParseProcessor(String brand, String node, Category category,String keyword, String sort,String outputFile) {
		this.brand = brand;
		this.node = node;
		this.category=category;
		this.keyword=keyword;
		this.sort = sort;
		this.outputFile = outputFile;
	}
	
	public AmazonParseProcessor(String brand, String node, Category category,String keyword, String sort, String mustInclude,String outputFile) {
		this.brand = brand;
		this.node = node;
		this.category=category;
		this.keyword=keyword;
		this.sort = sort;
		this.mustInclude = mustInclude;
		this.outputFile = outputFile;
	}
	
	
	public void iterateAmazon() {
		try {
			int pageNumber = 1;
			int totalPages = 10;
			
			while (pageNumber < totalPages && pageNumber < maxPages) {
				totalPages = processParse(pageNumber,totalPages);
				pageNumber++;
				
				LOGGER.info(brand + " page number is " + pageNumber + " and totalPages is " + totalPages);
				Thread.sleep(1000);
			}
			
			Thread.sleep(1000);
		} catch (Exception e) {
			LOGGER.error("Problem processing Amazon!",e);
		}		
	}
	
	
	private String getUrl(int pageNumber) {
		AmazonUrlHelper h = new AmazonUrlHelper(brand,node,pageNumber,keyword);
		h.setOnlyAmazon(amazonOnly);
		
		String url ="";
		if (sort != null) {
			url = h.getUrl(sort); 
		} else {
			url = h.getUrl();
		}
		
		return url;
	}
	
	
	private int processParse(int pageNumber, int totalPages) throws Exception {
		String url = getUrl(pageNumber);
		
		LOGGER.info(url);
		
		SAXParserFactory parserFactor = SAXParserFactory.newInstance();
		SAXParser parser = parserFactor.newSAXParser();
		
		AmazonHandler handler = new AmazonHandler(brand,category,keyword,mustInclude,outputFile);
		
	    InputSource ins = UrlHelper.getInputSource(url);
		
		parser.parse(ins, handler); 
		totalPages = handler.getTotalPages();

		return totalPages;
	}
	

	/*public Database getDb() {
		return db;
	}

	public void setDb(Database db) {
		this.db = db;
	}*/

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getNode() {
		return node;
	}

	public void setNode(String node) {
		this.node = node;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getMustInclude() {
		return mustInclude;
	}

	public void setMustInclude(String mustInclude) {
		this.mustInclude = mustInclude;
	}

	public Map<String, String> getFixedAttributes() {
		return fixedAttributes;
	}

	public void setFixedAttributes(Map<String, String> fixedAttributes) {
		this.fixedAttributes = fixedAttributes;
	}

	public int getMaxPages() {
		return maxPages;
	}

	public void setMaxPages(int maxPages) {
		this.maxPages = maxPages;
	}

	public boolean isAmazonOnly() {
		return amazonOnly;
	}

	public void setAmazonOnly(boolean amazonOnly) {
		this.amazonOnly = amazonOnly;
	}

	public float getMinimumPrice() {
		return minimumPrice;
	}

	public void setMinimumPrice(float minimumPrice) {
		this.minimumPrice = minimumPrice;
	}
}
