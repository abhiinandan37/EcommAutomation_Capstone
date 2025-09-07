package testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartFeatureValidationTestCases {
	
	WebDriver driver = BrowserSetupPage.getDriver();
	
	@Test (groups = {"SanityTest"}, priority = 6, description = "TC11_Validate cart adding feature with single product" )
	  
	  public void addSingleProduct() {
		  driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
		  WebElement cartBadge = driver.findElement(By.xpath("//a[@class='shopping_cart_link']"));
		  String itemCount = cartBadge.getText();
		  Assert.assertEquals(itemCount, "1", "Cart should have only 1 item");
		  
		
		  
	  }
	  
	  @Test (groups = {"SanityTest"}, priority = 7, description = "TC12_Validate remove product from cart")
	  
	  public void removeItem() {
		  
		  driver.findElement(By.className("shopping_cart_link")).click();
		  
		  List<WebElement> cartItems = driver.findElements(By.className("cart_item"));
		  Assert.assertTrue(cartItems.size()>0, "No Items in the cart");
		  
		  
		  driver.findElement(By.id("remove-sauce-labs-backpack")).click();
		  
		  
		  List<WebElement> afterRemove = driver.findElements(By.id("cart_item"));
		  Assert.assertEquals(afterRemove.size(), 0, "Cart is not Empty");
		  
		  WebElement a = driver.findElement(By.xpath("//button[@id='continue-shopping']"));
		  a.click();
		 		  
	  }
	  
	  @Test (groups = {"SanityTest"}, priority = 8, description = "TC13_Validate cart adding feature with multitle products")
	  public void addMultipleProduct() {
		  
		  
		  
		  driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
		  driver.findElement(By.id("add-to-cart-sauce-labs-fleece-jacket")).click();
		  
		  WebElement cartBadge = driver.findElement(By.xpath("//a[@class='shopping_cart_link']"));
		  String countItem = cartBadge.getText();
		  
		  int count = Integer.parseInt(countItem);
		  Assert.assertTrue(count>1, "Cart must have more than 1 item!");
		  
		  driver.quit();
	  }
	  
  
}
