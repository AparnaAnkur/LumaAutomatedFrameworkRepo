package com.luma.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {
	WebDriver driver;
	
	@FindBy(xpath="//div[@data-ui-id='message-success']/div")
	private WebElement AccountSuccessMessage;
	
	@FindBy(xpath="//h1[@class='page-title']//span")
	private WebElement MyAccountMessage;
	
	@FindBy(xpath="//a//span[text()='Manage Addresses']")
	private WebElement manageAddressLink;
	
	public MyAccountPage(WebDriver driver) {
			this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public String retrieveAccountSuccessMessage() {
		String accountSuccessMessage= AccountSuccessMessage.getText();
		return  accountSuccessMessage;
	}
	public boolean getMyAccountMessage() {
		boolean myAccountMessage= MyAccountMessage.isDisplayed();
		return myAccountMessage;
	}
	public void goToManageAddressLink() {
		manageAddressLink.click();
	}
	

}
