package com.fl.qa.pages;

import java.io.IOException;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fl.qa.base.TestBase;
import com.fl.qa.util.ExcelUtility;

public class PaymentPage extends TestBase {
	
	@FindBy(xpath = "//*[contains(text(),'CONTINUE')]")
	WebElement cntBtn;
	
	
	@FindBy(xpath = "/html/body/div[1]/div/div[2]/div/div[1]/div[4]/div/div/div[2]/div/label[3]/div[2]/div/div")
	WebElement credit;
	
	
	@FindBy(xpath = "//input[@name='cardNumber']")
	WebElement cardInput;
	
	@FindBy(xpath = "//span[text()='Not a valid card number']")
	WebElement cardErmsg;
	
	
	
	public PaymentPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public String validatepayPageTitle() {
		return driver.getTitle();
		
	}
	

	public boolean creditCardpage() throws InterruptedException, IOException {
		
		cntBtn.click();
		Thread.sleep(5000);
		credit.click();
		//Map<String,String>testData =ExcelUtility.getMap();
		//cardNumInput.sendKeys(testData.get("creditcard"));
		//cardNumInput.sendKeys("371449635398431");
		cardInput.sendKeys("371111111111111");
		Thread.sleep(5000);
		
		try
        {	
           if(cardErmsg.isDisplayed())
           {
           return false;
           }
           else {
           return true;
           }
        }
        catch(Exception e)
        {
            return true;
        }

		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
