package sample;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class Parameters {
	WebDriver driver;
  @BeforeMethod
  public void beforeMethod() {
	  
	  System.setProperty("webdriver.chrome.driver", "/Users/netra/Downloads/selenium_new/ChromeDriver/chromedriver");
		driver = new ChromeDriver();
		driver.get("https://www.amazon.com/ref=nav_logo");
		driver.manage().window().maximize();
		WebElement signin = driver.findElement(By.id("nav-link-accountList-nav-line-1"));
		signin.click();
  }

  
  @Test
  public void loginWithValidCredential() throws InterruptedException {
	  
	  WebElement email = driver.findElement(By.id("ap_email"));
	  email.sendKeys("netra.motgi@googlemail.com");
	  
	  WebElement continueButton = driver.findElement(By.id("continue"));
	  continueButton.click();
	  
	  WebElement pass = driver.findElement(By.id("ap_password"));
	  pass.sendKeys("netravati11");
	  
	  WebElement signin1 = driver.findElement(By.id("signInSubmit"));
	  signin1.click();
	  
	  
  }
  
  @AfterMethod
  public void afterMethod() {
	  
	  driver.quit();
  }

}
