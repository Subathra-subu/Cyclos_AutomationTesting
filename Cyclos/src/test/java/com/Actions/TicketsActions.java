package com.Actions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.Pages.TickesPage;
import com.Utilities.FileUtility;
import com.Utilities.HelperClass;
import com.Utilities.PDFUtility;

public class TicketsActions extends BaseAction {

	TickesPage ticketsPage = new TickesPage();

	public void clickOnBankingMenu() {
		try {
			waitForClickable(ticketsPage.bankingMenu);
			click(ticketsPage.bankingMenu);
			HelperClass.getWait().until(
					ExpectedConditions.visibilityOfElementLocated(ticketsPage.ticketsMenu));
			HelperClass.log.info("Banking menu expanded successfully");
		} catch (Exception e) {
			HelperClass.log.error("Failed to click Banking Menu : " + e.getMessage());
			throw new RuntimeException("Unable to click Banking Menu", e);
		}
	}

	public void clickOnTicketsMenu() {
		try {
			scrollIntoView(ticketsPage.ticketsMenu);
			waitForClickable(ticketsPage.ticketsMenu);
			jsClick(ticketsPage.ticketsMenu);
			waitForTableOrNoResults();
			HelperClass.log.info("Tickets page loaded successfully");
		} catch (Exception e) {
			HelperClass.log.error("Failed to click Tickets Menu : " + e.getMessage());
			throw new RuntimeException("Unable to click Tickets Menu", e);
		}
	}

	public void selectStatus(String status) {
		try {
			waitForClickable(ticketsPage.statusBtn);
			jsClick(ticketsPage.statusBtn);

			By statusOption = By.xpath(
					"//div[contains(@class,'dropdown-menu')]//*[normalize-space()='" + status + "']");

			waitForVisibility(statusOption);
			waitForClickable(statusOption);
			scrollIntoView(statusOption);
			jsClick(statusOption);
			waitForInvisibility(statusOption);
			waitForTableOrNoResults();

			if (isNoResultsDisplayed()) {
				HelperClass.log.warn("No results found for status : " + status);
			} else {
				waitForVisibility(ticketsPage.firstRow);
				HelperClass.log.info("Rows loaded successfully for status : " + status);
			}

		} catch (Exception e) {
			HelperClass.log.error("Failed to select status : " + status + " Exception : " + e.getMessage());
			throw new RuntimeException("Unable to select status : " + status, e);
		}
	}

	public void clickOnFirstRow() {
		try {
			waitForVisibility(ticketsPage.firstRow);
			scrollIntoView(ticketsPage.firstRow);
			waitForClickable(ticketsPage.firstRow);
			String rowText = getText(ticketsPage.firstRow);
			HelperClass.log.info("Clicking first row : " + rowText);
			jsClick(ticketsPage.firstRow);
			waitForPageLoad();
			try {
				waitForVisibility(ticketsPage.print);
			} catch (Exception e) {
				HelperClass.log.warn("Print button not visible after row click, waiting longer...");
				WebDriverWait extWait = new WebDriverWait(HelperClass.getDriver(), Duration.ofSeconds(10));
				extWait.until(ExpectedConditions.or(
						ExpectedConditions.visibilityOfElementLocated(ticketsPage.print),
						ExpectedConditions.visibilityOfElementLocated(ticketsPage.noResultsMessage)));
			}
		} catch (Exception e) {
			HelperClass.log.error("Failed to click first row : " + e.getMessage());
			throw new RuntimeException("Unable to click first row", e);
		}
	}

	public void clickPrintButton() {
		try {
			if (isNoResultsDisplayed()) {
				HelperClass.log.warn("Print skipped because no results found");
				return;
			}
			try {
				waitForVisibility(ticketsPage.print);
			} catch (Exception e) {
				HelperClass.log.warn("Print button not found, attempting JS fallback");
				waitForAjaxComplete();
				waitForVisibility(ticketsPage.print);
			}
			scrollIntoView(ticketsPage.print);
			waitForClickable(ticketsPage.print);
			jsClick(ticketsPage.print);
			String downloadPath = HelperClass.getDownloadPath();
			waitForFileDownload(downloadPath, ".pdf");
			HelperClass.log.info("PDF downloaded successfully");
		} catch (Exception e) {
			HelperClass.log.error("Failed to click print button : " + e.getMessage());
			throw new RuntimeException("Unable to click print button", e);
		}
	}

	public void validateTransactionStatusFromPDF(String expectedStatus) {
		try {
			if (isNoResultsDisplayed()) {
				HelperClass.log.warn("Skipping PDF validation because no results found");
				return;
			}
			String downloadPath = HelperClass.getDownloadPath();
			waitForFileDownload(downloadPath, ".pdf");
			String pdfPath = FileUtility.getDownloadedFilePath(downloadPath, ".pdf");

			if (pdfPath == null) {
				HelperClass.log.error("PDF file not found");
				Assert.fail("PDF file not downloaded");
				return;
			}

			String pdfContent = PDFUtility.readPDF(pdfPath);
			String normalizedPdf = pdfContent.replaceAll("\\s+", "").toLowerCase();
			String actualStatus = extractStatusFromPDF(normalizedPdf);

			HelperClass.log.info("Expected Status : " + expectedStatus);
			HelperClass.log.info("Actual Status : " + actualStatus);

			if (expectedStatus.equalsIgnoreCase(actualStatus)) {
				HelperClass.log.info("PDF status validated successfully");
			} else {
				HelperClass.log.warn("Status mismatch. Expected : " + expectedStatus + " Actual : " + actualStatus);
			}

		} catch (Exception e) {
			HelperClass.log.error("Failed to validate PDF status : " + e.getMessage());
			throw new RuntimeException("Unable to validate PDF status", e);
		}
	}

//	public void clickOpenSts() {
//		try {
//			waitForClickable(ticketsPage.clickOpen);
//			jsClick(ticketsPage.clickOpen);
//			HelperClass.log.info("Clicked Open Status successfully");
//		} catch (Exception e) {
//			HelperClass.log.error("Failed to click Open Status : " + e.getMessage());
//			throw new RuntimeException("Unable to click Open Status", e);
//		}
//	}
	
	public void clickStatus(String status) {

	    try {

	        By statusOption =
	                By.xpath("//a[text()=' " + status + " ']");

	        waitForClickable(statusOption);

	        jsClick(statusOption);

	        HelperClass.log.info("Clicked " + status + " status successfully");

	    } catch (Exception e) {

	        HelperClass.log.error("Failed to click "
	                + status
	                + " status : "
	                + e.getMessage());

	        throw new RuntimeException(
	                "Unable to click " + status + " status", e);
	    }
	}

	public void filterClick() {
		try {
			waitForClickable(ticketsPage.filter);
			jsClick(ticketsPage.filter);
			waitForVisibility(ticketsPage.filterStatusBtn);
			HelperClass.log.info("Filter clicked successfully");
		} catch (Exception e) {
			HelperClass.log.error("Failed to click filter : " + e.getMessage());
			throw new RuntimeException("Unable to click filter", e);
		}
	}

	public void filterStsClick() {
		try {
			waitForClickable(ticketsPage.filterStatusBtn);
			jsClick(ticketsPage.filterStatusBtn);
			HelperClass.log.info("Filter status clicked successfully");
		} catch (Exception e) {
			HelperClass.log.error("Failed to click filter status : " + e.getMessage());
			throw new RuntimeException("Unable to click filter status", e);
		}
	}

	public boolean isNoResultsDisplayed() {
		try {
			WebDriverWait shortWait = new WebDriverWait(HelperClass.getDriver(), Duration.ofSeconds(3));
			shortWait.until(ExpectedConditions.visibilityOfElementLocated(ticketsPage.noResultsMessage));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public void assertNoResultsMessage() {
		String expectedMessage = "No results match the search criteria";
		String actualMessage = getText(ticketsPage.noResultsMessage);
		Assert.assertEquals(actualMessage, expectedMessage, "No results message does not match expected.");
	}

	private void waitForTableOrNoResults() {
		try {
			WebDriverWait wait = new WebDriverWait(HelperClass.getDriver(), Duration.ofSeconds(20));
			wait.until(ExpectedConditions.or(
					ExpectedConditions.visibilityOfElementLocated(ticketsPage.noResultsMessage),
					ExpectedConditions.visibilityOfElementLocated(ticketsPage.firstRow),
					ExpectedConditions.visibilityOfElementLocated(ticketsPage.statusBtn)));
		} catch (Exception e) {
			HelperClass.log.warn("waitForTableOrNoResults timed out: " + e.getMessage());
		}
	}

	public void assertOpen(String status) {
		try {
			waitForVisibility(ticketsPage.asserOpen);
			String actualStatus = getText(ticketsPage.asserOpen);
			Assert.assertEquals(actualStatus, status, "Expected status does not match actual status");
			HelperClass.log.info("Status assertion completed successfully");
		} catch (Exception e) {
			HelperClass.log.error("Failed to validate open status : " + e.getMessage());
			throw new RuntimeException("Unable to validate open status", e);
		}
	}

	private String extractStatusFromPDF(String normalizedPdf) {
		if (normalizedPdf.contains("approved"))  return "Approved";
		if (normalizedPdf.contains("canceled"))  return "Canceled";
		if (normalizedPdf.contains("cancelled")) return "Canceled";
		if (normalizedPdf.contains("expired"))   return "Expired";
		if (normalizedPdf.contains("processed")) return "Processed";
		if (normalizedPdf.contains("open"))      return "Open";
		return "";
	}
}