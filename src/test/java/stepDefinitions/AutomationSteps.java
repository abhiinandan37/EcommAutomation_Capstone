/*THIS IS THE CUCUMBER TEST DEFINITION CLASS*/

package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.InventoryPage;
import testcases.LoginPage;

public class AutomationSteps {

    private LoginPage loginPage;
    private InventoryPage inventoryPage;

    @Given("I am on the SauceDemo home page")
    public void i_am_on_the_home_page() {
        loginPage = new LoginPage(Hooks.driver);
        inventoryPage = new InventoryPage(Hooks.driver);
        loginPage.open();
    }

    @Then("I enter the username as {string}")
    public void i_enter_the_username(String username) {
        loginPage.enterUsername(username);
    }
    
    @Then("I enter the password as {string}")
    public void i_enter_the_password(String userpassword) {
        loginPage.enterpwd(userpassword);
    }
    
    @Then("I click on Login button")
    public void i_click_on_login_button() {
        loginPage.submit();
    }
    
    @Then("I verify that inventory page open")
    public void i_verify_inventory_page_open() {
    	inventoryPage.isAt();
    }
    
    @Then("I verify the error message {string}")
    public void i_verify_the_error_message(String ExpectedMsg) {
        loginPage.verifyingErrorMessage(ExpectedMsg);
    }
    
    
}
