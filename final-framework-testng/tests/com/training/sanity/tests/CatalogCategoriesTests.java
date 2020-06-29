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
import com.training.pom.CatalogCategoriesPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class CatalogCategoriesTests {

	private WebDriver driver;
	private String baseUrl;
	private CatalogCategoriesPOM catalogCategoriesPOM;
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
		catalogCategoriesPOM = new CatalogCategoriesPOM(driver); 
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
	public void validLoginTest() throws InterruptedException {
		catalogCategoriesPOM.sendUserName("admin");
		catalogCategoriesPOM.sendPassword("admin@123");
		catalogCategoriesPOM.clickLoginBtn(); 
		screenShot.captureScreenShot("successfulLogin");
		catalogCategoriesPOM.mouseOnCatalog();
		catalogCategoriesPOM.ClickOnCategories();
		screenShot.captureScreenShot("categoriesHome");
			
		String expectedresult="Category List";   
		String actualresult=driver.findElement(By.xpath("//h3[contains(text(),'Category List')]")).getText();   
		Assert.assertEquals(actualresult,expectedresult);
		screenShot.captureScreenShot("category");	
	}
}
