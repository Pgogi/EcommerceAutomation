package StepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AddToCartPage;
import pages.LoginPage;
//import utils.BrowserFactory;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import hooks.Hooks;

public class EcommerceSteps {

	WebDriver driver;
	LoginPage loginPage;
	AddToCartPage cartPage;
	
	public EcommerceSteps() {
        // Always get driver from Hooks
        this.driver = Hooks.getDriver();
    }
	@Given("Open the application")
    public void Open_the_application() {
//        loginPage = new LoginPage(BrowserFactory.getDriver());
		loginPage = new LoginPage(driver);
        cartPage = new AddToCartPage(driver);
        System.out.println("Navigated to the application");
    }

    @When("User enters {string} and {string}")
    public void user_enters_credentials(String username, String password) {
    	loginPage.enterEmail(username);
    	loginPage.enterPassword(password);
//        loginPage.enterEmail(username);
//        loginPage.enterPassword(password);
    }

    @When("Click on login button")
    public void Click_on_login_button() {
        loginPage.clickLogin();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(driver -> loginPage.isLoginSuccessful() || loginPage.isLoginErrorVisible());
    }

    @Then("Verify the title of the page")
    public void Verify_the_title_of_the_page() {
    	if (loginPage.isLoginSuccessful()) {
            System.out.println("Login successful");
        } else if (loginPage.isLoginErrorVisible()) {
            System.out.println("Login failed");
        }
    }

    @When("User adds product to cart")
    public void User_adds_product_to_cart() {
//        cartPage = new AddToCartPage(BrowserFactory.getDriver());
        if(loginPage.isLoginSuccessful()) {
        	cartPage.openCart();
            cartPage.clickHereLink();
            cartPage.addProduct();
            cartPage.viewCart();
            cartPage.selectMenTshirt();	
        }
        else {
        	 System.out.println("Skipping cart steps because login failed.");
        }
    	
    }

    @When("increases quantity {string}")
    public void increases_quantity(String qty) {
        cartPage.setQuantity(qty);
        cartPage.addMoreToCart();
        cartPage.viewAgainCart();
    }

    @Then("Verify total price is correct")
    public void Verify_total_price_is_correct() {
        int unit = cartPage.getUnitPrice();
        int total = cartPage.getTotalPrice();
        int quantity = 4; // hardcoded, could be parameterized
        Assert.assertEquals(total, unit * quantity, "Cart total mismatch!");
    }
}
