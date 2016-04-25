package com.careydevelopment.ecommerceautomation.company;

public class Company {

	private String name;
	private String outputFileName;
	
	public Company (String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOutputFileName() {
		return outputFileName;
	}

	public void setOutputFileName(String outputFileName) {
		this.outputFileName = outputFileName;
	}
	
	
}
