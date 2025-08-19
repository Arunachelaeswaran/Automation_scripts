package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import baseProperties.PageConfigurationSetup;

public class SignUpPage extends PageConfigurationSetup {

	public SignUpPage(WebDriver _driver) {

		super(_driver);
	}

	@FindBy(xpath = "//b[contains(text(),'Enter Account Information')]")
	private WebElement accountInformationLabel;

	@FindBy(id = "id_gender1")
	private WebElement mr_RadioButton;

	@FindBy(id = "id_gender2")
	private WebElement mrs_RadioButton;

	@FindBy(css = "#name")
	private WebElement nameField;

	@FindBy(id = "email")
	private WebElement emailField;

	@FindBy(css = "#password")
	private WebElement passwordField;

	@FindBy(id = "days")
	private WebElement day;

	@FindBy(id = "months")
	private WebElement month;

	@FindBy(id = "years")
	private WebElement year;

	@FindBy(id = "newsletter")
	private WebElement newsLetter_Checkbox;

	@FindBy(id = "optin")
	private WebElement receiveOffers_Checkbox;

	@FindBy(id = "first_name")
	private WebElement firstnameField;

	@FindBy(id = "last_name")
	private WebElement lastnameField;

	@FindBy(id = "company")
	private WebElement companyField;

	@FindBy(id = "address1")
	private WebElement address1Field;

	@FindBy(id = "address2")
	private WebElement address2Field;

	@FindBy(id = "country")
	private WebElement country;

	@FindBy(id = "state")
	private WebElement stateField;

	@FindBy(id = "city")
	private WebElement cityField;

	@FindBy(id = "zipcode")
	private WebElement zipcodeField;

	@FindBy(id = "mobile_number")
	private WebElement numberField;

	@FindBy(xpath = "//button[contains(text(),'Create Account')]")
	private WebElement createAccountButton;

	@FindBy(xpath = "//b[contains(text(),'Account Created!')]")
	private WebElement accountCreatedLabel;

	@FindBy(xpath = "//a[contains(text(),'Continue')]")
	private WebElement continueButton;

	public HomePage CreateUser(String _userName, String _password, String _date, String _month, String _year, String _fname,
			String _lname, String _company, String _add1, String _add2, String _country, String _state, String _city,
			String _zip, String _num) {

		// Wait for a webelement on the signUp Page that has to be appear
		wait.until(ExpectedConditions.visibilityOf(accountInformationLabel));

		// Verify that 'ENTER ACCOUNT INFORMATION' is visible
		Assert.assertEquals(true, accountInformationLabel.isDisplayed());

		// Fill details: Title, Name, Email, Password, Date of birth
		mr_RadioButton.click();

		nameField.clear();

		nameField.sendKeys(_userName);

		Assert.assertEquals(false, emailField.isEnabled());

		passwordField.sendKeys(_password);

		SelectByText(day, _date);

		SelectByText(month, _month);

		SelectByText(year, _year);

		// Select checkbox 'Sign up for our newsletter!' Due to some element intercept
		// exception javascript executor code has been used to click the element
		js.executeScript("arguments[0].click();", newsLetter_Checkbox);

		// Select checkbox 'Receive special offers from our partners!' Due to some
		// element intercept exception javascript executor code has been used to click
		// the element
		js.executeScript("arguments[0].click();", receiveOffers_Checkbox);

		// Fill details: First name, Last name, Company, Address, Address2,
		// Country, State, City, Zipcode, Mobile Number
		firstnameField.sendKeys(_fname);
		lastnameField.sendKeys(_lname);
		companyField.sendKeys(_company);
		address1Field.sendKeys(_add1);
		address2Field.sendKeys(_add2);

		SelectByText(country, _country);

		stateField.sendKeys(_state);
		cityField.sendKeys(_city);
		zipcodeField.sendKeys(_zip);
		numberField.sendKeys(_num);

		// Click 'Create Account button'
		js.executeScript("arguments[0].click();", createAccountButton);
		//createAccountButton.click();

		// Verify that 'ACCOUNT CREATED!' is visible
		wait.until(ExpectedConditions.visibilityOf(accountCreatedLabel));
		Assert.assertEquals(accountCreatedLabel.getText(), "ACCOUNT CREATED!");

		// Click 'Continue' button
		continueButton.click();
		
		return new HomePage(driver);
	}

}
