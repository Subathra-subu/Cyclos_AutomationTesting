package com.Actions;

import org.openqa.selenium.support.ui.ExpectedConditions;

import com.Pages.memberAccountPage;
import com.Utilities.FileUtility;
import com.Utilities.HelperClass;
import com.Utilities.PDFUtility;

public class memberAction extends BaseAction

{
	
	memberAccountPage mPage = new memberAccountPage();

	public void clickOnBankingMenu() {
		try {
			waitForClickable(mPage.bankingMenu);
			click(mPage.bankingMenu);
			HelperClass.getWait().until(ExpectedConditions.visibilityOfElementLocated(mPage.downloadBtn));
			HelperClass.log.info("Banking menu expanded successfully");
		} catch (Exception e) {
			HelperClass.log.error("Failed to click Banking Menu : " + e.getMessage());
			throw new RuntimeException("Unable to click Banking Menu", e);
		}
	}
	
	public void clickOnMemberAccountButton() {
		try {
			waitForClickable(mPage.memberAccountLink);
			click(mPage.memberAccountLink);
			HelperClass.log.info("Member Account link clicked successfully");
		} catch (Exception e) {
			HelperClass.log.error("Failed to click Member Account link : " + e.getMessage());
			throw new RuntimeException("Unable to click Member Account link", e);
		}
	}
	
	public void clickDownloadButton()
	{
		try {
			waitForClickable(mPage.downloadBtn);
			click(mPage.downloadBtn);
			HelperClass.log.info("Download button clicked successfully");
		} catch (Exception e) {
			HelperClass.log.error("Failed to click Download button : " + e.getMessage());
			throw new RuntimeException("Unable to click Download button", e);
		}
	}
	
	public void clickPdfOption() {
		try {
			waitForClickable(mPage.pdfOption);
			click(mPage.pdfOption);
			HelperClass.log.info("PDF option clicked successfully");
		} catch (Exception e) {
			HelperClass.log.error("Failed to click PDF option : " + e.getMessage());
			throw new RuntimeException("Unable to click PDF option", e);
		}
	}
	
	public void validateMemberAccountPDF() {

	    try {

	        String downloadPath = HelperClass.getDownloadPath();

	        
	        waitForFileDownload(downloadPath, ".pdf");

	        
	        String pdfPath =
	                FileUtility.getDownloadedFilePath(
	                        downloadPath,
	                        ".pdf");

	        
	        if (pdfPath == null) {

	            HelperClass.log.error(
	                    "PDF file not found in download folder");

	            throw new AssertionError(
	                    "PDF file was not downloaded");
	        }

	        HelperClass.log.info(
	                "PDF found at : " + pdfPath);

	        
	        String pdfText = PDFUtility.readPDF(pdfPath);

	        
	        if (pdfText.length() > 300) {

	            pdfText = pdfText.substring(0, 300);
	        }

	        
	        System.out.println(pdfText);

	        HelperClass.log.info(
	                "PDF Content (First 300 chars) : \n" + pdfText);

	        
	        String expectedText =
	                "Transaction history";

	        
	        if (!pdfText.contains(expectedText)) {

	            HelperClass.log.error(
	                    "Expected text not found in PDF");

	            throw new AssertionError(
	                    "Expected text not present in first 300 characters : "
	                            + expectedText);
	        }

	        HelperClass.log.info(
	                "PDF validation successful");

	    } catch (Exception e) {

	        HelperClass.log.error(
	                "Failed to validate member account PDF : "
	                        + e.getMessage());

	        throw new RuntimeException(
	                "Unable to validate member account PDF", e);
	    }
	}


}
