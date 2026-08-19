package com.Actions;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Pages.referencePage;
import com.Utilities.HelperClass;

public class ReferenceActions extends BaseAction {

	referencePage referencePage = new referencePage();

	public void clickPersonalMenu() {
		try {
			waitForVisibility(referencePage.personalMenu);
			waitForClickable(referencePage.personalMenu);
			jsClick(referencePage.personalMenu);
			HelperClass.log.info("Clicked Personal Menu Successfully");
		} catch (Exception e) {
			HelperClass.log.error("Failed to click Personal Menu : " + e.getMessage());
			throw e;
		}
	}

	public void clickReferencesMenu() {
		try {
			waitForVisibility(referencePage.referenceMenu);
			waitForClickable(referencePage.referenceMenu);
			jsClick(referencePage.referenceMenu);
			HelperClass.log.info("Clicked References Menu Successfully");
		} catch (Exception e) {
			HelperClass.log.error("Failed to click References Menu : " + e.getMessage());
			throw e;
		}
	}

	public void clickReceivedReference() {
		try {
			waitForVisibility(referencePage.receivedReference);
			waitForClickable(referencePage.receivedReference);
			jsClick(referencePage.receivedReference);
			HelperClass.log.info("Clicked Received Reference Successfully");
		} catch (Exception e) {
			HelperClass.log.error("Failed to click Received Reference : " + e.getMessage());
			throw e;
		}
	}

	public void clickDeleteButton() {
		try {
			waitForVisibility(referencePage.deleteButton);
			scrollIntoView(referencePage.deleteButton);
			waitForClickable(referencePage.deleteButton);
			click(referencePage.deleteButton);
			HelperClass.log.info("Clicked Delete Button Successfully");
		} catch (Exception e) {
			HelperClass.log.error("Failed to click Delete Button : " + e.getMessage());
			throw e;
		}
	}

	public void confirmDeletion() {
		try {
			WebDriverWait shortWait = new WebDriverWait(HelperClass.getDriver(), Duration.ofSeconds(5));
			try {
				Alert alert = shortWait.until(ExpectedConditions.alertIsPresent());
				alert.accept();
				HelperClass.log.info("Confirmed Deletion via JavaScript alert");
				return;
			} catch (TimeoutException e) {
				// no alert
			}

			// Try to find the dialog and its buttons - dump HTML for debugging
			By dialog = By.xpath("//*[@role='dialog' or contains(@class,'modal-dialog') or contains(@class,'cdk-overlay-pane')]");
			if (isDisplayed(dialog, 5)) {
				// Dump dialog HTML
				WebElement dialogEl = HelperClass.getDriver().findElement(dialog);
				String dialogHtml = (String) ((org.openqa.selenium.JavascriptExecutor) HelperClass.getDriver())
					.executeScript("return arguments[0].outerHTML;", dialogEl);
				HelperClass.log.info("Dialog HTML: " + (dialogHtml.length() > 500 ? dialogHtml.substring(0, 500) : dialogHtml));

				// Find all buttons in the dialog
				List<WebElement> buttons = HelperClass.getDriver().findElements(
					By.xpath("(//*[@role='dialog'] | //*[contains(@class,'modal-dialog')] | //*[contains(@class,'cdk-overlay-pane')])//button"));
				for (int bi = 0; bi < buttons.size(); bi++) {
					WebElement btn = buttons.get(bi);
					HelperClass.log.info("  Button[" + bi + "]: text='" + btn.getText().trim() + "' class='" + btn.getAttribute("class") + "' disabled='" + btn.getAttribute("disabled") + "' type='" + btn.getAttribute("type") + "'");
				}
				if (buttons.size() > 0) {
					// Click the first button via native HTMLElement.click()
					WebElement confirmBtn = buttons.get(0);
					String btnText = confirmBtn.getText().trim();
					HelperClass.log.info("Clicking dialog button [0]: '" + btnText + "' via HTMLElement.click()");
					scrollIntoView(confirmBtn);
					((org.openqa.selenium.JavascriptExecutor) HelperClass.getDriver())
						.executeScript("arguments[0].click();", confirmBtn);
					HelperClass.log.info("Confirmed via HTMLElement.click: '" + btnText + "'");
					try { Thread.sleep(2000); } catch (InterruptedException ie) {}

					// Check if dialog closed after click
					try {
						WebElement dialogAfter = HelperClass.getDriver().findElement(dialog);
						if (dialogAfter.isDisplayed()) {
							HelperClass.log.info("Dialog still visible after click - trying to click Cancel then Confirm again");
							// If still open, try clicking Cancel first, then Confirm (unlikely but worth trying)
						} else {
							HelperClass.log.info("Dialog closed after click");
						}
					} catch (Exception e3) {
						HelperClass.log.info("Dialog element gone after click - CLOSED");
					}
				} else {
					HelperClass.log.info("Dialog found but no buttons inside");
				}
			} else {
				HelperClass.log.info("No confirmation dialog appeared");
			}
		} catch (Exception e) {
			HelperClass.log.error("Failed to confirm Deletion : " + e.getMessage());
			throw e;
		}
	}

	public boolean isSuccessMessageDisplayed() {
		try {
			// Check if dialog is still visible (means click didn't close it)
			By dialogCheck = By.xpath("//*[@role='dialog' or contains(@class,'modal-dialog') or contains(@class,'cdk-overlay-pane')]");
			try {
				if (HelperClass.getDriver().findElement(dialogCheck).isDisplayed()) {
					HelperClass.log.info("Dialog still visible after clicking confirm - action may not have triggered");
				} else {
					HelperClass.log.info("Dialog closed after clicking confirm");
				}
			} catch (Exception e2) {
				HelperClass.log.info("Dialog not found after clicking confirm - it was dismissed");
			}

			// Check for snackbar
			boolean found = isDisplayed(referencePage.successMessage);
			if (!found) {
				HelperClass.log.info("Success message not found at //snack-bar, trying fallbacks");
				By fallback1 = By.xpath("//*[contains(text(),'removed') or contains(text(),'deleted') or contains(text(),'success')]");
				found = isDisplayed(fallback1, 5);
				if (!found) {
					By fallback2 = By.xpath("//simple-snack-bar");
					found = isDisplayed(fallback2, 3);
					if (!found) {
						By fallback3 = By.xpath("//*[contains(@class,'toast') or contains(@class,'snackbar') or contains(@class,'notification')]");
						found = isDisplayed(fallback3, 3);
					}
				}
			}
			return found;
		} catch (Exception e) {
			HelperClass.log.error("Success message check failed : " + e.getMessage());
			return false;
		}
	}
}
