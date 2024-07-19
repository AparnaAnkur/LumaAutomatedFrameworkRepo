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

public class PaymentPage {
	WebDriver driver;
	Actions builder;
	WebDriverWait   wait;
	
	@FindBy(xpath="//button[@title='Place Order']//span")
	private WebElement placeOrderButton;
   
	public PaymentPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnPlaceOrderButton() throws InterruptedException {
		Thread.sleep(3000);
		wait= new WebDriverWait(driver,Duration.ofSeconds(30));
		
		wait.until(ExpectedConditions.visibilityOf(placeOrderButton));
		
		placeOrderButton.sendKeys(Keys.ENTER);;
	}
}
