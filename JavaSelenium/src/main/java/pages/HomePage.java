package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import baseProperties.PageConfigurationSetup;

public class HomePage extends PageConfigurationSetup {

	public HomePage(WebDriver _driver) {
		super(_driver);
	}

	@FindBy(xpath = "//a[text()=' Home']")
	private WebElement HomeLabel;

	@FindBy(xpath = "//a[text()=' Signup / Login']")
	private WebElement LoginButton;
	
	@FindBy(xpath = "//a[text()=' Delete Account']")
	private WebElement deleteAccountButton;
	
	@FindBy(xpath = "//b[text()='Account Deleted!']")
	private WebElement accountDeletedLabel;
	
	@FindBy(xpath = "//a[text()='Continue']")
	private WebElement continueButton;

	public LoginPage NavigateToLoginPage() {

		// Wait for the Home Label to appear on the page
		wait.until(ExpectedConditions.visibilityOf(HomeLabel));

		// Verify that home page is visible successfully
		String homePageTitle = driver.getTitle();
		Assert.assertEquals(homePageTitle, "Automation Exercise");

		// Click on 'Signup / Login' button
		LoginButton.click();

		return new LoginPage(driver);

	}
	
	public String getUsernameLabel(String username) {
		return driver.findElement(By.xpath("//b[text()='" + username + "']")).getText();
	}
	
	public void DeleteAccount(String _username) {

		// Verify that 'Logged in as username' is visible
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//b[text()='" + _username + "']"))));
		Assert.assertEquals(getUsernameLabel(_username), _username);

		// Click 'Delete Account' button
		deleteAccountButton.click();

		// Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
		wait.until(ExpectedConditions.visibilityOf(accountDeletedLabel));
		Assert.assertEquals(accountDeletedLabel.getText(), "ACCOUNT DELETED!");

		// Click the Continue button
		continueButton.click();

	}

	public String getHomeLabel() {
		
		return wait.until(ExpectedConditions.visibilityOf(HomeLabel)).getText();
	}

}
