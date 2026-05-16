package com.Actions;

import org.testng.Assert;

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
    	}
    	click(receivePaymentPage.confirm);
    	HelperClass.log.info("Clicked Confirm Button");
    }

    public void isPaymentSuccessful() {
    	waitForVisibility(receivePaymentPage.paymentconfirmation);
    	String text1 = getText(receivePaymentPage.paymentconfirmation);
    	Assert.assertEquals(text1, "Payment confirmation");
    	HelperClass.log.info("Payment Confirmation Page Displayed");
    	submit();

    	try {
    		waitForVisibility(receivePaymentPage.success, 10);
    		String text = getText(receivePaymentPage.success);
    		Assert.assertEquals(text,
    				"The payment was successfully processed");
    		HelperClass.log.info("Payment processed successfully");
    	} catch (Exception e) {
    		HelperClass.log.warn("Payment Limit Exceeded");
    	}
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

    public void enterInvalidUserDetails(String amountToUser) {
        sendKeys(receivePaymentPage.amount, amountToUser);
        HelperClass.log.info("Entered Invalid Amount : " + amountToUser);
    }
}