package com.luma.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddressBookPage {
 WebDriver driver;
 
 @FindBy(xpath="//h1[@class='page-title']//span")
 private WebElement addressBook;
 
 public AddressBookPage(WebDriver driver) {
	 this.driver= driver;
	 PageFactory.initElements(driver,this);
 }
 public boolean getAddressBookMessage() {
	 boolean addressBookMessage= addressBook.isDisplayed();
	 return addressBookMessage;
 }
}
