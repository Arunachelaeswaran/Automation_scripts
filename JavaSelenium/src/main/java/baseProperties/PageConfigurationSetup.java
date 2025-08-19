package baseProperties;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageConfigurationSetup {

	protected WebDriver driver;

	protected WebDriverWait wait;

	protected Select dropdown;
	
	protected JavascriptExecutor js;

	public PageConfigurationSetup(WebDriver _driver) {

		this.driver = _driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(8));
		js = (JavascriptExecutor)driver;
		PageFactory.initElements(driver, this);

	}

	public void SelectByText(WebElement ele, String val) {
		
		dropdown = new Select(ele);
		dropdown.selectByVisibleText(val);

	}

}
