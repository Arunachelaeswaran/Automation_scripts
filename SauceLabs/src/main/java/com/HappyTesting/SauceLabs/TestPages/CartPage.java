package com.HappyTesting.SauceLabs.TestPages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.HappyTesting.SauceLabs.BaseClass.PageProperties;

public class CartPage extends PageProperties{

	public CartPage(WebDriver Driver) {	super(Driver); }
	
	@FindBy(css = "div.cart_item_label a div") private List<WebElement> productLabels;
	
	@FindBy(xpath = "//div[@class='cart_footer'] //a[@class='btn_action checkout_button']") private WebElement checkOutBtn;
	
	public CartPage CheckProducts(String [] products) {
		
		for (WebElement productLabel : productLabels) {
			
			for (int i = 0; i < products.length; i++) {
				
				if(productLabel.getText().equalsIgnoreCase(products[i])) {
					
					System.out.println("Checkout Item: "+productLabel.getText());
				}
				
			}
		}
		
		return this;
	
	}
	
	public CheckOutInformationPage ClickCheckOutButton() {
		
		checkOutBtn.click();
		return new CheckOutInformationPage(driver);
	}
	

}
