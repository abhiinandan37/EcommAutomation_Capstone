Feature: User login credential validation (Positive, Negative, Edge) 

  @SanityTest
  Scenario Outline: TC01_Verify login with valid username and password
    Given I am on the SauceDemo home page
    Then I enter the username as "standard_user" 
    And I enter the password as "secret_sauce"
    Then I click on Login button
    Then I verify that inventory page open
    
   Scenario Outline: TC02_Verify login with invalid username and valid password
    Given I am on the SauceDemo home page
    Then I enter the username as "standard_user2" 
    And I enter the password as "secret_sauce"
    Then I click on Login button
    Then I verify the error message "Epic sadface: Username and password do not match any user in this service"
    
    
  Scenario Outline: TC03_Verify login with valid username and invalid password
    Given I am on the SauceDemo home page
    Then I enter the username as "standard_user" 
    And I enter the password as "secret_sauce2"
    Then I click on Login button
    Then I verify the error message "Epic sadface: Username and password do not match any user in this service"
    
    Scenario Outline: TC04_Verify login with empty username and valid password
    Given I am on the SauceDemo home page
    Then I enter the username as "" 
    And I enter the password as "secret_sauce"
    Then I click on Login button
    Then I verify the error message "Epic sadface: Username is required"
    
    Scenario Outline: TC05_Verify login with valid username and empty password
    Given I am on the SauceDemo home page
    Then I enter the username as "standard_user" 
    And I enter the password as ""
    Then I click on Login button
    Then I verify the error message "Epic sadface: Password is required"

