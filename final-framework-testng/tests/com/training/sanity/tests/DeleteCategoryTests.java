//RTTC_040	TO Verify whether application allows admin to delete multiple category from categories list
	
package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.training.generics.ScreenShot;
import com.training.pom.DeleteCategoryPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class DeleteCategoryTests {

	private WebDriver driver;
	private String baseUrl;
	private DeleteCategoryPOM deleteCategoryPOM;
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
		deleteCategoryPOM = new DeleteCategoryPOM(driver); 
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

	//RTTC_040	TO Verify whether application allows admin to delete multiple category from categories list
@Test
	public void deleteCategory() throws InterruptedException {
	//login	
	deleteCategoryPOM.sendUserName("admin");
		deleteCategoryPOM.sendPassword("admin@123");
		deleteCategoryPOM.clickLoginBtn(); 
		screenShot.captureScreenShot("successfulLogin");
		
		//delete category
		deleteCategoryPOM.mouseOnCatalog();
		deleteCategoryPOM.ClickOnCategories();
		screenShot.captureScreenShot("categoriesHome");
		deleteCategoryPOM.clickCategoryCheckbox("Electronic");
		deleteCategoryPOM.deleteCategory();
		
		//validation
		String ActualMessage=deleteCategoryPOM.getMessage();
		String ExpectedMessage="Success: You have modified categories!";
		Assert.assertTrue(ActualMessage.contains(ExpectedMessage));
				
	}
}
