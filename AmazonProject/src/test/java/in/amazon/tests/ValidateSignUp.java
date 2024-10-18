package in.amazon.tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import in.amazon.pages.Homepage;
import in.amazon.pages.SignInPage;
import in.amazon.pages.SignUpPage;

public class ValidateSignUp {
	
	private WebDriver driver;
	private SignInPage signInPage;
	private Homepage homepage;
	private SignUpPage signUp;

    @Parameters("Browser")
	@BeforeTest
	void launchBrowser(String expectedBrowser) {
		if (expectedBrowser.equals("Chrome")) {
			driver = new ChromeDriver();
		}
		if (expectedBrowser.equals("Firefox")) {
			driver = new FirefoxDriver();
		}
		if (expectedBrowser.equals("Edge")) {
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@BeforeClass
	void initializePOM() {
		signInPage = new SignInPage(driver);
        homepage = new Homepage(driver);
        signUp = new SignUpPage(driver);
	}
	
	@BeforeMethod
	void goToSignUpPage() {
		driver.get("https://www.amazon.in/");
		signUp.createAccount();
	}
	@Test
	void verifySignUp() {
		signUp.enterName("Sanket Gadakh");
		signUp.enterPhoneNo("8830594690");
		signUp.enterPassword("0987654321");
		
		}
	
	@AfterMethod
	void signOut() {
		homepage.signout();
	}
	
	@AfterTest
	void closeBrowser() {
		driver.quit();
	}
	


}
