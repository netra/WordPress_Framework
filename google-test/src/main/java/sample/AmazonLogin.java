package sample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
// this is new comment
public class AmazonLogin {

	public static void main(String[] args) throws InterruptedException {
		//  nav-action-inner id -ap_email, id -continue ap_password signInSubmit hmenu-customer-name
		
		 System.setProperty("webdriver.chrome.driver","/Users/netra/Downloads/selenium_new/ChromeDriver/chromedriver");
		 WebDriver driver = new ChromeDriver();
		 driver.get("https://www.amazon.com/ref=nav_logo");
		 driver.manage().window().maximize();
		 WebElement All_signin = driver.findElement(By.id("nav-link-accountList-nav-line-1"));
		 All_signin.click();
			/*
			 * WebElement signin = driver.findElement(By.id("hmenu-customer-name"));
			 * signin.click()
			 */;
			 
			
	
		 WebElement email = driver.findElement(By.id("ap_email"));
		 email.sendKeys("netra.motgi@googlemail.com");
		 
		 WebElement continueButton= driver.findElement(By.id("continue"));
		 continueButton.click();
		
		 WebElement pass = driver.findElement(By.id("ap_password"));
		 pass.sendKeys("netravati11");
		 WebElement signin1 = driver.findElement(By.id("signInSubmit"));
		 signin1.click();
		 
		 String actualTitle = driver.getTitle();

         System.out.println(actualTitle);
         
         String expectedTitle = "Amazon Sign-In";
 		if(actualTitle.equalsIgnoreCase(expectedTitle))
 			System.out.println("Title Matched");
 		else
 			System.out.println("Title didn't match");
 		driver.close();
		 
		// Thread.sleep(5000);
		 //driver.quit();
	}

}
