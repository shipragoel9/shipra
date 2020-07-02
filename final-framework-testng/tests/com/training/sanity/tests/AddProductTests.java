//RTTC_042-To Verify whether application allows admin to add product by entering valid credentials in mandatory fields only

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
import com.training.pom.AddProductPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class AddProductTests {

	private WebDriver driver;
	private String baseUrl;
	private AddProductPOM addProductPOM;
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
		addProductPOM = new AddProductPOM(driver); 
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
	
	//RTTC_042-To Verify whether application allows admin to add product by entering valid credentials in mandatory fields only
	@Test
	public void AddProduct() throws InterruptedException {
//login
		addProductPOM.sendUserName("admin");
		addProductPOM.sendPassword("admin@123");
		addProductPOM.clickLoginBtn(); 
		screenShot.captureScreenShot("successfulLogin");
//Add product
		addProductPOM.mouseOnCatalog();
		addProductPOM.ClickOnProducts();
		screenShot.captureScreenShot("ProductHome");
		addProductPOM.ClickAddProd();
		addProductPOM.sendGeneral("Finger Ring", "Finger Ring for ladies");
		addProductPOM.sendData("SKU-012", 500, 50);
		addProductPOM.sendLink("EARRINGS");
		addProductPOM.ClickAdd();
		screenShot.captureScreenShot("AddProduct");
//validation		
		String ExpectedMessage="Success: You have modified products!";
		String ActualMessage=addProductPOM.getMessage();
	   // System.out.println("actual"+ActualMessage);
	    Assert.assertTrue(ActualMessage.contains(ExpectedMessage));
				
	}
}
