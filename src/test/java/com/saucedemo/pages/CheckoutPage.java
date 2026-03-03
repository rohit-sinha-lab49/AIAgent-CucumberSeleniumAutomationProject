package com.saucedemo.pages;

import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.ByteArrayInputStream;

/**
 * CheckoutPage — Page Object for checkout step one, step two, and confirmation.
 * URLs: /checkout-step-one.html → /checkout-step-two.html → /checkout-complete.html
 */
public class CheckoutPage extends BasePage {

    // ── Locators ───────────────────────────────────────────────────────────────
    private final By firstNameInput    = By.cssSelector("[data-test='firstName']");
    private final By lastNameInput     = By.cssSelector("[data-test='lastName']");
    private final By postalCodeInput   = By.cssSelector("[data-test='postalCode']");
    private final By continueButton    = By.id("continue");
    private final By finishButton      = By.cssSelector("[data-test='finish']");
    private final By summaryItemName   = By.cssSelector(".cart_item .inventory_item_name, .inventory_item_name");
    private final By itemTotal         = By.cssSelector(".summary_subtotal_label, .summary_info_label");
    private final By confirmationTitle = By.cssSelector(".complete-header");

    // ── Actions ────────────────────────────────────────────────────────────────

    public void fillCheckoutDetails(String firstName, String lastName, String postalCode) {
        type(firstNameInput, firstName);
        type(lastNameInput, lastName);
        type(postalCodeInput, postalCode);
    }

    public void clickContinue() {
        click(continueButton);
        // Wait for finish button to appear (confirms step 2 loaded)
        wait.until(ExpectedConditions.visibilityOfElementLocated(finishButton));
    }

    public void clickFinish() {
        click(finishButton);
        // Wait for confirmation header to appear
        wait.until(ExpectedConditions.visibilityOfElementLocated(confirmationTitle));
    }

    public void takeScreenshotAndAttach(String name) {
        byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        Allure.addAttachment(name, new ByteArrayInputStream(screenshot));
    }

    // ── Assertions ─────────────────────────────────────────────────────────────

    public void assertOrderSummaryContains(String itemName) {
        String actual = getText(summaryItemName);
        assert actual.contains(itemName)
                : "Expected item '" + itemName + "' in summary but got '" + actual + "'";
    }

    public void assertItemTotalVisible() {
        assert isDisplayed(itemTotal) : "Item total is not visible";
    }

    public void assertOrderConfirmation(String message) {
        String actual = getText(confirmationTitle);
        assert actual.contains(message)
                : "Expected confirmation '" + message + "' but got '" + actual + "'";
    }
}
