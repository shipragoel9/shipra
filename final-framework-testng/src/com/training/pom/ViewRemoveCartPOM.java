package com.training.pom;

import java.util.ArrayList;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ViewRemoveCartPOM {
	private WebDriver driver; 
	
	public ViewRemoveCartPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
		
	@FindBy(xpath="//span[contains(text(),'Shop')]")
	private WebElement shop; 
	
	@FindBy(linkText="Ethnic")
	private WebElement ethnic;
	
	@FindBy(xpath="//a[@href=\"http://retailm1.upskills.in/Engagement Rings\"]")
	private WebElement Item;

	@FindBy(xpath="//i[@class=\"tb_icon ico-linea-ecommerce-bag\"]")
	private WebElement cart;

	@FindBy(xpath="//a[@href=\"http://retailm1.upskills.in/checkout/cart\"]")
	private WebElement viewcart;
	
	@FindBy(xpath="//i[@class=\"fa fa-times-circle\"]")
	private WebElement remove;

	@FindBy(xpath="//i[@class=\"fa fa-refresh\"]")
	private WebElement refresh;

	@FindBy(xpath="//button[contains(text(),'Add to Cart')]")
	private WebElement AddToCart;
	
	@FindBy(xpath="//div[@class=\"tb_text_wrap tb_sep\"]")
	private WebElement cartMessage;
	
	public void mouseoverOnShop() {
		Actions act=new Actions(driver);
		WebElement Shop=this.shop;
    act.moveToElement(Shop).build().perform();
	}
    
	public void clickOnEthnic() {
	Actions act=new Actions(driver);
	WebElement Ethnic=this.ethnic;
    act.moveToElement(Ethnic).click().build().perform();
        	}
    
	public void addItem() {
	this.Item.click();
	}
	
	public void viewCart() throws InterruptedException {
    Actions act=new Actions(driver);
	ArrayList<String> windowdetails=new ArrayList<>(driver.getWindowHandles());
    driver.switchTo().window(windowdetails.get(1));
 	this.AddToCart.click();

 	WebDriverWait delay=new WebDriverWait(driver,10);
	delay.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class=\"noty_cont noty_layout_topRight\"]")));
	
	WebElement Cart=this.cart;   
    act.moveToElement(Cart).build().perform();
     WebElement ViewCart=this.viewcart;
     act.moveToElement(ViewCart).click().build().perform();
     
	}
	
	public void removeRefreshItem() {
	this.remove.click();
	this.refresh.click();
	}
	
	public String cartMessage() {
		String msg=this.cartMessage.getText();
		return msg;
	}
	
}
