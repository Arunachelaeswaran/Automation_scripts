package com.HappyTesting.SauceLabs.TestPages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.HappyTesting.SauceLabs.BaseClass.PageProperties;

public class ProductsPage extends PageProperties {
	
	public ProductsPage (WebDriver Driver) { super(Driver); }
	
	@FindBy(css = ".inventory_item_label a div") private List<WebElement> products;
	
	@FindBy(css = ".pricebar button") private List<WebElement> addcartButtons;
	
	@FindBy(css = "a.shopping_cart_link") private WebElement cartBtn;
	
	public ProductsPage AddtoCart(String [] pros) {
		
		int count = 0;
		
		for (WebElement product : products) {

			for (int i = 0; i < pros.length; i++) {
				
				if (product.getText().equalsIgnoreCase(pros[i])) {
					
					addcartButtons.get(count).click();
					
				}
			}
			
			count = count+1;
		}
		
		return this;
		
	}
	
	public CartPage ClickCartButton() throws InterruptedException {
		cartBtn.click();
		return new CartPage(driver);
		
	}
	
	
	
	

}
