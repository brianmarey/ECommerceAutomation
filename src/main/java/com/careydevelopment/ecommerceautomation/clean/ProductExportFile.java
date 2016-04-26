package com.careydevelopment.ecommerceautomation.clean;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import com.careydevelopment.ecommerceautomation.entity.Product;

public class ProductExportFile {

	private String fileName = "";
	
	private PrintWriter writer = null;
	
	public ProductExportFile(String fileName, boolean createNewFile) {
		this.fileName = fileName;
		
		try {
			File file = new File(fileName);
			
			if (createNewFile && file.exists()) {
				file.delete();
			}
			
			writer = new PrintWriter(new BufferedWriter(new FileWriter(fileName, true)));
			
			if (createNewFile) {
				writer.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?><!DOCTYPE product_catalog SYSTEM \"http://www.jdoqocy.com/content/dtd/product_catalog_1_1.dtd\">");
				writer.println("<catalog>");
			}
		} catch (IOException ie) {
			ie.printStackTrace();
		}
	}
	
	
	public void writeProduct(Product product) {
		//System.err.println("writing product");
		writer.println("<product>");
		writer.println("<programname>");
		writer.println(product.getProgramName());
		writer.println("</programname>");
		writer.println("<catalogname>");
		writer.println(product.getCatalogName());
		writer.println("</catalogname>");
		writer.println("<vendor>");
		writer.println(product.getVendor());
		writer.println("</vendor>");
		writer.println("<name>");
		writer.println(product.getName());
		writer.println("</name>");
		writer.println("<description>");
		writer.println(product.getDescription());
		writer.println("</description>");
		writer.println("<sku>");
		writer.println(product.getSku());
		writer.println("</sku>");
		writer.println("<manufacturerid>");
		writer.println(product.getManufacturerId());
		writer.println("</manufacturerid>");
		writer.println("<upc>");
		writer.println(product.getUpc());
		writer.println("</upc>");
		writer.println("<price>");
		writer.println(product.getPrice());
		writer.println("</price>");
		writer.println("<retailprice>");
		if (product.getRetailPrice() != null && !product.getRetailPrice().equals("")) {
			writer.println(product.getRetailPrice());
		} else {
			writer.println(product.getPrice());
		}
		writer.println("</retailprice>");
		writer.println("<buyurl>");
		writer.println(product.getBuyUrl());
		writer.println("</buyurl>");
		writer.println("<impressionurl>");
		writer.println(product.getImpressionUrl());
		writer.println("</impressionurl>");
		writer.println("<advertisercategory>");
		writer.println(product.getAdvertiserCategory());
		writer.println("</advertisercategory>");
		writer.println("<instock>");
		writer.println(product.getInStock());
		writer.println("</instock>");
		writer.println("<imageurl>");
		writer.println(product.getImageUrl());
		writer.println("</imageurl>");
		writer.println("<colors>");
		if (product.getColors() != null) writer.println(product.getColors());
		writer.println("</colors>");
		writer.println("<sizes>");
		if (product.getColors() != null) writer.println(product.getSizes());
		writer.println("</sizes>");
		
		writer.println("</product>");
	}
	
	public void close() {
		close(true);
	}
	
	public void close(boolean endElement) {
		//System.err.println("closing");
		if (endElement) writer.println("</catalog>");
		writer.close();
	}
	
	
}
