package com.bcframeworkhybrid.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	Properties properties;

	public ConfigReader() {
		try {
			FileInputStream fileInputStream = new FileInputStream("C:\\Users\\HP-laptop\\eclipse-workspace\\BootCampFramworkHybrid-Mamdouh-mmosman74\\src\\test\\java\\bctestdata.properties");
			properties = new Properties();
			properties.load(fileInputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getProperty(String key) {
		return properties.getProperty(key);
	}

}
