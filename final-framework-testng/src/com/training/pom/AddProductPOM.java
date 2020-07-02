package com.training.pom;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class AddProductPOM {
	private WebDriver driver; 
	
	public AddProductPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="input-username")
	private WebElement userName; 
	
	@FindBy(id="input-password")
	private WebElement password;
	
	@FindBy(xpath="//button[@type=\"submit\"]")
	private WebElement loginBtn; 

	@FindBy(xpath="//div[@class=\"alert alert-success\"]")
	private WebElement message; 
	
	
	
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

	
		
	public void ClickAddProd() {
		driver.findElement(By.xpath("//I[@class=\"fa fa-plus\"]")).click();
	}
	
	public void sendGeneral(String prodName,String Tag) {
		driver.findElement(By.id("input-name1")).sendKeys(prodName);
		driver.findElement(By.id("input-meta-title1")).sendKeys(Tag);
	}
	
	public void sendData(String model, double price, int Quantity) {
		driver.findElement(By.linkText("Data")).click();
		driver.findElement(By.id("input-model")).sendKeys("SKU-012");
		driver.findElement(By.id("input-price")).sendKeys("500");
		driver.findElement(By.id("input-quantity")).sendKeys("50");
		}
	public void sendLink(String categories) {
		driver.findElement(By.linkText("Links")).click();
		driver.findElement(By.id("input-category")).sendKeys(categories);
	}
	
	public void ClickAdd() {
		driver.findElement(By.xpath("//i[@class=\"fa fa-save\"]")).click();
		}
	
	public String getMessage() {
		String Message=this.message.getText();
			return Message;
		
	}
		
}
