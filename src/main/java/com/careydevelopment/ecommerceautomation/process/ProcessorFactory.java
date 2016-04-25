package com.careydevelopment.ecommerceautomation.process;

import com.careydevelopment.ecommerceautomation.company.Company;

public class ProcessorFactory {

	public static CompanyProcessor getProcessor(Company company) {
		String companyName = company.getName();
		
		switch(companyName) {
			case "Amazon":
				return new AmazonProcessor(company);
			default:
				throw new RuntimeException ("No known company: " + companyName);
		}
	}
}
