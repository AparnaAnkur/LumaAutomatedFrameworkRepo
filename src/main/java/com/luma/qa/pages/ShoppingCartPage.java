package com.luma.qa.pages;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShoppingCartPage {
 WebDriver driver;
 WebDriverWait wait;
 Actions builder;
 
 @FindBy(xpath= "//span[normalize-space()='Proceed to Checkout']")
 private WebElement proceedToCheckOut;
 
 @FindBy(id="cart-181840-qty")
 private WebElement quantityButton;
 
 @FindBy(xpath="//span[normalize-space()='Update Shopping Cart']")
 private WebElement updateShoppingCartButton;
 
 public ShoppingCartPage(WebDriver driver) {
	 this.driver=driver;
	 PageFactory.initElements(driver,this);
 }
 
 public void clickOnProceedToCheckOut() throws InterruptedException  {
	 quantityButton.click();
	 quantityButton.sendKeys(Keys.DELETE);
	 quantityButton.sendKeys("1");
	 updateShoppingCartButton.click();
	 Thread.sleep(3000);
	 builder= new Actions(driver);
	 builder.sendKeys(Keys.PAGE_DOWN).perform();
	 builder.click(proceedToCheckOut).perform();
	 
	 
 }
 
   
}
