package com.luma.qa.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	WebDriver driver;
	Actions builder;
	WebDriverWait wait;
	@FindBy(linkText="Sign In")
	private WebElement signInOption;
	
	@FindBy(css="div[class='panel header'] span[class='logged-in']")
	 private WebElement welcomeMessage;
	
	@FindBy(linkText="Create an Account")
	private WebElement createAnAccountOption;
	
	@FindBy(css="div[class='panel header'] button[type='button']")
	private WebElement customerWelcomeButton;
	
	@FindBy(xpath="//div[@aria-hidden='false']//a[normalize-space()='My Account']")
	private WebElement myAccountOption;
	
	@FindBy(xpath="//div[@aria-hidden='false']//a[normalize-space()='Sign Out']")
	private WebElement signOutOption;
	
	@FindBy(id="search")
	private WebElement searchBox;
	
	@FindBy(css="a[id='ui-id-3'] span:nth-child(1)")
	private WebElement whatsNew;
	
	@FindBy(xpath="//a[@id='ui-id-4']//span[2]")
	private WebElement womenOption;
	
	@FindBy(xpath="//a[@id='ui-id-9']//span[2]")
	private WebElement topsOption;
	
	@FindBy(xpath="//a[@id='ui-id-11']")
	private WebElement jackets;
	
	@FindBy(xpath="//img[@alt='Breathe-Easy Tank']")
	private WebElement breatheEasyTankImage;
	
	@FindBy(xpath="//img[@alt='Push It Messenger Bag']")
	private WebElement pushItMessengerBagImg;
	
	@FindBy(xpath="//div[@aria-hidden='false']//ul[@class='header links']//li[@class='link wishlist']//a[@href='https://magento.softwaretestingboard.com/wishlist/']")
	private WebElement MyWishListOption;
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	public void clickOnSignInOption() {
		signInOption.click();
	}
	public boolean getDisplayStatusOfWelcomeMessage() {
		boolean displayStatus= welcomeMessage.isDisplayed();
		return displayStatus;
	}
	public void clickOnCreateAnAccount() {
		createAnAccountOption.click();
	}
	public void clickOncustomerWelcomebutton() {
		customerWelcomeButton.click();
	}
	public void clickOnMyAccountOption() {
		myAccountOption.click();
		
	}
	public void clickOnSignOutOption() {
		signOutOption.click();
	}
	public void searchProduct(String productName) {
		searchBox.sendKeys(productName);
		searchBox.sendKeys(Keys.ENTER);
	}
	public void clickOnWhatsNew() {
		builder= new Actions(driver);
		builder.moveToElement(whatsNew).click().build().perform();
	}
	public void clickOnSearchBoxAutoSuggest(String prodName) throws InterruptedException {
		 wait= new WebDriverWait(driver,Duration.ofSeconds(10));
		 Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(searchBox));
		searchBox.sendKeys(prodName);
		int i=0;
		while(i<3) {
			Thread.sleep(2000);
	    wait.until(ExpectedConditions.visibilityOf(searchBox));
	    searchBox.sendKeys(Keys.DOWN);
		i++;
		}Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(searchBox));
		searchBox.sendKeys(Keys.ENTER);
	}
	public void clickOnWomenDropdown() {
		builder= new Actions(driver);
		
		 builder.moveToElement(womenOption).perform();
		  builder.moveToElement(topsOption).perform();
		  builder.moveToElement(jackets).click().build().perform();
	}
	public void clickOnBreatheEasyTankImage() {
		builder= new Actions(driver);
		 builder.sendKeys(Keys.PAGE_DOWN);
		breatheEasyTankImage.click();
		
	}
	public void clickOnPushMessengerBag() {
		builder= new Actions(driver);
		builder.scrollToElement(pushItMessengerBagImg);
		pushItMessengerBagImg.click();
		
	}
	public void clickOnMyWishListOption() {
		customerWelcomeButton.click();
		MyWishListOption.click();
		
	}
		
	

}
