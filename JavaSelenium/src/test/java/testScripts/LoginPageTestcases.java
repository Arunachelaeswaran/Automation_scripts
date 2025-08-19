package testScripts;

import org.testng.annotations.Test;

import baseProperties.BaseConfigurationSetup;
import junit.framework.Assert;
import pages.HomePage;
import pages.LoginPage;
import pages.SignUpPage;

public class LoginPageTestcases extends BaseConfigurationSetup {

	@Test(description = "Create a User Login and Delete the User")
	public void TC_001() {

		String username = "AutomationUser";
		String email = "automationuser771@gmail.com";
		
		HomePage homePage = new HomePage(driver);

		LoginPage loginPage = homePage.NavigateToLoginPage();

		SignUpPage signUpPage = loginPage.NewUserSignUp(username, email);

		homePage = signUpPage.CreateUser(username, "Test@123", "21", "December", "1999", "Automation", "User",
				"AutomationTech", "1008 W MAIN ST", "SALEM", "Canada", "USA", "VA", "24153", "1234567890");

		homePage.DeleteAccount(username);

	}

	@Test(description = "Login User with correct email and password")
	public void TC_002() {
		
		String username = "Arunachelam";
		String email = "arunachelam77@gmail.com";
		String password = "Test@123";

		HomePage homePage = new HomePage(driver);

		LoginPage loginPage = homePage.NavigateToLoginPage();

		homePage = loginPage.LoginIntoAccount(email, password);
		
		Assert.assertEquals("Arunachelam", homePage.getUsernameLabel(username).getText());


	}

	@Test(description = "Login User with incorrect email and password")
	public void TC_003() {

		String email = "automationuser771@gmail.com";
		String password = "Test@123";//

		HomePage homePage = new HomePage(driver);

		LoginPage loginPage = homePage.NavigateToLoginPage();

		loginPage.LoginIntoAccount(email, password);

		Assert.assertEquals("Your email or password is incorrect!", loginPage.getInvalidCredentialsMessage());

	}

}
