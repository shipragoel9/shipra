
//RTTC_010-To verify whether application allows the user to remove added product details from cart

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
import com.training.pom.ViewRemoveCartPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;


public class ViewRemoveCartTests {

	private WebDriver driver;
	private String baseUrl;
	private ViewRemoveCartPOM viewRemoveCartPOM;
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
	
	//RTTC_010-To verify whether application allows the user to remove added product details from cart
	@Test
	public void ViewCart() throws InterruptedException {
		//view
		viewRemoveCartPOM.mouseoverOnShop();
		viewRemoveCartPOM.clickOnEthnic();
		viewRemoveCartPOM.addItem();
	    viewRemoveCartPOM.viewCart();
	  	viewRemoveCartPOM.removeRefreshItem();  
	    screenShot.captureScreenShot("cartstatus");
	
	    //validation
	    String expectedresult="Your shopping cart is empty!";   
		   String actualresult=viewRemoveCartPOM.cartMessage();
		   Assert.assertEquals(actualresult,expectedresult);
		
		}
}
