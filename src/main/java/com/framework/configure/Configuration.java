package com.framework.configure;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Configuration {
	
	public static String getProperties(String value) {
			return setProerties(value);
	}

	private static String setProerties(String value) {
		// TODO Auto-generated method stub
		Properties properties = new Properties();
		File src = new File(System.getProperty("user.dir")+"//Files//property.properties");
		FileInputStream fis;
		try {
			fis = new FileInputStream(src);
			properties.load(fis);
			return properties.getProperty(value);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return value;	
	}
}
