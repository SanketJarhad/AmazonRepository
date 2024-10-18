package in.amazon.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignInPage {
	
	@FindBy(xpath = "//input[@id='ap_email']")
	private WebElement emailOrPhone;
	
	@FindBy(xpath = "//input[@id='continue']")
	private WebElement continueButton;
	
	@FindBy(xpath = "//input[@id='ap_password']")
	private WebElement passWord;
	
	@FindBy(xpath = "//input[@id='signInSubmit']")
	private WebElement signin;
	
	
//	private WebDriverWait wait;   //for waiting of same time for webElements
//	private WebDriver driver;  // for creating driver instance if waits are different for different webelements.//this is global variable declaration.
	
	
	public SignInPage(WebDriver driver) {  //this (WebDriver driver) is local variable declaration.
		PageFactory.initElements(driver, this);
		//this.driver=driver;   //global variable refers to local variable.
		//wait=new WebDriverWait(driver, Duration.ofSeconds(20));
	}
	
	
	public void enterEmailOrPhoneNo(String userId) {
		emailOrPhone.sendKeys(userId);
	}
	
    public void clickOnContinueButton() {
    	continueButton.click();
    }
	
    public void enterPassword(String userPassWord) {
    passWord.sendKeys(userPassWord);
    }
    
	public void signIn() {
		signin.click();
	}
	
	
	
}


//wait.until(ExpectedConditions.visibilityOf(emailOrPhone));
//emailOrPhone.sendKeys("8830594690");
//
//wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//wait.until(ExpectedConditions.visibilityOf(continueButton));  // we create this separately if wait is different for this element and we created global variable of 
//                                                              //WebDriver so that we dont need to pass (WebDriver driver) parameter in each method where we want to 
//                                                              //apply wait of different time
