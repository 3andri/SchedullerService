package com.andri.service.schedule.Stock;

import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//@Configuration
public class ChromeDrivergrab {
	private static ChromeDrivergrab single_instance = null;
	private static WebDriver driver = null;
	public String url;
	public String s;

	private final Properties configProp =PropertiesCache();

	private Properties PropertiesCache() {
		// Private constructor to restrict new instances
		InputStream in = this.getClass().getClassLoader().getResourceAsStream("application.properties");
		System.out.println("Reading all properties from the file");
		try {
			Properties conf = new Properties();
			conf.load(in);
			return conf;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}


	private ChromeDrivergrab() {
		// System.setProperty("webdriver.gecko.driver", "C:\\temp\\geckodriver.exe");
		System.out.println(configProp.getProperty("andri.chrome.path"));
		System.setProperty("webdriver.chrome.driver", configProp.getProperty("andri.chrome.path"));
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
		options.addArguments("--disable-dev-shm-usage");
		options.addArguments(
				"user-agent=Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/84.0.4147.125 Safari/537.36");
		driver = new ChromeDriver(options);
		// driver = new ChromeDriver();
	}

	public static ChromeDrivergrab getInstance() {
		if (single_instance == null)
			single_instance = new ChromeDrivergrab();

		return single_instance;
	}

	public String getUrl(String url) {
		try {
			driver.navigate().to(url);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(driver.getPageSource());
		System.out.println(driver.getCurrentUrl());
		WebElement l = driver.findElement(By.tagName("body"));

		return l.getText();
	}

	public String getUrlAdd() {
		return url;
	}

	public void close() {
		driver.close();
		driver = null;
		single_instance = null;
	}
}
