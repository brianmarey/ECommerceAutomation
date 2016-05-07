package com.careydevelopment.ecommerceautomation.process;

import com.careydevelopment.ecommerceautomation.company.Company;

public class ProcessorFactory {

	public static CompanyProcessor getProcessor(Company company) {
		String companyName = company.getName();
		
		switch(companyName) {
			case "Amazon":
				return new AmazonProcessor(company);
			case "eBay":
				return new EbayProcessor(company);
			case "Boscov's":
				return new BoscovsProcessor(company);
			default:
				throw new RuntimeException ("No known company: " + companyName);
		}
	}
}
