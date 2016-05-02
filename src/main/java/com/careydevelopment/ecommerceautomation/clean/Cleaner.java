package com.careydevelopment.ecommerceautomation.clean;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.careydevelopment.ecommerceautomation.service.ProductPersistenceService;

public class Cleaner {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(Cleaner.class);
	
	private static final int CHUNK_SIZE = 100;
	

	private String seller = "";
	//private Database db;
	private String file = "";
	
	private Cleaner() {}
	
	public Cleaner(String seller,String xmlFile) {
		this.seller = seller;
		//this.db = db;
		this.file = xmlFile;
	}
	
	private String getFile() {
		String text = "";
		try {
		    BufferedReader br = new BufferedReader(new FileReader(file));
		    try {
		        StringBuilder sb = new StringBuilder();
		        String line = br.readLine();
	
		        while (line != null) {
		            sb.append(line);
		            //sb.append("\n");
		            line = br.readLine();
		        }
		        text= sb.toString();
		    } finally {
		        br.close();
		    }
		} catch (Exception e) {
			LOGGER.error("Couldn't read " + file,e);
		}
		
		return text;
	}
	
	
	public void removeItemsNoLongerAvailable() {
		String file = getFile();
		
		ProductPersistenceService service = new ProductPersistenceService();
		
		List<String> skus = service.fetchSkusByVendor(seller);
		
		LOGGER.info("Skus size is " + skus.size());
		
		for (String sku : skus) {
			if (file.indexOf(sku)== -1) {
				LOGGER.info("Deleting product with sku " + sku);
				service.delete(seller,sku);
			}
		}
		
		deleteOutputFile();
	}	
	
	
	private void deleteOutputFile() {
		LOGGER.info("deleting output file " + file);
		
		File f = new File(file);
		f.delete();
	}
	
	public static void main(String[] args) {
		Cleaner cleaner = new Cleaner("sears","./output/brianmcarey/sears.xml");
		cleaner.removeItemsNoLongerAvailable();
	}
}
