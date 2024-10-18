package in.amazon.tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


//----------------------------Advantages of TestNG-----------------------------------------------------------------------------	
		//TestNG Liabrary--help to make test classes.
		//Can make test execution report through testng.
		         //Provides annotations--Helps test steps design
		         //verification--assertions
		         //Keywords--test controls
		//Test Execution report--
		//can run all test classes at one time.-->TestNG Suit.
		//we can run only failed test cases in last execution.
public class Testng {

	@BeforeClass
	//The method under BeforeClass annotation will execute before the class.
	public void beforeclass() {
		System.out.println("Before class ");
	}
	
	@BeforeMethod
	//The method under @BeforeMethod annotation will execute before the @Test.

	public void beforemethod() {
		System.out.println("Before method");

	}

	@Test      //Every method in TestNG annotations is by default public
   //The @Test is used to design the test method (test case).
	public void testcase() {
		System.out.println("testcase");
	}
	
	@Test      //Every method in TestNG annotations is by default public
	   //The @Test is used to design the test method (test case).
		public void testcase2() {
			System.out.println("testcase2");
		}
	
	@AfterMethod
	//The method under @AfterMethod annotation will execute after the @Test.

		public void aftermethod() {
			System.out.println("After method");

		}
	
	@AfterClass
	//The method under AfterClass annotation will execute after the class.

		public void afterclass() {
			System.out.println("After class ");   //every method should be non static in testng.
		}
		
	
	
		
}

