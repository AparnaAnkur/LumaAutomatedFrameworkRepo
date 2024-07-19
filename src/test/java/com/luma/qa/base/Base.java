package com.luma.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.luma.qa.utils.Utilities;

public class Base {
 WebDriver driver;
 public Properties prop;
 public Properties dataProp;
 WebDriverWait wait;
 public Base() {
	 prop= new Properties();
	 File propFile= new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\luma\\qa\\config\\config.properties");
	
	 try {
	 FileInputStream fis= new FileInputStream(propFile);
	 prop.load(fis);
	 }catch(Throwable e) {
		 e.printStackTrace();
	 }
	 dataProp= new Properties();
	 File dataPropFile= new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\luma\\qa\\testdata\\testdata.properties");
	 try {
		 FileInputStream dataFis= new FileInputStream(dataPropFile);
		 dataProp.load(dataFis);
	 }catch(Throwable e) {
		 e.printStackTrace();
	 }
 }
 public WebDriver initializeBrowser(String browserName) {
	 if(browserName.equalsIgnoreCase("chrome")) {
		 driver= new ChromeDriver();
	 }
		 else if(browserName.equalsIgnoreCase("firefox")) {
			 driver= new FirefoxDriver();
		 }
			 else if(browserName.equalsIgnoreCase("edge")) {
				 driver= new EdgeDriver();
				 
	 }
	 driver.manage().window().maximize();
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utilities.IMPLICIT_WAIT_TIME));
	// driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Utilities.PAGE_LOAD_TIME));
	 driver.get(prop.getProperty("url"));
	 
	 
	 return driver;
 }
}
