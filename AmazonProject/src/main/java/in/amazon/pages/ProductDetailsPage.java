package in.amazon.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductDetailsPage {

	@FindBy(xpath = "//span[@id='productTitle']")
	private WebElement productName;
	
	@FindBy(xpath = "(//span[@class='a-price-whole'])[6]")
	private WebElement productPrice;
	
	@FindBy(xpath = "(//input[@id='add-to-cart-button'])[2]")
	private WebElement addToCart;
	
	@FindBy(xpath = "//input[@id='buy-now-button']")
	private WebElement buyNow;
	
	public ProductDetailsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public String getProductName() {
		return productName.getText().trim();
	}
	
	public String getProductPrice() {
		return productPrice.getText().trim();
	}
	  
	public void clickOnAddToCart() {
		addToCart.click();
	}
	public void buyNow() {
		buyNow.click();	
	}
	
}



