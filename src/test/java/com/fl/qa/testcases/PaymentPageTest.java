package com.fl.qa.testcases;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.fl.qa.base.TestBase;
import com.fl.qa.util.ExcelUtility;
import com.fl.qa.pages.HomePage;
import com.fl.qa.pages.ProductPage;
import com.fl.qa.pages.LoginPage;
import com.fl.qa.pages.PaymentPage;

public class PaymentPageTest extends TestBase{
	
	
	LoginPage loginPage;
	HomePage homePage;
	ProductPage productPage;
	PaymentPage paymentpage;
	
//	static ExtentTest test;
//	static ExtentReports report;
//	static ExtentTest logger;

	
	public PaymentPageTest() {
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
		paymentpage = productPage.buynow();
		
		
		
	}
	
	
	
	@Test(priority=1)
	public void verifyOrderPageTitle() {
		String orderPageTitle = paymentpage.validatepayPageTitle();
		AssertJUnit.assertEquals(orderPageTitle,"SAMSUNG Galaxy F12 ( 64 GB Storage, 4 GB RAM ) Online at Best Price On Flipkart.com");
	}

	
	
	@Test(priority=2)
	public void PlaceOrder() throws InterruptedException, IOException {
		
		//ExtentTest test = ExtentReportListener.startTest("TestName");
		

		boolean cardstatus = paymentpage.creditCardpage();
		if(cardstatus) {
			//System.out.println("Credit card succeess");
	
			log.error("credit cardNumber successfull");
			
		}
		else {
			System.out.println("Wrong credit card number");
			log.error("Wrong credit cardNumber");
			//test.log(LogStatus.FAIL, "Error message for wrong CardNumber displayed");
		}
		
	}
	
	
	@AfterMethod
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
