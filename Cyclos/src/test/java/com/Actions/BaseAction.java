package com.Actions;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Utilities.HelperClass;

public class BaseAction {

    // CLICK
    public void click(By locator) {
        waitForClickable(locator);
        HelperClass.getDriver().findElement(locator).click();
    }

    // JS CLICK
    public void jsClick(By locator) {
        WebElement element = HelperClass.getWait().until(
                ExpectedConditions.elementToBeClickable(locator));   // ← was visibilityOf; clickable is safer

        JavascriptExecutor js = (JavascriptExecutor) HelperClass.getDriver();
        js.executeScript("arguments[0].click();", element);
    }

    // SEND KEYS
    public void sendKeys(By locator, String value) {
        waitForVisibility(locator);
        WebElement element = HelperClass.getDriver().findElement(locator);
        element.clear();
        element.sendKeys(value);
    }

    // GET TEXT
    public String getText(By locator) {
        waitForVisibility(locator);
        return HelperClass.getDriver().findElement(locator).getText();
    }

    // WAIT FOR VISIBILITY
    public void waitForVisibility(By locator) {
        HelperClass.getWait().until(
                ExpectedConditions.visibilityOfElementLocated(locator));
    }

    // WAIT FOR CLICKABLE
    public void waitForClickable(By locator) {
        HelperClass.getWait().until(
                ExpectedConditions.elementToBeClickable(locator));
    }

    // WAIT FOR ELEMENT TO DISAPPEAR (useful after clicking menus)
    public void waitForInvisibility(By locator) {
        HelperClass.getWait().until(
                ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    // SCROLL
    public void scrollIntoView(By locator) {
        WebElement element = HelperClass.getDriver().findElement(locator);
        JavascriptExecutor js = (JavascriptExecutor) HelperClass.getDriver();
        js.executeScript("arguments[0].scrollIntoView({block:'center'});", element);
    }

    // MOUSE HOVER
    public void mouseHover(By locator) {
        WebElement element = HelperClass.getDriver().findElement(locator);
        Actions actions = new Actions(HelperClass.getDriver());
        actions.moveToElement(element).perform();
    }

    // DISPLAYED
    public boolean isDisplayed(By locator) {
        try {
            return HelperClass.getDriver().findElement(locator).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    // FILE DOWNLOAD — FIXED: FluentWait now uses WebDriver, not a dummy WebElement
    public void waitForFileDownload(String downloadPath, String fileExtension) {

        FluentWait<WebDriver> wait = new FluentWait<>(HelperClass.getDriver())
                .withTimeout(Duration.ofSeconds(60))          // increased to 60s for slow downloads
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(Exception.class);

        wait.until(driver -> {
            File folder = new File(downloadPath);
            File[] files = folder.listFiles();
            if (files != null) {
                for (File file : files) {
                    // Ignore incomplete Chrome download temp files
                    if (file.getName().contains(fileExtension)
                            && !file.getName().endsWith(".crdownload")
                            && !file.getName().endsWith(".tmp")) {
                        return true;
                    }
                }
            }
            return false;
        });
    }

    // PAUSE — small sleep helper for cases where JS animations cause timing issues
    public void pause(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    // WAIT WITH CUSTOM TIMEOUT
    public void waitForVisibility(By locator, int timeoutSeconds) {
        new WebDriverWait(HelperClass.getDriver(), Duration.ofSeconds(timeoutSeconds))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}