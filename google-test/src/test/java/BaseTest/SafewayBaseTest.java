package BaseTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class SafewayBaseTest {
	
	protected WebDriver driver;

	@BeforeMethod
	public void beforeTest() {

		System.setProperty("webdriver.chrome.driver", "/Users/netra/Downloads/selenium_new/ChromeDriver/chromedriver");
		driver = new ChromeDriver();
		driver.get("https://www.safeway.com/"); 
		String title= driver.getTitle();
		driver.manage().window().maximize();
		
	}
	
	@AfterMethod

	public void afterTest() throws InterruptedException {
		Thread.sleep(5000);
		driver.quit();
		
	}

}
