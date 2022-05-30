package testNG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class AmazonCartAndCheckout {
	
	WebDriver driver;
	
	@BeforeMethod
		public void loginToAmazon() {
			System.setProperty("webdriver.chrome.driver", "/Users/netra/Downloads/selenium_new/ChromeDriver/chromedriver");
			driver = new ChromeDriver();
			driver.get("https://www.amazon.com/ref=nav_logo");
			driver.manage().window().maximize();
			WebElement signin = driver.findElement(By.id("nav-link-accountList-nav-line-1"));
			signin.click();
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
			WebElement email = driver.findElement(By.id("ap_email"));
			email.sendKeys("netra.motgi@googlemail.com");

			WebElement continueButton = driver.findElement(By.id("continue"));
			continueButton.click();
			
			WebElement pass = driver.findElement(By.id("ap_password"));
			pass.sendKeys("netravati11");

			WebElement signin1 = driver.findElement(By.id("signInSubmit"));
			signin1.click();
	}

	@Test //    
	public void addToCart() {
		WebElement bestSeller = driver.findElement(By.xpath("//a[@href='/gp/bestsellers/?ref_=nav_cs_bestsellers']"));
		bestSeller.click();

		// This will scroll page 400 pixel vertical
		((JavascriptExecutor) driver).executeScript("scroll(0,400)");

		WebElement addItem = driver
				.findElement(By.xpath("//img[contains(@alt,\"Gildan Men's Crew T-Shirts, Multipack\")]"));
		addItem.click();
		WebElement addToCart = driver.findElement(By.xpath("//input[@id='add-to-cart-button']"));
		addToCart.click();

		WebElement addToCartMsg = driver
				.findElement(By.xpath("//span[@class='a-size-medium-plus a-color-base sw-atc-text a-text-bold']"));
		String readMsg = addToCartMsg.getAttribute("innerHTML");
		System.out.println("Message in cart is : " + readMsg);

		/*
		 * WebElement proceedToCart =
		 * driver.findElement(By.xpath("//input[@name='proceedToRetailCheckout’]"));
		 * proceedToCart.click();
		 */
	}

	@Test
	public void addToCartAndCheckCart() {

		WebElement bestSeller = driver.findElement(By.xpath("//a[@href='/gp/bestsellers/?ref_=nav_cs_bestsellers']"));
		bestSeller.click();

		// This will scroll page 400 pixel vertical
		((JavascriptExecutor) driver).executeScript("scroll(0,400)");

		WebElement addItem = driver
				.findElement(By.xpath("//img[contains(@alt,\"Gildan Men's Crew T-Shirts, Multipack\")]"));
		addItem.click();
		WebElement addToCart = driver.findElement(By.xpath("//input[@id='add-to-cart-button']"));
		addToCart.click();

		WebElement goToCart = driver.findElement(By.xpath("//a[normalize-space()='Go to Cart']"));
		goToCart.click();

		WebElement shoppingCart = driver.findElement(By.xpath("//h1[normalize-space()='Shopping Cart']"));
		String cartMsg = shoppingCart.getAttribute("innerHTML");
		System.out.println("Shopping cart message : " + cartMsg);
	}

	@Test
	public void checkoutCartAndSaveForLater() {

		// click on bestseller from menu
		WebElement bestSeller = driver.findElement(By.xpath("//a[@href='/gp/bestsellers/?ref_=nav_cs_bestsellers']"));
		bestSeller.click();

		// This will scroll page 400 pixel vertical
		((JavascriptExecutor) driver).executeScript("scroll(0,400)");

		// click on item
		WebElement addItem = driver
				.findElement(By.xpath("//img[contains(@alt,\"Gildan Men's Crew T-Shirts, Multipack\")]"));
		addItem.click();

		// adding item to cart
		WebElement addToCart = driver.findElement(By.xpath("//input[@id='add-to-cart-button']"));
		addToCart.click();

		// go to cart
		WebElement goToCart = driver.findElement(By.xpath("//a[normalize-space()='Go to Cart']"));
		goToCart.click();

		// Save item for later
		WebElement saveForLater = driver.findElement(By.cssSelector("input[value='Save for later']"));
		saveForLater.click();

		// This will scroll page 400 pixel vertical
		((JavascriptExecutor) driver).executeScript("scroll(0,400)");

		WebElement actuleTitleONsaveForLater = driver
				.findElement(By.cssSelector("span[class='a-truncate a-size-base-plus'] span[class='a-truncate-cut']"));
		String actuleTitle = actuleTitleONsaveForLater.getAttribute("innerHTML");
		Assert.assertTrue(actuleTitle.contains("Gildan Men's Crew T-Shirts"));
		System.out.println("Test passed page verified");

	}

	@Test
	public void addToCartAndDeleteItem() {

		// click on bestseller from menu////a[@href='/gp/bestsellers/?ref_=nav_cs_bestsellers']
		WebElement bestSeller = driver.findElement(By.xpath("//a[@href='/gp/bestsellers/?ref_=nav_cs_bestsellers']"));
		bestSeller.click();

		// This will scroll page 400 pixel vertical
		((JavascriptExecutor) driver).executeScript("scroll(0,400)");

		// click on item
		WebElement addItem = driver
				.findElement(By.xpath("//img[contains(@alt,\"Gildan Men's Crew T-Shirts, Multipack\")]"));
		addItem.click();

		// adding item to cart
		WebElement addToCart = driver.findElement(By.xpath("//input[@id='add-to-cart-button']"));
		addToCart.click();

		// go to cart
		WebElement goToCart = driver.findElement(By.xpath("//a[normalize-space()='Go to Cart']"));
		goToCart.click();
		
		/*
		 * // delete the item from cart WebElement deleteIteInCart =
		 * driver.findElement(By.xpath(
		 * "/html[1]/body[1]/div[1]/div[4]/div[1]/div[3]/div[1]/div[2]/div[4]/div[1]/form[1]/div[2]/div[3]/div[4]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/span[2]/span[1]/input[1]"
		 * )); deleteIteInCart.click(); WebElement deleteItemConfirm =
		 * driver.findElement(By.
		 * cssSelector("div[id='sc-active-cart'] div[class='sc-list-item-removed-msg'] div:nth-child(1) span:nth-child(1) a:nth-child(1)"
		 * )); String deletedItemName=deleteItemConfirm.getAttribute("innerHTML");
		 * 
		 * Assert.assertTrue(deletedItemName.contains("Gildan Men's Crew T-Shirts"));
		 * System.out.println("Delete item confirmation message : " + deletedItemName);
		 */
	    
	}
	

	@AfterMethod
	public void afterMethod() {
		driver.close();
	}

}
