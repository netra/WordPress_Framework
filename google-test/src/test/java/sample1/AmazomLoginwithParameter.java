package sample1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class AmazomLoginwithParameter {
   
  WebDriver driver;
  @BeforeMethod
  @Parameters({"browser","url"})
  public void beforeMethod(String browser, String url) {
	  if(browser.equals("chrome")) {
	  System.setProperty("webdriver.chrome.driver", "/Users/netra/Downloads/selenium_new/ChromeDriver/chromedriver");	
	  driver = new ChromeDriver();
	  }else if(browser.equals("safari")) {
		  driver=new SafariDriver();
	  }
		driver.get(url);
		driver.manage().window().maximize();
		WebElement signin = driver.findElement(By.id("nav-link-accountList-nav-line-1"));
		signin.click();
  }

  
  @Test
  @Parameters({"emailID","password"})
  public void loginWithValidCredential(String emailID, String password) throws InterruptedException {
	  
	  WebElement email = driver.findElement(By.id("ap_email"));
	  email.sendKeys(emailID);
	  
	  WebElement continueButton = driver.findElement(By.id("continue"));
	  continueButton.click();
	  
	  WebElement pass = driver.findElement(By.id("ap_password"));
	  pass.sendKeys(password);
	  
	  WebElement signin1 = driver.findElement(By.id("signInSubmit"));
	  signin1.click();
	  
	  
  }
  
  @AfterMethod
  public void afterMethod() {
	  
	  driver.quit();
  }

}
