package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import pages.BasePage;

public class LoginPage extends BasePage {

	private final By usernameInput = By.id("user-name");
	private final By passwordInput = By.id("password");
	private final By loginButton = By.id("login-button");
	
	private final By errorButton = By.xpath("//h3[@data-test='error']");

    private static final String Page_URL = "https://www.saucedemo.com/";

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get(Page_URL);
    }
    
  
  public void enterUsername(String username) {
  	
	  driver.findElement(usernameInput).sendKeys(username);
		
}

  public void enterpwd(String userpassword) {

	   driver.findElement(passwordInput).sendKeys(userpassword);

}
  
  public void submit() {

	   driver.findElement(loginButton).click();

}
  
  public void verifyingErrorMessage(String ExpectedMsg) {

	 String ActualMsg =  driver.findElement(errorButton).getText();
	 
	 Assert.assertEquals(ActualMsg, ExpectedMsg, "Provided message not matched");

}
  
}
