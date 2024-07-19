package com.luma.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class JacketsPage {
	WebDriver driver;
	
	@FindBy(xpath="//div[normalize-space()='Style']")
	private WebElement styleOption;
	
	@FindBy(xpath="//div[@id='narrow-by-list']//div[1]//div[2]//ol[1]//li[1]//a[1]")
	private WebElement insulatedOption;
	
	@FindBy(xpath="//span[text()='Insulated']")
	private WebElement filterMessage;
	
	@FindBy(xpath="//h1[@id='page-title-heading']//span")
	private WebElement jacketHeading;

	public JacketsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	
	}
	
	public void clickOnJacketsFilter() {
		styleOption.click();
		insulatedOption.click();
		
	}
	public String retrieveFilterMessage() {
		String getFilterMessage=filterMessage.getText();
	    return getFilterMessage;
	}
	public boolean getJacketHeading() {
		boolean jacketMessage= jacketHeading.isDisplayed();
		return jacketMessage;
	}
	

}
