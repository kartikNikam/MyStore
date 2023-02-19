package com.Mystore.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {
	
	Properties properties;
	
	String path="C:\\Users\\kartikpc\\eclipse-workspace\\MyStore\\Configuration\\config.properties";
	// Constructor
	public ReadConfig() {
		
		properties = new Properties();
		
		try {
			FileInputStream fis = new FileInputStream(path);
			try {
				properties.load(fis);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public String getBaseUrl() {
		String value=properties.getProperty("baseurl");
		if(value!=null)
			return value;
		else
			throw new RuntimeException("url not available in config file");
	}
	
	public String Browser() {
		String value=properties.getProperty("browser");
		if(value!=null)
			return value;
		else
			throw new RuntimeException("browser not available in config file");
	}

}
