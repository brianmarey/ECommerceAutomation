package com.careydevelopment.ecommerceautomation.process;

import java.util.Properties;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.InputSource;

import com.careydevelopment.ecommerceautomation.company.Company;
import com.careydevelopment.ecommerceautomation.entity.Categories;
import com.careydevelopment.ecommerceautomation.entity.Category;
import com.careydevelopment.ecommerceautomation.parse.EbayHandler;
import com.careydevelopment.ecommerceautomation.util.EbayUrlHelper;
import com.careydevelopment.ecommerceautomation.util.UrlHelper;
import com.careydevelopment.propertiessupport.PropertiesFactory;
import com.careydevelopment.propertiessupport.PropertiesFactoryException;
import com.careydevelopment.propertiessupport.PropertiesFile;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.core.util.StatusPrinter;

public class EbayProcessor extends BaseProcessor {
	private static final Logger LOGGER = LoggerFactory.getLogger(EbayProcessor.class);
	
	public EbayProcessor(Company company) {
		super(company);
		
		LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
		StatusPrinter.print(lc);
	}
	
	public static void main(String args[]) {
		//AmazonProcessor pa = new AmazonProcessor();
		//pa.process();
	}

	
	protected void iterateProducts() {
		try {
			//gets polo ralph lauren shirts
			//processParseEbay(Categories.MENS_POLO_SHIRTS,"57990","polo%20shirt");
			//processParseEbay(Categories.WOMEN_TOPS_POLOS,"53159","polo");

			processParseEbay(Categories.WOMENS_DRESS_SHORTS,"11555",null,"Style","Dress%20Shorts");
			processParseEbay(Categories.WOMENS_CASUAL_SHORTS,"11555",null,"Style","Casual%20Shorts");
			processParseEbay(Categories.WOMENS_DENIM_SHORTS,"11555",null,"Style","Denim");
			
			processParseEbay(Categories.WOMENS_CASUAL_DRESSES,"63861",null,"Occasion","Casual");
			processParseEbay(Categories.WOMENS_NIGHT_OUT_DRESSES,"63861",null,"Occasion","Clubwear");
			processParseEbay(Categories.WOMENS_WEAR_TO_WORK_DRESSES,"63861",null,"Occasion","Wear%20to%20Work");
			
			processParseEbay(Categories.MENS_CARGO_SHORTS,"15689",null,"Style","Cargo");
			processParseEbay(Categories.MENS_DENIM_SHORTS,"15689",null,"Style","Denim");
			
			processParseEbay(Categories.WOMEN_PANTS_WORK,"63863",null,"Style","Dress%20Pants");
			processParseEbay(Categories.WOMEN_PANTS_CASUAL,"63863",null,"Style","Casual%20Pants");
			processParseEbay(Categories.WOMEN_PANTS_CAPRIS,"63863",null,"Style","Capris%252C%2520Cropped");
			
			processParseEbay(Categories.WOMEN_JEANS_BOOTCUT,"11554","bootcut");
			processParseEbay(Categories.WOMEN_JEANS_ANKLE,"11554","ankle");
			processParseEbay(Categories.WOMEN_JEANS_SKINNY,"11554","skinny");
			processParseEbay(Categories.WOMEN_JEANS_BOYFRIEND,"11554","boyfriend");
			
			processParseEbay(Categories.WOMEN_TOPS_BLOUSES,"53159","blouse");
			processParseEbay(Categories.WOMEN_TOPS_HENLEY,"53159","henley");
			processParseEbay(Categories.WOMEN_TOPS_TEES,"63869","t-shirt");
			processParseEbay(Categories.WOMEN_TOPS_TEES,"63869","tee");
			
			processParseEbay(Categories.MENS_DRESS_PANTS,"57989",null,"Style","Dress%20-%20Flat%20Front");
			processParseEbay(Categories.MENS_DRESS_PANTS,"57989",null,"Style","Dress%20-%20Pleated");
			processParseEbay(Categories.MENS_CASUAL_PANTS,"57989",null,"Style","Casual%20Pants");
			
			processParseEbay(Categories.MENS_RELAXED_JEANS,"11483","relaxed");
			processParseEbay(Categories.MENS_STRAIGHT_JEANS,"11483","straight");
			processParseEbay(Categories.MENS_SKINNY_JEANS,"11483","skinny");
			processParseEbay(Categories.MENS_SLIM_JEANS,"11483","slim");
			
			processParseEbay(Categories.MENS_CASUAL_SHIRTS,"57990","shirt");
			processParseEbay(Categories.MENS_DRESS_SHIRTS,"57991","shirt");			
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		LOGGER.info("all done!");
	}
	
	private void processParseEbay(Category category, String categoryId, String keyword)  {
		processParseEbay(category,categoryId,keyword,null,null);
	}
	
	private void processParseEbay(Category category, String categoryId, String keyword,Float minPrice)  {
		processParseEbay(category,categoryId,keyword,null,minPrice,null,null);
	}

	private void processParseEbay(Category category,String categoryId,String keyword,String exclude) {
		processParseEbay(category, categoryId, keyword, exclude,null,null,null);
	}
	
	private void processParseEbay(Category category,String categoryId,String keyword,String aspect, String aspectValue) {
		processParseEbay(category, categoryId, keyword, null, null,aspect,aspectValue);
	}
	
	
	private String getAppId() {
		String appId = "";
		try {
			Properties props = PropertiesFactory.getProperties(PropertiesFile.EBAY_PROPERTIES);
			appId = props.getProperty("app.id");
		} catch (PropertiesFactoryException pe) {
			LOGGER.error("Problem getting ebay app id!");
			pe.printStackTrace();
		}
		
		return appId;
	}
	
	
	private void processParseEbay(Category category,String categoryId,String keyword,String exclude,Float minPrice,String aspect, String aspectValue) {
		String appId = getAppId();
			
		LOGGER.info("Aspect is " + aspect + " " + aspectValue);
		
		for (int i=1;i<20;i++) {
			LOGGER.info("Page " + i);
			
			try {
				String url = EbayUrlHelper.getFindItemsUrl(keyword, categoryId,i,appId,aspect,aspectValue);
				LOGGER.info("Category URL is " + url);
				
				SAXParserFactory parserFactor = SAXParserFactory.newInstance();
				SAXParser parser = parserFactor.newSAXParser();
				EbayHandler handler = new EbayHandler(category,keyword,outputFile,appId,exclude);
				handler.setMinPrice(minPrice);

				InputSource ins = UrlHelper.getInputSource(url);
			    ins.setEncoding("US-ASCII");
				
				parser.parse(ins, handler); 
			} catch (Exception e) {
				LOGGER.error("Couldn't finish cat "+ category);
				e.printStackTrace();
			}
		}
	}
}
