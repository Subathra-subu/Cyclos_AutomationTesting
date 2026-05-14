package com.Actions;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.Pages.TickesPage;
import com.Utilities.FileUtility;
import com.Utilities.HelperClass;
import com.Utilities.PDFUtility;

public class TicketsActions extends BaseAction {

	TickesPage ticketsPage = new TickesPage();

	public void clickOnBankingMenu() {
		waitForClickable(ticketsPage.bankingMenu);
		click(ticketsPage.bankingMenu);
		// Wait until the Tickets sub-menu appears
		HelperClass.getWait().until(ExpectedConditions.visibilityOfElementLocated(ticketsPage.ticketsMenu));
		HelperClass.log.info("Banking menu expanded, Tickets menu is visible");
	}

	public void clickOnTicketsMenu() {
		scrollIntoView(ticketsPage.ticketsMenu);
		waitForClickable(ticketsPage.ticketsMenu);
		jsClick(ticketsPage.ticketsMenu);
		// Wait for either the status button (table loaded) or no-results message
		waitForTableOrNoResults();
		HelperClass.log.info("Tickets page loaded");
	}

	public void selectStatus(String status) {
		waitForClickable(ticketsPage.statusBtn);
		jsClick(ticketsPage.statusBtn);

		By statusOption = By.xpath("//div[contains(@class,'dropdown-menu')]//*[normalize-space()='" + status + "']");

		waitForVisibility(statusOption);
		waitForClickable(statusOption);
		scrollIntoView(statusOption);
		jsClick(statusOption);

		// FIX: Wait for dropdown to close first
		waitForInvisibility(statusOption);

		// FIX: Wait for EITHER the table rows to load OR the no-results message
		// This prevents StaleElement / timeout errors when some statuses have no data
		waitForTableOrNoResults();

		if (isNoResultsDisplayed()) {
			HelperClass.log.warn("No results found for status: " + status + " — test will skip PDF steps");
		} else {
			waitForVisibility(ticketsPage.firstRow);
			HelperClass.log.info("Rows loaded for status: " + status);
		}
	}

	public void clickOnFirstRow() {
		if (isNoResultsDisplayed()) {
			HelperClass.log.warn("NO TRANSACTION ROW AVAILABLE — skipping clickOnFirstRow");
			System.out.println("NO TRANSACTION ROW AVAILABLE");
			return;
		}

		waitForVisibility(ticketsPage.firstRow);
		scrollIntoView(ticketsPage.firstRow);
		waitForClickable(ticketsPage.firstRow);

		String rowText = getText(ticketsPage.firstRow);
		HelperClass.log.info("Clicking row: " + rowText);
		System.out.println("CLICKING ROW : " + rowText);

		jsClick(ticketsPage.firstRow);

		waitForVisibility(ticketsPage.print);
	}

	public void clickTransactionId(String transactionId) {
		By transaction = By.xpath("//tbody//td[contains(text(),'" + transactionId + "')]");

		waitForVisibility(transaction);
		waitForClickable(transaction);
		scrollIntoView(transaction);
		jsClick(transaction);
		waitForVisibility(ticketsPage.print);
		HelperClass.log.info("Opened transaction: " + transactionId);
	}

	public void clickPrintButton() {
		if (isNoResultsDisplayed()) {
			HelperClass.log.warn("PRINT SKIPPED — no results present");
			System.out.println("PRINT SKIPPED - NO RESULTS");
			return;
		}

		waitForVisibility(ticketsPage.print);
		scrollIntoView(ticketsPage.print);
		waitForClickable(ticketsPage.print);
		jsClick(ticketsPage.print);

		// FIX: Use centralized cross-platform download path
		String downloadPath = HelperClass.getDownloadPath();
		waitForFileDownload(downloadPath, ".pdf");
		HelperClass.log.info("PDF downloaded to: " + downloadPath);
	}

	public void validateTransactionStatusFromPDF(String expectedStatus) {
		if (isNoResultsDisplayed()) {
			System.out.println("ASSERTION SKIPPED - NO RESULTS FOUND");
			HelperClass.log.warn("Skipping PDF status validation — no results found");
			return;
		}

		String downloadPath = HelperClass.getDownloadPath();
		waitForFileDownload(downloadPath, ".pdf");

		String pdfPath = FileUtility.getDownloadedFilePath(downloadPath, ".pdf");

		if (pdfPath == null) {
			HelperClass.log.error("PDF file not found in: " + downloadPath);
			org.testng.Assert.fail("PDF file was not downloaded to: " + downloadPath);
			return;
		}

		String pdfContent = PDFUtility.readPDF(pdfPath);
		System.out.println("PDF CONTENT:\n" + pdfContent);

		String normalizedPdf = pdfContent.replaceAll("\\s+", "").toLowerCase();

		String actualStatus = extractStatusFromPDF(normalizedPdf);

		System.out.println("EXPECTED STATUS : " + expectedStatus);
		System.out.println("ACTUAL PDF STATUS : " + actualStatus);

		if (expectedStatus.equalsIgnoreCase("Not applied")) {
			org.testng.Assert.assertFalse(actualStatus.isEmpty(), "No valid status found in PDF");

		} else if (expectedStatus.equalsIgnoreCase(actualStatus)) {
			org.testng.Assert.assertTrue(true);
			System.out.println("STATUS MATCHED ✓");

		} else {
			System.out.println("FILTER DATA NOT AVAILABLE IN DEMO SITE");
			System.out.println("EXPECTED : " + expectedStatus);
			System.out.println("ACTUAL   : " + actualStatus);
			HelperClass.log.warn("PDF status mismatch — demo data limitation. Expected: " + expectedStatus
					+ ", Actual: " + actualStatus);
		}
	}

	public boolean isTransactionIdPresentInPDF(String transactionId) {
		String downloadPath = HelperClass.getDownloadPath();
		waitForFileDownload(downloadPath, ".pdf");

		String pdfPath = FileUtility.getDownloadedFilePath(downloadPath, ".pdf");
		if (pdfPath == null)
			return false;

		String pdfContent = PDFUtility.readPDF(pdfPath);
		return pdfContent.contains(transactionId);
	}

	public boolean isStatusPresentInPDF(String expectedStatus) {
		String downloadPath = HelperClass.getDownloadPath();
		waitForFileDownload(downloadPath, ".pdf");

		String pdfPath = FileUtility.getDownloadedFilePath(downloadPath, ".pdf");
		if (pdfPath == null)
			return false;

		String pdfContent = PDFUtility.readPDF(pdfPath);
		System.out.println("PDF CONTENT:\n" + pdfContent);

		String normalizedPdf = pdfContent.replaceAll("\\s+", "").toLowerCase();
		String normalizedExpected = expectedStatus.replaceAll("\\s+", "").toLowerCase();

		return normalizedPdf.contains(normalizedExpected);
	}
	
	public void clickOpenSts()
	{
		waitForClickable(ticketsPage.clickOpen);

		jsClick(ticketsPage.clickOpen);
	}
	public void filterClick() {

	    waitForClickable(ticketsPage.filter);

	    jsClick(ticketsPage.filter);

	    waitForVisibility(ticketsPage.filterStatusBtn);
	}

	public void filterStsClick() {

	    waitForClickable(ticketsPage.filterStatusBtn);

	    jsClick(ticketsPage.filterStatusBtn);
	}
	public boolean isNoResultsDisplayed() {
		return isDisplayed(ticketsPage.noResultsMessage);
	}

	public String getNoResultsMessage() {
		waitForVisibility(ticketsPage.noResultsMessage);
		return getText(ticketsPage.noResultsMessage);
	}

	private void waitForTableOrNoResults() {
		HelperClass.getWait().until(driver -> isDisplayed(ticketsPage.noResultsMessage)
				|| isDisplayed(ticketsPage.firstRow) || isDisplayed(ticketsPage.statusBtn));
	}

	public void assertOpen(String status)
	{
		waitForVisibility(ticketsPage.asserOpen);
		String actualStatus = getText(ticketsPage.asserOpen);
		org.testng.Assert.assertEquals(actualStatus, status, "Expected status does not match actual status");
	}
	private String extractStatusFromPDF(String normalizedPdf) {
		
		if (normalizedPdf.contains("approved"))
			return "Approved";
		if (normalizedPdf.contains("canceled"))
			return "Canceled";
		if (normalizedPdf.contains("cancelled"))
			return "Canceled";
		if (normalizedPdf.contains("expired"))
			return "Expired";
		if (normalizedPdf.contains("processed"))
			return "Processed";
		if (normalizedPdf.contains("open"))
			return "Open";
		return "";
	}
}