package sample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonSearch {

	public static void main(String[] args) throws InterruptedException {
		 System.setProperty("webdriver.chrome.driver","/Users/netra/Downloads/selenium_new/ChromeDriver/chromedriver");
		 WebDriver driver = new ChromeDriver();
		 driver.get("https://www.amazon.com/ref=nav_logo");
		 driver.manage().window().maximize();
		 WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
		 Thread.sleep(5000);
		 searchBox.sendKeys("Java book");
		 
		 WebElement searchButton = driver.findElement(By.id("nav-search-submit-button"));
		 
		 searchButton.click();
		 driver.close();
		 
	}

}
