package com.wordpress.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class RegistrationPagePageFactory {
	
	WebDriver driver;

	@FindBy(xpath = "//input[@id='email']")
	@CacheLookup
	WebElement email;
	
	@FindBy(how = How.ID, using = "username")
	@CacheLookup
	WebElement username;

	@FindBy(how = How.XPATH, using = "//input[@id='password']")
	@CacheLookup
	WebElement password;
	
	@FindBy(how = How.XPATH, using = "//button[@type='submit']")
	@CacheLookup
	WebElement createbttn;
	
	public  RegistrationPagePageFactory(WebDriver driver) {
		this.driver = driver;
	}
	
	public void registationTest(String emailID,String userName, String pass) throws InterruptedException {
		Thread.sleep(2000);
		email.sendKeys(emailID);
		username.sendKeys(userName);
		password.sendKeys(pass);
		createbttn.click();

	}

	

	

}
