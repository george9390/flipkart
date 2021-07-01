package com.fl.qa.testcases;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import org.testng.Assert;
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
import com.fl.qa.pages.PaymentPage;
import com.fl.qa.util.ExcelUtility;

public class ProductPageTest extends TestBase{

	LoginPage loginPage;
	HomePage homePage;
	ProductPage productPage;
    PaymentPage paymentPage;

	
	public ProductPageTest() {
		super();
	}
	


	@BeforeMethod
	@BeforeTest
	public void setUp() throws InterruptedException, IOException {
		initialization();
		Map<String,String>testData =ExcelUtility.getMap();
		loginPage = new LoginPage();
		homePage = loginPage.Login(testData.get("username"), testData.get("password"));
		Thread.sleep(5000);
		productPage = homePage.searchItemandClick(testData.get("itemtosearch"));
		ArrayList<String> newTb = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(newTb.get(1));
		
	}
	
	@Test(priority=1)
	public void verifyItemPageTitle() {
		String PageTitle = productPage.validatePageTitle();
		Assert.assertEquals(PageTitle,"SAMSUNG Galaxy F12 ( 64 GB Storage, 4 GB RAM ) Online at Best Price On Flipkart.com");
		
	}
	
	/*@Test(priority=2)
	public void verifyItemPrice() {
		
		log.debug("Verifying item Price");
		String expectedPrice = "45,990";
		String price = itemSelected.validateItemPrice();
		price = price.substring(1);
		AssertJUnit.assertEquals(expectedPrice, price);
		
*/
	
	@Test(priority=2)
	public void buyNow() {
		log.debug("click the pay button.");
		paymentPage = productPage.buynow();
	}
	

	@AfterMethod
	@AfterTest
	public void tearDown() {
		//driver.quit();
	}
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	

