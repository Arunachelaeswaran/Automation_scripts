package com.HappyTesting.SauceLabs.TestPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.HappyTesting.SauceLabs.BaseClass.PageProperties;

public class LoginPage extends PageProperties {

	public LoginPage(WebDriver Driver) {

		super(Driver);
		
	}
	
	@FindBy(id = "user-name") private WebElement Username;
	
	@FindBy(id = "password") private WebElement Password;
	
	@FindBy(id = "login-button") private WebElement LoginButton;
	
	public ProductsPage Credentials(String name, String password) {
		
		Username.sendKeys(name);
		Password.sendKeys(password);
		LoginButton.click();
		return new ProductsPage(driver);
		
	}

}
