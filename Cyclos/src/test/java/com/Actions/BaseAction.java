package com.Actions;

import java.io.File;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Utilities.ConfigureClass;
import com.Utilities.HelperClass;

public class BaseAction {

    private static final int MAX_RETRIES = 3;

    // ═══════════════════════════════════════════════════════════════════
    //  PAGE LOAD / AJAX
    // ═══════════════════════════════════════════════════════════════════

    public void waitForPageLoad() {
        try {
            WebDriverWait w = new WebDriverWait(HelperClass.getDriver(),
                    Duration.ofSeconds(ConfigureClass.getPageLoadTimeout()));
            w.until(d -> ((JavascriptExecutor) d)
                    .executeScript("return document.readyState").equals("complete"));
        } catch (Exception e) {
            HelperClass.log.warn("waitForPageLoad timed out after {}s",
                    ConfigureClass.getPageLoadTimeout());
        }
    }

    public void waitForAjaxComplete() {
        try {
            WebDriverWait w = new WebDriverWait(HelperClass.getDriver(),
                    Duration.ofSeconds(ConfigureClass.getExplicitWait()));
            w.until(d -> {
                Boolean jQuery = (Boolean) ((JavascriptExecutor) d)
                        .executeScript("return !!(window.jQuery && window.jQuery.active === 0)");
                Boolean angular = (Boolean) ((JavascriptExecutor) d)
                        .executeScript(
                                "return !!(window.angular && window.angular.element(document).injector()"
                                + " && window.angular.element(document).injector().get('$http').pendingRequests.length === 0)");
                Boolean docReady = ((JavascriptExecutor) d)
                        .executeScript("return document.readyState").equals("complete");
                return jQuery && angular && docReady;
            });
        } catch (Exception e) {
            HelperClass.log.warn("waitForAjaxComplete timed out, continuing anyway");
        }
    }

    // ═══════════════════════════════════════════════════════════════════
    //  WAIT CONDITIONS  (use HelperClass.getWait() – thread-local)
    // ═══════════════════════════════════════════════════════════════════

    public WebElement waitForVisibility(By locator) {
        return HelperClass.getWait().until(
                ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public WebElement waitForClickable(By locator) {
        return HelperClass.getWait().until(
                ExpectedConditions.elementToBeClickable(locator));
    }

    public void waitForInvisibility(By locator) {
        try {
            HelperClass.getWait().until(
                    ExpectedConditions.invisibilityOfElementLocated(locator));
        } catch (Exception e) {
            // non-critical
        }
    }

    public void waitForElementToBeStale(By locator) {
        try {
            WebElement el = HelperClass.getDriver().findElement(locator);
            HelperClass.getWait().until(
                    ExpectedConditions.stalenessOf(el));
        } catch (Exception e) {
            // already stale or not found
        }
    }

    public void waitForTextToBePresent(By locator, String text) {
        HelperClass.getWait().until(
                ExpectedConditions.textToBePresentInElementLocated(locator, text));
    }

    public void waitForAttributeToContain(By locator, String attr, String value) {
        HelperClass.getWait().until(
                ExpectedConditions.attributeContains(locator, attr, value));
    }

    public void waitForNumberOfElementsToBeMoreThan(By locator, int count) {
        HelperClass.getWait().until(
                d -> d.findElements(locator).size() > count);
    }

    

    // ═══════════════════════════════════════════════════════════════════
    //  SMART WAIT — loader + table state detection
    // ═══════════════════════════════════════════════════════════════════
   
    public void waitForLoaderToDisappear(By loaderLocator) {
        try {
            HelperClass.getWait()
                    .withTimeout(Duration.ofSeconds(ConfigureClass.getExplicitWait()))
                    .until(ExpectedConditions.invisibilityOfElementLocated(loaderLocator));
        } catch (Exception e) {
            // loader already gone or never appeared
        }
    }

    public void waitForTableDataToLoad(By noResultsLocator, By tableRowLocator, By... otherIndicators) {
        By[] allLocators = Arrays.copyOf(otherIndicators, otherIndicators.length + 2);
        allLocators[otherIndicators.length] = noResultsLocator;
        allLocators[otherIndicators.length + 1] = tableRowLocator;

        try {
            WebDriverWait w = new WebDriverWait(HelperClass.getDriver(),
                    Duration.ofSeconds(ConfigureClass.getExplicitWait()));
            w.until(d -> {
                for (By loc : allLocators) {
                    try {
                        WebElement el = d.findElement(loc);
                        if (el.isDisplayed()) return true;
                    } catch (Exception ignored) { }
                }
                return false;
            });
        } catch (Exception e) {
            HelperClass.log.warn("waitForTableDataToLoad timed out after {}s",
                    ConfigureClass.getExplicitWait());
        }
    }

    // ═══════════════════════════════════════════════════════════════════
    //  CLICK – with stale-element retry
    // ═══════════════════════════════════════════════════════════════════

    public void click(By locator) {
        for (int i = 0; i < MAX_RETRIES; i++) {
            try {
                waitForPageLoad();
                WebElement el = waitForClickable(locator);
                scrollIntoView(el);
                el.click();
                waitForPageLoad();
                HelperClass.log.info("Clicked: {}", locator);
                return;
            } catch (StaleElementReferenceException e) {
                HelperClass.log.warn("StaleElement click retry {}/{}: {}", i + 1, MAX_RETRIES, locator);
                waitForPageLoad();
            } catch (Exception e) {
                HelperClass.log.error("Click failed: {} – {}", locator, e.getMessage());
                throw e;
            }
        }
        throw new RuntimeException("Click failed after " + MAX_RETRIES + " retries: " + locator);
    }

    public void jsClick(By locator) {
        for (int i = 0; i < MAX_RETRIES; i++) {
            try {
                waitForPageLoad();
                WebElement el = waitForClickable(locator);
                ((JavascriptExecutor) HelperClass.getDriver()).executeScript("arguments[0].click();", el);
                waitForPageLoad();
                HelperClass.log.info("JS Clicked: {}", locator);
                return;
            } catch (StaleElementReferenceException e) {
                HelperClass.log.warn("StaleElement jsClick retry {}/{}: {}", i + 1, MAX_RETRIES, locator);
                waitForPageLoad();
            } catch (Exception e) {
                HelperClass.log.error("JS Click failed: {} – {}", locator, e.getMessage());
                throw e;
            }
        }
        throw new RuntimeException("JS Click failed after " + MAX_RETRIES + " retries: " + locator);
    }

    // ═══════════════════════════════════════════════════════════════════
    //  SEND KEYS – with clear + stale-element retry
    // ═══════════════════════════════════════════════════════════════════

    public void sendKeys(By locator, String value) {
        if (value == null) return;
        for (int i = 0; i < MAX_RETRIES; i++) {
            try {
                WebElement el = waitForVisibility(locator);
                scrollIntoView(el);
                el.clear();
                el.sendKeys(value);
                HelperClass.log.info("Sent keys to: {}", locator);
                return;
            } catch (StaleElementReferenceException e) {
                HelperClass.log.warn("StaleElement sendKeys retry {}/{}: {}", i + 1, MAX_RETRIES, locator);
                waitForPageLoad();
            } catch (Exception e) {
                HelperClass.log.error("sendKeys failed: {} – {}", locator, e.getMessage());
                throw e;
            }
        }
        throw new RuntimeException("sendKeys failed after " + MAX_RETRIES + " retries: " + locator);
    }
    
    public void pressEnter(By locator) {
        waitForVisibility(locator).sendKeys(Keys.ENTER);
    }

    // ═══════════════════════════════════════════════════════════════════
    //  GET TEXT – with stale-element retry
    // ═══════════════════════════════════════════════════════════════════

    public String getText(By locator) {
        for (int i = 0; i < MAX_RETRIES; i++) {
            try {
                return waitForVisibility(locator).getText().trim();
            } catch (StaleElementReferenceException e) {
                HelperClass.log.warn("StaleElement getText retry {}/{}: {}", i + 1, MAX_RETRIES, locator);
                waitForPageLoad();
            } catch (Exception e) {
                HelperClass.log.error("getText failed: {} – {}", locator, e.getMessage());
                throw e;
            }
        }
        throw new RuntimeException("getText failed after " + MAX_RETRIES + " retries: " + locator);
    }

    // ═══════════════════════════════════════════════════════════════════
    //  STATE CHECKS – short timeout, no exception thrown
    // ═══════════════════════════════════════════════════════════════════

    public boolean isElementPresent(By locator) {
        return HelperClass.getDriver().findElements(locator).size() > 0;
    }

    public boolean isDisplayed(By locator) {
        try {
            WebDriverWait shortWait = new WebDriverWait(HelperClass.getDriver(),
                    Duration.ofSeconds(ConfigureClass.getExplicitWait()));
            return shortWait.until(ExpectedConditions.visibilityOfElementLocated(locator)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isDisplayed(By locator, int timeoutSeconds) {
        try {
            WebDriverWait shortWait = new WebDriverWait(HelperClass.getDriver(),
                    Duration.ofSeconds(timeoutSeconds));
            return shortWait.until(ExpectedConditions.visibilityOfElementLocated(locator)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isEnabled(By locator) {
        try {
            return waitForVisibility(locator).isEnabled();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isSelected(By locator) {
        try {
            return waitForVisibility(locator).isSelected();
        } catch (Exception e) {
            return false;
        }
    }

    // ═══════════════════════════════════════════════════════════════════
    //  SCROLL
    // ═══════════════════════════════════════════════════════════════════

    public void scrollIntoView(WebElement element) {
        try {
            ((JavascriptExecutor) HelperClass.getDriver())
                    .executeScript("arguments[0].scrollIntoView({block:'center'});", element);
        } catch (Exception ignored) { }
    }

    public void scrollIntoView(By locator) {
        try {
            WebElement el = HelperClass.getDriver().findElement(locator);
            scrollIntoView(el);
        } catch (Exception ignored) { }
    }

    // ═══════════════════════════════════════════════════════════════════
    //  HIGHLIGHT (debug aid)
    // ═══════════════════════════════════════════════════════════════════

    public void highlightElement(By locator) {
        try {
            WebElement el = HelperClass.getDriver().findElement(locator);
            JavascriptExecutor js = (JavascriptExecutor) HelperClass.getDriver();
            js.executeScript("arguments[0].style.border='3px solid red'", el);
        } catch (Exception ignored) { }
    }

    public void highlightElement(WebElement el) {
        try {
            ((JavascriptExecutor) HelperClass.getDriver())
                    .executeScript("arguments[0].style.border='3px solid red'", el);
        } catch (Exception ignored) { }
    }

    // ═══════════════════════════════════════════════════════════════════
    //  DOWNLOAD UTILITIES
    // ═══════════════════════════════════════════════════════════════════

    public void clearDownloadFolder(String downloadPath) {
        File folder = new File(downloadPath);
        if (!folder.exists()) {
            folder.mkdirs();
            return;
        }
        File[] files = folder.listFiles();
        if (files != null) {
            for (File f : files) {
                if (f.isFile()) f.delete();
            }
        }
    }

    public void waitForFileDownload(String downloadPath, String extension) {
        FluentWait<WebDriver> wait = new FluentWait<>(HelperClass.getDriver())
                .withTimeout(Duration.ofSeconds(60))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(Exception.class);

        wait.until(d -> {
            File folder = new File(downloadPath);
            File[] files = folder.listFiles();
            if (files != null) {
                for (File f : files) {
                    if (f.getName().endsWith(extension)
                            && !f.getName().contains(".crdownload")
                            && !f.getName().contains(".tmp")) {
                        return true;
                    }
                }
            }
            return false;
        });
    }
}
