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

import com.StepDefinitions.Hooks;
import com.Utilities.HelperClass;

public class BaseAction {

	public void click(By locator) {
		
		waitForClickable(locator);
		
		HelperClass.getDriver().findElement(locator).click();
		
		Hooks.logger.info("Clicked on element: " + locator.toString());
	}

	public void jsClick(By locator) {
		
		WebElement element = HelperClass.getWait().until(ExpectedConditions.elementToBeClickable(locator));
		
		JavascriptExecutor js = (JavascriptExecutor) HelperClass.getDriver();
		
		js.executeScript("arguments[0].click();", element);
		
		Hooks.logger.info("JS Clicked on element: " + locator.toString());
	}

	public void sendKeys(By locator, String value) {
		
		waitForVisibility(locator);
		
		WebElement element = HelperClass.getDriver().findElement(locator);
		
		element.clear();
		
		element.sendKeys(value);
		
		Hooks.logger.info("Sent keys to: " + locator.toString() + " value: " + value);
	}

	public String getText(By locator) {
		
		waitForVisibility(locator);
		
		Hooks.logger.info("Got text from element: " + locator.toString());
		
		return HelperClass.getDriver().findElement(locator).getText();
	}

	public void waitForVisibility(By locator) {
		
		HelperClass.getWait().until(ExpectedConditions.visibilityOfElementLocated(locator));
		
		Hooks.logger.info("Element is visible: " + locator.toString());
	}

	public void waitForClickable(By locator) {
		
		HelperClass.getWait().until(ExpectedConditions.elementToBeClickable(locator));
		
		Hooks.logger.info("Element is clickable: " + locator.toString());
	}

	public void waitForInvisibility(By locator) {
		
		HelperClass.getWait().until(ExpectedConditions.invisibilityOfElementLocated(locator));
		
		Hooks.logger.info("Element is invisible: " + locator.toString());
	}

	public void scrollIntoView(By locator) {
		
		WebElement element = HelperClass.getDriver().findElement(locator);
		
		JavascriptExecutor js = (JavascriptExecutor) HelperClass.getDriver();
		
		js.executeScript("arguments[0].scrollIntoView({block:'center'});", element);
		
		Hooks.logger.info("Scrolled into view: " + locator.toString());
	}

	public void mouseHover(By locator) {
		
		WebElement element = HelperClass.getDriver().findElement(locator);
		
		Actions actions = new Actions(HelperClass.getDriver());
		
		actions.moveToElement(element).perform();
		
		Hooks.logger.info("Mouse hovered on element: " + locator.toString());
	}

	public boolean isDisplayed(By locator) {
		
		try {
			
			Hooks.logger.info("Checking if element is displayed: " + locator.toString());
			
			return HelperClass.getDriver().findElement(locator).isDisplayed();
		} 
		catch (Exception e) {
			
			Hooks.logger.warn("Element not found or not displayed: " + locator.toString());
			
			return false;
		}
	}

	// FIX: Use HelperClass.getDownloadPath() everywhere — no hardcoded separators
	public void clearDownloadFolder(String downloadPath) {
		
		File folder = new File(downloadPath);
		
		if (!folder.exists()) {
			folder.mkdirs();
			return;
		}
		
		File[] files = folder.listFiles();
		
		if (files != null) {
			for (File file : files) {
				if (file.isFile()) {
					file.delete();
				}
			}
		}
		
		Hooks.logger.info("Cleared download folder: " + downloadPath);
	}

	public void waitForFileDownload(String downloadPath, String fileExtension) {
		
		FluentWait<WebDriver> wait = new FluentWait<>(HelperClass.getDriver()).withTimeout(Duration.ofSeconds(60))
				.pollingEvery(Duration.ofSeconds(2)).ignoring(Exception.class);

		wait.until(driver -> {
			
			File folder = new File(downloadPath);
			
			File[] files = folder.listFiles();
			
			if (files != null) {
				for (File file : files) {
					if (file.getName().toLowerCase().contains(fileExtension.toLowerCase())
							&& !file.getName().endsWith(".crdownload") && !file.getName().endsWith(".tmp")) {
						return true;
					}
				}
			}
			return false;
		});

		Hooks.logger.info("File with extension " + fileExtension + " downloaded in: " + downloadPath);
	}

	public void waitForVisibility(By locator, int timeoutSeconds) {
		
		new WebDriverWait(HelperClass.getDriver(), Duration.ofSeconds(timeoutSeconds)).until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
}