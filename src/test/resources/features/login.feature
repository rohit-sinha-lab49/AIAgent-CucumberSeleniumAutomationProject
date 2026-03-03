Feature: Saucedemo Login

  Background:
    Given I open the Saucedemo login page

  @smoke
  Scenario: Successful login with valid credentials
    When I enter username "standard_user" and password "secret_sauce"
    And I click the Login button
    Then I should be redirected to the inventory page
    And I should see the page title "Swag Labs"

  @negative
  Scenario: Failed login with invalid credentials shows error message
    When I enter username "invalid_user" and password "wrong_password"
    And I click the Login button
    Then I should see an error message "Epic sadface: Username and password do not match any user in this service"

  @negative
  Scenario: Login with locked out user shows locked out error
    When I enter username "locked_out_user" and password "secret_sauce"
    And I click the Login button
    Then I should see an error message "Epic sadface: Sorry, this user has been locked out"

  @negative
  Scenario: Login with empty credentials shows error
    When I enter username "" and password ""
    And I click the Login button
    Then I should see an error message "Epic sadface: Username is required"

  @negative
  Scenario: Login with wrong password shows error - intentional failure demo
    When I enter username "standard_user" and password "wrong_password"
    And I click the Login button
    Then I should see an error message "Login successful"
