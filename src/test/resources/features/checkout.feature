Feature: End-to-End Purchase Journey on Saucedemo

  @e2e
  Scenario: User logs in, adds item to cart, checks out and places order
    Given I open the Saucedemo login page
    When I enter username "standard_user" and password "secret_sauce"
    And I click the Login button
    Then I should be redirected to the inventory page

    When I add "Sauce Labs Backpack" to the cart
    Then the cart badge should show "1"

    When I go to the cart
    Then I should see "Sauce Labs Backpack" in the cart

    When I click Checkout
    And I fill in checkout details with first name "John", last name "Doe" and postal code "10001"
    And I click Continue

    Then I should see the order summary with "Sauce Labs Backpack"
    And the item total should be visible

    When I click Finish
    Then I should see the order confirmation message "Thank you for your order!"
    And I take a screenshot of the order confirmation
