package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class InventoryUIValidationTestCase {

	WebDriver driver = BrowserSetupPage.getDriver();
	
	 @Test (groups = {"SanityTest"}, priority = 1, description = "TC06_Validating the product images on the inventory page")
	  public void validateUI() {
			
		  String title = driver.getTitle();
		  Assert.assertEquals(title, "Swag Labs", "Page not Found");
		  
		  WebElement product1 = driver.findElement(By.xpath("//img[@alt='Sauce Labs Backpack']"));
		  WebElement product2 = driver.findElement(By.xpath("//img[@alt='Sauce Labs Bike Light']"));
		  WebElement product3 = driver.findElement(By.xpath("//img[@alt='Sauce Labs Bolt T-Shirt']"));
		  WebElement product4 = driver.findElement(By.xpath("//img[@alt='Sauce Labs Fleece Jacket']"));
		  WebElement product5 = driver.findElement(By.xpath("//img[@alt='Sauce Labs Onesie']"));
		  WebElement product6 = driver.findElement(By.xpath("//img[@alt='Test.allTheThings() T-Shirt (Red)']"));
		  
		  Assert.assertTrue(product1.isDisplayed(), "Product not found");
		  Assert.assertTrue(product2.isDisplayed(), "Product not found");
		  Assert.assertTrue(product3.isDisplayed(), "Product not found");
		  Assert.assertTrue(product4.isDisplayed(), "Product not found");
		  Assert.assertTrue(product5.isDisplayed(), "Product not found");
		  Assert.assertTrue(product6.isDisplayed(), "Product not found");
		  
		  driver.quit();
		  
	  }
}
