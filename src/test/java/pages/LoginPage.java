package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

	WebDriver driver;
	WebDriverWait wait;
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@data-qa='login-email']")
    WebElement userName;

    @FindBy(xpath = "//input[@data-qa='login-password']")
    WebElement passWord;

    @FindBy(xpath = "//button[@data-qa='login-button']")
    WebElement loginButton;

    @FindBy(xpath = "//a[contains(text(), ' Logout')]")
    WebElement logoutButton;

    @FindBy(xpath = "//p[contains(text(),'Your email or password is incorrect!')]")
    WebElement loginError;

    public void enterEmail(String username) {
        userName.clear();
        userName.sendKeys(username);
    }

    public void enterPassword(String password) {
        passWord.clear();
        passWord.sendKeys(password);
    }

    public void clickLogin() {
        loginButton.click();
    }

    public boolean isLoginSuccessful() {
        try {
            return logoutButton.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isLoginErrorVisible() {
        try {
            return loginError.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
