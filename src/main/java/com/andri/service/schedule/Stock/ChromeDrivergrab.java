package com.andri.service.schedule.Stock;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeDrivergrab {
	private static ChromeDrivergrab single_instance = null;
	private static WebDriver driver = null;
	public String url;
	public String s;

	private ChromeDrivergrab() {
		// System.setProperty("webdriver.gecko.driver", "C:\\temp\\geckodriver.exe");
		System.setProperty("webdriver.chrome.driver", "C:\\temp\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		//options.addArguments("--headless", "--disable-gpu", "--blink-settings=imagesEnabled=false");
		driver = new ChromeDriver(options);
		//driver = new ChromeDriver();
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
		WebElement l=driver.findElement(By.tagName("body"));
		
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
