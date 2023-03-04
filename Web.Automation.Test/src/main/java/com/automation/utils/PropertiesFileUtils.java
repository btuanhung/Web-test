package com.automation.utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

public class PropertiesFileUtils {
	private static String configPath = "./configuration/configs.properties";
	private static String urlPath = "./configuration/url.properties";
	//get value
	public String getProperty(String key) {
		Properties prop = new Properties();
		String value = "";
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(configPath);
			prop.load(fis);
			value = prop.getProperty(key);
			return value;
		}catch(Exception e) {
			System.out.println("Had an error");
		}
		return value;
	}
	//save url
	public void setUrl(String key, String value) {
		Properties prop = new Properties();
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(urlPath);
			prop.setProperty(key, value);
			prop.store(fos, value);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	//get url
	public String getUrl(String key) {
		Properties prop = new Properties();
		String value = "";
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(urlPath);
			prop.load(fis);
			value = prop.getProperty(key);
			return value;
		}catch(Exception e) {
			System.out.println("Had an error");
		}
		return value;
	}
}
