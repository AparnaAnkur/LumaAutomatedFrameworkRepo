package com.luma.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	
	@FindBy(id="email")
	private WebElement email;
	
	@FindBy(id="pass")
	private WebElement password;
	
	@FindBy(xpath="//button[contains(@class,'primary')]//span")
	private WebElement signIn;
	
	@FindBy(xpath="//div[@data-ui-id='message-error']//div")
	private WebElement incorrectAccountSignIn;
	
	@FindBy(xpath="//a[@class='action remind']//span")
	private WebElement forgotPasswordLink;
	
	@FindBy(xpath="//a[contains(@class,'action create primary')]//span")
	private WebElement createAnAccount;
	
	@FindBy(id="email-error")
	private WebElement emailError;
	
	@FindBy(id="pass-error")
	private WebElement passwordError;
	
	
	public LoginPage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver,this);
		
		
	}
	public void loginMethod(String validEmail,String validPassword) {
		email.sendKeys(validEmail);
		password.sendKeys(validPassword);
		signIn.click();
		
	}
	public String retriveIncorrectAccountSignInWarningMessage() {
		String warningText= incorrectAccountSignIn.getText();
		return warningText;
	}
	public void clickOnSignInButton() {
		signIn.click();
	}
	public void forgotPassword() {
		forgotPasswordLink.click();
	}
	public void clickOnCreateAnAccount() {
		createAnAccount.click();
	}
	public boolean emailErrorMessage() {
		boolean emailErrorMessage= emailError.isDisplayed();
		return emailErrorMessage;
	}
	
	public boolean emailPasswordMessage() {
		boolean passwordErrorMessage= passwordError.isDisplayed();
		return passwordErrorMessage;
	}
	

}
