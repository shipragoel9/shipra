
package com.training.pom;

import java.util.ArrayList;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class OrderPlaceAndCompletedPOM {
	private WebDriver driver; 
	
	public OrderPlaceAndCompletedPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//i[@class=\"fa fa-user-o\"]")
	private WebElement logIcon; 
	
	@FindBy(linkText="LOGIN / REGISTER")
	private WebElement login; 
	
	@FindBy(id="input-email")
	private WebElement email; 
	
	@FindBy(id="input-password")
	private WebElement password; 
	
	@FindBy(xpath="//input[@type=\"submit\"]")
	private WebElement submit; 
	
	@FindBy(xpath="//img[@src=\"http://retailm1.upskills.in/image/cache/catalog/engagementring-340x480.jpg\"]")
	private WebElement Item;

	@FindBy(xpath="//i[@class=\"tb_icon ico-linea-ecommerce-bag\"]")
	private WebElement cart;

	@FindBy(xpath="//a[@href=\"http://retailm1.upskills.in/checkout/cart\"]")
	private WebElement viewcart;

	//@FindBy(xpath="//button[contains(text(),'Add to Cart')]")
	@FindBy(id="button-cart")
	private WebElement AddToCart;
	
	@FindBy(linkText="Checkout")
	private WebElement check;
	
	@FindBy(id="button-payment-address")
	private WebElement continuePay;
	
	@FindBy(id="button-shipping-address")
	private WebElement continueShip;
	
	@FindBy(name="comment")
	private WebElement comment;
	
	@FindBy(id="button-shipping-method")
	private WebElement continueShipMd;
	
	@FindBy(name="agree")
	private WebElement agree;
	
	@FindBy(id="button-payment-method")
	private WebElement continuePayMd;

	@FindBy(id="button-confirm")
	private WebElement confirm;
	
	@FindBy(linkText="LOGOUT")
	private WebElement logout;
	 
	
	@FindBy(id="input-username")
	private WebElement AdminUser; 
	
	@FindBy(id="input-password")
	private WebElement AdminPW;
	
	@FindBy(xpath="//button[@type=\"submit\"]")
	private WebElement AdminloginBtn; 
	

	@FindBy(xpath="//i[@class=\"fa fa-shopping-cart fw\"]")
	private WebElement salesIcon; 

	@FindBy(xpath="//a[contains(text(),'Orders')]")
	private WebElement orderIcon; 

	@FindBy(xpath="//table/tbody/tr[1]/td[2]")
	private WebElement expCellValue; 

	@FindBy(xpath="//table/tbody/tr[1]/td[8]//a[@class=\"btn btn-info\"]")
	private WebElement viewButton; 

	@FindBy(id="input-order-status")
	private WebElement statusDrop; 

	@FindBy(id="input-override")
	private WebElement overCheckbox; 

	@FindBy(id="button-history")
	private WebElement addHistory; 

	@FindBy(linkText="View your order history")
	private WebElement viewHistory;
	
	@FindBy(xpath="//table/tbody/tr[1]/td[1]")
	private WebElement actCellValue;
	
	public void loginRetail(String email,String password) {
		WebElement log=this.logIcon;	
		Actions act=new Actions(driver);
		act.moveToElement(log).build().perform();
		this.login.click();
		this.email.sendKeys(email);
		this.password.sendKeys(password);
		this.submit.click();
	}
	
	public void clickItem() {
	this.Item.click();
	}
	
	public void viewAndAddCart() throws InterruptedException {
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
	
	public void checkout() {
	
	this.check.click();
	this.continuePay.click();
	this.continueShip.click();
	this.comment.sendKeys("This product is nice");
	this.continueShipMd.click();
	this.agree.click();
	this.continuePayMd.click();
	this.confirm.click();
    String message=driver.findElement(By.xpath("//div[@class=\"tb_text_wrap tb_sep\"]")).getText();
	System.out.println("success message"+message);
	
	}
	public void logoutRetail() {    
	 WebElement Logout=this.logIcon;
	 Actions act=new Actions(driver);
	 act.moveToElement(Logout).build().perform();
	 this.logout.click();
	}

	public void openNewTab(String newURL) {   
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.open()");
        ArrayList<String> windowdetails=new ArrayList<>(driver.getWindowHandles());
        int windowNum =windowdetails.size();
        driver.switchTo().window(windowdetails.get(windowNum-1));
	    driver.get(newURL);	

	}

	public void loginRetailAdmin(String AdminUser, String AdminPW) {
		this.AdminUser.sendKeys(AdminUser);
		this.AdminPW.sendKeys(AdminPW); 
		this.AdminloginBtn.click();
	}
	
	public String changeOrderStatus() {

	this.salesIcon.click();
	this.orderIcon.click();
	//storing expected value
	String ExpectedOrderID=this.expCellValue.getText();
	System.out.println("Expected Order ID"+ExpectedOrderID);
	this.viewButton.click();
	WebElement StatusDrop=this.statusDrop;
	Select sel=new Select(StatusDrop);
	sel.selectByVisibleText("Complete");
	this.overCheckbox.click();
	this.addHistory.click();
    return (ExpectedOrderID);
	
	}
	
	
	public String viewHistory() {
	
	this.viewHistory.click();
	String actualOrderID=this.actCellValue.getText();
	//System.out.println("actual Order ID"+actualOrderID);
	return actualOrderID;
	}
	
}
