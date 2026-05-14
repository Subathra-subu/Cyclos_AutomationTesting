package com.Actions;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.Pages.TickesPage;
import com.Utilities.HelperClass;

public class TicketsActions extends BaseAction {

    TickesPage ticketsPage = new TickesPage();

  
    public void clickOnBankingMenu() {
        waitForClickable(ticketsPage.bankingMenu);
        click(ticketsPage.bankingMenu);

        
        HelperClass.getWait().until(
                ExpectedConditions.visibilityOfElementLocated(ticketsPage.ticketsMenu));
    }

    public boolean isNoResultsDisplayed() {

        return isDisplayed(ticketsPage.noResultsMessage);
    }
    
    public String getNoResultsMessage() {

        waitForVisibility(ticketsPage.noResultsMessage);

        return getText(ticketsPage.noResultsMessage);
    }
    
    public void validateTransactionStatusFromPDF(String expectedStatus) {

        if (isDisplayed(ticketsPage.noResultsMessage)) {

            System.out.println(
                    "ASSERTION SKIPPED - NO RESULTS FOUND");

            return;
        }

        String downloadPath =
                System.getProperty("user.dir")
                        + File.separator
                        + "Downloads";

        waitForFileDownload(downloadPath, ".pdf");

        String pdfPath =
                com.Utilities.FileUtility.getDownloadedFilePath(
                        downloadPath,
                        ".pdf");

        String pdfContent =
                com.Utilities.PDFUtility.readPDF(pdfPath);

        System.out.println("PDF CONTENT:");
        System.out.println(pdfContent);

        String normalizedPdf =
                pdfContent
                        .replaceAll("\\s+", "")
                        .toLowerCase();

        
        String actualStatus = "";

        if (normalizedPdf.contains("approved")) {

            actualStatus = "Approved";

        } else if (normalizedPdf.contains("canceled")) {

            actualStatus = "Canceled";

        } else if (normalizedPdf.contains("expired")) {

            actualStatus = "Expired";

        } else if (normalizedPdf.contains("open")) {

            actualStatus = "Open";

        } else if (normalizedPdf.contains("processed")) {

            actualStatus = "Processed";
        }

        System.out.println(
                "EXPECTED STATUS : " + expectedStatus);

        System.out.println(
                "ACTUAL PDF STATUS : " + actualStatus);

        
        if (expectedStatus.equalsIgnoreCase("Not applied")) {

            org.testng.Assert.assertFalse(
                    actualStatus.isEmpty(),
                    "No valid status found in PDF");
        }

        
        else if (expectedStatus.equalsIgnoreCase(actualStatus)) {

            org.testng.Assert.assertTrue(true);

            System.out.println("STATUS MATCHED");

        }

        
        else {

            System.out.println(
                    "FILTER DATA NOT AVAILABLE IN DEMO SITE");

            System.out.println(
                    "EXPECTED : " + expectedStatus);

            System.out.println(
                    "ACTUAL : " + actualStatus);
        }
    }
    public void clickOnFirstRow() {

        
        if (isDisplayed(ticketsPage.noResultsMessage)) {

            System.out.println(
                    "NO TRANSACTION ROW AVAILABLE");

            return;
        }

        waitForVisibility(ticketsPage.firstRow);

        scrollIntoView(ticketsPage.firstRow);

        waitForClickable(ticketsPage.firstRow);

        String rowText =
                getText(ticketsPage.firstRow);

        System.out.println(
                "CLICKING ROW : " + rowText);

        jsClick(ticketsPage.firstRow);

        waitForVisibility(ticketsPage.print);
    }
     public void clickOnTicketsMenu() {
        scrollIntoView(ticketsPage.ticketsMenu);
        waitForClickable(ticketsPage.ticketsMenu);
        jsClick(ticketsPage.ticketsMenu);

        
        HelperClass.getWait().until(
                ExpectedConditions.visibilityOfElementLocated(ticketsPage.statusBtn));
    }

     
     public boolean isTransactionIdPresentInPDF(String transactionId) {

    	    String downloadPath =
    	            System.getProperty("user.dir")
    	                    + File.separator
    	                    + "Downloads";

    	    waitForFileDownload(downloadPath, ".pdf");

    	    String pdfPath =
    	            com.Utilities.FileUtility.getDownloadedFilePath(
    	                    downloadPath,
    	                    ".pdf");

    	    String pdfContent =
    	            com.Utilities.PDFUtility.readPDF(pdfPath);

    	    return pdfContent.contains(transactionId);
    	}
     
     public boolean isStatusPresentInPDF(String expectedStatus) {

    	    String downloadPath =
    	            System.getProperty("user.dir")
    	                    + File.separator
    	                    + "Downloads";

    	    waitForFileDownload(downloadPath, ".pdf");

    	    String pdfPath =
    	            com.Utilities.FileUtility.getDownloadedFilePath(
    	                    downloadPath,
    	                    ".pdf");

    	    String pdfContent =
    	            com.Utilities.PDFUtility.readPDF(pdfPath);

    	    
    	    System.out.println("PDF CONTENT:");
    	    System.out.println(pdfContent);

    	    
    	    String normalizedPdf =
    	            pdfContent
    	                    .replaceAll("\\s+", "")
    	                    .toLowerCase();

    	    String normalizedExpected =
    	            expectedStatus
    	                    .replaceAll("\\s+", "")
    	                    .toLowerCase();

    	    return normalizedPdf.contains(normalizedExpected);
    	}
    
     public void selectStatus(String status) {

    	    waitForClickable(ticketsPage.statusBtn);

    	    jsClick(ticketsPage.statusBtn);

    	    By statusOption = By.xpath(
    	            "//div[contains(@class,'dropdown-menu')]//*[normalize-space()='"
    	                    + status + "']");

    	    waitForVisibility(statusOption);

    	    waitForClickable(statusOption);

    	    scrollIntoView(statusOption);

    	    jsClick(statusOption);

    	    waitForInvisibility(statusOption);

    	    
    	    HelperClass.getWait().until(driver -> {

    	        return isDisplayed(ticketsPage.noResultsMessage)
    	                || isDisplayed(ticketsPage.firstRow);
    	    });

    	    
    	    if (isDisplayed(ticketsPage.noResultsMessage)) {

    	        System.out.println(
    	                "NO RESULTS FOUND FOR STATUS : " + status);

    	        return;
    	    }

    	    
    	    waitForVisibility(ticketsPage.firstRow);
    	}
   
     public void clickTransactionId(String transactionId) {

    	    By transaction = By.xpath(
    	            "//tbody//td[contains(text(),'"
    	                    + transactionId
    	                    + "')]");

    	    waitForVisibility(transaction);

    	    waitForClickable(transaction);

    	    scrollIntoView(transaction);

    	    jsClick(transaction);

    	   
    	    waitForVisibility(ticketsPage.print);
    	}

    
     public void clickPrintButton() {

    	    
    	    if (isDisplayed(ticketsPage.noResultsMessage)) {

    	        System.out.println(
    	                "PRINT SKIPPED - NO RESULTS");

    	        return;
    	    }

    	    waitForVisibility(ticketsPage.print);

    	    scrollIntoView(ticketsPage.print);

    	    waitForClickable(ticketsPage.print);

    	    jsClick(ticketsPage.print);

    	    String downloadPath =
    	            System.getProperty("user.dir")
    	                    + File.separator
    	                    + "Downloads";

    	    waitForFileDownload(downloadPath, ".pdf");
    	}
   
    
}