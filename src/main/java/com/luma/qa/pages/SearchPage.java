package com.luma.qa.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SearchPage {
	WebDriver driver;
	Actions builder;
	
	@FindBy(className="base")
	private WebElement searchMessage;
	
	@FindBy(xpath="//div[contains(text(),'Your search returned no results.')]")
	private WebElement noSearchResultMessage;
	
	@FindBy(id="sorter")
	private WebElement sortByDropdown;
	
	@FindBy(xpath="//img[@alt='Zoe Tank']")
	private WebElement productImage;
	
	@FindBy(xpath="//h1[@class='page-title']//span")
	private WebElement productMessage;

	public SearchPage(WebDriver driver) {
	this.driver= driver;
	PageFactory.initElements(driver, this);
	}
	
	public boolean getSearchMessage() {
		boolean searchResult=searchMessage.isDisplayed();
		return searchResult;
	}
	public String retrieveNoSearchResultMessage() {
		String noSearchMessage= noSearchResultMessage.getText();
		return noSearchMessage;
	}
	public void clickOnProductImage() {
		WebElement sortBy= sortByDropdown;
		Select select= new Select(sortBy);
		select.selectByVisibleText("Product Name");
		builder= new Actions(driver);
		builder.sendKeys(Keys.PAGE_DOWN).build().perform();
		productImage.click();
	}
	public boolean getProductMessage() {
		boolean displayStatus= productMessage.isDisplayed();
		return displayStatus;
	}
}
