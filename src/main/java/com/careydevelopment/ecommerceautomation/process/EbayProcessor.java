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
			processParseEbay(Categories.MENS_DRESS_SHIRTS,"57991","shirt");

			/*processParseEbay(CareyCategories.MEN_RELAXED_JEANS,"11483","relaxed",attMap);

			attMap = new HashMap<String,String>();
			//attMap.put(CareyAttributes.LABEL_MENS_JEAN_TYPE, CareyAttributes.MENS_STRAIGHT_JEANS);
			processParseEbay(CareyCategories.MEN_STRAIGHT_JEANS,"11483","straight",attMap);

			attMap = new HashMap<String,String>();
			//attMap.put(CareyAttributes.LABEL_MENS_JEAN_TYPE, CareyAttributes.MENS_SLIM_JEANS);
			processParseEbay(CareyCategories.MEN_SLIM_JEANS,"11483","slim",attMap);

			attMap = new HashMap<String,String>();
			//attMap.put(CareyAttributes.LABEL_MENS_JEAN_TYPE, CareyAttributes.MENS_SKINNY_JEANS);
			processParseEbay(CareyCategories.MEN_SKINNY_JEANS,"11483","skinny",attMap);

			attMap = new HashMap<String,String>();
			//attMap.put(CareyAttributes.LABEL_MENS_PANTS_TYPE, CareyAttributes.DRESS_PANTS);
			processParseEbay(CareyCategories.MEN_DRESS_PANTS,"57989",null,"Style","Dress - Flat Front",attMap,null);

			attMap = new HashMap<String,String>();
			//attMap.put(CareyAttributes.LABEL_MENS_PANTS_TYPE, CareyAttributes.DRESS_PANTS);
			processParseEbay(CareyCategories.MEN_DRESS_PANTS,"57989",null,"Style","Dress - Pleated",attMap,null);

			attMap = new HashMap<String,String>();
			//attMap.put(CareyAttributes.LABEL_MENS_PANTS_TYPE, CareyAttributes.CASUAL_PANTS);
			processParseEbay(CareyCategories.MEN_CASUAL_PANTS,"57989",null,"Style","Casual Pants",attMap,null);

			
			
			attMap = new HashMap<String,String>();
			//attMap.put(CareyAttributes.LABEL_WOMENS_TOP_TYPE, CareyAttributes.BLOUSES);
			processParseEbay(CareyCategories.WOMEN_TOPS_BLOUSES,"53159","blouse",attMap);

			attMap = new HashMap<String,String>();
			//attMap.put(CareyAttributes.LABEL_WOMENS_TOP_TYPE, CareyAttributes.HENLEY);
			processParseEbay(CareyCategories.WOMEN_TOPS_HENLEY,"53159","henley",attMap);
			
			attMap = new HashMap<String,String>();
			//attMap.put(CareyAttributes.LABEL_WOMENS_TOP_TYPE, CareyAttributes.HENLEY);
			processParseEbay(CareyCategories.WOMEN_TOPS_POLOS,"53159","polo",attMap);

			attMap = new HashMap<String,String>();
			//attMap.put(CareyAttributes.LABEL_WOMENS_TOP_TYPE, CareyAttributes.TSHIRT);
			processParseEbay(CareyCategories.WOMEN_TOPS_TEES,"63869","t-shirt",attMap);

			attMap = new HashMap<String,String>();
			//attMap.put(CareyAttributes.LABEL_WOMENS_TOP_TYPE, CareyAttributes.TSHIRT);
			processParseEbay(CareyCategories.WOMEN_TOPS_TEES,"63869","tee",attMap);

			
			attMap = new HashMap<String,String>();
			//attMap.put(CareyAttributes.LABEL_WOMENS_JEAN_TYPE, CareyAttributes.BOOTCUT_JEANS);
			processParseEbay(CareyCategories.WOMEN_JEANS_BOOTCUT,"11554","bootcut",attMap);

			attMap = new HashMap<String,String>();
			//attMap.put(CareyAttributes.LABEL_WOMENS_JEAN_TYPE, CareyAttributes.ANKLE_JEANS);
			processParseEbay(CareyCategories.WOMEN_JEANS_ANKLE,"11554","ankle",attMap);

			attMap = new HashMap<String,String>();
			//attMap.put(CareyAttributes.LABEL_WOMENS_JEAN_TYPE, CareyAttributes.SKINNY_JEANS);
			processParseEbay(CareyCategories.WOMEN_JEANS_SKINNY,"11554","skinny",attMap);

			attMap = new HashMap<String,String>();
			//attMap.put(CareyAttributes.LABEL_WOMENS_JEAN_TYPE, CareyAttributes.BOYFRIEND_JEANS);
			processParseEbay(CareyCategories.WOMEN_JEANS_BOYFRIEND,"11554","boyfriend",attMap);
			
			
			attMap = new HashMap<String,String>();
			//attMap.put(CareyAttributes.LABEL_WOMENS_PANTS_TYPE, CareyAttributes.WEAR_TO_WORK_PANTS);
			processParseEbay(CareyCategories.WOMEN_PANTS_WORK,"63863",null,"Style","Dress Pants",attMap,null);

			attMap = new HashMap<String,String>();
			//attMap.put(CareyAttributes.LABEL_WOMENS_PANTS_TYPE, CareyAttributes.CASUAL_PANTS);
			processParseEbay(CareyCategories.WOMEN_PANTS_CASUAL,"63863",null,"Style","Casual Pants",attMap,null);

			attMap = new HashMap<String,String>();
			attMap.put(CareyAttributes.LABEL_MENS_SHORTS_TYPE, CareyAttributes.CARGO_SHORTS);
			processParseEbay(CareyCategories.MEN_SHORTS,"15689",null,"Style","Cargo",attMap);

			attMap = new HashMap<String,String>();
			attMap.put(CareyAttributes.LABEL_MENS_SHORTS_TYPE, CareyAttributes.DENIM_SHORTS);
			processParseEbay(CareyCategories.MEN_SHORTS,"15689",null,"Style","Denim",attMap);
			
			attMap = new HashMap<String,String>();
			attMap.put(CareyAttributes.LABEL_WOMENS_DRESS_TYPE, CareyAttributes.CASUAL_DRESSES);
			processParseEbay(CareyCategories.WOMEN_DRESSES,"63861",null,"Occasion","Casual",attMap);

			attMap = new HashMap<String,String>();
			attMap.put(CareyAttributes.LABEL_WOMENS_DRESS_TYPE, CareyAttributes.NIGHT_OUT_DRESSES);
			processParseEbay(CareyCategories.WOMEN_DRESSES,"63861",null,"Occasion","Clubwear",attMap);
			
			attMap = new HashMap<String,String>();
			attMap.put(CareyAttributes.LABEL_WOMENS_DRESS_TYPE, CareyAttributes.WEAR_TO_WORK_DRESSES);
			processParseEbay(CareyCategories.WOMEN_DRESSES,"63861",null,"Occasion","Wear to Work",attMap);
			*/
			
			/*
			attMap = new HashMap<String,String>();
			attMap.put(CareyAttributes.LABEL_WOMENS_SHORTS_TYPE, CareyAttributes.WOMEN_DRESS_SHORTS);
			processParseEbay(CareyCategories.WOMEN_SHORTS,"11555",null,"Style","Dress Shorts",attMap);
			
			attMap = new HashMap<String,String>();
			attMap.put(CareyAttributes.LABEL_WOMENS_SHORTS_TYPE, CareyAttributes.WOMEN_CASUAL_SHORTS);
			processParseEbay(CareyCategories.WOMEN_SHORTS,"11555",null,"Style","Casual Shorts",attMap);

			attMap = new HashMap<String,String>();
			attMap.put(CareyAttributes.LABEL_WOMENS_SHORTS_TYPE, CareyAttributes.WOMEN_DENIM_SHORTS);
			processParseEbay(CareyCategories.WOMEN_SHORTS,"11555",null,"Style","Denim",attMap);
*/			
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		LOGGER.info("all done!");
	}
	
	private void processParseEbay(Category category, String categoryId, String keyword)  {
		processParseEbay(category,categoryId,keyword,null,null,null);
	}
	
	private void processParseEbay(Category category, String categoryId, String keyword,Float minPrice)  {
		processParseEbay(category,categoryId,keyword,null,null,minPrice);
	}

	private void processParseEbay(Category category,String categoryId,String keyword,String aspect, String aspectValue) {
		processParseEbay(category, categoryId, keyword, aspect, aspectValue,null);
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
	
	
	private void processParseEbay(Category category,String categoryId,String keyword,String aspect, String aspectValue,Float minPrice) {
		String appId = getAppId();
			
		for (int i=1;i<20;i++) {
			LOGGER.info("Page " + i);
			
			try {
				String url = EbayUrlHelper.getFindItemsUrl(keyword, categoryId, aspect, aspectValue,i,appId);
				LOGGER.info("Category URL is " + url);
				
				SAXParserFactory parserFactor = SAXParserFactory.newInstance();
				SAXParser parser = parserFactor.newSAXParser();
				EbayHandler handler = new EbayHandler(category,keyword,outputFile,appId);
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
