package com.HappyTesting.SauceLabs.TestScripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.HappyTesting.SauceLabs.BaseClass.BaseProperties;
import com.HappyTesting.SauceLabs.TestPages.CartPage;
import com.HappyTesting.SauceLabs.TestPages.CheckOutInformationPage;
import com.HappyTesting.SauceLabs.TestPages.CheckOutOverviewPage;
import com.HappyTesting.SauceLabs.TestPages.LoginPage;
import com.HappyTesting.SauceLabs.TestPages.OrderConfirmationPage;
import com.HappyTesting.SauceLabs.TestPages.ProductsPage;

public class PurchaseProducts extends BaseProperties {

	@Test(description = "Purchase Products")
	public void TC_01() throws InterruptedException {
		
		String [] products = {"Test.allTheThings() T-Shirt (Red)", "Sauce Labs Onesie", "Sauce Labs Fleece Jacket"};

		LoginPage Lpage = new LoginPage(driver);
		
		ProductsPage PPage = Lpage.Credentials("standard_user", "secret_sauce");

		CartPage CPage = PPage.AddtoCart(products).ClickCartButton();

		CheckOutInformationPage CIPage = CPage.CheckProducts(products).ClickCheckOutButton();
		
		CheckOutOverviewPage COOPage = CIPage.FillCheckOutInformation("Arunachela","eswaran S","635263").ClickContinueButton();
		
		Assert.assertTrue(COOPage.CheckTotalAmountForCartItems(products));
		
		OrderConfirmationPage OCPage = COOPage.ClickFinishButton();
		
		Assert.assertTrue(OCPage.IsYourOderIsConfirmed());
	}

}
