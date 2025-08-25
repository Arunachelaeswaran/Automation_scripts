package testScripts;

import org.testng.annotations.Test;

import baseProperties.BaseConfigurationSetup;
import junit.framework.Assert;
import pages.HomePage;
import pages.LoginPage;
import pages.SignUpPage;

public class LoginPageTestcases extends BaseConfigurationSetup {
	
	String username = "Arunachelam";
	String email = "automationuser77@gmail.com";
	String password = "Test@123";

	@Test(description = "Create a User Account")
	public void TC_001() {
		
		HomePage homePage = new HomePage(driver);

		LoginPage loginPage = homePage.NavigateToLoginPage();

		SignUpPage signUpPage = loginPage.NewUserSignUp(username, email);

		homePage = signUpPage.CreateUser(username, "Test@123", "21", "December", "1999", "Automation", "User",
				"AutomationTech", "1008 W MAIN ST", "SALEM", "Canada", "USA", "VA", "24153", "1234567890");

	}

	@Test(description = "Login User with correct email and password")
	public void TC_002() {

		HomePage homePage = new HomePage(driver);

		LoginPage loginPage = homePage.NavigateToLoginPage();

		homePage = loginPage.LoginIntoAccount(email, password);
		
		Assert.assertEquals("Arunachelam", homePage.getUsernameLabel(username));

	}

	@Test(description = "Login User with incorrect email and password")
	public void TC_003() {

		HomePage homePage = new HomePage(driver);

		LoginPage loginPage = homePage.NavigateToLoginPage();

		loginPage.LoginIntoAccount(email, "Test@1234");

		Assert.assertEquals("Your email or password is incorrect!", loginPage.getInvalidCredentialsMessage());

	}
	
	@Test(description = "Logout the User Account")
	public void TC_004() {

		HomePage homePage = new HomePage(driver);
		
		Assert.assertEquals("Home", homePage.getHomeLabel());;

		LoginPage loginPage = homePage.NavigateToLoginPage();
		
		Assert.assertEquals("Login to your account", loginPage.getLoginToYourAccountLabel());

		loginPage.LoginIntoAccount(email, password);

		Assert.assertEquals("Arunachelam", homePage.getUsernameLabel(username));
		
	}
	
	@Test(description = "Delete the User Account")
	public void TC_005() {

		HomePage homePage = new HomePage(driver);
		
		Assert.assertEquals("Home", homePage.getHomeLabel());;

		LoginPage loginPage = homePage.NavigateToLoginPage();

		loginPage.LoginIntoAccount(email, password);

		Assert.assertEquals("Arunachelam", homePage.getUsernameLabel(username));
		
		homePage.DeleteAccount(username);
		
	}

}
