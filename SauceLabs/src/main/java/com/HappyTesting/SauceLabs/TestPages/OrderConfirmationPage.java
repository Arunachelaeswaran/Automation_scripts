package com.HappyTesting.SauceLabs.TestPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.HappyTesting.SauceLabs.BaseClass.PageProperties;

public class OrderConfirmationPage extends PageProperties{

	public OrderConfirmationPage(WebDriver Driver) { super(Driver); }
	
	@FindBy(css="#checkout_complete_container .complete-header") private WebElement confirmOrderLabel;
	
	
	public boolean IsYourOderIsConfirmed() {
		
		if(confirmOrderLabel.getText().equalsIgnoreCase("THANK YOU FOR YOUR ORDER"))
			
			return true;
		
		else
			return false;
		
		
	}
	

}
