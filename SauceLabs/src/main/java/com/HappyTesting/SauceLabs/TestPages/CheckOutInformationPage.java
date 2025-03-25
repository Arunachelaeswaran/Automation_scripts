package com.HappyTesting.SauceLabs.TestPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.HappyTesting.SauceLabs.BaseClass.PageProperties;

public class CheckOutInformationPage extends PageProperties{

	public CheckOutInformationPage(WebDriver Driver) { super(Driver); }
	
	@FindBy(css = "#first-name") private WebElement firstName;
	
	@FindBy(css = "#last-name") private WebElement lastName;
	
	@FindBy(css = "#postal-code") private WebElement zipCode;
	
	@FindBy(xpath = "//input[@value='CONTINUE']") private WebElement continueBtn;
	
	public CheckOutInformationPage FillCheckOutInformation(String fname, String lname, String zip) {
		
		firstName.sendKeys(fname);
		lastName.sendKeys(lname);
		zipCode.sendKeys(zip);
		
		return this;
	}
	
	public CheckOutOverviewPage ClickContinueButton() {
		
		continueBtn.click();
		
		return new CheckOutOverviewPage(driver);
	}
	

}
