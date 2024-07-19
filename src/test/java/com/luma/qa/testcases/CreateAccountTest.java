package com.luma.qa.testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.luma.qa.base.Base;
import com.luma.qa.pages.CreateAccountPage;
import com.luma.qa.pages.HomePage;
import com.luma.qa.pages.MyAccountPage;
import com.luma.qa.utils.Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateAccountTest extends Base{
	public CreateAccountTest() {
		super(); 
	}
	public WebDriver driver;
	Actions builder;
	@BeforeMethod
	public void setUp() {

		driver= initializeBrowser(prop.getProperty("browserName"));

		// builder= new Actions(driver);
		HomePage homePage= new HomePage(driver);
		homePage.clickOnCreateAnAccount();


	}
	@Test(priority=1)
	public void verifyCreatingAnAccountWithMandatoryFields() {
		CreateAccountPage createAccount= new CreateAccountPage(driver);
		createAccount.createAccount(dataProp.getProperty("firstName"), dataProp.getProperty("lastName"), Utilities.generateEmailWithTimeStamp(),prop.getProperty("validPassword"),prop.getProperty("validPassword"));


		MyAccountPage myAccount= new MyAccountPage(driver);

		String actualSuccessHeading=myAccount.retrieveAccountSuccessMessage();
		Assert.assertEquals(actualSuccessHeading,dataProp.getProperty("actualSuccessHeading"),"Your account has not been created");

	}
	@Test(priority=2)
	public void verifyCreatingAnAccountWithAlreadyExistingAccount() {
		CreateAccountPage createAccount= new CreateAccountPage(driver);
		createAccount.createAccount(dataProp.getProperty("firstName"), dataProp.getProperty("lastName"), prop.getProperty("validEmail"),prop.getProperty("validPassword"),prop.getProperty("validPassword"));
		String actualWarning=createAccount.retrieveExistingAccountwarningMessage();
		Assert.assertTrue(actualWarning.contains(dataProp.getProperty("duplicateEmailWarning")),"Warning message not displayed");
	}
	@Test(priority=3)
	public void verifyCreatingAnAccountWithoutfillingAnyFields() {

		CreateAccountPage createAccount= new CreateAccountPage(driver);
		createAccount.createAccountWithoutProvidingAnyCredentials();

		String actualFirstNameWarning=createAccount.retrieveFirstNameWarningMessage();
		Assert.assertEquals(actualFirstNameWarning,dataProp.getProperty("firstNameWarning"),"FirstName warning message is not displayed");

		String actualLastNameWarning=createAccount.retrieveLastNameWarningMessage();
		Assert.assertEquals(actualLastNameWarning,dataProp.getProperty("lastNameWarning"),"LastName warning message is not displayed");

		String actualEmailWarning=createAccount.retrieveEmailWarningMessage();
		Assert.assertEquals(actualEmailWarning,dataProp.getProperty("emailWarning"),"Email warning message is not displayed");

		String actualPasswordStrengthMeterWarning=createAccount.retrievePasswordStrengthMeterWarningMessage();
		Assert.assertEquals(actualPasswordStrengthMeterWarning,dataProp.getProperty("passwordStrengthMeterWarning"),"Password Strength Meter warning message is not displayed");

		String actualPasswordWarning=createAccount.retrievePasswordWarningMessage();
		Assert.assertEquals(actualPasswordWarning,dataProp.getProperty("passwordWarning"),"Password warning message is not displayed");

		String actualPasswordConfirmationWarning=createAccount.retrievePasswordCongirmationWarningMessage();
		Assert.assertEquals(actualPasswordConfirmationWarning,dataProp.getProperty("passwordConfirmationWarning"),"Password confirmation warning message is not displayed");


	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}


}
