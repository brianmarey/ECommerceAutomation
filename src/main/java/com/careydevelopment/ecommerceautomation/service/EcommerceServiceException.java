package com.careydevelopment.ecommerceautomation.service;

public class EcommerceServiceException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5912448301621004597L;

	public EcommerceServiceException(String s) {
		super(s);
	}
	
	public EcommerceServiceException(Exception e) {
		super(e);
	}
}
