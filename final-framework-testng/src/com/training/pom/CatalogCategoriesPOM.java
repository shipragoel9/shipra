package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CatalogCategoriesPOM {
	private WebDriver driver; 
	
	public CatalogCategoriesPOM(WebDriver driver) {
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
	
	public void ClickOnCategories() {
        		WebElement categories=driver.findElement(By.linkText("Categories"));
        		Actions act=new Actions(driver);
        		act.moveToElement(categories).click().build().perform();
	}
        
	
	
	
	}
	

