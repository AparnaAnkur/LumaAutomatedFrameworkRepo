package com.luma.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class SuccessPage {
WebDriver driver;

@FindBy(xpath="//span[text()='Thank you for your purchase!']")
private WebElement successMessage;

public SuccessPage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver,this);
}

public boolean getSuccessPageMessage() throws InterruptedException {
	Thread.sleep(3000);
boolean displayStatus=successMessage.isDisplayed();
return displayStatus;
}
}
