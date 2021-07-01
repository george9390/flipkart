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
import com.fl.qa.pages.ProductPage;
import com.fl.qa.pages.LoginPage;
import com.fl.qa.util.ExcelUtility;

public class HomePageTest extends TestBase{

	HomePage homePage;
	LoginPage loginPage;
	ProductPage productPage;
	
	
	
	public HomePageTest() {
		super();
	}



	@BeforeMethod
	//@BeforeTest
	public void setUp() throws IOException {
		initialization();
		Map<String,String>testData =ExcelUtility.getMap();
		loginPage = new LoginPage();
		homePage = loginPage.Login(testData.get("username"), testData.get("password"));
	}
	
	
	
	@Test(priority=1)
	public void verifyHomePageTitle() throws InterruptedException {
		log.debug("Page Title Verification");
		String homePageTitle = homePage.validateLoginPageTitle();
		AssertJUnit.assertEquals(homePageTitle, "Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!");
	}
	@Test(priority=2)
	public void itemSearchclick() throws IOException, InterruptedException {
		Thread.sleep(4000);
		log.debug("Items searching and selecting");
		Map<String,String>testData =ExcelUtility.getMap();
		productPage = homePage.searchItemandClick(testData.get("itemtosearch"));
		
	}
	
	
	/*@Test(priority=3)
	public void verifyUserName() {
		log.debug("Verifying user name");
		AssertJUnit.assertTrue(homePage.verifyCorrectUserName());
	}*/
	
	
	
	@AfterMethod
	//@AfterTest
	public void tearDown() {
		//driver.quit();
	}	
	
	
	
	
	
	
	
	
	
}
