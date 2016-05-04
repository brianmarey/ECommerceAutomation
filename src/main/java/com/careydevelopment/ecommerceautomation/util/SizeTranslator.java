package com.careydevelopment.ecommerceautomation.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SizeTranslator {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SizeTranslator.class);
	
	public static final String getSize(String size) {

		String originalSize = size;
		
		String newSize = null;
		if (size!=null) {
			size = size.trim();
			size = size.toUpperCase();
			
			if (size.endsWith(")")) {
				size = size.substring(0, size.length() - 1);
			}
			
			if (size.endsWith("W") && size.length() < 5) {
				size = size.substring(0, size.length() -1);
			}
			
			if (size.startsWith("0") && !size.equals("0") && !size.equals("00")) {
				size = size.substring(1, size.length());
			}
			
			if (size.indexOf("/") > -1) {
				String[] parts = size.split("/");
				String returnSize = "";
				
				returnSize = getSize(parts[0]);

				if (!returnSize.equals("")) {
					return returnSize;
				}
			}
			
			if (size.indexOf(" NECK") > -1) {
				int loc = size.indexOf(" NECK");
				String neckSize = size.substring(0, loc-1);
				//System.err.println("neck size is " + neckSize);
				return neckSize;
			}
 			
			if (size.indexOf("-") > -1 && !size.equals("X-LARGE")
					&& !size.equals("X-SMALL")
					&& !size.equals("XX-SMALL")
					&& !size.equals("XX-LARGE")
					&& !size.equals("XXX-LARGE")) {
				String[] parts = size.split("-");
				String returnSize = "";
				for (String part : parts) {
					part = part.trim();
					part = getSize(part);
					if (part != null) {
						returnSize += part + ",";
					}
				}
				
				if (!returnSize.equals("")) {
					return returnSize;
				}
			}
			
			
			try {
				Integer i = new Integer(size);
				return size;
			} catch (Exception e) {
				//size is not a number
			}
			
			if (size.indexOf(" ") > -1 && size.indexOf("PLUS")==-1) {
				String[] parts = size.split(" ");
				
				try {
					Integer i = new Integer(parts[0].trim());
					return parts[0].trim();
				} catch (Exception e) {
					//still not a number
				}
				
				/*if (parts[1] != null) {
					try {
						Integer i = new Integer(parts[1].trim());
						return parts[1].trim();
					} catch (Exception e) {
						//still not a number
					}
				}*/
			}
			
			if (size.equals("XXS") || size.equals("XS") || size.equals("S") || size.equals("M") || size.equals("L") || size.equals("XL") || size.equals("XXL") || size.equals("XXXL")) {
				return size;
			}
			
			if (size.equals("0X")) {
				return size;
			}
			
			if (size.equals("1X")) {
				return size;
			}
			
			if (size.equals("2X") || size.equals("2XL")) {
				return "2X";
			}
			
			if (size.equals("3X") || size.equals("3XL")) {
				return "3X";
			}
			
			if (size.equals("4X")) {
				return size;
			}
			
			if (size.equals("5X")) {
				return size;
			}
			
			//we don't need the word Plus after 2X, etc.
			if (size.indexOf(" PLUS")>-1) {
				int stop = size.indexOf(" PLUS");
				originalSize = originalSize.substring(0,stop);
				return originalSize;
			}
			
			if (size.trim().indexOf(" ")>-1) {
				String trimmed = size.substring(0,size.indexOf(" "));
				return getSize(trimmed);
			}
			
			if (size.equalsIgnoreCase("SMALL")) {
				return "S";
			}
			
			if (size.equalsIgnoreCase("SMALL/US")) {
				return "S";
			}
			
			if (size.equalsIgnoreCase("LARGE")) {
				return "L";
			}
			
			if (size.equalsIgnoreCase("LARGE/US")) {
				return "L";
			}
			
			if (size.equalsIgnoreCase("MEDIUM")) {
				return "M";
			}
			
			if (size.equalsIgnoreCase("MEDIUM/US")) {
				return "M";
			}
			
			if (size.indexOf("X-SMALL")>-1) {
				return "XS";
			}
			
			if (size.indexOf("X-LARGE")>-1) {
				return "XL";
			}
			
			if (size.indexOf("XX-LARGE")>-1) {
				return "XXL";
			}
			
			if (size.equals("XLARGE")) {
				return "XL";
			}
			
			if (size.equals("XXLARGE")) {
				return "XXL";
			}
			
			if (size.equals("XSMALL")) {
				return "XS";
			}
			
			if (size.equals("XXSMALL")) {
				return "XXS";
			}
			
			if (size.indexOf("MEDIUM")>-1) {
				return "M";
			}
			
			if (size.indexOf("LRG")>-1) {
				return "L";
			}
			
			if (size.indexOf("MED")>-1) {
				return "M";
			}
			
			if (size.indexOf("SML")>-1) {
				return "S";
			}
			
			if (size.indexOf("XXLRG")>-1) {
				return "XXL";
			}
			
			if (size.indexOf("XLG")>-1) {
				return "XL";
			}
			
			if (size.equals("SM")) {
				return "S";
			}
			
			if (size.equals("LG")) {
				return "L";
			}
 		}
		
		if (newSize == null) LOGGER.warn("Couldn't translate " + originalSize);
		return newSize;
	}
}
