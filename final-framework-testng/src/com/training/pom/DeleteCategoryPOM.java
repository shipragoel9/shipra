package com.training.pom;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class DeleteCategoryPOM {
	private WebDriver driver; 
	
	public DeleteCategoryPOM(WebDriver driver) {
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
		WebElement Catalog=this.catalog;
        Actions act=new Actions(driver);
        act.moveToElement(Catalog).build().perform();
	}
	
	public void ClickOnCategories() {
        		WebElement categories=this.category;
        		Actions act=new Actions(driver);
        		act.moveToElement(categories).click().build().perform();
	}

	public void clickCategoryCheckbox(String Category) {

        String beforeXpath="//td[contains(text(),'";
        String afterXpath="')]//preceding-sibling::td//input";
        String CategoryXpath=beforeXpath+Category+afterXpath;
        driver.findElement(By.xpath(CategoryXpath)).click();     

 }

	
	public void deleteCategory() {
		driver.findElement(By.xpath("//i[@class=\"fa fa-trash-o\"]")).click();
        Alert alertpop=driver.switchTo().alert();
        alertpop.accept();
        	}
	
	public String getMessage() {
		String Message=this.message.getText();
			return Message;
		
	}
}
