package com.wordpress.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPagePageFactory {

	WebDriver driver;

	@FindBy(id = "usernameOrEmail")
	@CacheLookup
	WebElement username;

	@FindBy(how = How.XPATH, using = "//button[@type='submit']")
	@CacheLookup
	WebElement continuBttn;

	@FindBy(how = How.ID, using = "password")
	@CacheLookup
	WebElement password;

	@FindBy(how = How.XPATH, using = "//button[@type='submit']")
	@CacheLookup
	WebElement loginBttn;
	
	public LoginPagePageFactory(WebDriver driver) {
		this.driver = driver;
	}
	
	public void loginTest(String userId, String pass) throws InterruptedException {
		Thread.sleep(2000);
		username.sendKeys(userId);
		continuBttn.click();
		Thread.sleep(2000);
		password.sendKeys(pass);
		loginBttn.click();

	}

}
