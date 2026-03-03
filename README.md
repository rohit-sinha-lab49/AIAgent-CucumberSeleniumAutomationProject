<div align="center">

# 🧪 Selenium + Cucumber BDD Framework

### End-to-End Test Automation for [saucedemo.com](https://www.saucedemo.com/)

[![Java](https://img.shields.io/badge/Java-21-orange?logo=openjdk)](https://openjdk.org/)
[![Selenium](https://img.shields.io/badge/Selenium-4.27-green?logo=selenium)](https://www.selenium.dev/)
[![Cucumber](https://img.shields.io/badge/Cucumber-7.20-brightgreen?logo=cucumber)](https://cucumber.io/)
[![Maven](https://img.shields.io/badge/Maven-3.9-red?logo=apachemaven)](https://maven.apache.org/)
[![Allure](https://img.shields.io/badge/Allure-Report-orange)](https://allurereport.org/)
[![License: ISC](https://img.shields.io/badge/License-ISC-yellow.svg)](https://opensource.org/licenses/ISC)

</div>

---

## 📖 Overview

A **production-ready BDD automation framework** that automates the complete purchase journey on [saucedemo.com](https://www.saucedemo.com/) — from login to order confirmation — using **Cucumber (Gherkin)**, **Selenium WebDriver**, **Java 21**, and **Maven**.

### ✨ Key Features

| Feature | Description |
|---------|-------------|
| 🥒 **BDD with Gherkin** | Plain English test scenarios anyone can read |
| 🌐 **Selenium WebDriver** | Reliable cross-browser automation |
| ☕ **Java 21** | Modern Java with clean OOP design |
| 📄 **Page Object Model** | Clean, maintainable selector management |
| 📊 **Allure Reports** | Beautiful interactive HTML reports with screenshots |
| 📸 **Auto Screenshots** | Captured on failure + at order confirmation |
| 🏷️ **Tag-based Execution** | Run specific tests with `@smoke`, `@e2e`, `@ignore` |
| 🔒 **ThreadLocal Driver** | Thread-safe WebDriver for parallel execution |
| ⚙️ **Central Config** | All settings in one `ConfigManager.java` |

---

## 🏗️ Architecture

```
┌─────────────────────────────────────────────────────────────┐
│                   Feature File (.feature)                    │
│           Plain English BDD scenarios (Gherkin)             │
└────────────────────────┬────────────────────────────────────┘
                         │  maps to
┌────────────────────────▼────────────────────────────────────┐
│                  Step Definitions (.java)                    │
│           Given / When / Then implementations               │
└────────────────────────┬────────────────────────────────────┘
                         │  uses
┌────────────────────────▼────────────────────────────────────┐
│               Page Object Model (.java)                      │
│      Encapsulates selectors + actions per page              │
└────────────────────────┬────────────────────────────────────┘
                         │  drives
┌────────────────────────▼────────────────────────────────────┐
│              Selenium WebDriver (ChromeDriver)               │
│         Auto-managed by WebDriverManager                    │
└─────────────────────────────────────────────────────────────┘
```

---

## 📁 Project Structure

```
selenium-cucumber-java/
│
├── 📂 src/test/
│   ├── 📂 java/com/saucedemo/
│   │   ├── 📂 config/
│   │   │   └── ConfigManager.java       # ⚙️ Central config (URL, timeouts, credentials)
│   │   │
│   │   ├── 📂 hooks/
│   │   │   ├── DriverManager.java       # ThreadLocal WebDriver lifecycle
│   │   │   └── Hooks.java               # Before/After Cucumber hooks
│   │   │
│   │   ├── 📂 pages/
│   │   │   ├── BasePage.java            # Common WebDriver utilities
│   │   │   ├── LoginPage.java           # Login page actions & assertions
│   │   │   ├── InventoryPage.java       # Product listing page
│   │   │   ├── CartPage.java            # Shopping cart page
│   │   │   └── CheckoutPage.java        # Checkout flow + screenshot
│   │   │
│   │   ├── 📂 steps/
│   │   │   ├── LoginSteps.java          # Login Given/When/Then
│   │   │   └── CheckoutSteps.java       # Checkout Given/When/Then
│   │   │
│   │   └── 📂 runner/
│   │       └── TestRunner.java          # JUnit 5 Suite entry point
│   │
│   └── 📂 resources/
│       ├── 📂 features/
│       │   ├── login.feature            # Login BDD scenarios
│       │   └── checkout.feature         # E2E purchase journey
│       ├── allure.properties            # Allure results directory config
│       └── junit-platform.properties   # Cucumber engine configuration
│
├── 📂 .vscode/
│   ├── settings.json                    # Cucumber step navigation config
│   └── extensions.json                  # Recommended VS Code extensions
│
├── pom.xml                              # Maven dependencies & plugins
└── README.md
```

---

## 🚀 Getting Started

### Prerequisites

- **Java 21** → [Download](https://adoptium.net/)
- **Maven 3.9+** → [Download](https://maven.apache.org/download.cgi)
- **Google Chrome** (latest)
- **VS Code** → [Download](https://code.visualstudio.com/) *(optional)*

### 1️⃣ Clone the Repository

```bash
git clone https://github.com/rohit-sinha-lab49/AIAgent-CucumberSeleniumAutomationProject.git
cd AIAgent-CucumberSeleniumAutomationProject
```

### 2️⃣ Install Dependencies

```bash
mvn clean install -DskipTests
```

> ChromeDriver is **auto-downloaded** by WebDriverManager — no manual setup needed!

---

## ▶️ Running Tests

### Run all non-ignored tests

```bash
mvn test
```

### Run only E2E tests

```bash
mvn test -Dcucumber.filter.tags="@e2e"
```

### Run only smoke tests

```bash
mvn test -Dcucumber.filter.tags="@smoke"
```

### Run a specific feature

```bash
mvn test -Dcucumber.features="src/test/resources/features/checkout.feature"
```

---

## 📊 Allure Report

### Generate & Open Report

```bash
# Step 1: Run tests (use -Dmaven.test.failure.ignore=true so report generates even on failures)
mvn clean test -Dmaven.test.failure.ignore=true

# Step 2: Generate HTML report
mvn allure:report

# Step 3: Open in browser
.allure/allure-2.29.0/bin/allure open target/site/allure-maven-plugin
```

### Or run everything in one command using Make:

```bash
make all
```

> ⚠️ **Important:** Always use `-Dmaven.test.failure.ignore=true` when running tests so that Maven does **not** stop on test failures — this ensures `mvn allure:report` can always run and include failure screenshots in the report.

### What's in the Report?

- ✅ **Pass/Fail** status per scenario and step
- 📸 **Screenshots** — auto-attached on failure + at order confirmation
- ⏱️ **Execution time** per step and scenario
- 📋 **Full Gherkin steps** breakdown
- 🏷️ **Feature/tag grouping**
- 📈 **History trends** across runs

---

## 🧪 Test Scenarios

### 🔐 Login Feature (`login.feature`)

| Tag | Scenario | Expected Result |
|-----|----------|----------------|
| `@smoke` | Valid login (`standard_user` / `secret_sauce`) | ✅ Redirected to inventory |
| `@ignore` | Invalid credentials | ❌ Error message shown |
| `@ignore` | Locked out user | 🔒 Locked out error shown |

### 🛒 E2E Checkout Feature (`checkout.feature`)

| Tag | Scenario | Steps |
|-----|----------|-------|
| `@e2e` | Full purchase journey | Login → Add to Cart → Checkout → Place Order → Confirm |

#### E2E Journey Steps:

```gherkin
Given I open the Saucedemo login page
When  I enter username "standard_user" and password "secret_sauce"
And   I click the Login button
Then  I should be redirected to the inventory page

When  I add "Sauce Labs Backpack" to the cart
Then  the cart badge should show "1"

When  I go to the cart
Then  I should see "Sauce Labs Backpack" in the cart

When  I click Checkout
And   I fill in checkout details with first name "John", last name "Doe" and postal code "10001"
And   I click Continue

Then  I should see the order summary with "Sauce Labs Backpack"
And   the item total should be visible

When  I click Finish
Then  I should see the order confirmation message "Thank you for your order!"
And   I take a screenshot of the order confirmation  ← 📸 attached to Allure report
```

---

## 🏷️ Tag Reference

| Tag | Purpose |
|-----|---------|
| `@smoke` | Quick sanity checks |
| `@e2e` | Full end-to-end journeys |
| `@ignore` | Skip this scenario |

---

## ⚙️ Configuration

### `ConfigManager.java` — Central Config

All framework settings live in **one place**. Edit this file to change browser behaviour, app URL, or timeouts.

```java
public class ConfigManager {
    // Application
    public static final String BASE_URL        = "https://www.saucedemo.com";

    // Browser
    public static final boolean HEADLESS       = false;
    public static final int     WINDOW_WIDTH   = 1280;
    public static final int     WINDOW_HEIGHT  = 720;

    // Timeouts (seconds)
    public static final int IMPLICIT_WAIT      = 10;
    public static final int EXPLICIT_WAIT      = 15;
    public static final int PAGE_LOAD_TIMEOUT  = 30;
}
```

| Setting | Property | Default |
|---------|----------|---------|
| Run headless | `HEADLESS` | `false` |
| App URL | `BASE_URL` | `https://www.saucedemo.com` |
| Implicit wait | `IMPLICIT_WAIT` | `10s` |
| Explicit wait | `EXPLICIT_WAIT` | `15s` |
| Page load timeout | `PAGE_LOAD_TIMEOUT` | `30s` |

---

## 📄 Page Object Reference

### `BasePage.java`
| Method | Description |
|--------|-------------|
| `waitForVisible(By)` | Wait until element is visible |
| `waitForClickable(By)` | Wait until element is clickable |
| `click(By)` | Click an element |
| `type(By, String)` | Clear and type text |
| `getText(By)` | Get element text |
| `isDisplayed(By)` | Check if element is visible |

### `LoginPage.java`
| Method | Description |
|--------|-------------|
| `navigate()` | Go to saucedemo.com |
| `enterUsername(String)` | Fill username field |
| `enterPassword(String)` | Fill password field |
| `clickLogin()` | Click Login button |
| `assertOnInventoryPage()` | Verify URL is `/inventory.html` |
| `assertErrorMessage(String)` | Verify error text |

### `InventoryPage.java`
| Method | Description |
|--------|-------------|
| `addItemToCart(String)` | Click Add to Cart for item |
| `goToCart()` | Click cart icon |
| `assertCartBadge(String)` | Verify cart item count |

### `CartPage.java`
| Method | Description |
|--------|-------------|
| `assertItemInCart(String)` | Verify item is in cart |
| `clickCheckout()` | Click Checkout button |

### `CheckoutPage.java`
| Method | Description |
|--------|-------------|
| `fillCheckoutDetails(fn, ln, zip)` | Fill checkout form |
| `clickContinue()` | Proceed to order summary |
| `assertOrderSummaryContains(String)` | Verify item in summary |
| `assertItemTotalVisible()` | Verify price is shown |
| `clickFinish()` | Place the order |
| `assertOrderConfirmation(String)` | Verify success message |
| `takeScreenshotAndAttach(String)` | Capture & attach to Allure |

---

## 🪝 Hooks Lifecycle

```
Before each Scenario ──► DriverManager.initDriver()
                         │  - Launch Chrome
                         │  - Set implicit wait, page load timeout
                         │  - Maximize window
                         │
        [Scenario runs]
                         │
After each Scenario  ──► if FAILED → take screenshot → attach to Allure
                         DriverManager.quitDriver()
                         │  - Close browser
                         │  - Remove ThreadLocal
```

> **ThreadLocal** ensures each scenario gets its own isolated WebDriver instance — safe for parallel execution.

---

## 🔧 VS Code Setup

For **Ctrl+Click navigation** from Gherkin steps to Java step definitions:

1. Open VS Code Extensions (`Cmd+Shift+X`)
2. Search: **Cucumber** by `Cucumber`
3. Install `cucumberopen.cucumber-official`

The `.vscode/settings.json` is already configured:

```json
{
  "cucumber.features": ["src/test/resources/features/**/*.feature"],
  "cucumber.glue": ["src/test/java/com/saucedemo/steps/**/*.java"]
}
```

---

## 👥 Available Test Users

| Username | Password | Type |
|----------|----------|------|
| `standard_user` | `secret_sauce` | ✅ Normal user |
| `locked_out_user` | `secret_sauce` | 🔒 Blocked |
| `problem_user` | `secret_sauce` | 🐛 Has UI bugs |
| `performance_glitch_user` | `secret_sauce` | 🐢 Slow login |
| `error_user` | `secret_sauce` | ❌ Has errors |
| `visual_user` | `secret_sauce` | 👁️ Visual bugs |

---

## 📦 Maven Commands Reference

| Command | Description |
|---------|-------------|
| `mvn test` | Run all non-ignored tests |
| `mvn test -Dcucumber.filter.tags="@smoke"` | Run smoke tests only |
| `mvn test -Dcucumber.filter.tags="@e2e"` | Run E2E tests only |
| `mvn allure:report` | Generate Allure HTML report |
| `mvn clean test allure:report` | Clean + run + report |
| `mvn test -DskipTests` | Skip tests (compile only) |

---

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch: `git checkout -b feature/my-new-test`
3. Write your feature file in `src/test/resources/features/`
4. Add page objects in `src/test/java/com/saucedemo/pages/`
5. Add step definitions in `src/test/java/com/saucedemo/steps/`
6. Run tests: `mvn test`
7. Push and create a Pull Request

---

<div align="center">

Made with ❤️ using Selenium + Cucumber + Java + Maven

</div>
