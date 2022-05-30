package com.wordpress.Testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.wordpress.pages.LoginPagePageFactory;
import com.wordpress.pages.WordPressBaseClass;
import com.wordpress.utility.BrowserFactory;
import com.wordpress.utility.ExcelDataProvider;
import com.wordpress.utility.Helper;

public class VerifyValidLogin extends WordPressBaseClass { // LogInTOWodrPress

	@Test(priority=1)
	public void checkValidUser() throws InterruptedException {

		logger = extent.createTest("Log in to wordpress");
		// .log(Status.PASS, "This is a logging event for MyFirstTest, and it passed!");
		
		// call the method
		LoginPagePageFactory loginpagefactory = PageFactory.initElements(driver, LoginPagePageFactory.class);

		logger = extent.createTest("Starting application");
		loginpagefactory.loginTest(excel.getStringData("login", 0, 0), excel.getStringData("login", 0, 1));
		logger.pass("Login Success");
		Helper.captureScreenshot(driver);
	}

	@Test(priority=2)
	public void checkInValidpass() throws InterruptedException {
		
		logger = extent.createTest("Log in to wordpress");
				
		// call the method
		LoginPagePageFactory loginpagefactory = PageFactory.initElements(driver, LoginPagePageFactory.class);

		logger = extent.createTest("Starting application");
		loginpagefactory.loginTest(excel.getStringData("login", 0, 0), excel.getStringData("login", 0, 1));
		
		logger.pass("Login Success");
		loginpagefactory.loginTest("netra.motgi@googlemail.com", "netra");
	}

}
