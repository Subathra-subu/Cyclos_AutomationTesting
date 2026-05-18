package com.Actions;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Utilities.HelperClass;
//baseaction
public class BaseAction {

	public void click(By locator) {
		try {
			waitForClickable(locator);
			HelperClass.getDriver().findElement(locator).click();
			HelperClass.log.info("Clicked on element: " + locator.toString());
		} catch (Exception e) {
			HelperClass.log.error("Failed to click on element: " + locator.toString() + " | Error: " + e.getMessage());
			throw e;
		}
	}

	public void jsClick(By locator) {
		try {
			WebElement element = HelperClass.getWait().until(ExpectedConditions.elementToBeClickable(locator));
			JavascriptExecutor js = (JavascriptExecutor) HelperClass.getDriver();
			js.executeScript("arguments[0].click();", element);
			HelperClass.log.info("JS Clicked on element: " + locator.toString());
		} catch (Exception e) {
			HelperClass.log.error("Failed to JS click on element: " + locator.toString() + " | Error: " + e.getMessage());
			throw e;
		}
	}

	public void sendKeys(By locator, String value) {
		try {
			waitForVisibility(locator);
			WebElement element = HelperClass.getDriver().findElement(locator);
			element.clear();
			element.sendKeys(value);
			HelperClass.log.info("Sent keys to: " + locator.toString() + " value: " + value);
		} catch (Exception e) {
			HelperClass.log.error("Failed to send keys to element: " + locator.toString() + " | Error: " + e.getMessage());
			throw e;
		}
	}

	public String getText(By locator) {
		try {
			waitForVisibility(locator);
			HelperClass.log.info("Got text from element: " + locator.toString());
			return HelperClass.getDriver().findElement(locator).getText();
		} catch (Exception e) {
			HelperClass.log.error("Failed to get text from element: " + locator.toString() + " | Error: " + e.getMessage());
			throw e;
		}
	}

	public void waitForVisibility(By locator) {
		try {
			HelperClass.getWait().until(ExpectedConditions.visibilityOfElementLocated(locator));
			HelperClass.log.info("Element is visible: " + locator.toString());
		} catch (Exception e) {
			HelperClass.log.error("Failed to wait for visibility of element: " + locator.toString() + " | Error: " + e.getMessage());
			throw e;
		}
	}

	public void waitForClickable(By locator) {
		try {
			HelperClass.getWait().until(ExpectedConditions.elementToBeClickable(locator));
			HelperClass.log.info("Element is clickable: " + locator.toString());
		} catch (Exception e) {
			HelperClass.log.error("Failed to wait for element to be clickable: " + locator.toString() + " | Error: " + e.getMessage());
			throw e;
		}
	}

	public void waitForInvisibility(By locator) {
		try {
			HelperClass.getWait().until(ExpectedConditions.invisibilityOfElementLocated(locator));
			HelperClass.log.info("Element is invisible: " + locator.toString());
		} catch (Exception e) {
			HelperClass.log.error("Failed to wait for element to be invisible: " + locator.toString() + " | Error: " + e.getMessage());
			throw e;
		}
	}

	public void scrollIntoView(By locator) {
		try {
			WebElement element = HelperClass.getDriver().findElement(locator);
			JavascriptExecutor js = (JavascriptExecutor) HelperClass.getDriver();
			js.executeScript("arguments[0].scrollIntoView({block:'center'});", element);
			HelperClass.log.info("Scrolled into view: " + locator.toString());
		} catch (Exception e) {
			HelperClass.log.error("Failed to scroll into view: " + locator.toString() + " | Error: " + e.getMessage());
			throw e;
		}
	}
	
	public boolean isSelected(By locator) {

	    try {

	        WebDriverWait wait =
	                new WebDriverWait(HelperClass.getDriver(),
	                        Duration.ofSeconds(2));

	        return wait.until(
	                ExpectedConditions.visibilityOfElementLocated(locator))
	                .isSelected();

	    } catch (Exception e) {

	        return false;
	    }
	}public boolean isEnabled(By locator) {

	    try {

	        WebDriverWait wait =
	                new WebDriverWait(HelperClass.getDriver(),
	                        Duration.ofSeconds(2));

	        return wait.until(
	                ExpectedConditions.visibilityOfElementLocated(locator))
	                .isEnabled();

	    } catch (Exception e) {

	        return false;
	    }
	}

	public boolean isDisplayed(By locator) {

	    try {

	        WebDriverWait wait =
	                new WebDriverWait(HelperClass.getDriver(),
	                        Duration.ofSeconds(2));

	        return wait.until(
	                ExpectedConditions.visibilityOfElementLocated(locator))
	                .isDisplayed();

	    } catch (Exception e) {

	        return false;
	    }
	}

	public void clearDownloadFolder(String downloadPath) {
		try {
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
			HelperClass.log.info("Cleared download folder: " + downloadPath);
		} catch (Exception e) {
			HelperClass.log.error("Failed to clear download folder: " + downloadPath + " | Error: " + e.getMessage());
			throw e;
		}
	}

	public void waitForFileDownload(String downloadPath, String fileExtension) {
		try {
			FluentWait<WebDriver> wait = new FluentWait<>(HelperClass.getDriver())
					.withTimeout(Duration.ofSeconds(60))
					.pollingEvery(Duration.ofSeconds(2))
					.ignoring(Exception.class);

			wait.until(driver -> {
				File folder = new File(downloadPath);
				File[] files = folder.listFiles();
				if (files != null) {
					for (File file : files) {
						if (file.getName().toLowerCase().contains(fileExtension.toLowerCase())
								&& !file.getName().endsWith(".crdownload")
								&& !file.getName().endsWith(".tmp")) {
							return true;
						}
					}
				}
				return false;
			});

			HelperClass.log.info("File with extension " + fileExtension + " downloaded in: " + downloadPath);
		} catch (Exception e) {
			HelperClass.log.error("Failed to wait for file download in: " + downloadPath + " | Error: " + e.getMessage());
			throw e;
		}
	}
}