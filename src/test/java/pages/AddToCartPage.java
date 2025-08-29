package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddToCartPage {

	WebDriver driver;
	WebDriverWait wait;
	
	public AddToCartPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}
	
	//locators
	@FindBy(xpath="//a[contains(text(), ' Cart')]") WebElement cart;
    @FindBy(xpath="//u[text()='here']") WebElement clickHere;
    @FindBy(xpath="//div[@class='productinfo text-center']//a[@data-product-id='2']") WebElement addToCart;
    @FindBy(linkText="View Cart") WebElement cartView;
    @FindBy(xpath="//a[contains(text(), 'Men Tshirt')]") WebElement menTshirt;
    @FindBy(xpath="//input[@type='number' and @id='quantity']") WebElement quantityBox;
    @FindBy(xpath="//button[contains(normalize-space(),'Add to cart')]") WebElement addMoreBtn;
    @FindBy(xpath="//u[text()='View Cart']") WebElement viewAgain;
    @FindBy(xpath="//td[@class=\"cart_price\"]/p") WebElement unitPrice;
    @FindBy(xpath="//td[@class=\"cart_total\"]/p") WebElement totalPrice;
    
    //methods
    public void openCart() { 
    	cart.click();
//    	wait.until(ExpectedConditions.elementToBeClickable(cart)).click(); 
    	}
    
    public void clickHereLink() { 
    	clickHere.click();
//    	wait.until(ExpectedConditions.elementToBeClickable(clickHere)).click(); 
    	}
    
    public void addProduct() { 
    	addToCart.click(); }
    
    public void viewCart() { 
    	cartView.click();
//    	wait.until(ExpectedConditions.elementToBeClickable(cartView)).click(); 
    	}
    
    public void selectMenTshirt() { 
    	menTshirt.click(); }
    
    public void setQuantity(String qty) { 
    	
    	quantityBox.clear(); quantityBox.sendKeys(qty); }
    
    public void addMoreToCart() { 
    	addMoreBtn.click();
//    	wait.until(ExpectedConditions.elementToBeClickable(addMoreBtn)).click(); 
    	}
    
    public void viewAgainCart() { viewAgain.click(); }

    public int getUnitPrice() {
        String price = unitPrice.getText().replaceAll("[^0-9]", "");
        return Integer.parseInt(price);
    }

    public int getTotalPrice() {
        String total = totalPrice.getText().replaceAll("[^0-9]", "");
        return Integer.parseInt(total);
    }
}
