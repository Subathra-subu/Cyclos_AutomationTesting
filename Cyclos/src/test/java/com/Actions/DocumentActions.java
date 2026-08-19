package com.Actions;

import org.testng.Assert;
import com.Pages.DocumentPage;
import com.Utilities.FileUtility;
import com.Utilities.HelperClass;
import com.Utilities.PDFUtility;

public class DocumentActions extends BaseAction {

	DocumentPage documentPage = new DocumentPage();

	public void clickDocumentsMenu() {
		try {
			scrollIntoView(documentPage.documentsMenu);
			waitForVisibility(documentPage.documentsMenu);
			waitForClickable(documentPage.documentsMenu);
			jsClick(documentPage.documentsMenu);
			HelperClass.log.info("Clicked Documents Menu Successfully");
		} catch (Exception e) {
			HelperClass.log.error("Failed to click Documents Menu : " + e.getMessage());
			throw new RuntimeException("Unable to click Documents Menu", e);
		}
	}

	public void clickDownloadForInnovativeDocument() {
		try {
			waitForVisibility(documentPage.innovativeDocRow);
			scrollIntoView(documentPage.innovativeDocRow);
			HelperClass.log.info("Found document row: Innovative Approaches to Development");
			waitForVisibility(documentPage.downloadBtn);
			waitForClickable(documentPage.downloadBtn);
			String downloadPath = HelperClass.getDownloadPath();
			clearDownloadFolder(downloadPath);
			jsClick(documentPage.downloadBtn);
			waitForFileDownload(downloadPath, ".pdf");
			HelperClass.log.info("PDF downloaded successfully");
		} catch (Exception e) {
			HelperClass.log.error("Failed to download PDF : " + e.getMessage());
			throw new RuntimeException("Unable to download PDF", e);
		}
	}

	public void assertPDFContainsTitle(String expectedText) {
		try {
			String downloadPath = HelperClass.getDownloadPath();
			String pdfPath = FileUtility.getDownloadedFilePath(downloadPath, ".pdf");
			if (pdfPath == null) {
				HelperClass.log.error("PDF file not found in download folder");
				Assert.fail("PDF file not downloaded");
				return;
			}
			String pdfContent = PDFUtility.readPDF(pdfPath);
			String normalizedContent = pdfContent.replaceAll("\\s+", " ").trim();
			HelperClass.log.info("PDF content length : " + normalizedContent.length());
			HelperClass.log.info("PDF content preview : " + normalizedContent.substring(0, Math.min(500, normalizedContent.length())));
			Assert.assertTrue(normalizedContent.toLowerCase().contains(expectedText.toLowerCase()),
					"Assertion Failed: PDF does not contain expected text '" + expectedText + "'");
			HelperClass.log.info("PDF title assertion successful : " + expectedText);
		} catch (Exception e) {
			HelperClass.log.error("Failed to assert PDF content : " + e.getMessage());
			throw new RuntimeException("Unable to assert PDF content", e);
		}
	}

}
