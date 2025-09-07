/*IN THIS CLASS I AM USING TESTNG PARAMETER*/

package testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CheckoutFeatureValidationTestCases {
	
	WebDriver driver = BrowserSetupPage.getDriver();
	
	@Parameters ({"FirstName","LastName"})
	@Test (groups = {"SanityTest"}, priority = 9, description = "TC14_Validate checkout feature without postal code")
	  
	  public void checkoutWithOutPostalCode(String FirstName, String LastName) {
		
		driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
		  
		  driver.findElement(By.className("shopping_cart_link")).click();
		  
		  List<WebElement> cartItems = driver.findElements(By.className("cart_item"));
		  
		  Assert.assertTrue(cartItems.size()>0, "Please add item before checkout");
		  
		  driver.findElement(By.id("checkout")).click();
		  
		  driver.findElement(By.id("first-name")).sendKeys(FirstName);
		  
		  driver.findElement(By.id("last-name")).sendKeys(LastName);
		  
		  driver.findElement(By.id("postal-code")).sendKeys("");
		  
		  driver.findElement(By.id("continue")).click();
		  
		  
		  WebElement errorMessage = driver.findElement(By.xpath("//div[@class='error-message-container error']"));
		  
		  Assert.assertEquals(errorMessage.getText(), "Error: Postal Code is required", "Provided message not matched");
		  
		  
	  }
	
	@Parameters ({"PostalCode"})
	@Test (groups = {"SanityTest"}, priority = 10, description = "TC15_Validate checkout feature with proper address")
	  
	  public void checkoutWithAllDetails(String PostalCode) {
		  
		  driver.findElement(By.id("postal-code")).sendKeys(PostalCode);
		  
		  driver.findElement(By.id("continue")).click();
		  
		  driver.findElement(By.id("finish")).click();
		  
		  
		  WebElement successMessage = driver.findElement(By.className("complete-header"));
		  
		  Assert.assertEquals(successMessage.getText(), "Thank you for your order!", "OOPS! Order was not placed");
		  
		  driver.quit();
	  }
	
	
}
