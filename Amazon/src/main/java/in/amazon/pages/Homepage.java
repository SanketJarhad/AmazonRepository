package in.amazon.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Homepage {

	  @FindBy(xpath = "//span[@class='nav-line-2 ']")
	  private WebElement acclist;
	  
	  @FindBy(xpath = "(//span[text()='Sign in'])[1]")
		private WebElement signInButton;
	  
	  @FindBy(xpath = "//input[@type='text']")
	  private WebElement search;
	  
	  @FindBy(xpath = "//input[@id='nav-search-submit-button']")
	  private WebElement searchButton;
	  
	  @FindBy(xpath = "//span[@id='attach-sidesheet-view-cart-button']//input[@class='a-button-input']")
	  private WebElement cart; 
	  
	  @FindBy(xpath = "//span[text()='Sign Out']")
	  private WebElement signOutButton; 
	  
	  private Actions actions;
	  private WebDriverWait wait;

	  public Homepage(WebDriver driver) {
		  PageFactory.initElements(driver, this);
			actions=new Actions(driver);
			wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	  }
	  
	 
	   public void cart() {
		   cart.click();
	   }
	   
	   public void signin() {
		   wait.until(ExpectedConditions.visibilityOf(acclist));
		   actions.moveToElement(acclist).moveToElement(signInButton).click().perform();
	   }
	   public void signout() {
			actions.moveToElement(acclist).moveToElement(signOutButton).click().perform();

	   }
	   public void enterProductName(String productName) {
		   search.sendKeys(productName);
	   }
	   public void clickOnSearchButton() {
		   searchButton.click();
	   }
	   
	  
}
