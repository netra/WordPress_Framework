package wordpress;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

// this class will store all the locater and methods of login class
public class LoginPage {

	WebDriver driver;

	By username = By.id("usernameOrEmail");
	By continuBttn = By.xpath("//button[@type='submit']");
	By password = By.id("password");
    By loginBttn = By.xpath("//button[@type='submit']");

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public void loginTest(String userId, String pass) throws InterruptedException {
		driver.findElement(username).sendKeys(userId);
		driver.findElement(continuBttn).click();
		Thread.sleep(2000);
		driver.findElement(password).sendKeys(pass);
		driver.findElement(loginBttn).click();
		
	}

}
