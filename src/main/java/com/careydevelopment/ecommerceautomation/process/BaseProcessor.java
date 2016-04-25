package com.careydevelopment.ecommerceautomation.process;

import com.careydevelopment.ecommerceautomation.clean.Cleaner;
import com.careydevelopment.ecommerceautomation.clean.ProductExportFile;
import com.careydevelopment.ecommerceautomation.company.Company;

public abstract class BaseProcessor implements CompanyProcessor {
	
	private Company company;
	private String outputFile;
	
	public BaseProcessor(Company company) {
		this.company = company;
		setOutputFile(company);
	}

	
	@Override
	public void process() {
		ProductExportFile pef = new ProductExportFile(outputFile,true);
		pef.close(false);
		
		iterateProducts();
		
		Cleaner cleaner = new Cleaner(company.getName(),outputFile);
		cleaner.removeItemsNoLongerAvailable();
					
		pef = new ProductExportFile(outputFile,false);
		pef.close(true);
	}
	
	
	private void setOutputFile(Company company) {
		StringBuilder builder = new StringBuilder();
		builder.append(OUTPUT_FILE_LOC);
		builder.append(company.getOutputFileName());
		
		outputFile = builder.toString();
	}

	
	protected abstract void iterateProducts();
}
