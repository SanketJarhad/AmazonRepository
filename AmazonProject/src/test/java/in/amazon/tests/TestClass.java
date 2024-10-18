//package in.amazon.tests;
//
//import java.time.Duration;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;
//
//import in.amazon.pages.CartPage;
//import in.amazon.pages.Homepage;
//import in.amazon.pages.SignInPage;
//import in.amazon.pages.SignUpPage;
//
//
//public class TestClass {
//	
//	private WebDriver driver;
//	private  Homepage homepage;
//	private CartPage cart;
//	private SignInPage loginPage;
//	
//	@BeforeClass
//	void launchBrowser() {
//		ChromeOptions option=new ChromeOptions();
//		driver = new ChromeDriver(option);
//	    driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//	}
//	
//    //	 SignUpPage x = new SignUpPage(driver);
//    //	 x.createAccount(driver);
//	
//	@BeforeMethod
//	void login() {
//		 driver.get("https://www.amazon.in/");
//		 loginPage=new SignInPage(driver);
//		 loginPage.login();
//	}
//     
//	@Test
//	void addToCart(){
//		homepage=new Homepage(driver);
//		homepage.addToCart();
//	}
//	
//	@Test
//	void removeItem() {
//		homepage = new Homepage(driver);
//		homepage.cart();
//		cart=new CartPage(driver);
//		cart.removeItems();
//
//	}
//	
//	@AfterMethod
//	void logout() {
//		homepage=new Homepage(driver);
//        homepage.signout();
//	}
//	
//	@AfterClass
//	void closeBrowser() {
//		
//		driver.close();
//	}
//	 	 
//}
//
