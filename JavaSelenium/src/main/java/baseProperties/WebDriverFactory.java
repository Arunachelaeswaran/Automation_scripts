package baseProperties;

import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory {

	private static WebDriver driver;

	public static WebDriver GetBrowser(String browserType) {

		switch (browserType) {

		case "chrome" -> {

			driver = new ChromeDriver();
			driver.manage().window().maximize();
			break;

		}

		case "firefox" -> {

			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			break;

		}

		case "edge" -> {

			driver = new EdgeDriver();
			driver.manage().window().maximize();
			break;

		}
		default -> {

			throw new InvalidArgumentException("Invalid Browser Type: " + browserType);

		}

		}

		return driver;

	}

}
