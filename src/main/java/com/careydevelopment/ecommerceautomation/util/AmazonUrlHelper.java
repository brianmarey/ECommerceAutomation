package com.careydevelopment.ecommerceautomation.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.careydevelopment.propertiessupport.PropertiesFactory;
import com.careydevelopment.propertiessupport.PropertiesFile;

public class AmazonUrlHelper {
	private static final Logger LOGGER = LoggerFactory.getLogger(AmazonUrlHelper.class);

	public static final String SORT_BOOKS_BESTSELLERS = "salesrank";


    /*
     * Use one of the following end-points, according to the region you are
     * interested in:
     * 
     *      US: ecs.amazonaws.com 
     *      CA: ecs.amazonaws.ca 
     *      UK: ecs.amazonaws.co.uk 
     *      DE: ecs.amazonaws.de 
     *      FR: ecs.amazonaws.fr 
     *      JP: ecs.amazonaws.jp
     * 
     */
    private static final String ENDPOINT = "ecs.amazonaws.com";

    private SignedRequestsHelper helper;
    
    private String brand;
    private String browseNode;
    private int pageNumber = 0;
    private String keyword = null;
    
    private boolean onlyAmazon = true;
    
    public AmazonUrlHelper() {
        try {
        	Properties props = PropertiesFactory.getProperties(PropertiesFile.AMAZON_PROPERTIES);
        	String accessKey = props.getProperty("access.key");
        	String secretKey = props.getProperty("secret.key");
        	
            helper = SignedRequestsHelper.getInstance(ENDPOINT, accessKey, secretKey);
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
    }
    
    public AmazonUrlHelper(String brand,String browseNode,int pageNumber,String keyword) {
    	this.brand = brand;
    	this.browseNode = browseNode;
    	this.pageNumber = pageNumber;
    	this.keyword = keyword;

        try {
        	Properties props = PropertiesFactory.getProperties(PropertiesFile.AMAZON_PROPERTIES);
        	String accessKey = props.getProperty("access.key");
        	String secretKey = props.getProperty("secret.key");
        	
            helper = SignedRequestsHelper.getInstance(ENDPOINT, accessKey, secretKey);
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
    }

    public String getUrl(String sortType) {
        Map<String, String> params = new HashMap<String, String>();
        params.put("Service", "AWSECommerceService");
        params.put("Version", "2011-08-01");
        params.put("Operation", "ItemSearch");
        params.put("ResponseGroup", "Large,EditorialReview,Variations,ItemAttributes");
        params.put("SearchIndex", "Apparel");
        params.put("AssociateTag", "brmca-20");
        params.put("BrowseNode", browseNode);
        if (brand!=null) params.put("Brand", brand);
        params.put("Availability", "Available");
        if (onlyAmazon) params.put("MerchantId", "Amazon");
        params.put("sort", sortType);
        params.put("ItemPage", new Integer(pageNumber).toString());
        if (keyword != null) params.put("Keywords", keyword);
        
        String requestUrl = helper.sign(params);
        
        LOGGER.info("Amazon URL is " + requestUrl);
        
        return requestUrl;
    }
    
    /*public String getUrl2(String sortType) {
        Map<String, String> params = new HashMap<String, String>();
        params.put("Service", "AWSECommerceService");
        params.put("Version", "2011-08-01");
        params.put("Operation", "ItemSearch");
        params.put("ResponseGroup", "EditorialReview,OfferFull,Variations,ItemAttributes");
        params.put("SearchIndex", "Apparel");
        params.put("AssociateTag", "brmca-20");
        params.put("BrowseNode", browseNode);
        if (brand!=null) params.put("Brand", brand);
        params.put("Availability", "Available");
        params.put("MerchantId", "Amazon");
        params.put("sort", sortType);
        params.put("ItemPage", new Integer(pageNumber).toString());
        if (keyword != null) params.put("Keywords", keyword);
        
        String requestUrl = helper.sign(params);
        
        System.err.println("Amazon URL is " + requestUrl);
        
        return requestUrl;
    }*/
    
    
    public String getUrl() {
        Map<String, String> params = new HashMap<String, String>();
        params.put("Service", "AWSECommerceService");
        params.put("Version", "2011-08-01");
        params.put("Operation", "ItemSearch");
        params.put("ResponseGroup", "Large,EditorialReview,Variations,ItemAttributes");
        params.put("SearchIndex", "Apparel");
        params.put("AssociateTag", "brmca-20");
        params.put("BrowseNode", browseNode);
        if (brand!=null) params.put("Brand", brand);
        params.put("Availability", "Available");
        if (onlyAmazon) params.put("MerchantId", "Amazon");
        params.put("sort", "pricerank");
        params.put("ItemPage", new Integer(pageNumber).toString());
        if (keyword != null) params.put("Keywords", keyword);
        
        String requestUrl = helper.sign(params);
        
        LOGGER.info("Amazon URL is " + requestUrl);
        
        return requestUrl;
    }
    

    /*public String getUrl2() {
        Map<String, String> params = new HashMap<String, String>();
        params.put("Service", "AWSECommerceService");
        params.put("Version", "2011-08-01");
        params.put("Operation", "ItemSearch");
        params.put("ResponseGroup", "EditorialReview,OfferFull,Variations,ItemAttributes");
        params.put("SearchIndex", "Apparel");
        params.put("AssociateTag", "brmca-20");
        params.put("BrowseNode", browseNode);
        if (brand!=null) params.put("Brand", brand);
        params.put("Availability", "Available");
        params.put("MerchantId", "Amazon");
        params.put("sort", "pricerank");
        params.put("ItemPage", new Integer(pageNumber).toString());
        if (keyword != null) params.put("Keywords", keyword);
        
        String requestUrl = helper.sign(params);
        
        LOGGER.debug("Amazon URL is " + requestUrl);
        
        return requestUrl;
    }*/
    
    
    public String getSpecificItemUrl(String sku) {
        Map<String, String> params = new HashMap<String, String>();
        params.put("Service", "AWSECommerceService");
        params.put("Version", "2011-08-01");
        params.put("Operation", "ItemLookup");
        params.put("ResponseGroup", "Variations,Large");
        params.put("AssociateTag", "brmca-20");
        params.put("ItemId", sku);
        
        String requestUrl = helper.sign(params);
        
        //System.err.println("Specific item URL is " + requestUrl);
        
        return requestUrl;
    }
    
    
    public static void main(String[] args) {
    	//AmazonUrlHelper h = new AmazonUrlHelper("Anne Klein","2346727011");
    	//h.getUrl();
    }

	public boolean isOnlyAmazon() {
		return onlyAmazon;
	}

	public void setOnlyAmazon(boolean onlyAmazon) {
		this.onlyAmazon = onlyAmazon;
	}
}
