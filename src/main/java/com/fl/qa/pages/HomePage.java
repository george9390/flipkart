package com.fl.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fl.qa.base.TestBase;
import com.fl.qa.pages.ProductPage;

public class HomePage extends TestBase{

	@FindBy(xpath = "//input[@name='q']")
	WebElement searchInput;
	
	@FindBy(xpath = "//button[@type='submit']")
	WebElement searchbtn;
	
	
	@FindBy(xpath = "//*[contains(text(), 'SAMSUNG Galaxy F12 (Sea Green, 64 GB)')]")
	WebElement itemtoselect;
	
	
	
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String validateLoginPageTitle() {
		return driver.getTitle();
		
	}
	
	/*public boolean verifyCorrectUserName() {
		return userLabel.isDisplayed();
	}
	*/
	public ProductPage searchItemandClick(String item) throws InterruptedException {
		searchInput.sendKeys(item);
		searchbtn.submit();
		Thread.sleep(5000);
		itemtoselect.click(); 
		return new ProductPage();
	}
	

	
	

}
	
	
	
	
	
	
	
	
	
	
	
	

