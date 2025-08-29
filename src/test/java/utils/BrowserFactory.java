package utils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {

	WebDriver driver;
	
	public static WebDriver StartApplication(WebDriver driver, String URL, String browser) {
		
		if(browser.equalsIgnoreCase("Chrome")) {
			driver = new ChromeDriver();
			System.out.println("Chrome browser started");
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
			System.out.println("Firefox browser started");
		}
		else {
			throw new RuntimeException("Browser not supported: " + browser);
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(URL);
		return driver;
	}
	
	public static void quitBrowser(WebDriver driver) {
		if(driver!= null) {
			driver.quit();
		}
	}
	
}
