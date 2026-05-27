package com.Actions;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.Pages.memberAccountPage;
import com.Utilities.ExcelUtilities;
import com.Utilities.FileUtility;
import com.Utilities.HelperClass;
import com.Utilities.PDFUtility;
import java.io.BufferedReader;
import java.io.FileReader;

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
	
	public void clickCsvOption() {
		try {
			waitForClickable(mPage.csvOption);
			click(mPage.csvOption);
			HelperClass.log.info("Csv option clicked successfully");
		} catch (Exception e) {
			HelperClass.log.error("Failed to click Csv option : " + e.getMessage());
			throw new RuntimeException("Unable to click Csv option", e);
		}
	}
	
	public void clickexcelOption() {
		try {
			waitForClickable(mPage.execOption);
			click(mPage.execOption);
			HelperClass.log.info("Csv option clicked successfully");
		} catch (Exception e) {
			HelperClass.log.error("Failed to click Csv option : " + e.getMessage());
			throw new RuntimeException("Unable to click Csv option", e);
		}
	}
	
	
	public void validateMemberAccountCSV() {

	    try {

	        String downloadPath =
	                HelperClass.getDownloadPath();

	        waitForFileDownload(
	                downloadPath,
	                ".csv");

	        String csvPath =
	                FileUtility.getDownloadedFilePath(
	                        downloadPath,
	                        ".csv");

	        if (csvPath == null) {

	            HelperClass.log.error(
	                    "CSV file not found");

	            throw new AssertionError(
	                    "CSV file was not downloaded");
	        }

	        HelperClass.log.info(
	                "CSV file found at : " + csvPath);

	        BufferedReader br =
	                new BufferedReader(
	                        new FileReader(csvPath));

	        String firstLine =
	                br.readLine();

	        br.close();

	        if (firstLine == null ||
	                !firstLine.contains("transactionNumber")) {

	            HelperClass.log.error(
	                    "transactionNumber not found in first cell");

	            throw new AssertionError(
	                    "transactionNumber not present in CSV file");
	        }

	        HelperClass.log.info(
	                "CSV validation successful");

	    } catch (Exception e) {

	        HelperClass.log.error(
	                "Failed to validate CSV file : "
	                        + e.getMessage());

	        throw new RuntimeException(
	                "Unable to validate CSV file", e);
	    }
	}
	@SuppressWarnings("resource")
	public void validateMemberAccountExcel() {

	    try {

	        String downloadPath =
	                HelperClass.getDownloadPath();

	        waitForFileDownload(
	                downloadPath,
	                ".xlsx");

	        String excelPath =
	                FileUtility.getDownloadedFilePath(
	                        downloadPath,
	                        ".xlsx");

	        if (excelPath == null) {

	            HelperClass.log.error(
	                    "Excel file not found");

	            throw new AssertionError(
	                    "Excel file was not downloaded");
	        }

	        HelperClass.log.info(
	                "Excel file found at : " + excelPath);

	        FileInputStream fis =
	                new FileInputStream(excelPath);

	        XSSFWorkbook workbook =
	                new XSSFWorkbook(fis);

	        XSSFSheet sheet =
	                workbook.getSheetAt(0);

	        XSSFRow row =
	                sheet.getRow(0);

	        XSSFCell cell =
	                row.getCell(1);

	        String excelData =
	                cell.toString();

	        String expectedText =
	                "Transaction number";

	        if (!excelData.contains(expectedText)) {

	            HelperClass.log.error(
	                    "Expected text not found in Excel file");

	            throw new AssertionError(
	                    "Expected text not present in Excel file : "
	                            + expectedText);
	        }

	        workbook.close();

	        fis.close();

	        HelperClass.log.info(
	                "Excel validation successful");

	    } catch (Exception e) {

	        HelperClass.log.error(
	                "Failed to validate Excel file : "
	                        + e.getMessage());

	        throw new RuntimeException(
	                "Unable to validate Excel file", e);
	    }
	}
	public void validateMemberAccountPDF() {

	    try {

	        String downloadPath =
	                HelperClass.getDownloadPath();

	        waitForFileDownload(
	                downloadPath,
	                ".pdf");

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

	        String pdfText =
	                PDFUtility.readPDF(pdfPath);

	        System.out.println(pdfText);

	        HelperClass.log.info(
	                "PDF Content : \n" + pdfText);

	        String expectedText =
	                "Transaction history";

	        if (!pdfText.contains(expectedText)) {

	            HelperClass.log.error(
	                    "Expected text not found in PDF");

	            throw new AssertionError(
	                    "Expected text not present in PDF : "
	                            + expectedText);
	        }

	        HelperClass.log.info(
	                "PDF validation successful");

	    } catch (Exception e) {

	        HelperClass.log.error(
	                "Failed to validate member account PDF : "
	                        + e.getMessage());

	        throw new RuntimeException(
	                "Unable to validate member account PDF",
	                e);
	    }
	}


}
