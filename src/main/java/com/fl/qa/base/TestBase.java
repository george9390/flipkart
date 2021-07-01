package com.fl.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.fl.qa.util.TestUtil;

public class TestBase {
	
	
	public static WebDriver driver;
	public static Properties prop;
	public static Logger log;
	
	
public TestBase() {
		
		try {
			prop = new Properties();
			FileInputStream file = new FileInputStream("C:\\Users\\George Mathew\\eclipse-workspace\\FLRTest\\src\\main\\java\\com\\fl\\qa\\config\\config.properties");
			prop.load(file);
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}

	public static void initialization() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\George Mathew\\Documents\\chromedriver.exe");
		driver = new ChromeDriver();
		log = Logger.getLogger("Flipkart");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
		 

	}


	public WebDriver getDriver() {
		return driver;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
