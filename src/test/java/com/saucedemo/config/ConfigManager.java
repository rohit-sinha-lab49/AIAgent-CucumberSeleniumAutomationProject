package com.saucedemo.config;

/**
 * Central configuration for the Selenium framework.
 * All settings in one place — no hardcoded values in tests.
 */
public class ConfigManager {

    // ── Application ────────────────────────────────────────────────────────────
    public static final String BASE_URL       = "https://www.saucedemo.com";

    // ── Browser ────────────────────────────────────────────────────────────────
    public static final boolean HEADLESS      = false;
    public static final int     WINDOW_WIDTH  = 1280;
    public static final int     WINDOW_HEIGHT = 720;

    // ── Timeouts (seconds) ─────────────────────────────────────────────────────
    public static final int IMPLICIT_WAIT     = 10;
    public static final int EXPLICIT_WAIT     = 15;
    public static final int PAGE_LOAD_TIMEOUT = 30;

    // ── Test Data ──────────────────────────────────────────────────────────────
    public static final String VALID_USERNAME    = "standard_user";
    public static final String VALID_PASSWORD    = "secret_sauce";
    public static final String LOCKED_USERNAME   = "locked_out_user";
    public static final String INVALID_USERNAME  = "invalid_user";
    public static final String INVALID_PASSWORD  = "wrong_password";

    private ConfigManager() {}
}
