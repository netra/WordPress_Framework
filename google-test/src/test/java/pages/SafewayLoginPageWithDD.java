package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import BaseTest.SafewayBaseTest;
import dataDriven.XLUtility;

public class SafewayLoginPageWithDD extends SafewayBaseTest implements LoginConstant{
	
	@DataProvider(name = "Login_data")
	public Object[][] getData() throws IOException {

		String path="/Users/netra/eclipse-workspace/google-test/datafiles/DDTestData.xlsx";
		XLUtility xlutil = new XLUtility(path);
		int totalrows=xlutil.getRowCount("Sheet1");
		int totalcols = xlutil.getCellCount("Sheet1", 1);
		
		String loginData[][]= new String[totalrows][totalcols];
		
		for(int i=1;i<=totalrows;i++) {
			for(int j=0;j<totalcols;j++) {
				loginData[i-1][j]=xlutil.getCellData("Sheet1", i, j);
			}
		}
		return loginData;
	}
	
	@Test(dataProvider = "Login_data") 
	  public void loginWithDifferentCredential(String email, String pwd, String exp) throws InterruptedException {
		WebElement signin = driver.findElement(By.xpath("//span[@class='button__item menu-nav__profile-button-sign-in-up d-none d-lg-inline-block dst-sign-in-up']"));
		signin.click();
		
		WebElement signin1 = driver.findElement(By.xpath("//a[@id='sign-in-modal-link']"));
		signin1.click();
		Thread.sleep(2000);
		WebElement email1 = driver.findElement(By.id("label-email"));
		email1.sendKeys(email);

		WebElement pass = driver.findElement(By.id("label-password"));
		pass.sendKeys(pwd);

		WebElement signin2 = driver.findElement(By.id("btnSignIn"));
		signin2.click();
		
		Assert.assertEquals("Home - Online Grocery Delivery | Safeway", driver.getTitle());
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.safeway.com/"));
	 
	}
	
	

}
