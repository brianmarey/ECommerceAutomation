package com.careydevelopment.ecommerceautomation.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InseamTranslator {

	private static final Logger LOGGER = LoggerFactory.getLogger(InseamTranslator.class);
	
	public static String translateInseam(String ins) {
		String inseam = null;
		
		if (ins != null) {
			ins = ins.trim();
			
			if (ins.indexOf(" 1/2") > -1) {
				ins = ins.substring(0,ins.indexOf(" 1/2")).trim();
			}
			
			if (ins.indexOf("/") > -1) {
				String[] parts = ins.split("/");
				ins = parts[1].trim();
			}
			
			try {
				Integer insInt = new Integer(ins);
				inseam = ins;
			} catch (NumberFormatException e) {
				LOGGER.warn("Can't translate inseam " + ins);
			}
		}
		
		return inseam;
	}
	
	public static String getInseamFromSize(String size) {
		String inseam = null;
		
		if (size != null) {
			if (size.toLowerCase().indexOf("w x ") > -1) {
				int start = size.toLowerCase().indexOf("w x ");
				start += 4;
				inseam = size.substring(start,size.length()).trim();
				if (inseam.toLowerCase().endsWith("l")) {
					inseam = inseam.substring(0, inseam.length() - 1);
				}
			}
		}
		
		return inseam;
	}
}
