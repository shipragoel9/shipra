package com.training.pom;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
	
	@FindBy(xpath="//i[@class=\"fa fa-tags fw\"]")
	private WebElement catalog; 

	@FindBy(linkText="Categories")
	private WebElement category;

	@FindBy(xpath="//h3[contains(text(),'Category List')]")
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
		WebElement Catalog=this.catalog;
        Actions act=new Actions(driver);
        act.moveToElement(Catalog).build().perform();
	}
	
	public void ClickOnCategories() {
        		WebElement categories=this.category;
        		Actions act=new Actions(driver);
        		act.moveToElement(categories).click().build().perform();
	}
        
	
	public String sendmessage() {
		String Message=this.message.getText();
		return Message;
	}
	
	}
	

