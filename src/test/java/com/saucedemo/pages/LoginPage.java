package com.saucedemo.pages;

import com.saucedemo.config.ConfigManager;
import org.openqa.selenium.By;

/**
 * LoginPage — Page Object for https://www.saucedemo.com/
 */
public class LoginPage extends BasePage {

    // ── Locators ───────────────────────────────────────────────────────────────
    private final By usernameInput = By.id("user-name");
    private final By passwordInput = By.id("password");
    private final By loginButton   = By.id("login-button");
    private final By errorMessage  = By.cssSelector("[data-test='error']");
    private final By pageTitle     = By.cssSelector(".app_logo");

    // ── Actions ────────────────────────────────────────────────────────────────

    public void navigate() {
        driver.get(ConfigManager.BASE_URL);
    }

    public void enterUsername(String username) {
        type(usernameInput, username);
    }

    public void enterPassword(String password) {
        type(passwordInput, password);
    }

    public void clickLogin() {
        click(loginButton);
    }

    // ── Assertions ─────────────────────────────────────────────────────────────

    public void assertOnInventoryPage() {
        wait.until(d -> d.getCurrentUrl().contains("inventory.html"));
    }

    public void assertPageTitle(String expectedTitle) {
        String actual = getText(pageTitle);
        assert actual.equals(expectedTitle)
                : "Expected title '" + expectedTitle + "' but got '" + actual + "'";
    }

    public void assertErrorMessage(String expectedMessage) {
        String actual = getText(errorMessage);
        if (!actual.contains(expectedMessage)) {
            throw new AssertionError(
                    "Expected error message to contain:\n  '" + expectedMessage + "'\nBut got:\n  '" + actual + "'");
        }
    }
}
