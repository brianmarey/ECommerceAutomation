package com.careydevelopment.ecommerceautomation.process;

import com.careydevelopment.ecommerceautomation.company.Companies;
import com.careydevelopment.ecommerceautomation.company.Company;

public class ProcessCompany {

	public static void main(String[] args) {
		Company company = Companies.AMAZON;
		CompanyProcessor processor = ProcessorFactory.getProcessor(company);
		processor.process();
	}

}
