package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import baseProperties.PageConfigurationSetup;

public class LoginPage extends PageConfigurationSetup {

	public LoginPage(WebDriver _driver) {
		super(_driver);
	}

	@FindBy(xpath = "//h2[text()='New User Signup!']")
	private WebElement NewUserSignUp_Label;

	@FindBy(name = "name")
	private WebElement nameField;

	@FindBy(xpath = "//input[@data-qa='signup-email']")
	private WebElement emailAddressField;

	@FindBy(xpath = "//button[text()='Signup']")
	private WebElement signUpButton;

	@FindBy(xpath = "(//input[@name='email'])[1]")
	private WebElement usernameField;

	@FindBy(xpath = "//input[@name='password']")
	private WebElement passwordField;

	@FindBy(xpath = "//button[@data-qa='login-button']")
	private WebElement loginButton;

	@FindBy(xpath = "//p[contains(text(),'Your email or password is incorrect!')]")
	private WebElement invalidCredentialsValidationMessage;

	public String getInvalidCredentialsMessage() {

		return wait.until(ExpectedConditions.visibilityOf(invalidCredentialsValidationMessage)).getText();

	}

	public SignUpPage NewUserSignUp(String userName, String email) {

		// wait for the Login Page to appear
		wait.until(ExpectedConditions.visibilityOf(NewUserSignUp_Label));

		// Verify 'New User Signup!' is visible
		Assert.assertEquals(true, NewUserSignUp_Label.isDisplayed());

		// Enter name and email address
		nameField.sendKeys(userName);
		emailAddressField.sendKeys(email);

		// Click 'Signup' button
		signUpButton.click();

		return new SignUpPage(driver);

	}

	public HomePage LoginIntoAccount(String username, String password) {

		usernameField.sendKeys(username);
		passwordField.sendKeys(password);
		loginButton.click();

		return new HomePage(driver);

	}

}
