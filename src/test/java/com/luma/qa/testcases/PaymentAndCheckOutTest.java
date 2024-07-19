package com.luma.qa.testcases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.luma.qa.base.Base;
import com.luma.qa.pages.HomePage;
import com.luma.qa.pages.LoginPage;
import com.luma.qa.pages.MyWishListPage;
import com.luma.qa.pages.ProductPage;

public class PaymentAndCheckOutTest extends Base{
	public PaymentAndCheckOutTest() {
		super();
	}
	public WebDriver driver;
	Actions builder;
	 @BeforeMethod
	 public void setUp(){
		 driver= initializeBrowser(prop.getProperty("browserName"));
		
		 HomePage homePage= new HomePage(driver);
		 homePage.clickOnSignInOption();
		
		 LoginPage login= new LoginPage(driver);
		 login.loginMethod(prop.getProperty("validEmail"),prop.getProperty("validPassword") );
		  
	 }
	 @Test(priority=1)
	 public void verifyAddingProductToShoppingCart()  {
		 HomePage homePage= new HomePage(driver);
		 homePage.clickOnBreatheEasyTankImage();
		 ProductPage productPage= new ProductPage(driver);
		 productPage.clickOnShoppingCartLink();
		 
		 Assert.assertEquals(driver.getTitle(),"Shopping Cart","Shopping Cart is not displayed");
	 }
	 
		 
	
	 @Test(priority=2)
	 public void verifyAddingProductToWishlist()  {
		 HomePage homePage= new HomePage(driver);
		 homePage.clickOnPushMessengerBag();
		 ProductPage productPage= new ProductPage(driver);
		 productPage.clickOnWishList();
		  MyWishListPage myWishListPage= new MyWishListPage(driver);
		  String actualSuccessMessage=myWishListPage.wishlistSuccessMessage();
		  Assert.assertEquals(actualSuccessMessage,dataProp.getProperty("wishListSuccessMessage"),"Push It Messenger Bag has not been added to your Wish List");
		 
	 }
	 @Test(priority=3,dependsOnMethods= {"verifyAddingProductToWishlist"})
	 public void verifyRemovingProductFromWishlist() throws InterruptedException {
		 HomePage homePage= new HomePage(driver);
		 homePage.clickOnMyWishListOption();
		  
	
		 MyWishListPage myWishListPage= new MyWishListPage(driver);
		 myWishListPage.clickOnRemoveThisItem();
		
		  String actualSuccessMessage=myWishListPage.wishlistRemoveSuccessMessage();
		  Assert.assertEquals(actualSuccessMessage,dataProp.getProperty("removeWishListMessage"),"Push It Messenger Bag has not been removed from your Wish List.");
		  
		  
		 
	 }
	 @AfterMethod
	 public void tearDown() {
		 driver.quit();
	 }

}
