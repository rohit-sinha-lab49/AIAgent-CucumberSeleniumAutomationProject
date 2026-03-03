package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * CartPage — Page Object for the shopping cart page.
 * URL: /cart.html
 */
public class CartPage extends BasePage {

    // ── Locators ───────────────────────────────────────────────────────────────
    private final By cartItemName   = By.cssSelector(".inventory_item_name");
    private final By checkoutButton = By.cssSelector("[data-test='checkout']");
    private final By firstNameInput = By.cssSelector("[data-test='firstName']");

    // ── Actions ────────────────────────────────────────────────────────────────

    public void clickCheckout() {
        click(checkoutButton);
        // Wait for checkout step 1 form to appear
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameInput));
    }

    // ── Assertions ─────────────────────────────────────────────────────────────

    public void assertItemInCart(String itemName) {
        String actual = getText(cartItemName);
        assert actual.contains(itemName)
                : "Expected item '" + itemName + "' in cart but got '" + actual + "'";
    }
}
