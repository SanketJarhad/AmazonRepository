package in.amazon.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultPage {

	@FindBy(xpath = "(//span[@class='a-size-medium a-color-base a-text-normal'])[1]")
	private WebElement firstProduct;
	
	@FindBy(xpath = "(//button[text()='Add to cart'])[1]")
	  private WebElement addToCart;
	
	@FindBy(xpath = "(//span[@class='a-price-whole'])[3]")
	private WebElement firstProductPrice;


public SearchResultPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}

public void clickOnFirstProduct() {
	firstProduct.click();
}
}