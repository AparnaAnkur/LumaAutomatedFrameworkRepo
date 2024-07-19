package com.luma.qa.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporter {
	public static ExtentReports generateExtentReport() {
		ExtentReports extentReport= new ExtentReports();
		File extentReportFile= new File(System.getProperty("user.dir")+"\\test-output\\ExtentReports\\extentReport.html");
		ExtentSparkReporter sparkReporter= new ExtentSparkReporter(extentReportFile);
		
		sparkReporter.config().setTheme(Theme.DARK);
		sparkReporter.config().setReportName("Luma Automation Report");
		sparkReporter.config().setDocumentTitle("Luma Automation Report");
		sparkReporter.config().setTimeStampFormat("dd|MM|yyyy   hh:mm:ss");
		
		extentReport.attachReporter(sparkReporter);
		
		Properties configProp= new Properties();
		File configPropFile= new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\luma\\qa\\config\\config.properties");
		try {
		FileInputStream fisConfigProp= new FileInputStream(configPropFile);
		
			configProp.load(fisConfigProp);
		} catch (IOException e) {
		
			e.printStackTrace();
		}
		extentReport.setSystemInfo("Application url",configProp.getProperty("url"));
		extentReport.setSystemInfo("BrowserName", configProp.getProperty("browserName"));
		extentReport.setSystemInfo("Email", configProp.getProperty("validEmail"));
		extentReport.setSystemInfo("Password", configProp.getProperty("validPassword"));
		extentReport.setSystemInfo("OperatingSystem",System.getProperty("os.name"));
		extentReport.setSystemInfo("OperatingSystem",System.getProperty("user.name"));
		
		return extentReport;
	}
}
