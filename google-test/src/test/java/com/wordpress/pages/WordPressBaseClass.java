package com.wordpress.pages;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import com.wordpress.utility.BrowserFactory;
import com.wordpress.utility.ConfigDataProvider;
import com.wordpress.utility.ExcelDataProvider;
import com.wordpress.utility.Helper;

public class WordPressBaseClass {

	protected WebDriver driver;
	protected ExcelDataProvider excel;
	protected ConfigDataProvider config;
	protected ExtentReports extent;
	protected ExtentTest logger;

	@BeforeSuite
	public void setUpSuite() {
		
		Reporter.log("Setting up report and test is getting ready", true);

		excel = new ExcelDataProvider();
		config = new ConfigDataProvider();

		extent = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter("./Reports/FreeWordPress_"+Helper.getCurrentDateTime()+".html");
				//(new File("use.dir") + "/Reports/FreeWordPress.html");
		extent.attachReporter(spark);
		
		Reporter.log("Setting is done : Test can be started", true);

	}

	@BeforeClass
	public void setup() {
		// launch browser and open url
		driver = BrowserFactory.startBrowser(config.getBrowser(), config.getStagingURL());

		// create page object using page factory
		// regi = https://wordpress.com/start/user?ref=logged-out-homepage-lp
		// login =
		// https://wordpress.com/log-in?redirect_to=https%3A%2F%2Fwordpress.com%2F
	}

	@AfterClass
	public void tearDown() {

		Reporter.log("Trying to start browser and getting application ready", true);
		
		BrowserFactory.quitBrowser(driver);
		
		Reporter.log("Browser and application up and running", true);

	}

	@AfterMethod
	public void tearDownMethod(ITestResult result) {

		Reporter.log("Test is above to end", true);
		
		if (result.getStatus() == ITestResult.FAILURE) {
			//Helper.captureScreenshot(driver);
			logger.fail("Test Failed ", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
		}
		else if(result.getStatus() == ITestResult.SUCCESS) {
			logger.fail("Test passed ", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
		}
		extent.flush();
		
		Reporter.log("Test complited >> Reports generated", true);
	}

}
