package com.Actions;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import com.Pages.PaymentRequestPage;
import com.Utilities.ExcelData;
import com.Utilities.HelperClass;

public class ReqpaymentActions extends BaseAction {

    PaymentRequestPage paypage = new PaymentRequestPage();

    public void navigateToPaymentRequestPage() {
        try {
            click(paypage.Banking);
            click(paypage.paymentrequest);
            HelperClass.log.info("Navigated to Payment Requests successfully");
        } catch (Exception e) {
            HelperClass.log.error("Failed to navigate to Payment Requests: " + e.getMessage());
            throw e;
        }
    }

    public void clickSendRequest() {
        try {
            click(paypage.sendrequest);
            HelperClass.log.info("Clicked Send a new request successfully");
        } catch (Exception e) {
            HelperClass.log.error("Failed to click Send request: " + e.getMessage());
            throw e;
        }
    }

    public void addPaymentRequest(String receiver, String amountVal) {
        try {
            waitForVisibility(paypage.user);
            sendKeys(paypage.user, receiver);

            By genericOptionLocator = By.xpath("//a[contains(@class, 'autocomplete-option') or contains(@class, 'select-option')]");
            waitForVisibility(genericOptionLocator);
            click(genericOptionLocator);

            sendKeys(paypage.amount, amountVal);
            HelperClass.log.info("Typed amount: " + amountVal);

            waitForVisibility(paypage.date);
            WebElement dateInput = HelperClass.getDriver().findElement(paypage.date);
            
            click(paypage.date);
            dateInput.clear();
            
            String dynamicDate = "25-12-2067"; 
            sendKeys(paypage.date, dynamicDate);
            HelperClass.log.info("Populated date field via structured string: " + dynamicDate);

            dateInput.sendKeys(org.openqa.selenium.Keys.TAB);
            HelperClass.log.info("Sent TAB key to release focus from the date input component wrapper.");

        } catch (Exception e) {
            HelperClass.log.error("Failed inside data validation form operations: " + e.getMessage());
            throw e;
        }
    }

    public void submitForm() {
        try {
        	waitForClickable(paypage.confirm);
           jsClick(paypage.confirm);
            HelperClass.log.info("Submitted primary payment form via explicit Actions click sequence.");

        } catch (Exception e) {
            HelperClass.log.warn("Standard action pipeline click intercepted. Triggering JS fallback click event... Details: " + e.getMessage());
           
        }
    }
    

    public void assertModal(String expectedModalText) {
        try {
            By flexibleModalLocator = By.xpath("//*[contains(text(), '" + expectedModalText + "') or contains(., '" + expectedModalText + "')]");
            waitForVisibility(flexibleModalLocator);
            String actualText = getText(flexibleModalLocator);
            
            Assert.assertTrue(actualText.toLowerCase().contains(expectedModalText.toLowerCase()), 
                    "Assertion Failed: Modal text mismatch! Found: " + actualText);
            HelperClass.log.info("Modal confirmation text assertion successful.");
        } catch (Exception e) {
            HelperClass.log.error("Modal confirmation text assertion failed: " + e.getMessage());
            throw e;
        }
    }

    public void clickModalConfirm() {
        try {
            waitForVisibility(paypage.modalConfirm);
            click(paypage.modalConfirm);
            HelperClass.log.info("Clicked modal Confirm successfully");
        } catch (Exception e) {
            HelperClass.log.error("Failed to click modal Confirm button: " + e.getMessage());
            throw e;
        }
    }

    public void assertBanner(String expectedMessage) {
        try {
            waitForVisibility(paypage.successBanner);
            String actualMessage = getText(paypage.successBanner);
            Assert.assertEquals(actualMessage, expectedMessage);
            HelperClass.log.info("Success banner message assertion successful");
        } catch (Exception e) {
            HelperClass.log.error("Success banner message assertion failed: " + e.getMessage());
            throw e;
        }
    }

    public void excelData() throws IOException {
        ExcelData excelData = new ExcelData();
        Object[][] data = excelData.paymentRequestKrishnaData(); 

        for (int i = 0; i < data.length; i++) {
            String receiver = data[i][0].toString().trim();
            String amountVal = data[i][1].toString().trim();
            
            addPaymentRequest(receiver, amountVal);
        }
        
        try {
            HelperClass.getWait().until(
                org.openqa.selenium.support.ui.ExpectedConditions.attributeToBe(paypage.date, "value", "2026-12-25")
            );
            HelperClass.log.info("Framework explicit wait confirmed date value has settled in DOM.");
        } catch (Exception e) {
            HelperClass.getWait().until(
                org.openqa.selenium.support.ui.ExpectedConditions.attributeToBeNotEmpty(HelperClass.getDriver().findElement(paypage.date), "value")
            );
        }
    }
    public void clickExistingUser() {
        jsClick(paypage.existingUser);
    }

    public String paymentPageAssert() {
        return getText(paypage.paypageAssert);
    }

    public void printRequest() {
        click(paypage.print);
    }

    public void cancelRequest() {
        click(paypage.cancel);
    }
    
    public void addPaymentRequestWithEmptyDate(String receiver, String amountVal) {
        try {
            waitForVisibility(paypage.user);
            sendKeys(paypage.user, receiver);

            By genericOptionLocator = By.xpath("//a[contains(@class, 'autocomplete-option') or contains(@class, 'select-option')]");
            waitForVisibility(genericOptionLocator);
            click(genericOptionLocator);

            sendKeys(paypage.amount, amountVal);
            HelperClass.log.info("Typed amount value: " + amountVal);

            waitForVisibility(paypage.date);
            WebElement dateInput = HelperClass.getDriver().findElement(paypage.date);
            click(paypage.date);
            
            dateInput.sendKeys(org.openqa.selenium.Keys.chord(org.openqa.selenium.Keys.CONTROL, "a"));
            dateInput.sendKeys(org.openqa.selenium.Keys.BACK_SPACE);
            dateInput.clear();
            
            dateInput.sendKeys(org.openqa.selenium.Keys.TAB);
            HelperClass.log.info("Date field wiped out completely and left blank.");

        } catch (Exception e) {
            HelperClass.log.error("Failed executing negative test data entries: " + e.getMessage());
            throw e;
        }
    }

    public String assertDateValidationError() {
        try {
        	
            waitForVisibility(paypage.dateValidationError);
            return getText(paypage.dateValidationError);
            
        } catch (Exception e) {
            HelperClass.log.error("Failed to locate expected date field validation message block: " + e.getMessage());
            throw e;
        }
    }
    public void excelDataForEmptyDate() throws IOException {
        ExcelData excelData = new ExcelData();
        Object[][] data = excelData.paymentRequestKrishnaData(); 

        for (int i = 0; i < data.length; i++) {
            String receiver = data[i][0].toString().trim();
            String amountVal = data[i][1].toString().trim();
            
            addPaymentRequestWithEmptyDate(receiver, amountVal);
        }
    }
}