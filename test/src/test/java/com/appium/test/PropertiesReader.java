package com.appium.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class PropertiesReader {

	public static Map<String, String> read(String file, String[] propertyNames) {
		Properties prop = new Properties();
		InputStream input = null;

		Map<String, String> result = new HashMap<>();
		try {
			input = new FileInputStream(file);

			prop.load(input);
			for (String property : propertyNames) {
				result.put(property, prop.getProperty(property));
			}

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return result;

	}
}
