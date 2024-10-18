package in.amazon.tests;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import in.amazon.pages.CartPage;
import in.amazon.pages.Homepage;
import in.amazon.pages.ProductDetailsPage;
import in.amazon.pages.SearchResultPage;
import in.amazon.pages.SignInPage;

public class ValidateAddToCart {
	private WebDriver driver;
	private Homepage homepage;
	private SignInPage signInPage;
	private SearchResultPage searchResultPage;
	private ProductDetailsPage productDetailsPage;
	private CartPage cartPage;
	
	@Parameters("Browser")
	@BeforeTest
	void launchBrowser(String expectedBrowser) {
		
		if(expectedBrowser.equals("Chrome")) {
			driver = new ChromeDriver();
          }
		if(expectedBrowser.equals("Firefox")) {
			driver = new FirefoxDriver();
          }
		if(expectedBrowser.equals("Edge")) {
			driver = new EdgeDriver();
          }
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@BeforeClass
	void initializePOM() {
		homepage = new Homepage(driver);
		searchResultPage = new SearchResultPage(driver);
		productDetailsPage = new ProductDetailsPage(driver);
		cartPage = new CartPage(driver);
		signInPage = new SignInPage(driver);
        }

	@BeforeMethod
	void signIn() {
		driver.get("https://www.amazon.in/");
		homepage = new Homepage(driver);
		homepage.signin();

		signInPage.enterEmailOrPhoneNo("8830594690");
		signInPage.clickOnContinueButton();
		signInPage.enterPassword("8830594690");
		signInPage.signIn();
	}

	@Test
	void verifyAddToCart() {
		homepage.enterProductName("Mobile");
		homepage.clickOnSearchButton();

		searchResultPage.clickOnFirstProduct();

		// Child Browser

		List<String> addr = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(addr.get(1));

		String expectedProductName = productDetailsPage.getProductName();
		String expectedProductPrice = productDetailsPage.getProductPrice();
		double expectedprice= Double.parseDouble(expectedProductPrice);    //connverted to double bcz its price changing from int to decimal after adding to cart.
        productDetailsPage.clickOnAddToCart();
        homepage.cart();


		String actualProductName = cartPage.getFirstProductName();
		String actualProductPrice = cartPage.getFirstProductPrice();
		double actualprice= Double.parseDouble(actualProductPrice);   //connverted to double bcz its price changing from int to decimal after adding to cart.

		Assert.assertEquals(actualProductName, expectedProductName);
		Assert.assertEquals(actualprice, expectedprice);

	}

	@AfterMethod
	void signOutFromApplication() {
		homepage.signout();
	}

	@AfterClass
	void closeBrowser() {
		driver.quit();
	}
}
