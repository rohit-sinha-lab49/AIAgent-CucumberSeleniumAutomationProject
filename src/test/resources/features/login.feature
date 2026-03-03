Feature: Saucedemo Login

  Background:
    Given I open the Saucedemo login page

  @smoke
  Scenario: Successful login with valid credentials
    When I enter username "standard_user" and password "secret_sauce"
    And I click the Login button
    Then I should be redirected to the inventory page
    And I should see the page title "Swag Labs"

  @ignore
  Scenario: Failed login with invalid credentials
    When I enter username "invalid_user" and password "wrong_password"
    And I click the Login button
    Then I should see an error message "Username and password do not match"

  @ignore
  Scenario: Login with locked out user
    When I enter username "locked_out_user" and password "secret_sauce"
    And I click the Login button
    Then I should see an error message "Sorry, this user has been locked out"
