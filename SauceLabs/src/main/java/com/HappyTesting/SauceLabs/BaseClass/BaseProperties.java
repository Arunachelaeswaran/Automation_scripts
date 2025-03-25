package com.HappyTesting.SauceLabs.BaseClass;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseProperties {
	
	protected WebDriver driver; //Variable has been protected. It should accessible only outside the package if it extends
	
	@BeforeTest
	public void SetupBrowser() {
		
		driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/v1/");
		driver.manage().window().maximize();
		
	}
	
	@AfterTest
	public void TearDownBrowser() {
		
		driver.quit();
		
	}

}
