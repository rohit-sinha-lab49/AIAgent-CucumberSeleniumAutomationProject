package com.saucedemo.steps;

import com.saucedemo.pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

/**
 * Login Step Definitions for saucedemo.com
 */
public class LoginSteps {

    private final LoginPage loginPage = new LoginPage();

    @Given("I open the Saucedemo login page")
    public void iOpenTheSaucedemoLoginPage() {
        loginPage.navigate();
    }

    @When("I enter username {string} and password {string}")
    public void iEnterUsernameAndPassword(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }

    @When("I click the Login button")
    public void iClickTheLoginButton() {
        loginPage.clickLogin();
    }

    @Then("I should be redirected to the inventory page")
    public void iShouldBeRedirectedToTheInventoryPage() {
        loginPage.assertOnInventoryPage();
    }

    @And("I should see the page title {string}")
    public void iShouldSeeThePageTitle(String title) {
        loginPage.assertPageTitle(title);
    }

    @Then("I should see an error message {string}")
    public void iShouldSeeAnErrorMessage(String message) {
        loginPage.assertErrorMessage(message);
    }
}
