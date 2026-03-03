package com.saucedemo.steps;

import com.saucedemo.pages.CartPage;
import com.saucedemo.pages.CheckoutPage;
import com.saucedemo.pages.InventoryPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

/**
 * Checkout Step Definitions — End-to-End purchase journey on saucedemo.com
 */
public class CheckoutSteps {

    private final InventoryPage inventoryPage = new InventoryPage();
    private final CartPage      cartPage      = new CartPage();
    private final CheckoutPage  checkoutPage  = new CheckoutPage();

    // ── Inventory ─────────────────────────────────────────────────────────────

    @When("I add {string} to the cart")
    public void iAddItemToCart(String itemName) {
        inventoryPage.addItemToCart(itemName);
    }

    @Then("the cart badge should show {string}")
    public void cartBadgeShouldShow(String count) {
        inventoryPage.assertCartBadge(count);
    }

    @When("I go to the cart")
    public void iGoToTheCart() {
        inventoryPage.goToCart();
    }

    // ── Cart ──────────────────────────────────────────────────────────────────

    @Then("I should see {string} in the cart")
    public void iShouldSeeItemInCart(String itemName) {
        cartPage.assertItemInCart(itemName);
    }

    @When("I click Checkout")
    public void iClickCheckout() {
        cartPage.clickCheckout();
    }

    // ── Checkout Step 1 ───────────────────────────────────────────────────────

    @And("I fill in checkout details with first name {string}, last name {string} and postal code {string}")
    public void iFillInCheckoutDetails(String firstName, String lastName, String postalCode) {
        checkoutPage.fillCheckoutDetails(firstName, lastName, postalCode);
    }

    @And("I click Continue")
    public void iClickContinue() {
        checkoutPage.clickContinue();
    }

    // ── Checkout Step 2 (Order Summary) ──────────────────────────────────────

    @Then("I should see the order summary with {string}")
    public void iShouldSeeOrderSummaryWith(String itemName) {
        checkoutPage.assertOrderSummaryContains(itemName);
    }

    @And("the item total should be visible")
    public void theItemTotalShouldBeVisible() {
        checkoutPage.assertItemTotalVisible();
    }

    @When("I click Finish")
    public void iClickFinish() {
        checkoutPage.clickFinish();
    }

    // ── Order Confirmation ────────────────────────────────────────────────────

    @Then("I should see the order confirmation message {string}")
    public void iShouldSeeOrderConfirmation(String message) {
        checkoutPage.assertOrderConfirmation(message);
    }

    @And("I take a screenshot of the order confirmation")
    public void iTakeScreenshotOfOrderConfirmation() {
        checkoutPage.takeScreenshotAndAttach("Order Confirmation Screenshot");
    }
}
