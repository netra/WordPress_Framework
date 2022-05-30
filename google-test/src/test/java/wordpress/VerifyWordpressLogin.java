
package wordpress;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

// open Chrome and execute
public class VerifyWordpressLogin {
	
	@Test
	public void verifyValidLogin() throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "/Users/netra/Downloads/selenium_new/ChromeDriver/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://wordpress.com/log-in?redirect_to=https%3A%2F%2Fwordpress.com%2F");
		
		LoginPage login = new LoginPage(driver);	 
		login.loginTest("netra.motgi@googlemail.com","netravati11");
		driver.quit();
		
	}
}
