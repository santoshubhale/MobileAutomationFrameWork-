package com.generic;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyReader {
	
	
	
	/**
	* This is method is used to read the content from capabalities property file 
	*/
	public String getStringTestData(String key) {
		Properties prop1 = new Properties();
		InputStream input1 = null;
		String Value = null;
		try {
			input1 = getClass().getResourceAsStream("/testDataHandler/capabalities.properties");
			prop1 = new Properties();
			// load a properties file
			prop1.load(input1);

			Value = prop1.getProperty(key);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Value;
	}
	/**
	* This is method is used to read the content from capabalities property file 
	*/
	public String getStringForElements(String key) {
		Properties prop1 = new Properties();
		InputStream input1 = null;
		String Value = null;
		try {
			input1 = getClass().getResourceAsStream("/elementsHandler/elements.properties");
			prop1 = new Properties();
			// load a properties file
			prop1.load(input1);

			Value = prop1.getProperty(key);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Value;
	}
	
	public String getStringNewTestData(String key) {
		Properties prop1 = new Properties();
		InputStream input1 = null;
		String Value = null;
		try {
			input1 = getClass().getResourceAsStream("/testDataHandler/testData.properties");
			prop1 = new Properties();
			// load a properties file
			prop1.load(input1);

			Value = prop1.getProperty(key);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Value;
	}
}