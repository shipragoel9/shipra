package com.training.pom;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class FilterProductPOM {
	private WebDriver driver; 
	
	public FilterProductPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="input-username")
	private WebElement userName; 
	
	@FindBy(id="input-password")
	private WebElement password;
	
	@FindBy(xpath="//button[@type=\"submit\"]")
	private WebElement loginBtn; 
	
	
	
	public void sendUserName(String userName) {
		this.userName.clear();
		this.userName.sendKeys(userName);
	}
	
	public void sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password); 
	}
	
	public void clickLoginBtn() {
		this.loginBtn.click(); 
	}

	
	
	public void mouseOnCatalog() {
		WebElement catalog=driver.findElement(By.xpath("//i[@class=\"fa fa-tags fw\"]"));
        Actions act=new Actions(driver);
        act.moveToElement(catalog).build().perform();
	}
	
	public void ClickOnProducts() {
        		WebElement categories=driver.findElement(By.linkText("Products"));
        		Actions act=new Actions(driver);
        		act.moveToElement(categories).click().build().perform();
	}

	
	@FindBy(id="input-name")
	private WebElement name; 
		
	@FindBy(id="input-price")
	private WebElement price;
	
	
	@FindBy(id="input-model")
	private WebElement model;
	
	@FindBy(id="input-quantity")
	private WebElement quantity;
	
	@FindBy(id="button-filter")
	private WebElement filter; 
	
	@FindBy(xpath="//table/tbody/tr/td[3]")
	private WebElement productName; 
	
	
	public String sendName(String name) {
		this.name.clear();
		this.name.sendKeys(name);
		return name;
	}
	
	public void sendPrice(String price) {
		this.price.clear(); 
		this.price.sendKeys(price); 
	}
	
	public void sendStatus(String status) {
		WebElement status1=driver.findElement(By.id("input-status"));
		Select sel=new Select(status1);
		sel.selectByVisibleText(status);
	}
	
	public void sendModel(String model) {
		this.model.clear(); 
		this.model.sendKeys(model);
		}
	
	public void sendQuantity(String quantity) {
		this.quantity.clear(); 
		this.quantity.sendKeys(quantity);
		}
	
	public void sendImage(String image) {

		WebElement image1=driver.findElement(By.id("input-image"));
		Select selImage=new Select(image1);
		selImage.selectByVisibleText(image);
	}
	
	public void clickFilter() {
		this.filter.click(); 
	}

	public String ProductName() {
		String msg=this.productName.getText();
		return msg;
	}
}
