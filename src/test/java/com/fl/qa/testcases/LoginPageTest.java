package com.fl.qa.testcases;

import java.io.IOException;
import java.util.Map;

import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import com.fl.qa.base.TestBase;
import com.fl.qa.pages.HomePage;
import com.fl.qa.pages.LoginPage;
import com.fl.qa.util.ExcelUtility;

public class LoginPageTest extends TestBase {

	LoginPage loginPage;
	HomePage homepage;


	
	
	public LoginPageTest() {
		super();
		
	}
	

	
	@BeforeMethod
	//@BeforeTest
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
	}
	
	
	@Test(priority=1)
	public void loginTest() throws InterruptedException, IOException{
		Thread.sleep(2000);
		log.debug("Loging..");
		Map<String,String>testData =ExcelUtility.getMap();
		homepage = loginPage.Login(testData.get("username"), testData.get("password"));
	}
	
	@Test(priority=2)
	public void verifyLoginPageTitle() {
		log.debug("Verifying Loginpage title.");
		String PageTitle = loginPage.validateloginPageTitle();
		AssertJUnit.assertEquals(PageTitle, "Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!");
	}
//


	@AfterMethod
	//@AfterTest
	public void tearDown() {
		//driver.quit();
	}

}
