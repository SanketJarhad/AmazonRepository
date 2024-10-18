package in.amazon.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignUpPage {

	@FindBy(xpath = "//span[text()='Account & Lists']")
	private WebElement acc;
	
	@FindBy(xpath = "(//a[text()='Start here.'])[1]")
	private WebElement startHere;
	
	@FindBy(xpath = "//input[@id='ap_customer_name']")
	private WebElement name;
	
	@FindBy(xpath = "//input[@id='ap_phone_number']")
	private WebElement phNo;
	
	@FindBy(xpath = "//input[@id='ap_password']")
	private WebElement password;
	
	@FindBy(xpath = "//input[@id='continue']")
	private WebElement createAcc;
	
	private WebDriver driver;
	private WebDriverWait wait;
	Actions act;
	
	public SignUpPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		act = new Actions(driver);
	}
	
	public void createAccount() {
		//this is right but we dont use. 
		act.moveToElement(acc).moveToElement(startHere).click().perform();
		}
	
	public void enterName(String UserName) {
		name.sendKeys(UserName);
	}
	
	public void enterPhoneNo(String PhNo) {
	wait.until(ExpectedConditions.visibilityOf(phNo));
	phNo.sendKeys(PhNo);
	}
	
	public void enterPassword(String UserPassword) {
	password.sendKeys(UserPassword);
		}
	
	public void clickonCreateAcc()
	{
		createAcc.click();
	}
	
}
