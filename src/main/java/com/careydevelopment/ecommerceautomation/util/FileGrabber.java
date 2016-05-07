package com.careydevelopment.ecommerceautomation.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.zip.GZIPInputStream;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPClientConfig;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.careydevelopment.propertiessupport.PropertiesFactory;
import com.careydevelopment.propertiessupport.PropertiesFile;

public class FileGrabber {
	private static final Logger LOGGER = LoggerFactory.getLogger(FileGrabber.class);
	
	public static final int LORD_AND_TAYLOR = 1;
	public static final int FRAGRANCEX = 2;
	public static final int SEARS = 3;
	public static final int BOSCOVS = 4;
	public static final int SEARS2 = 5;
	public static final int OFFICE_DEPOT = 6;
	
	public static void main (String args[]) {
	}
	
	public static void grabFile(String outputFile, int retailer) {
		FTPClient ftp = new FTPClient();
		FTPClientConfig config = new FTPClientConfig();
		
	    boolean error = false;
	    try {
	      int reply;
	      ftp.connect("datatransfer.cj.com");
	      LOGGER.info("Connected to cj");
	      LOGGER.info(ftp.getReplyString());

	      // After connection attempt, you should check the reply code to verify
	      // success.
	      reply = ftp.getReplyCode();

	      if(!FTPReply.isPositiveCompletion(reply)) {
	        ftp.disconnect();
	        LOGGER.warn("FTP server refused connection.");
	        //System.exit(1);
	      }
	      
	      Properties props = PropertiesFactory.getProperties(PropertiesFile.CJ_PROPERTIES);
	      String username = props.getProperty("cj.username");
	      String password = props.getProperty("cj.password");
	      
	      ftp.login(username, password);
	      ftp.setFileType(FTP.BINARY_FILE_TYPE, FTP.BINARY_FILE_TYPE);
	      //ftp.setFileTransferMode(FTP.BINARY_FILE_TYPE);
	      //System.err.println(i);
	      //System.err.println(ftp.printWorkingDirectory());
	      //FTPFile[] files = ftp.listFiles("/");
	      //System.err.println("lefnt is " + files.length);
	      // transfer files
	      String dir = getDir(retailer);
	      LOGGER.info("switching to " + dir);
	      ftp.cwd(dir);
	      
	      String file = getFile(retailer);
	      
	      File zip = new File("/etc/tomcat8/import/" + file);
	      if (zip.exists()) zip.delete();
	      FileOutputStream fos = new FileOutputStream(zip);
	      
	      LOGGER.info("getting file");
	      
	      FTPFile[] files = ftp.listFiles();
	      
	      for (FTPFile f : files) {
	    	  LOGGER.info(f.getName());
	      }
	      
	      LOGGER.info(file);
	      ftp.retrieveFile(file, fos);
	      
	      fos.close();
	      
	      LOGGER.info("done retrieving");
	      
	      byte[] buffer = new byte[1024]; 

	      try { 
	    	  	File fil = new File(outputFile);
	    	  	if (fil.exists()) fil.delete();
	    	  	
	            FileInputStream fileIn = new FileInputStream(zip); 
	            GZIPInputStream gZIPInputStream = new GZIPInputStream(fileIn); 
	            FileOutputStream fileOutputStream = new FileOutputStream(outputFile); 
	            int bytes_read; 
	
	            while ((bytes_read = gZIPInputStream.read(buffer)) > 0) { 
	                fileOutputStream.write(buffer, 0, bytes_read); 
	            } 
	
	            gZIPInputStream.close(); 
	            fileOutputStream.close(); 
	
	            LOGGER.info("The file was decompressed successfully!"); 

	        } catch (IOException ex) { 
	            ex.printStackTrace(); 
	        } 

	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
	}
	
	private static final String getFile(int retailer) {
		StringBuilder builder = new StringBuilder("");
		
		switch (retailer) {
		case 1:
			builder.append("Lord_Taylor-Lord_Taylor_Product_Catalog.xml.gz");
			break;
		case 2:
			builder.append("FragranceX_com-FragranceX_com_USA_Feed.xml.gz");
			break;
		case 3:
			builder.append("Sears-Sears_Product_Catalog.xml.gz");
			break;
		case 4:
			builder.append("Boscov_s_Department_Stores-Product_Catalog.xml.gz");
			break;
		case 5:
			builder.append("Sears-Sears_Marketplace_Product_Catalog_2.xml.gz");
			break;
		case 6:
			builder.append("Office_Depot_and_OfficeMax_-Product_Catalog.xml.gz");
			break;
		}
		
		String dir = builder.toString();
		
		return dir;		
	}
	
	
	private static final String getDir(int retailer) {
		StringBuilder builder = new StringBuilder("/outgoing/productcatalog/");
		
		switch (retailer) {
		case 1:
			builder.append("162775");
			break;
		case 2:
			builder.append("170594");
			break;
		case 3:
			builder.append("171716");
			break;
		case 4:
			builder.append("162770");
			break;
		case 5:
			builder.append("180188");
			break;
		case 6:
			builder.append("170573");
			break;
		}
		
		String dir = builder.toString();
		
		return dir;
	}
}
