package com.wordpress.Testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.wordpress.pages.LoginPagePageFactory;
import com.wordpress.pages.RegistrationPagePageFactory;
import com.wordpress.pages.WordPressBaseClass;
import com.wordpress.utility.BrowserFactory;

public class VerifyRegistrationWordPress extends  WordPressBaseClass {
	
	@Test
	public void checkValidUser() throws InterruptedException {

		// call the method
		RegistrationPagePageFactory	registrationPagefactory = PageFactory.initElements(driver, RegistrationPagePageFactory.class);
	
		registrationPagefactory.registationTest("ketapukoju@matra.top","Netravati", "qatesting123");
	}
	@Test
	public void checkInValidUser() throws InterruptedException {

		// call the method
		RegistrationPagePageFactory	registrationPagefactory = PageFactory.initElements(driver, RegistrationPagePageFactory.class);
	
		registrationPagefactory.registationTest("","Netravati", "qatesting123");
		
	}

	
	
	


}
