package com.careydevelopment.ecommerceautomation.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class UrlHelper {

	public static InputSource getInputSource(String url) throws SAXException,ParserConfigurationException,IOException {
		//System.err.println(url);		
		URL urlConn = new URL(url);
		HttpURLConnection httpcon = (HttpURLConnection) urlConn.openConnection();
		httpcon.setConnectTimeout(20000);
	    httpcon.addRequestProperty("User-Agent", "Mozilla/4.76");
	    
	    InputStream is = httpcon.getInputStream();
	   
	    //Reader reader = new InputStreamReader(is,"ISO-8859-1");
	    //Reader reader = new InputStreamReader(is,"UTF-8");
	    Reader reader = new InputStreamReader(is,"US-ASCII");
	    
	    InputSource ins = new InputSource(reader);
	    //ins.setEncoding("ISO-8859-1");
	    //ins.setEncoding("UTF-8");
	    ins.setEncoding("US-ASCII");
	    
	    return ins;
	}
}
