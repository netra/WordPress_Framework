package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import BaseTest.SafewayBaseTest;

public class SafewayLoginPage extends SafewayBaseTest implements LoginConstant{
	
	@Test 	(priority = 1)  
	public void loginWithDifferentCredential() throws InterruptedException {
		driver.findElement(By.xpath("//span[@class='button__item menu-nav__profile-button-sign-in-up d-none d-lg-inline-block dst-sign-in-up']")).click();;
		driver.findElement(By.xpath("//a[@id='sign-in-modal-link']")).click();;
	
		Thread.sleep(2000);
		WebElement email1 = driver.findElement(By.id("label-email"));
		email1.sendKeys(EMAIL);

		WebElement pass = driver.findElement(By.id("label-password"));
		pass.sendKeys(PASSWORD);

	    driver.findElement(By.id("btnSignIn")).click();
		 
		WebElement account=driver.findElement(By.xpath("//*[name()='path' and contains(@class,'account-ic')]"));
		account.click();
		String str =driver.findElement(By.xpath("//p[@class='sidebar__user-welcome__message']")).getAttribute("innerHTML");
		
		System.out.println("title of the page is : "+str);
		
		Assert.assertEquals("Home - Online Grocery Delivery | Safeway", driver.getTitle());
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.safeway.com/"));
	 
	}
	
	@Test(priority = 2)
	public void loginWithIncorrectCredential() throws InterruptedException {
		
		WebElement signin = driver.findElement(By.xpath("//span[@class='button__item menu-nav__profile-button-sign-in-up d-none d-lg-inline-block dst-sign-in-up']"));
		signin.click();
		
		WebElement signin1 = driver.findElement(By.xpath("//a[@id='sign-in-modal-link']"));
		signin1.click();
		Thread.sleep(2000);
		WebElement email1 = driver.findElement(By.id("label-email"));
		email1.sendKeys("test123@gmail.com");

		WebElement pass = driver.findElement(By.id("label-password"));
		pass.sendKeys("test123");

		WebElement signin2 = driver.findElement(By.id("btnSignIn"));
		signin2.click();
		System.out.println("title of the page is : "+driver.getTitle());
		Assert.assertEquals("Home - Online Grocery Delivery | Safeway", driver.getTitle());
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.safeway.com/"));	
	}
	
	@Test(priority = 3)
	public void loginWithIncorrectPassword() throws InterruptedException {
		
		WebElement signin = driver.findElement(By.xpath("//span[@class='button__item menu-nav__profile-button-sign-in-up d-none d-lg-inline-block dst-sign-in-up']"));
		signin.click();
		
		WebElement signin1 = driver.findElement(By.xpath("//a[@id='sign-in-modal-link']"));
		signin1.click();
		Thread.sleep(2000);
		WebElement email1 = driver.findElement(By.id("label-email"));
		email1.sendKeys(EMAIL);

		WebElement pass = driver.findElement(By.id("label-password"));
		pass.sendKeys("test123");

		WebElement signin2 = driver.findElement(By.id("btnSignIn"));
		signin2.click();
		System.out.println("title of the page is : "+driver.getTitle());
		Assert.assertEquals("Home - Online Grocery Delivery | Safeway", driver.getTitle());
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.safeway.com/"));	
		
	}
	
	@Test (priority = 4)
	  public void loginWithBlanckEmail() throws InterruptedException {
		
		WebElement signin = driver.findElement(By.xpath("//span[@class='button__item menu-nav__profile-button-sign-in-up d-none d-lg-inline-block dst-sign-in-up']"));
		signin.click();
		
		WebElement signin1 = driver.findElement(By.xpath("//a[@id='sign-in-modal-link']"));
		signin1.click();
		Thread.sleep(2000);
		WebElement email1 = driver.findElement(By.id("label-email"));
		email1.sendKeys("");

		WebElement pass = driver.findElement(By.id("label-password"));
		pass.sendKeys(PASSWORD);

		WebElement signin2 = driver.findElement(By.id("btnSignIn"));
		signin2.click();
		System.out.println("title of the page is : "+driver.getTitle());
		Assert.assertEquals("Home - Online Grocery Delivery | Safeway", driver.getTitle());
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.safeway.com/"));
	  
	}
	
	

}
