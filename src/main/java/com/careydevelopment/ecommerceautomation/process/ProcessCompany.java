package com.careydevelopment.ecommerceautomation.process;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.careydevelopment.ecommerceautomation.company.Companies;
import com.careydevelopment.ecommerceautomation.company.Company;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.core.util.StatusPrinter;

public class ProcessCompany {
	private static final Logger LOGGER = LoggerFactory.getLogger(ProcessCompany.class);

	public static void main(String[] args) {
		  LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
		  // print logback's internal status
		  StatusPrinter.print(lc);
		
		Company company = Companies.AMAZON;
		CompanyProcessor processor = ProcessorFactory.getProcessor(company);
		processor.process();
	}

}
