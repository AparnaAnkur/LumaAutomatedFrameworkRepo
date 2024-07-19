package com.luma.qa.testcases;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.luma.qa.base.Base;
import com.luma.qa.pages.CreateAccountPage;
import com.luma.qa.pages.ForgotPasswordPage;
import com.luma.qa.pages.HomePage;
import com.luma.qa.pages.LoginPage;
import com.luma.qa.utils.Utilities;



import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class LoginTest extends Base {
	public LoginTest() {
		super();
	}
   public WebDriver driver;
	Actions builder;
  
	@BeforeMethod
	 public void setUp() {
		driver= initializeBrowser(prop.getProperty("browserName"));
		 HomePage homePage= new HomePage(driver);
		 homePage.clickOnSignInOption();
		 
		 builder= new Actions(driver);
		 
	 }
	  
 @Test(priority=1)
 public void verifyLoginWithValidCredentials(){
	
	  LoginPage login= new LoginPage(driver);
	  login.loginMethod(prop.getProperty("validEmail"),prop.getProperty("validPassword"));
	  HomePage homePage= new HomePage(driver);
	  Assert.assertTrue(homePage.getDisplayStatusOfWelcomeMessage(),"Welcome message not displayed");

	  
 }
 @Test(priority=2,dataProvider="invalid Credentials Supplier")
 public void verifyLoginWithInvalidCredentials(String email, String password) throws InterruptedException {

	  LoginPage login= new LoginPage(driver);
	  login.loginMethod(email, password);
	  
	  String actualWarningMessage=login.retriveIncorrectAccountSignInWarningMessage();
	  String expectedWarningMessage=dataProp.getProperty("incorrectAccountSignIn");
	  Assert.assertTrue(actualWarningMessage.contains(expectedWarningMessage),"Expected warning message is not displayed");
	  
 }
  @DataProvider(name="invalid Credentials Supplier")
  public Object[][]supplyTestData(){
	  Object[][]data=Utilities.getTestDataFromExcel("Login");
	  return data;
  }
  
 @Test(priority=3)
 public void verifyLoginWithValidEmailAndInvalidPassword() throws InterruptedException {
	  LoginPage login= new LoginPage(driver);
	  login.loginMethod(prop.getProperty("validEmail"),dataProp.getProperty("invalidPassword") );
	  
	  String actualWarningMessage=login.retriveIncorrectAccountSignInWarningMessage();
	  String expectedWarningMessage=dataProp.getProperty("incorrectAccountSignIn");
	  Assert.assertTrue(actualWarningMessage.contains(expectedWarningMessage),"Expected warning message is not displayed");
	 
 }
 @Test(priority=4)
 public void verifyLoginWithInvalidEmailAndValidPassword() throws InterruptedException {
	 LoginPage login= new LoginPage(driver);
	 login.loginMethod(Utilities.generateEmailWithTimeStamp(),prop.getProperty("validPassword"));
	  
	  String actualWarningMessage=login.retriveIncorrectAccountSignInWarningMessage();
	  String expectedWarningMessage=dataProp.getProperty("incorrectAccountSignIn");
	  Assert.assertTrue(actualWarningMessage.contains(expectedWarningMessage),"Expected warning message is not displayed");
 }
 @Test(priority=5)
 public void verifyLoggingWithoutProvidingAnyCredentials() throws InterruptedException {
	 
	 LoginPage login= new LoginPage(driver);
	 login.clickOnSignInButton();
	  
	  Assert.assertTrue(login.emailErrorMessage(),"This is required field is not displayed");
	  Assert.assertTrue(login.emailPasswordMessage(),"This is required field is not displayed");
 }
  @Test(priority=6)
  public void verifyForgotPasswordLink() {
	  LoginPage login= new LoginPage(driver);
	  login.forgotPassword();
	  ForgotPasswordPage forgotPassword= new ForgotPasswordPage(driver);
	  
	  Assert.assertTrue(forgotPassword.getforgotPasswordlinkMessage(),"Forgot Your Password? message is not displayed");
  }
  @Test(priority=7)
  public void verifyCreateAnAccountFromCustomerLogin() {
	  LoginPage login= new LoginPage(driver);
	  login.clickOnCreateAnAccount();
	  CreateAccountPage createAccount= new CreateAccountPage(driver);
	  
	 Assert.assertTrue(createAccount.createAccountPageMessage(),"Create New Customer Account is not displayed");
	  
  }
  
	 
	  @AfterMethod
		 public void tearDown() {
		 driver.quit();
		 
 }
 
}

