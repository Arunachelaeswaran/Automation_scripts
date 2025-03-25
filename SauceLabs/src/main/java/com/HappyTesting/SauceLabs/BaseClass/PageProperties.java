package com.HappyTesting.SauceLabs.BaseClass;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageProperties {
	
	protected WebDriver driver;
	protected WebDriverWait wait;
	
	public PageProperties(WebDriver Driver) {
		
		this.driver = Driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(8));
		PageFactory.initElements(driver, this);

	}

}
