package com.Actions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;

import com.Pages.LoginPage;
import com.StepDefinitions.Hooks;
import com.Utilities.ConfigureClass;
import com.Utilities.HelperClass;

public class LoginAction extends BaseAction {

    LoginPage loginPage = new LoginPage();

    // ── Send username ─────────────────────────────────────────────────────────
    public void sendUserName(String name) {
        sendKeys(loginPage.userName, name);
    }

    // ── Send password ─────────────────────────────────────────────────────────
    public void sendPassword(String password) {
        sendKeys(loginPage.password, password);
    }

    // ── Click login link ──────────────────────────────────────────────────────
    public void clickLoginLink() {
        click(loginPage.loginLink);
    }

    // ── Enter valid credentials from Configure.properties ────────────────────
    public void entervaliduserNameAndPassword() {
        sendUserName(ConfigureClass.getUsername());
        sendPassword(ConfigureClass.getPassword());
    }

    // ── Wait for dashboard after login ────────────────────────────────────────
    /**
     * Uses a FluentWait (polls every 2 s, ignores all exceptions) so that
     * Angular's async rendering does not race against a one-shot explicit wait.
     * Timeout comes from Configure.properties → loginWaitTimeout (default 60 s).
     */
    public void waitForDashboardToLoad() {

        int loginTimeout = ConfigureClass.getLoginWaitTimeout();

        try {
            // 1. Wait for JS document.readyState == "complete"
            waitForPageLoad();

            // 2. FluentWait: URL must leave the login page
            FluentWait<WebDriver> fluentWait = new FluentWait<>(HelperClass.getDriver())
                    .withTimeout(Duration.ofSeconds(loginTimeout))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(Exception.class);

            fluentWait.until(driver ->
                    !driver.getCurrentUrl().toLowerCase().contains("login"));

            // 3. Wait for the Banking nav-link, Quick Access, or logout trigger (proof the dashboard rendered)
            waitForVisibility(By.xpath("//div[contains(text(),'Quick access')]"));

            HelperClass.log.info("Login successful. URL: {}",
                    HelperClass.getDriver().getCurrentUrl());

        } catch (Exception e) {

            String currentUrl = "unknown";
            try {
                currentUrl = HelperClass.getDriver().getCurrentUrl();
            } catch (Exception ignored) { /* driver may be dead */ }

            HelperClass.log.error(
                    "Home page not loaded. Current URL: [{}] | Cause: {}",
                    currentUrl, e.getMessage());

            throw new RuntimeException("Login Failed");
        }
    }

    // ── Click Submit + wait for dashboard (with configurable retry) ───────────
    /**
     * Clicks Submit, then waits for dashboard.
     * Retries up to loginRetryCount times (from Configure.properties) before failing.
     * Between retries the page is refreshed so we start from a clean state.
     */
    public void clickSubmitButton() {

        int maxRetries = ConfigureClass.getLoginRetryCount();
        Exception lastException = null;

        for (int attempt = 1; attempt <= maxRetries; attempt++) {

            try {
                HelperClass.log.info("Login attempt [{}/{}] on thread [{}]",
                        attempt, maxRetries, Thread.currentThread().getName());

                click(loginPage.loginButton);
                waitForDashboardToLoad();
                return; // success — exit

            } catch (Exception e) {

                lastException = e;
                HelperClass.log.warn(
                        "Login attempt {}/{} failed: {}",
                        attempt, maxRetries, e.getMessage());

                if (attempt < maxRetries) {
                    // Navigate back so credentials can be re-entered
                    try {
                        HelperClass.getDriver().navigate().to(ConfigureClass.getUrl());
                        waitForPageLoad();
                        // Re-enter credentials for next attempt
                        click(loginPage.loginLink);
                        sendUserName(ConfigureClass.getUsername());
                        sendPassword(ConfigureClass.getPassword());
                    } catch (Exception navEx) {
                        HelperClass.log.error("Navigation to login page failed: {}",
                                navEx.getMessage());
                    }
                }
            }
        }

        // All attempts exhausted
        Hooks.logger.error("Unable to login after {} attempts", maxRetries, lastException);
        throw new RuntimeException("Login Failed");
    }

    // ── Invalid login helper ──────────────────────────────────────────────────
    public void enterinvalidUsernameandPassword(String name, String password) {
        sendUserName(name);
        sendPassword(password);
    }

    // ── Assertions ────────────────────────────────────────────────────────────
    public void assertAlertMessage(String expected) {
        String actual = getText(loginPage.alertMessage);
        Assert.assertEquals(actual, expected);
    }

    public void assertRequiredMessage(By locator, String expected) {
        String actual = getText(locator);
        Assert.assertEquals(actual, expected);
    }

    public void assertUsernameRequired(String expected) {
        assertRequiredMessage(loginPage.userRequiredMessage, expected);
    }

    public void assertPasswordRequired(String expected) {
        assertRequiredMessage(loginPage.passwordRequiredMessage, expected);
    }

    public void enterBlankUserName(String username, String password) {
        sendUserName(username);
        sendPassword(password);
    }

    public void enterBlankPassword(String username, String password) {
        sendUserName(username);
        sendPassword(password);
    }

    public void assertBothRequiredMessage(String expected) {
        assertUsernameRequired(expected);
        assertPasswordRequired(expected);
    }

    public void enterBlankInputs(String username, String password) {
        sendUserName(username);
        sendPassword(password);
    }

    // ── Logout validation ─────────────────────────────────────────────────────
    public void checkLogout() {
        boolean actual = isDisplayed(loginPage.loginLink);
        Assert.assertTrue(actual);
    }
}