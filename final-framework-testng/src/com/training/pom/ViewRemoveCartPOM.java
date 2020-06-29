package com.training.pom;

import java.util.ArrayList;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ViewRemoveCartPOM {
	private WebDriver driver; 
	
	public ViewRemoveCartPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
		
	public void mouseoverOnShop() {
		Actions act=new Actions(driver);
		WebElement shop=driver.findElement(By.xpath("//span[contains(text(),'Shop')]"));
    act.moveToElement(shop).build().perform();
	}
    
	public void clickOnEthnic() {
	Actions act=new Actions(driver);
	WebElement ethnic=driver.findElement(By.linkText("Ethnic"));
    act.moveToElement(ethnic).click().build().perform();
        	}
    
	public void addItem() {
	driver.findElement(By.xpath("//a[@href=\"http://retailm1.upskills.in/Engagement Rings\"]")).click();
	}
	
	public void viewCart() throws InterruptedException {
    Actions act=new Actions(driver);
	ArrayList<String> windowdetails=new ArrayList<>(driver.getWindowHandles());
    driver.switchTo().window(windowdetails.get(1));
 	driver.findElement(By.xpath("//button[contains(text(),'Add to Cart')]")).click();

 	WebDriverWait delay=new WebDriverWait(driver,10);
	delay.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class=\"noty_cont noty_layout_topRight\"]")));
	
	WebElement cart=driver.findElement(By.xpath("//span[@class=\"tb_items\"]"));    
    act.moveToElement(cart).build().perform();
     WebElement ViewCart=driver.findElement(By.xpath("//a[@href=\"http://retailm1.upskills.in/checkout/cart\"]"));
     act.moveToElement(ViewCart).click().build().perform();
     
	}
	
	public void removeRefreshItem() {
	driver.findElement(By.xpath("//i[@class=\"fa fa-times-circle\"]")).click();
	driver.findElement(By.xpath("//i[@class=\"fa fa-refresh\"]")).click();
	}
	
}
