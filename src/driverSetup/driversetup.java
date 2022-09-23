package driverSetup;

import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class driversetup {
	WebDriver driver;

	public void open_chrome() {
		System.setProperty("webdriver.chrome.driver", "/Users/anmolmishra/Documents/DSA/GoComet_cucumber/chromedriver");
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		driver = new ChromeDriver(options);
		System.out.println();
		driver.get("https://www.demoblaze.com/index.html");

	}

	public void close_chrome() {
		driver.quit();

	}

	public WebDriver get_driver() {
		return driver;
	}

}

