package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class SortingFeatureValidationTestCases {
	
	WebDriver driver = BrowserSetupPage.getDriver();
	
	  @Test (groups = {"SanityTest"}, priority = 2, description = "TC07_Validating the sorting feature A to Z")
	  
	  public void sortingByAToZ() {
		  
		  WebElement sortButton = driver.findElement(By.className("product_sort_container"));
		  sortButton.click();
		  Select sort = new Select(sortButton);
		  sort.selectByVisibleText("Name (A to Z)");

		  
	  }
	  
	   @Test (groups = {"SanityTest"}, priority = 3, description = "TC08_Validating the sorting feature Z to A")
	public void sortingByZToA() {
		  
		  WebElement sortButton = driver.findElement(By.className("product_sort_container"));
		  sortButton.click();
		  Select sort = new Select(sortButton);

		  sort.selectByVisibleText("Name (Z to A)");

		  
	  }
	  
	   @Test (groups = {"SanityTest"}, priority = 4, description = "TC09_Validating the price sorting feature by Low to High")
	public void sortingByPriceLowToHigh() {
		  
		  WebElement sortButton = driver.findElement(By.className("product_sort_container"));
		  sortButton.click();
		  Select sort = new Select(sortButton);
		  sort.selectByValue("lohi");

		  
	  }
	  
	   @Test (groups = {"SanityTest"}, priority = 5, description = "TC10_Validating the price sorting feature by High to Low")
	public void sortingByPriceHighToLow() {
		  
		  WebElement sortButton = driver.findElement(By.className("product_sort_container"));
		  sortButton.click();
		  Select sort = new Select(sortButton);
		  sort.selectByVisibleText("Price (high to low)");
		  
		  driver.quit();
		  
	  }

}
