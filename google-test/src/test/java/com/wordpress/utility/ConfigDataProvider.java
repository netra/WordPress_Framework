package com.wordpress.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ConfigDataProvider {

	Properties pro;

	public ConfigDataProvider() {
         
		File src = new File("./Config/Config.properties");

		try {
			FileInputStream fis = new FileInputStream(src);

			pro = new Properties();

			pro.load(fis);
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Unable to load config File " + e.getMessage());
		}

	}

	public String getDataFromConfig(String keyTosearch) {

		return pro.getProperty(keyTosearch);

	}

	public String getBrowser() {

		return pro.getProperty("Browser");

	}

	public String getStagingURL() {

		return pro.getProperty("qaURL");
	}

}
