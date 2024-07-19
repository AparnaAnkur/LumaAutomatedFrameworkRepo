package com.luma.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyWishListPage {
	WebDriver driver;
	Actions builder;
	
	@FindBy(xpath="//div[@data-ui-id='message-success']//div")
	private WebElement wishlistMessage;
	
	@FindBy(xpath="//div//a[@title='Remove This Item']")
	private WebElement remove;
	
	@FindBy(xpath="//div[@data-ui-id='message-success']//div")
	private WebElement wishlistRemoveMessage;
	
	public MyWishListPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this );
	}
  public String wishlistSuccessMessage() {
	  String wishlist=wishlistMessage.getText();
	  return wishlist;
  }
  public void clickOnRemoveThisItem() {
	  builder= new Actions(driver);
	  builder.scrollByAmount(0,600 );
	  remove.click();
	  
  }
  public String wishlistRemoveSuccessMessage() {
	  String wishlistRemove=wishlistRemoveMessage.getText();
	  return wishlistRemove;
}
}