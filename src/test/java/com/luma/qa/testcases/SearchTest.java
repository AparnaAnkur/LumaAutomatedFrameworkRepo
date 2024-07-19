package com.luma.qa.testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.luma.qa.base.Base;
import com.luma.qa.pages.HomePage;
import com.luma.qa.pages.JacketsPage;
import com.luma.qa.pages.ProductPage;
import com.luma.qa.pages.SearchPage;

public class SearchTest extends Base{
	public SearchTest() {
		super();
	}
	public WebDriver driver;
	Actions builder;
	 @BeforeMethod
	 public void setUp() {
		 driver= initializeBrowser(prop.getProperty("browserName"));
		  
	
	 }
	 @Test(priority=1)
	 public void verifySearchWithValidProduct(){
		 HomePage homePage= new HomePage(driver);
		 homePage.searchProduct(dataProp.getProperty("validProduct"));
		 SearchPage searchPage= new SearchPage(driver);
		 Assert.assertTrue(searchPage.getSearchMessage(),"Search Product not displayed");
		 
	 }
	 @Test(priority=2)
	 public void verifyAddingproductToCart() {
		 HomePage homePage= new HomePage(driver);
		 homePage.searchProduct(dataProp.getProperty("validProduct"));
		
		 SearchPage searchPage= new SearchPage(driver);
		 searchPage.clickOnProductImage();
	   
		 ProductPage productPage= new ProductPage(driver);
		 productPage.clickOnAddToCart();
		
		 String actualSuccessMessage=productPage.retrieveProductAddedToShoppingCartMessage();
		 Assert.assertEquals(actualSuccessMessage,dataProp.getProperty("successMessage"),"You are not able to add Zoe Tank to your shopping cart");
		 
	 }
	 @Test(priority=3)
	 public void verifySearchWithInvalidProduct() {
		 HomePage homePage= new HomePage(driver);
		 homePage.searchProduct(dataProp.getProperty("invalidProduct"));
		 SearchPage searchPage= new SearchPage(driver);
			
		
	    String actualWarningMessage=searchPage.retrieveNoSearchResultMessage();
	    Assert.assertEquals(actualWarningMessage,dataProp.getProperty("noSearchResultWarning"),"Product Search Result Message");
	    
		 
		 
	 }
	 @Test(priority=4)
	 public void verifySearchWithWomenOptionDropdown() throws InterruptedException {
		 HomePage homePage= new HomePage(driver);
		 homePage.clickOnWomenDropdown();
		 
		 JacketsPage jacketsPage= new JacketsPage(driver);
		  Assert.assertTrue(jacketsPage.getJacketHeading(),"Jacket Heading is not displayed");
		  
		 
	 }
	 @Test(priority=5)
	 public void verifyApplyingFiltersToJackets() {
		 HomePage homePage= new HomePage(driver);
		 homePage.clickOnWomenDropdown();
		 JacketsPage jacketsPage= new JacketsPage(driver);
		 jacketsPage.clickOnJacketsFilter();
		
		
		  String actualFilter=jacketsPage.retrieveFilterMessage();
		  Assert.assertEquals(actualFilter,dataProp.getProperty("filter"),"No filter applied");
	 }
		 
		@Test(priority=6)
		public void verifyClickingOnWhatsNewOption()  {
		    HomePage homePage= new HomePage(driver);
		    homePage.clickOnWhatsNew();
			
			Assert.assertEquals(driver.getTitle(),"What's New","Whats New Page is not displayed");
		
		 
	 }
		@Test(priority=7)
		public void verifySearchWithAutosuggestiveDropdown() throws InterruptedException {
			HomePage homePage= new HomePage(driver);
		   
			homePage.clickOnSearchBoxAutoSuggest("bags");
			SearchPage searchPage= new SearchPage(driver);
			
			Assert.assertTrue(searchPage.getProductMessage(),"Search Result is not displayed");
			
		}
	 
	 @AfterMethod
	 public void tearDown() {
	 driver.quit();
	 }
	

}
