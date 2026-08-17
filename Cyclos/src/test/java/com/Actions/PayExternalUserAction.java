package com.Actions;

import org.testng.Assert;

import com.Pages.PayExternalUserPage;
import com.Utilities.HelperClass;

public class PayExternalUserAction extends BaseAction {

    PayExternalUserPage page =
            new PayExternalUserPage();

    public void clickPayUser() {

        try {

            waitForVisibility(page.payUser);

            scrollIntoView(page.payUser);

            jsClick(page.payUser);

            HelperClass.log.info(
                "Clicked pay user successfully");

        }

        catch (Exception e) {

            HelperClass.log.error(
                "Failed to click pay user : "
                + e.getMessage());

            throw e;
        }
    }

    public void clickExternalPayments() {

        try {

            waitForVisibility(page.externalPayments);

            scrollIntoView(page.externalPayments);

            jsClick(page.externalPayments);

            HelperClass.log.info(
                "Clicked external payments successfully");

        }

        catch (Exception e) {

            HelperClass.log.error(
                "Failed to click external payments : "
                + e.getMessage());

            throw e;
        }
    }

    public void clickPayExternalUser() {

        try {

            waitForVisibility(page.payExternalUser);

            scrollIntoView(page.payExternalUser);

            jsClick(page.payExternalUser);

            HelperClass.log.info(
                "Clicked pay external user successfully");

        }

        catch (Exception e) {

            HelperClass.log.error(
                "Failed to click pay external user : "
                + e.getMessage());

            throw e;
        }
    }

    public void enterEmail(String email) {

        try {

            waitForVisibility(page.emailField);

            sendKeys(page.emailField, email);

            HelperClass.log.info(
                "Entered email successfully");

        }

        catch (Exception e) {

            HelperClass.log.error(
                "Failed to enter email : "
                + e.getMessage());

            throw e;
        }
    }

    public void enterAmount(String amount) {

        try {

            waitForVisibility(page.amountField);

            sendKeys(page.amountField, amount);

            HelperClass.log.info(
                "Entered amount successfully");

        }

        catch (Exception e) {

            HelperClass.log.error(
                "Failed to enter amount : "
                + e.getMessage());

            throw e;
        }
    }

    public void enterDescription(String description) {

        try {

            waitForVisibility(page.descriptionField);

            sendKeys(page.descriptionField, description);

            HelperClass.log.info(
                "Entered description successfully");

        }

        catch (Exception e) {

            HelperClass.log.error(
                "Failed to enter description : "
                + e.getMessage());

            throw e;
        }
    }

    public void clickNext() {

        try {

            waitForVisibility(page.nextBtn);

            scrollIntoView(page.nextBtn);

            jsClick(page.nextBtn);

            HelperClass.log.info(
                "Clicked next button successfully");

        }

        catch (Exception e) {

            HelperClass.log.error(
                "Failed to click next button : "
                + e.getMessage());

            throw e;
        }
    }

    public void validatePaymentConfirmationPage() {

        try {

            waitForVisibility(
                page.paymentConfirmationTitle);

            String actual =
                getText(page.paymentConfirmationTitle);

            Assert.assertTrue(
                actual.contains(
                    "Payment confirmation"));

            HelperClass.log.info(
                "Payment confirmation validated successfully");

        }

        catch (Exception e) {

            HelperClass.log.error(
                "Payment confirmation validation failed : "
                + e.getMessage());

            throw e;
        }
    }

    public void clickConfirm() {

        try {

            waitForVisibility(page.confirmBtn);

            scrollIntoView(page.confirmBtn);

            jsClick(page.confirmBtn);

            HelperClass.log.info(
                "Clicked confirm button successfully");

        }

        catch (Exception e) {

            HelperClass.log.error(
                "Failed to click confirm button : "
                + e.getMessage());

            throw e;
        }
    }

    public void validateSuccessMessage() {

        try {

            waitForVisibility(page.successMessage);

            String actual =
                getText(page.successMessage);

            Assert.assertTrue(
                actual.contains(
                    "successfully performed"));

            HelperClass.log.info(
                "Success message validated successfully");

        }

        catch (Exception e) {

            HelperClass.log.error(
                "Success validation failed : "
                + e.getMessage());

            throw e;
        }
    }

    public void validatePendingStatus() {

        try {

            waitForVisibility(page.pendingStatus);

            String actual =
                getText(page.pendingStatus);

            Assert.assertEquals(
                actual,
                "Pending");

            HelperClass.log.info(
                "Pending status validated successfully");

        }

        catch (Exception e) {

            HelperClass.log.error(
                "Pending validation failed : "
                + e.getMessage());

            throw e;
        }
    }

    public void validateEmailErrorMessage(
            String expectedMessage) {

        try {

            waitForVisibility(
                page.emailErrorMessage);

            String actualMessage =
                getText(page.emailErrorMessage);

            Assert.assertEquals(
                actualMessage.trim(),
                expectedMessage.trim());

            HelperClass.log.info(
                "Email error validated successfully");

        }

        catch (Exception e) {

            HelperClass.log.error(
                "Email validation failed : "
                + e.getMessage());

            throw e;
        }
    }
    public void openPayment(String description) {

        waitForVisibility(page.payment(description));

        scrollIntoView(page.payment(description));

        jsClick(page.payment(description));
    }
    public void clickCancelPayment() {

        try {

            waitForVisibility(page.cancelPaymentBtn);

            scrollIntoView(page.cancelPaymentBtn);

            jsClick(page.cancelPaymentBtn);

            HelperClass.log.info("Clicked cancel payment button successfully");

        } catch (Exception e) {

            HelperClass.log.error("Failed to click cancel payment button : " + e.getMessage());

            throw e;
        }
    }
    public void enterCancellationComment(String comment) {

        try {

            waitForVisibility(page.cancellationComment);

            sendKeys(page.cancellationComment, comment);

            HelperClass.log.info("Entered cancellation comment successfully");

        } catch (Exception e) {

            HelperClass.log.error("Failed to enter cancellation comment : " + e.getMessage());

            throw e;
        }
    }
    public void clickConfirmCancellation() {

        try {

            waitForVisibility(page.confirmCancelBtn);

            scrollIntoView(page.confirmCancelBtn);

            jsClick(page.confirmCancelBtn);

            HelperClass.log.info("Clicked confirm cancellation successfully");

        } catch (Exception e) {

            HelperClass.log.error("Failed to confirm cancellation : " + e.getMessage());

            throw e;
        }
    }
    public void validateCancellationSuccess() {

        try {

            waitForVisibility(page.cancelledMessage);

            String actual = getText(page.cancelledMessage);

            Assert.assertTrue(actual.contains("cancel"));

            HelperClass.log.info("Cancellation validated successfully");

        } catch (Exception e) {

            HelperClass.log.error("Cancellation validation failed : " + e.getMessage());

            throw e;
        }
    }
    
    public void validateInvalidEmailErrorMessage() {

        try {

            waitForVisibility(page.invalidEmailErrorMessage);

            String actualMessage =getText(page.invalidEmailErrorMessage);

            Assert.assertEquals(actualMessage.trim(),"Destination user identifier is invalid.");

            HelperClass.log.info("Invalid email error validated successfully");

        } catch (Exception e) {

            HelperClass.log.error("Invalid email error validation failed : "+ e.getMessage());

            throw e;
        }
    }
    public void validateAmountErrorMessage(String expectedMessage) {

        try {

            clickNext();

            waitForVisibility(page.amountErrorMessage);

            String actualMessage = getText(page.amountErrorMessage);

            Assert.assertEquals(
                actualMessage.trim(),
                expectedMessage.trim());

            HelperClass.log.info(
                "Amount error validated successfully: " + actualMessage);

        } catch (Exception e) {

            HelperClass.log.error(
                "Amount validation failed : " + e.getMessage());

            throw e;
        }
    }
    
}