//RTTC_070--	To verify whether application allows user to place an order with Pre Logging in & admin change the status of order to complete

package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.training.generics.ScreenShot;
import com.training.pom.OrderPlaceAndCompletedPOM;
import com.training.pom.ViewRemoveCartPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class OrderPlacedAndCompletedTests<OrderPlacedAndCompletedPOM> {

	private WebDriver driver;
	private String baseUrl;
	private ViewRemoveCartPOM viewRemoveCartPOM;
	private OrderPlaceAndCompletedPOM orderPlacedAndCompletedPOM;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others2.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		viewRemoveCartPOM = new ViewRemoveCartPOM(driver);
		orderPlacedAndCompletedPOM = new OrderPlaceAndCompletedPOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver);
		// open the browser 
		driver.get(baseUrl);
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	
	
	@Test
	public void ViewCart() throws InterruptedException {
		//login into Retail website and buy item
		orderPlacedAndCompletedPOM.loginRetail("shipragoel9@gmail.com", "abc123");
		viewRemoveCartPOM.mouseoverOnShop();
		viewRemoveCartPOM.clickOnEthnic();
		orderPlacedAndCompletedPOM.clickItem();
		orderPlacedAndCompletedPOM.viewAndAddCart();
		orderPlacedAndCompletedPOM.checkout();
	    screenShot.captureScreenShot("Checkout Success");  
	    orderPlacedAndCompletedPOM.logoutRetail();
	   
	    //Go to Admin link and change the order status to COMPLETE
	    orderPlacedAndCompletedPOM.openNewTab("http://retailm1.upskills.in/admin");
	    orderPlacedAndCompletedPOM.loginRetailAdmin("admin","admin@123");
		screenShot.captureScreenShot("Adminloginsuccess");
		String ExpectedOrderId= orderPlacedAndCompletedPOM.changeOrderStatus();
		
		//Login into Retail website and veiw the history 
			 	
		orderPlacedAndCompletedPOM.openNewTab("http://retailm1.upskills.in/");
		orderPlacedAndCompletedPOM.loginRetail("shipragoel9@gmail.com", "abc123");
		String actualOrderId=orderPlacedAndCompletedPOM.viewHistory();
		screenShot.captureScreenShot("FinalHistoryPage");
		//Validate the order id 
		Assert.assertTrue(actualOrderId.contains(ExpectedOrderId));
		}

}
