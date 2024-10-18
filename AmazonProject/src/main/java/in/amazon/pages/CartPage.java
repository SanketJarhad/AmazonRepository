package in.amazon.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {


	  @FindBy(xpath = "(//span[@class='a-truncate-full a-offscreen'])[1]")
	  private WebElement firstProductTitle;  //(//h2[@class='a-size-mini a-spacing-none a-color-base s-line-clamp-2'])[1]
	  
	  @FindBy(xpath = "(//div[@class='a-section a-spacing-mini'])[1]")
	  private WebElement firstProductPrice;
	  
	  public CartPage(WebDriver driver) {
		  PageFactory.initElements(driver, this);
	  }

	  public String getFirstProductName() {
		  return firstProductPrice.getText().trim();
	  }
	  
	  public String getFirstProductPrice() {
		  return firstProductPrice.getText().trim();
	  }
	  
	  public void removeItems() {
		 
	  }
}
