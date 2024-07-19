package com.luma.qa.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateAccountPage {
 WebDriver driver;
 Actions builder;
 
 @FindBy(xpath="//h1[@class='page-title']//span")
 private WebElement createAccount;
 
 @FindBy(id="firstname")
 private WebElement firstNameField;
 
 @FindBy(id="lastname")
 private WebElement lastNameField;
 
 @FindBy(name="email")
 private WebElement emailField;
 
 @FindBy(id="password")
 private WebElement passwordField;
 
 @FindBy(id="password-confirmation")
 private WebElement passwordConfirmationField;
 
 @FindBy(xpath="//span[text()='Create an Account']")
 private WebElement createAccountButton;
 
 @FindBy(xpath="//div[@data-ui-id='message-error']/div")
 private WebElement existingAccountWarning;
 
 @FindBy(id="firstname-error")
 private WebElement firstNameWarning;
 
 @FindBy(id="lastname-error")
 private WebElement lastNameWarning;
 
 @FindBy(id="email_address-error")
 private WebElement emailWarning;
 
 @FindBy(id="password-strength-meter")
 private WebElement passwordStrengthMeterWarning;
 
 @FindBy(id="password-error")
 private WebElement passwordWarning;
 
 @FindBy(id="password-confirmation-error")
 private WebElement passwordConfirmationWarning;
 
 
 
 public CreateAccountPage(WebDriver driver) {
	 this.driver= driver;
	 PageFactory.initElements(driver,this);
 }
 
 public boolean createAccountPageMessage() {
	 boolean createAccountPageMessage= createAccount.isDisplayed();
	 return createAccountPageMessage;
 }
 
 public void createAccount(String firstName,String lastName,String email,String password, String passwordConfirm) {
	 firstNameField.sendKeys(firstName);
	 lastNameField.sendKeys(lastName);
	 emailField.sendKeys(email);
	 passwordField.sendKeys(password);
	 builder= new Actions(driver);
	 builder.sendKeys(Keys.PAGE_DOWN).build().perform();
	 passwordConfirmationField.sendKeys(passwordConfirm);
	 createAccountButton.click();
 }
 public String retrieveExistingAccountwarningMessage() {
	 String accountWarning= existingAccountWarning.getText();
	 return accountWarning;
 }
	 
	 public void createAccountWithoutProvidingAnyCredentials() {
		 createAccountButton.click();
	 }	 
	 public String retrieveFirstNameWarningMessage() {
		 String firstNamewarningMessage=firstNameWarning.getText();
		 return firstNamewarningMessage;
		 
	 }
	 
 

	public String retrieveLastNameWarningMessage() {
		 String lastNamewarningMessage=lastNameWarning.getText();
		 return lastNamewarningMessage;
		
	}

	public String retrieveEmailWarningMessage() {
		String emailwarningMessage= emailWarning.getText();
		return emailwarningMessage;
		
	}
	public String retrievePasswordStrengthMeterWarningMessage() {
		String passwordStrengthMeterwarningMessage= passwordStrengthMeterWarning.getText();
		return passwordStrengthMeterwarningMessage;
	}
	public String retrievePasswordWarningMessage() {
		String passwordwarningMessage= passwordWarning.getText();
		return passwordwarningMessage;
	}
	public String retrievePasswordCongirmationWarningMessage() {
		String passwordConfirmationMessage= passwordConfirmationWarning.getText();
		return passwordConfirmationMessage;
	}
	
}
