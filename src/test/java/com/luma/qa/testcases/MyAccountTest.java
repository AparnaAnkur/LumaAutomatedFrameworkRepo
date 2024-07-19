package com.luma.qa.testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.luma.qa.base.Base;
import com.luma.qa.pages.AddressBookPage;
import com.luma.qa.pages.HomePage;
import com.luma.qa.pages.LoginPage;
import com.luma.qa.pages.MyAccountPage;

public class MyAccountTest extends Base{
	
	public MyAccountTest() {
		super();
	}
	public WebDriver driver;
	Actions builder;
	 @BeforeMethod
	 public void setUp() {
		driver= initializeBrowser(prop.getProperty("browserName"));
		 
		 builder= new Actions(driver);
		 HomePage homePage= new HomePage(driver);
		 homePage.clickOnSignInOption();
		 LoginPage login= new LoginPage(driver);
		 login.loginMethod(prop.getProperty("validEmail"),prop.getProperty("validPassword") );
		 
		 homePage.clickOncustomerWelcomebutton();
		
	 }
	 @Test(priority=1)
	 public void verifyMyAccountPage() {
		 
		 HomePage homePage= new HomePage(driver);
		 homePage.clickOnMyAccountOption();
		 MyAccountPage myAccount= new MyAccountPage(driver);
		
		  Assert.assertTrue(myAccount.getMyAccountMessage(),"My Account is not displayed");
	 }
	 @Test(priority=2)
	 public void verifyManageAddressesInMyAccount(){
		 
		 HomePage homePage= new HomePage(driver);
		 homePage.clickOnMyAccountOption();
		 MyAccountPage myAccount= new MyAccountPage(driver);
		 myAccount.goToManageAddressLink();
		 AddressBookPage addressBook= new AddressBookPage(driver);
		  
		  Assert.assertTrue(addressBook.getAddressBookMessage(),"Address Book is not displayed");
		
		 
	 }
	 @Test(priority=3)
	 public void VerifySignOutOption(){
		 
		  HomePage homePage= new HomePage(driver);
		  homePage.clickOnSignOutOption();
		 String url=driver.getCurrentUrl();
		 Assert.assertEquals(url,"https://magento.softwaretestingboard.com/customer/account/logoutSuccess/");
		 
		
		
		 
		 
	 }
	 @AfterMethod
	 public void tearDown() {
		 driver.quit();
	 }
}
