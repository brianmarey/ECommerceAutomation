package com.careydevelopment.ecommerceautomation.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.careydevelopment.ecommerceautomation.process.AmazonProcessor;


public class EbayUrlHelper {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(EbayUrlHelper.class);
	
	public static String getFindItemsUrl(String keywords,String categoryId, String aspect, String aspectValue, int pageNumber, String appId) {
		String url = "http://svcs.ebay.com/services/search/FindingService/v1?GLOBAL-ID=EBAY-US&SECURITY-APPNAME=";
		url += appId;
		url += "&affiliate.trackingId=5337364004&affiliate.networkId=9&sortOrder=BestMatch&outputSelector=PictureURLLarge";
		if (keywords != null) {
			url +="&keywords=";
			url += keywords;
		}
		if (aspect != null) {
			url += "&aspectFilter.aspectName=" + aspect + "&aspectFilter.aspectValueName=" + aspectValue;
		}
		url += "&OPERATION-NAME=findItemsAdvanced&categoryId=";
		url += categoryId;
		url += "&paginationInput.entriesPerPage=75&paginationInput.pageNumber=" + pageNumber;
		url += "&RESPONSE-DATA-FORMAT=XML&REST-PAYLOAD&productId.@type=UPC&productId=024543611363&itemFilter%280%29.name=Condition&itemFilter%280%29.value=New&sortOrder=BestMatch&itemFilter%281%29.name=LocatedIn&itemFilter%281%29.value=US&itemFilter%282%29.name=Currency&itemFilter%282%29.value=USD&itemFilter%283%29.name=TopRatedSellerOnly&itemFilter%283%29.value=true";
		url += "&itemFilter%284%29.name=ListingType&itemFilter%284%29.value%280%29=AuctionWithBIN&itemFilter%284%29.value%281%29=FixedPrice&itemFilter%285%29.name=FreeShippingOnly&itemFilter%285%29.value=true";
		LOGGER.debug("ebay find url is " + url);
		
		String s = getHistogramUrl(keywords,categoryId,aspect,aspectValue,pageNumber,appId);
		
		return url;
	}

	
	public static String getHistogramUrl(String keywords,String categoryId, String aspect, String aspectValue, int pageNumber, String appId) {
		String url = "http://svcs.ebay.com/services/search/FindingService/v1?GLOBAL-ID=EBAY-US&SECURITY-APPNAME=";
		url += appId;
		url += "&affiliate.trackingId=5337364004&affiliate.networkId=9&sortOrder=BestMatch&outputSelector=AspectHistogram";
		if (keywords != null) {
			url +="&keywords=";
			url += keywords;
		}
		if (aspect != null) {
			url += "&aspectFilter.aspectName=" + aspect + "&aspectFilter.aspectValueName=" + aspectValue;
		}
		url += "&OPERATION-NAME=findItemsAdvanced&categoryId=";
		url += categoryId;
		url += "&paginationInput.entriesPerPage=75&paginationInput.pageNumber=" + pageNumber;
		url += "&RESPONSE-DATA-FORMAT=XML&REST-PAYLOAD&productId.@type=UPC&productId=024543611363&itemFilter%280%29.name=Condition&itemFilter%280%29.value=New&sortOrder=BestMatch&itemFilter%281%29.name=LocatedIn&itemFilter%281%29.value=US&itemFilter%282%29.name=Currency&itemFilter%282%29.value=USD&itemFilter%283%29.name=TopRatedSellerOnly&itemFilter%283%29.value=true";
		url += "&itemFilter%284%29.name=ListingType&itemFilter%284%29.value%280%29=AuctionWithBIN&itemFilter%284%29.value%281%29=FixedPrice&itemFilter%285%29.name=FreeShippingOnly&itemFilter%285%29.value=true";
		LOGGER.info("HISTOGRAM url is " + url);
		
		return url;
	}
	
	
	public static String getSpecificItemUrl(String itemId, String appId) {
		String url = "http://open.api.ebay.com/Shopping?callname=GetSingleItem&&responseencoding=XML&appid=";
		url += appId;
		url+= "&siteid=0&version=661&IncludeSelector=Description,ItemSpecifics,ShippingCosts&ItemID=";
		url += itemId;
		
		LOGGER.debug("ebay get specific item url is " + url);
		
		return url;
	}
}
