package testNG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;

public class AmazonRegistrationTest {

	WebDriver driver;

	@BeforeMethod
	public void beforeMethod() {

		/*
		 * System.setProperty("webdriver.chrome.driver",
		 * "/Users/netra/Downloads/selenium_new/ChromeDriver/chromedriver"); driver =
		 * new ChromeDriver();
		 */
	     driver = new SafariDriver();
		// Enter the URL
		driver.get("https://www.amazon.com/ref=nav_logo");
		driver.manage().window().maximize();

		WebElement ele = driver.findElement(By.id("nav-link-accountList-nav-line-1"));
		Actions act = new Actions(driver);
		act.moveToElement(ele).perform();

		List<WebElement> submenus = driver.findElements(
				By.xpath("//div[@id='nav-flyout-ya-newCust']//a[@class='nav-a'][normalize-space()='Start here.']"));
		for (int i = 0; i < submenus.size(); i++) {
			WebElement element = submenus.get(i);
			String text = element.getAttribute("innerHTML");
			System.out.println("Links name is :  " + text);
			if (text.equals("Start here.")) {
				element.click();
				break;
			}
		}
	}

	@Test(priority = 1)
	public void registerWithCorrectInput() {
		// Enter user name
		WebElement userName = driver.findElement(By.xpath("//input[@id='ap_customer_name']"));
		userName.sendKeys("test123");
		// Enter email
		WebElement userEmail = driver.findElement(By.id("ap_email"));
		userEmail.sendKeys("ketapukoju@matra.top");
		// Enter password again
		WebElement password = driver.findElement(By.id("ap_password"));
		password.sendKeys("qatesting123");
		// Enter password again
		WebElement reEntPass = driver.findElement(By.xpath("//input[@id='ap_password_check']"));
		reEntPass.sendKeys("qatesting123");
		// Click button
		WebElement continueBT = driver.findElement(By.xpath("//input[@id='continue']"));
		continueBT.click();
	}

	@Test(priority = 2)
	public void registerWithAllBlankInput() {
		// Enter user name
		WebElement userName = driver.findElement(By.xpath("//input[@id='ap_customer_name']"));
		userName.sendKeys("");
		// Enter email
		WebElement userEmail = driver.findElement(By.id("ap_email"));
		userEmail.sendKeys("");
		// Enter password
		WebElement password = driver.findElement(By.id("ap_password"));
		password.sendKeys("");
		// Enter password again
		WebElement reEntPass = driver.findElement(By.xpath("//input[@id='ap_password_check']"));
		reEntPass.sendKeys("");
		// Click button
		WebElement continueBT = driver.findElement(By.xpath("//input[@id='continue']"));
		continueBT.click();

		// Verify error messages
		WebElement UserNameErr = driver.findElement(By.xpath("//div[contains(text(),'Enter your name')]"));
		String nameError = UserNameErr.getAttribute("innerHTML");
		System.out.println("error message is : " + nameError);

		WebElement UserEmailErr = driver
				.findElement(By.xpath("//div[contains(text(),'Enter your email or mobile phone number')]"));
		String emailError = UserEmailErr.getAttribute("innerHTML");
		System.out.println("error message is : " + emailError);

		WebElement UserPasswordErr = driver.findElement(By.xpath(
				"//div[@id='auth-password-missing-alert']//div[@class='a-alert-content'][normalize-space()='Minimum 6 characters required']"));
		String passwordError = UserPasswordErr.getAttribute("innerHTML");
		System.out.println("error message is : " + passwordError);
	}

	@Test(priority = 3)
	public void registerWithIncorrectEmail() {
		// Enter user name
		WebElement userName = driver.findElement(By.xpath("//input[@id='ap_customer_name']"));
		userName.sendKeys("test123");
		// Enter email
		WebElement userEmail = driver.findElement(By.id("ap_email"));
		userEmail.sendKeys("@matra.top");
		// Enter password
		WebElement password = driver.findElement(By.id("ap_password"));
		password.sendKeys("qatesting123");
		// Enter password again
		WebElement reEntPass = driver.findElement(By.xpath("//input[@id='ap_password_check']"));
		reEntPass.sendKeys("qatesting123");
		// Click button
		WebElement continueBT = driver.findElement(By.xpath("//input[@id='continue']"));
		continueBT.click();

		// Verify message
		WebElement UserEmailErr = driver.findElement(By.xpath(
				"//div[@class='a-alert-content'][normalize-space()='Wrong or Invalid email address or mobile phone number. Please correct and try again.']"));
		String emailError = UserEmailErr.getAttribute("innerHTML");
		System.out.println("error message is : " + emailError);
	}

	@Test(priority = 4)
	public void registerWithPasswordMIssMatch() {
		// Enter user name
		WebElement userName = driver.findElement(By.xpath("//input[@id='ap_customer_name']"));
		userName.sendKeys("test123");
		// Enter email
		WebElement userEmail = driver.findElement(By.id("ap_email"));
		userEmail.sendKeys("ketapukoju@matra.top");
		// Enter password
		WebElement password = driver.findElement(By.id("ap_password"));
		password.sendKeys("aaaaaa");
		// Enter password again
		WebElement reEntPass = driver.findElement(By.xpath("//input[@id='ap_password_check']"));
		reEntPass.sendKeys("bbbbbb");
		// Click button
		WebElement continueBT = driver.findElement(By.xpath("//input[@id='continue']"));
		continueBT.click();

		// Verify message
		WebElement UserPasswordErr = driver.findElement(By.xpath("//div[contains(text(),'Passwords must match')]"));
		String passwordError = UserPasswordErr.getAttribute("innerHTML");
		System.out.println("error message is : " + passwordError);
	}

	@Test(priority = 5)
	public void registerWithMobileNumber() {
		// Enter user name
		WebElement userName = driver.findElement(By.xpath("//input[@id='ap_customer_name']"));
		userName.sendKeys("test123");
		// Enter email
		WebElement userEmail = driver.findElement(By.id("ap_email"));
		userEmail.sendKeys("1234567891");
		// Enter password
		WebElement password = driver.findElement(By.id("ap_password"));
		password.sendKeys("aaaaaa");
		// Enter password again
		WebElement reEntPass = driver.findElement(By.xpath("//input[@id='ap_password_check']"));
		reEntPass.sendKeys("aaaaaa");

		// Verify message
		WebElement mobileNo = driver.findElement(By.xpath("//div[@id='mobileClaimDisclosureMessage']"));
		String mobileNoMsg = mobileNo.getAttribute("innerHTML");
		System.out.println("Mobile Claim Disclosure Message : " + mobileNoMsg);
	}

	@AfterMethod
	public void afterMethod() {
		;

		driver.close();
	}

}
