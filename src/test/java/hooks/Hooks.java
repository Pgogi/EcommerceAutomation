package hooks;


import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.BrowserFactory;
import utils.ScreenshotUtil;

public class Hooks {

	//hooks here in BDD means base class in POM
	private static WebDriver driver;
	
	@Before
	public void setUp() {
		driver = BrowserFactory.StartApplication(driver, "https://automationexercise.com/login", "chrome");
		System.out.println("Browser launched successfully");
	}
	
	@After
	public void tearDown(Scenario scenario) {
		
//		WebDriver driver = BrowserFactory.getDriver();
	    if (scenario.isFailed() && driver != null) {
	        // Save file and attach to report
	        String path = ScreenshotUtil.captureScreenshot(driver, scenario.getName());
	        byte[] bytes = ScreenshotUtil.getScreenshotAsBytes(driver);
	        scenario.attach(bytes, "image/png", "failure_screenshot");
	        System.out.println("Saved screenshot to: " + path);
	    }
	    BrowserFactory.quitBrowser(driver);
	}
	 public static WebDriver getDriver() {
	        return driver;
	    }
}
