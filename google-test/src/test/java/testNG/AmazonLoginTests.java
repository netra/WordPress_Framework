package testNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AmazonLoginTests {
	WebDriver driver;

	@BeforeMethod
	public void beforeTest() {

		System.setProperty("webdriver.chrome.driver", "/Users/netra/Downloads/selenium_new/ChromeDriver/chromedriver");
		driver = new ChromeDriver();
		driver.get("https://www.amazon.com/ref=nav_logo");
		driver.manage().window().maximize();
		WebElement signin = driver.findElement(By.id("nav-link-accountList-nav-line-1"));
		signin.click();
	}

	
	  @Test(priority = 1)
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
	  
	  @Test (priority = 2) 
	  public void loginWithIncorrectPassword() throws InterruptedException {
	    
	  WebElement email = driver.findElement(By.xpath("//input[@id='ap_email'and@name='email']"));
	  email.sendKeys("netra.motgi@googlemail.com");
	  
	  WebElement continueButton = driver.findElement(By.id("continue"));
	  continueButton.click();
	  
	  WebElement pass = driver.findElement(By.id("ap_password"));
	  pass.sendKeys("test123");
	  
	  WebElement signin1 = driver.findElement(By.id("signInSubmit"));
	  signin1.click();
	  
	  WebElement element =driver.findElement(By.xpath("//span[@class='a-list-item']")); String
	  errorMessage = element.getAttribute("innerHTML");
	  System.out.println("error message is : " + errorMessage);
	  
	  }
	  
	  @Test (priority = 3)
	  public void loginWithIncorrectEmail() throws InterruptedException {
	  
	  WebElement email = driver.findElement(By.xpath("//input[@id='ap_email'and@name='email']"));
	  email.sendKeys("netra@googlemail.com");
	  
	  WebElement continueButton = driver.findElement(By.id("continue"));
	  continueButton.click();
	  
	  WebElement element =driver.findElement(By.xpath("//span[@class='a-list-item']")); String
	  errorMessage = element.getAttribute("innerHTML");
	  
	  System.out.println("error message is : " + errorMessage);
	   
	  
	  }
	 
	@Test(priority = 4)
	public void loginWithBlankEmail() throws InterruptedException {

		WebElement email = driver.findElement(By.xpath("//input[@id='ap_email'and@name='email']"));
		email.sendKeys(" ");

		WebElement continueButton = driver.findElement(By.id("continue"));
		continueButton.click();

		WebElement element = driver
				.findElement(By.xpath("//div[contains(text(),'Enter your email or mobile phone number')]"));
		String errorMessage = element.getAttribute("innerHTML");

		System.out.println("error message is : " + errorMessage);
		String title = driver.getTitle();
		System.out.println("Title of the page : "+title);
	}

	@AfterMethod

	public void afterTest() throws InterruptedException {
		Thread.sleep(5000);
		driver.quit();
		
		
//		WebElement ele = driver.findElement(By.id("nav-link-accountList-nav-line-1"));
//		Actions act = new Actions(driver);
//		act.moveToElement(ele).perform();
//
//		List<WebElement> submenus = driver.findElements(By.className("nav-text"));
//		for (int i = 0; i < submenus.size(); i++) {
//			WebElement element = submenus.get(i);
//			String text = element.getAttribute("innerHTML");
//			System.out.println("Links name is :  " + text);
//			if (text.equals("Sign Out")) {
//				element.click();
//				break;
//			}
		// driver.navigate().back();
		

		 
	}
	
	
  
}
