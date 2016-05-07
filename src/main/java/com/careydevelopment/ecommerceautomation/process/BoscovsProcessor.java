package com.careydevelopment.ecommerceautomation.process;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.careydevelopment.ecommerceautomation.company.Company;
import com.careydevelopment.ecommerceautomation.util.FileGrabber;

public class BoscovsProcessor extends BaseProcessor {
	private static final Logger LOGGER = LoggerFactory.getLogger(BoscovsProcessor.class);

	private static final String INPUT_FILE = "/etc/tomcat8/import/Boscov_s_Department_Stores-Product_Catalog.xml";

	public BoscovsProcessor(Company company) {
		super(company);
	}
	
	
	protected void importFile() {
		FileGrabber.grabFile(INPUT_FILE,FileGrabber.BOSCOVS);
	}
	
	
	protected void iterateProducts() {
		/*try {
			File file = new File(INPUT_FILE);
			
			SAXParserFactory parserFactor = SAXParserFactory.newInstance();
			SAXParser parser = parserFactor.newSAXParser();
			BrianBoscovCjHandler handler = new BrianBoscovCjHandler(DatabaseHelper.getDatabase(DatabaseHelper.BRIANMCAREY),OUTPUT_FILE);

			
			//System.err.println("about to parse");
			parser.parse(file, handler); 
		} catch (Exception e) {
			e.printStackTrace();
		}*/
	}
}
