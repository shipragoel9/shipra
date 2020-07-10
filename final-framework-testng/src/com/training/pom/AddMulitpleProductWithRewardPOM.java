package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddMulitpleProductWithRewardPOM {
	private WebDriver driver; 
	
	public AddMulitpleProductWithRewardPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="Data")
	private WebElement data; 
	
	@FindBy(id="input-model")
	private WebElement model; 
	
	@FindBy(id="input-price")
	private WebElement price; 
	
	@FindBy(id="input-quantity")
	private WebElement quantity; 
	
	@FindBy(linkText="Links")
	private WebElement link; 
	
	@FindBy(id="input-category")
	private WebElement category;  

	@FindBy(linkText="Discount")
	private WebElement disLink; 
	
	@FindBy(xpath="//button[@onclick=\"addDiscount();\"]")
	private WebElement addDiscount;
	
	@FindBy(name="product_discount[0][quantity]")
	private WebElement disQuantity; 
	
	@FindBy(name="product_discount[0][price]")
	private WebElement disPrice; 
	
	@FindBy(xpath="//tbody/tr/td[5]//i[@class=\"fa fa-calendar\"]")
	private WebElement startDateIcon;
	
	@FindBy(xpath="//div[5]//table/tbody//td[@class=\"day active today\"]")
	private WebElement startDateCal;
	
	@FindBy(xpath="//tbody/tr/td[6]//i[@class=\"fa fa-calendar\"]")
	private WebElement endDateIcon;

	@FindBy(xpath="//div[6]//table/tbody//td[@class=\"day active today\"]/following-sibling::td")
	private WebElement endDateCal;
	
	@FindBy(linkText="Reward Points")
	private WebElement reward; 
	
	@FindBy(id="input-points")
	private WebElement point; 

	@FindBy(xpath="//i[@class=\"fa fa-save\"]")
	private WebElement save; 
	
	@FindBy(xpath="//div[@class=\"alert alert-success\"]")
	private WebElement message; 

	@FindBy(xpath="//div[@class=\"alert alert-danger\"]")
	private WebElement errormessage; 
	
	public void sendData(String model, String price, String quantity) {
		this.data.click();
		this.model.sendKeys(model);
		this.price.sendKeys(price);
		this.quantity.sendKeys(quantity);
		}
	
	public void sendLink(String category) {
		this.link.click();
		this.category.sendKeys(category);
	}
	
	
	public void sendDiscount(String disQuantity, String disPrice) {
		this.disLink.click();
		this.addDiscount.click();
		this.disQuantity.sendKeys(disQuantity);
		this.disPrice.sendKeys(disPrice);
		
        this.startDateIcon.click();
		WebElement startDate=this.startDateCal;
		Actions act=new Actions(driver);
		act.moveToElement(startDate).click().build().perform();
		
		this.endDateIcon.click();
		WebElement endDate=this.endDateCal;
		act.moveToElement(endDate).click().build().perform();	
	}
	
	public void sendReward(String point) {
		this.reward.click();
		this.point.sendKeys(point);
		
		
	}
	public void ClickSave() {
		this.save.click();
		}
	
	
	public String getMessage() {
		String Message=this.message.getText();
			return Message;
		
	}
	
	public String getErrorMessage() {
		String Message=this.errormessage.getText();
			return Message;
		
	}
	
	
	
	
}
