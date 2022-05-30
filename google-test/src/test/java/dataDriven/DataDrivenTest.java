package dataDriven;

import java.io.IOException;
 

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
 
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataDrivenTest {

	WebDriver driver;

	@BeforeMethod
	public void setUP() {

		System.setProperty("webdriver.chrome.driver", "/Users/netra/Downloads/selenium_new/ChromeDriver/chromedriver");
		driver = new ChromeDriver();

		// Enter the URL
		driver.get("https://www.safeway.com/account/sign-in.html");
		driver.manage().window().maximize();

	}

	@Test(dataProvider = "Login_data")
	public void loginWithValidCredential(String email, String pwd, String exp) throws InterruptedException {

		WebElement email1 = driver.findElement(By.id("label-email"));
		email1.sendKeys(email);

		WebElement pass = driver.findElement(By.id("label-password"));
		pass.sendKeys(pwd);

		WebElement signin1 = driver.findElement(By.id("btnSignIn"));
		signin1.click();

		System.out.println("actual title of page : " + driver.getTitle());

		String exp_title = "Sign In | Safeway";
		String act_title = driver.getTitle();

		Thread.sleep(2000);

		Assert.assertEquals(act_title, exp_title, "title match");

	}

	
	@DataProvider(name = "Login_data")
	public Object[][] getData() throws IOException {

		String path = "/Users/netra/eclipse-workspace/google-test/datafiles/DDTestData.xlsx";
		XLUtility xlutil = new XLUtility(path);
		int totalrows = xlutil.getRowCount("Sheet1");
		int totalcols = xlutil.getCellCount("Sheet1", 1);

		String loginData[][] = new String[totalrows][totalcols];

		for (int i = 1; i <= totalrows; i++) {
			for (int j = 0; j < totalcols; j++) {
				loginData[i - 1][j] = xlutil.getCellData("Sheet1", i, j);
			}
		}
		return loginData;
	}

	@AfterClass
	void clearUp() {
		driver.close();
	}

}
