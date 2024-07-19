package com.luma.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
	WebDriver driver;
	
	@FindBy(id="option-label-size-143-item-168")
	private WebElement size;
	
	@FindBy(id="option-label-color-93-item-53")
	private WebElement color;
	
	@FindBy(id="qty")
	private WebElement quantity;
	
	@FindBy(xpath="//span[text()='Add to Cart']")
	private WebElement addToCartButton;
	
	@FindBy(xpath="//div[@data-ui-id='message-success']/div")
	private WebElement productSuccessMessage;
	
	
	@FindBy(id="option-label-color-93-item-59")
	private WebElement productColor;
	
	@FindBy(linkText="shopping cart")
	private WebElement shoppingCartLink;
	
	@FindBy(xpath="//a[@class='action towishlist']//span")
	private WebElement addToWishList;
	
	
	public ProductPage(WebDriver driver) {
	this.driver= driver;
	PageFactory.initElements(driver, this);
	}
	
	public void clickOnAddToCart() {
		size.click();
		color.click();
		quantity.click();
		addToCartButton.click();
	}
	public void clickOnShoppingCartLink() {
		size.click();
		productColor.click();
		quantity.click();
		addToCartButton.click();
		shoppingCartLink.click();
		
	}
	public String retrieveProductAddedToShoppingCartMessage() {
		String successMessage= productSuccessMessage.getText();
		return successMessage;
	}
  public void clickOnWishList() {
	  addToWishList.click();
  }
	
	 }
   

