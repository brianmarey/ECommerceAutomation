package com.careydevelopment.ecommerceautomation.parse;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.InputSource;

import com.careydevelopment.ecommerceautomation.util.AmazonUrlHelper;
import com.careydevelopment.ecommerceautomation.util.Node;

public class AmazonParseProcessor {

	private static final Logger LOGGER = LoggerFactory.getLogger(AmazonParseProcessor.class);

	private String brand;
	private String node;
	private Node<String> category;
	private String keyword;
	private String sort;
	private String mustInclude;
	private String outputFile;
	private boolean amazonOnly = true;
	private float minimumPrice = -1f;
	
	private int maxPages = 10;
	
	private Map<String,String> fixedAttributes = new HashMap<String,String>();
	
	public AmazonParseProcessor(String brand, String node, Node<String> category,String keyword,String outputFile) {
		this.brand = brand;
		this.node = node;
		this.category=category;
		this.keyword=keyword;
		this.outputFile = outputFile;
	}
	
	public AmazonParseProcessor(String brand, String node, Node<String> category,String keyword, String sort,String outputFile) {
		this.brand = brand;
		this.node = node;
		this.category=category;
		this.keyword=keyword;
		this.sort = sort;
		this.outputFile = outputFile;
	}
	
	public AmazonParseProcessor(String brand, String node, Node<String> category,String keyword, String sort, String mustInclude,String outputFile) {
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
				
				LOGGER.info("page number is " + pageNumber + " and totalPages is " + totalPages);
				Thread.sleep(1000);
			}
			
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
	
	private int processParse(int pageNumber, int totalPages) throws Exception {
		AmazonUrlHelper h = new AmazonUrlHelper(brand,node,pageNumber,keyword);
		h.setOnlyAmazon(amazonOnly);
		
		String url ="";
		if (sort != null) {
			url = h.getUrl(sort); //"http://ecs.amazonaws.com/onca/xml?AWSAccessKeyId=AKIAIRWIB43UG2D76MEA&AssociateTag=brmca-20&Availability=Available&Brand=Anne%20Klein&BrowseNode=2346727011&MerchantId=Amazon&Operation=ItemSearch&ResponseGroup=Large&SearchIndex=Apparel&Service=AWSECommerceService&Timestamp=2014-11-03T21%3A50%3A25.000Z&Version=2011-08-01&sort=pricerank&Signature=Or2yLcStOa%2FCLt1zw2UafmRaZMGTBLoX3pyjp7o7a8Y%3D";
		} else {
			url = h.getUrl();
		}
		
		LOGGER.info(url);
		
		SAXParserFactory parserFactor = SAXParserFactory.newInstance();
		SAXParser parser = parserFactor.newSAXParser();
		AmazonHandler handler = new AmazonHandler(brand,category,keyword,mustInclude,outputFile);
		//handler.setFixedAttributes(fixedAttributes);
		handler.setMinimumPrice(minimumPrice);
		
		URL urlConn = new URL(url);
		HttpURLConnection httpcon = (HttpURLConnection) urlConn.openConnection();
	    httpcon.addRequestProperty("User-Agent", "Mozilla/4.76");
	    
	    InputStream is = httpcon.getInputStream();
	   
	    //Reader reader = new InputStreamReader(is,"ISO-8859-1");
	    //Reader reader = new InputStreamReader(is,"UTF-8");
	    Reader reader = new InputStreamReader(is,"US-ASCII");
	    
	    InputSource ins = new InputSource(reader);
	    //ins.setEncoding("ISO-8859-1");
	    //ins.setEncoding("UTF-8");
	    ins.setEncoding("US-ASCII");
		
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

	public Node<String> getCategory() {
		return category;
	}

	public void setCategory(Node<String> category) {
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
