package com.HappyTesting.SauceLabs.TestPages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.HappyTesting.SauceLabs.BaseClass.PageProperties;

public class CheckOutOverviewPage extends PageProperties{

	public CheckOutOverviewPage (WebDriver Driver) { super(Driver); }
	
	@FindBy(css = "div.cart_item_label a div") private List<WebElement> productLabels;
	
	@FindBy(xpath = "//div[@class='cart_item_label'] //div[@class='inventory_item_price']") private List<WebElement> priceLabels;
	
	@FindBy(xpath = "//div[@class='cart_footer'] //a[@class='btn_action cart_button']") private WebElement finishButton;
	
	@FindBy(xpath = "//div[@class='summary_info'] //div[@class='summary_subtotal_label']") private WebElement getTotalAmount;
	
	public boolean CheckTotalAmountForCartItems(String [] products) {
		
		int count = 0;
		String pLabel;
		String [] chars;
		String [] chars2;
		float totalAmount=0;
		
		for (WebElement productLabel : productLabels) {
			
			for (int i = 0; i < products.length; i++) {
				
				if (productLabel.getText().equalsIgnoreCase(products[i])) {
					
					pLabel = priceLabels.get(count).getText();
					System.out.println(productLabel.getText()+": "+pLabel);
					
					//Extract the Price and convert it to number. Then Calculate the Total Amount
					chars = pLabel.split("[$]");
					
					totalAmount = totalAmount + Float.parseFloat(chars[1]);
	
				}	
			}
			count = count+1;
		}
		System.out.println("Total Amount for the Cart items: "+totalAmount);
		
		
		//Compare the UI amount and our logic amount is equals
		chars2 = getTotalAmount.getText().split("[$]");
		
		if(totalAmount == Float.parseFloat(chars2[1])) {	
			return true;
		}
		else {
			return false;
		}
		
		
	}
	
	public OrderConfirmationPage ClickFinishButton() {
		
		finishButton.click();
		return new OrderConfirmationPage(driver);
	}

//	public float getTotalAmount() {
//		String [] chars;
//		
//		chars = totalAmount.getText().split("[$]");
//		
//		return Float.parseFloat(chars[1]);
//		
//	}

}
