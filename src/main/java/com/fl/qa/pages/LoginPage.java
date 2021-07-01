package com.fl.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fl.qa.base.TestBase;
import com.fl.qa.pages.HomePage;

public class LoginPage extends TestBase{
	
	@FindBy(xpath = "//input[@class='_2IX_2- VJZDxU']")
    WebElement username;
	
	@FindBy(xpath = "//input[@type='password']")
    WebElement password;
	
	
	@FindBy(xpath = "//button/span")
    WebElement loginbtn;
	
	//Initializing the page objects
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	
	
	public HomePage Login(String usname, String pswd) {
		username.sendKeys(usname);
		password.sendKeys(pswd);
		loginbtn.click();
		
		return new HomePage();
	}




	public String validateloginPageTitle() {
		return driver.getTitle();
	}
}
