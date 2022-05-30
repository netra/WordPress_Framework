package sample1;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class AmazonLoginWithDataDriven {
	WebDriver driver;

	@BeforeMethod(enabled=false)
	public void beforeMethod() {
		System.setProperty("webdriver.chrome.driver", "/Users/netra/Downloads/selenium_new/ChromeDriver/chromedriver");
		driver = new ChromeDriver();
		driver.get("https://www.amazon.com/ref=nav_logo");
		driver.manage().window().maximize();
		WebElement signin = driver.findElement(By.id("nav-link-accountList-nav-line-1"));
		signin.click();

	}
	
	@DataProvider(name="getTestData")
	public Object[][] getTestData() {
		Object[][] data = new Object[2][2];
		data[0][0] ="firstUid";
		data[0][1]="firstPWD";
		
		data[1][0]="secondUid";
		data[1][1]="secondPWD";
		
		return data;
		
	}
	@Test(dataProvider="getTestData")
	public void loginTest(String Uid, String Pwd) {
		System.out.println("User name is : "+Uid);
		System.out.println("Password isn : "+Pwd);
		
	}

	@Test (enabled=false) // skip this method from execution
	public void loginWithValidCredential(String email, String password) {
		WebElement email1 = driver.findElement(By.id("ap_email"));
		  email1.sendKeys(email);
		  
		  WebElement continueButton = driver.findElement(By.id("continue"));
		  continueButton.click();
		  
		  WebElement pass = driver.findElement(By.id("ap_password"));
		  pass.sendKeys(password);
		  
		  WebElement signin1 = driver.findElement(By.id("signInSubmit"));
		  signin1.click();
		  
	}

	@AfterMethod
	public void afterMethod() {
	}

}
