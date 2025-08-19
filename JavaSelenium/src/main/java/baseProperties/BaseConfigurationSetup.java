package baseProperties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseConfigurationSetup {

	public WebDriver driver;

	@BeforeMethod
	public void BrowserInvoke() {

		this.driver = WebDriverFactory.GetBrowser("chrome");
		
		driver.get("https://www.automationexercise.com/");

	}

	@AfterMethod
	public void BrowserTearDown() {

		driver.quit();

	}

}
