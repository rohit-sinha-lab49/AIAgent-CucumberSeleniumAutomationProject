package com.saucedemo.pages;

import org.openqa.selenium.By;

/**
 * InventoryPage — Page Object for the products listing page.
 * URL: /inventory.html
 */
public class InventoryPage extends BasePage {

    // ── Locators ───────────────────────────────────────────────────────────────
    private final By cartBadge = By.cssSelector(".shopping_cart_badge");
    private final By cartLink  = By.cssSelector(".shopping_cart_link");

    private By addToCartButton(String itemName) {
        // "Sauce Labs Backpack" → "sauce-labs-backpack"
        String id = itemName.toLowerCase().replace(" ", "-");
        return By.cssSelector("[data-test='add-to-cart-" + id + "']");
    }

    // ── Actions ────────────────────────────────────────────────────────────────

    public void addItemToCart(String itemName) {
        click(addToCartButton(itemName));
    }

    public void goToCart() {
        click(cartLink);
    }

    // ── Assertions ─────────────────────────────────────────────────────────────

    public void assertCartBadge(String expectedCount) {
        String actual = getText(cartBadge);
        assert actual.equals(expectedCount)
                : "Expected cart badge '" + expectedCount + "' but got '" + actual + "'";
    }
}
