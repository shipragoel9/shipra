//RTTC_071	To verify whether application allows admin to add multiple product with the rewards point

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

import com.training.dataproviders.LoginDataProviders;
import com.training.generics.ScreenShot;
import com.training.pom.AddMulitpleProductWithRewardPOM;
import com.training.pom.AddProductPOM;
import com.training.pom.OrderPlaceAndCompletedPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class AddMulProductWithRewardsTests {

	private WebDriver driver;
	private String baseUrl;
	private AddProductPOM addProductPOM;
    private	AddMulitpleProductWithRewardPOM addMulitpleProductWithRewardPOM;
	private OrderPlaceAndCompletedPOM orderPlacedAndCompletedPOM; 
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
		addMulitpleProductWithRewardPOM=new AddMulitpleProductWithRewardPOM(driver);
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
	
	
	@Test(dataProvider = "excel-inputs", dataProviderClass = LoginDataProviders.class)
	public void AddProduct(String proName, String meta, String model,String price,String category, String disQuantity,String disPrice, String point)
	{
//login
		orderPlacedAndCompletedPOM.loginRetailAdmin("admin","admin@123");
//Add product
		addProductPOM.mouseOnCatalog();
		addProductPOM.ClickOnProducts();
		addProductPOM.ClickAddProd();
//data parameterization		
		addProductPOM.sendGeneral(proName, meta);
		addMulitpleProductWithRewardPOM.sendData(model, price, "50");
		addMulitpleProductWithRewardPOM.sendLink(category);
		addMulitpleProductWithRewardPOM.sendDiscount(disQuantity, disPrice);
		addMulitpleProductWithRewardPOM.sendReward(point);
		addMulitpleProductWithRewardPOM.ClickSave();
		screenShot.captureScreenShot("AddProduct");
		//validation		
		String ExpectedMessage="Success: You have modified products!";
		String ActualMessage=addMulitpleProductWithRewardPOM.getMessage();
	    //System.out.println("actual"+ActualMessage);
	    Assert.assertTrue(ActualMessage.contains(ExpectedMessage));
				
	}
}
