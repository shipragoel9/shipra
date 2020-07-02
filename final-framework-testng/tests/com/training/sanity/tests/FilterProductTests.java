//RTTC_041	To Verify whether application allows the admin to filter the product details with all textbox

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
import com.training.pom.FilterProductPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class FilterProductTests {

	private WebDriver driver;
	private String baseUrl;
	private FilterProductPOM filterProductPOM;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		filterProductPOM = new FilterProductPOM(driver); 
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
	
	//RTTC_041	To Verify whether application allows the admin to filter the product details with all textbox
	@Test
	public void filterProduct() throws InterruptedException {
		//Login
		filterProductPOM.sendUserName("admin");
		filterProductPOM.sendPassword("admin@123");
		filterProductPOM.clickLoginBtn(); 
		screenShot.captureScreenShot("successfulLogin");
		
		filterProductPOM.mouseOnCatalog();
		filterProductPOM.ClickOnProducts();
		screenShot.captureScreenShot("ProductHome");
		
		//passing filter parameters and filtering the result
	    String ExpectedName=filterProductPOM.sendName("Integer vitae iaculis massa");
		filterProductPOM.clickFilter();
		
		filterProductPOM.sendPrice("515");
		filterProductPOM.clickFilter();
		
		filterProductPOM.sendStatus("Enabled");
		filterProductPOM.clickFilter();
		
		filterProductPOM.sendModel("SKU-003");
		filterProductPOM.clickFilter();
		
		filterProductPOM.sendQuantity("712");
		filterProductPOM.clickFilter();
		
		filterProductPOM.sendImage("Enabled");
		filterProductPOM.clickFilter();
		
		//validation
		String ActualName=filterProductPOM.ProductName();
		Assert.assertTrue(ActualName.contains(ExpectedName));
				
	}
}
