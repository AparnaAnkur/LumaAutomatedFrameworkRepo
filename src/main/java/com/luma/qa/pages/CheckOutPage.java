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

public class CheckOutPage {
	WebDriver driver;
	Actions builder;
	WebDriverWait wait;
	 
	 @FindBy(name="ko_unique_1")
	 private WebElement shippingMethodRadioButton;
	 
	 @FindBy(xpath="//span[text()='Next']")
	 private WebElement nextButton;
	 
	 public CheckOutPage(WebDriver driver) {
		 this.driver=driver;
		 PageFactory.initElements(driver,this);
	 }
	 public void clickOnNext() throws InterruptedException {
		 Thread.sleep(2000);
		 wait= new WebDriverWait(driver,Duration.ofSeconds(30));
		 builder= new Actions(driver);
		 builder.sendKeys(Keys.PAGE_DOWN);
		 wait.until(ExpectedConditions.visibilityOf(shippingMethodRadioButton));
		 shippingMethodRadioButton.click();
		 wait.until(ExpectedConditions.visibilityOf(nextButton));
		 nextButton.click();
		 
	 }
}
