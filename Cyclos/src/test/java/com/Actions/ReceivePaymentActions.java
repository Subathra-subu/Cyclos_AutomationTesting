package com.Actions;

import org.testng.Assert;
import java.util.List;
import java.util.Map;

import io.cucumber.datatable.DataTable;

import com.Pages.ReceivePaymentPage;
import com.Utilities.HelperClass;

public class ReceivePaymentActions extends BaseAction {

    ReceivePaymentPage receivePaymentPage = new ReceivePaymentPage();
    
    public void clickingLinks() {
        click(receivePaymentPage.bankingLink);
        HelperClass.log.info("Clicked Banking Menu");
        click(receivePaymentPage.receivePaymentLink);
        HelperClass.log.info("Clicked Receive Payment Menu");
    }

    public void enterDetails(String userName, String amountToUser, String descriptiontothefield) {
        sendKeys(receivePaymentPage.user, userName);
        HelperClass.log.info("Entered Username : " + userName);
        click(receivePaymentPage.userClick);
        HelperClass.log.info("Selected User From Dropdown");
        sendKeys(receivePaymentPage.amount, amountToUser);
        HelperClass.log.info("Entered Amount : " + amountToUser);
        sendKeys(receivePaymentPage.description, descriptiontothefield);
        HelperClass.log.info("Entered Description");
    }

    public void clickingNext() {
        click(receivePaymentPage.next);
        HelperClass.log.info("Clicked Next Button");
    }

    public void submit() {
        click(receivePaymentPage.confirm);
        HelperClass.log.info("Clicked Confirm Button");
    }

    public void submit(String confirmpassword) {
    	if (isDisplayed(receivePaymentPage.confirmationpass)) {
    		sendKeys(receivePaymentPage.confirmationpass, confirmpassword);
    		HelperClass.log.info("Entered Confirmation Password");
    		click(receivePaymentPage.confirm);
        	HelperClass.log.info("Clicked Confirm Button");
    	}
    }

    public void isPaymentSuccessful() {

        if (isDisplayed(receivePaymentPage.paymentconfirmation)) {
            HelperClass.log.info("Payment Confirmation Page Displayed");
            submit();
        }

        if (isDisplayed(receivePaymentPage.success)) {
            String text = getText(receivePaymentPage.success);
            Assert.assertEquals(text.trim(),"The payment was successfully processed");
            HelperClass.log.info("Payment processed successfully");
            return;
        }

        if (isDisplayed(receivePaymentPage.exceededLimit)) {
            String text = getText(receivePaymentPage.exceededLimit);
            Assert.assertEquals(text.trim(),"You have exceeded the maximum of payments per day for the demo network");
            HelperClass.log.warn("Payment Limit Exceeded");
            return;
        }

        HelperClass.log.info("Neither success nor limit message was displayed");
    }

    public boolean errorMessageDisplayed() {
        if (isDisplayed(receivePaymentPage.positiveNumberError)) {
            String text = getText(receivePaymentPage.positiveNumberError);
            Assert.assertEquals(text, "Amount must be a positive number.");
            HelperClass.log.info("Validated Positive Number Error Message");
            return true;
        }
        return false;
    }

    public boolean requiredfieldError() {
        if (isDisplayed(receivePaymentPage.requiredFieldError)) {
            String text = getText(receivePaymentPage.requiredFieldError);
            Assert.assertEquals(text, "This field is required");
            HelperClass.log.info("Validated Required Field Error Message");
            return true;
        }
        return false;
    }

    public void enterInvalidUserDetails() {
    	String rupee = "3";
        sendKeys(receivePaymentPage.amount, rupee);
        HelperClass.log.info("Entered valid Amount : " + rupee);
    }
    public void verifyExceededAmountValidationMessage() {
        try {
            waitForVisibility(receivePaymentPage.exceededAmountValidationMessage);
            String actualMessage =getText(receivePaymentPage.exceededAmountValidationMessage);
            Assert.assertTrue(actualMessage.contains("Amount must be less or equal to"),"Exceeded amount validation message not displayed");
            HelperClass.log.info("Exceeded amount validation message displayed successfully");
        }
        catch (Exception e) {
            HelperClass.log.error("Failed to validate exceeded amount message : " + e.getMessage());
            throw e;
        }
    }
    public void enterExceededPaymentDetails(DataTable dataTable) {
        try {
            List<Map<String, String>> data =dataTable.asMaps(String.class,String.class);
            for (Map<String, String> row : data) {
                String name =row.get("Name");
                String amount = row.get("Amount");
                String description = row.get("Description");
                waitForVisibility(receivePaymentPage.user);
                sendKeys(receivePaymentPage.user,name);
                click(receivePaymentPage.userClick);
                sendKeys(receivePaymentPage.amount,amount);
                sendKeys(receivePaymentPage.description,description);
                HelperClass.log.info("Entered exceeded payment details successfully");
            }
        }

        catch (Exception e) {
            HelperClass.log.error("Failed to enter exceeded payment details : " + e.getMessage());
            throw e;
        }
    }
}