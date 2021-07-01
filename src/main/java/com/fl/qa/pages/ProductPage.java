package com.fl.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fl.qa.base.TestBase;
import com.fl.qa.pages.PaymentPage;

public class ProductPage extends TestBase{

	@FindBy(xpath = "//button[@type='button']")
	WebElement buybtn;
	
	@FindBy(xpath ="//*[@class='_30jeq3 _16Jk6d']")
	WebElement price;
	
	
	
	public ProductPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	


	public String validatePageTitle() {
		return driver.getTitle();
	}
	
	public String validateItemPrice() {
		String prices = price.getText().toString();
		return prices;
	}
	public PaymentPage buynow() {
		 buybtn.click();
		
		return new PaymentPage();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
