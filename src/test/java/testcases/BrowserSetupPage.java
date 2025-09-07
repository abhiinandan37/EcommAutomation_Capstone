/*THIS CLASS USED FOR BROWSER SETUP FOR USING TESTNG WITH DATA DRIVEN FRAMEWORK*/

package testcases;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import utils.ReadExcelData;

public class BrowserSetupPage extends ReadExcelData {
	
	private static WebDriver driver;
	
	
  @BeforeTest (groups = {"SanityTest"})
	  
  public static WebDriver getDriver() {
	    
	  ChromeOptions options = new ChromeOptions();
	  
	  // Open Chrome browser in incognito mode
	  options.addArguments("--incognito");
	  
	//  	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Abhinandan Ballav\\Downloads\\chromedriver-win64\\chromedriver.exe");
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\Abhinandan Ballav\\Downloads\\chromedriver-win64\\chromedriver.exe");
		driver = new ChromeDriver(options);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		
		// Fetching the user credential from Excel sheet
		String userName = testData(1, 0);
		String password = testData(1, 1);
		
		driver.findElement(By.id("user-name")).clear();
		driver.findElement(By.id("user-name")).sendKeys(userName);
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.id("login-button")).click();
		
		
		
		return driver;
		
		 
  }
  
  @AfterSuite (groups= {"SanityTest"})
  
  public void CloseBrowser() {
  driver.quit();
  }
 
}
