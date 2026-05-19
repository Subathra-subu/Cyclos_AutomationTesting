package com.Actions;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.Pages.PaymentToUserPage;
import com.Utilities.HelperClass;

public class PaymentToUserActions extends BaseAction {

    PaymentToUserPage paymentpage = new PaymentToUserPage();

    public void clickNext() {

        try {

            waitForVisibility(paymentpage.nextBtn);

            scrollIntoView(paymentpage.nextBtn);

            jsClick(paymentpage.nextBtn);

            HelperClass.log.info(
                    "Clicked Next button successfully");

        }

        catch (Exception e) {

            HelperClass.log.error(
                    "Failed to click next button : "
                            + e.getMessage());

            throw e;
        }
    }
    public void clickPayUser() {

        try {

            waitForVisibility(paymentpage.payuser);

            scrollIntoView(paymentpage.payuser);

            jsClick(paymentpage.payuser);

            HelperClass.log.info(
                    "Clicked payment to user successfully");

        }

        catch (Exception e) {

            HelperClass.log.error(
                    "Failed to click payment to user : "
                            + e.getMessage());

            throw e;
        }
    }
    public void enterUser(String value) {

        try {

            waitForVisibility(paymentpage.userfield);

            sendKeys(paymentpage.userfield, value);

            By suggestion = By.xpath(
                    "//a[contains(text(),\"" + value + "\")]");

            waitForClickable(suggestion);

            click(suggestion);

            HelperClass.log.info(
                    "Entered user successfully : " + value);

        }

        catch (Exception e) {

            HelperClass.log.error(
                    "Failed to enter user : "
                            + e.getMessage());

            throw e;
        }
    }

    public void enterAmount(String amount) {

        try {

            waitForVisibility(paymentpage.amountField);

            sendKeys(paymentpage.amountField, amount);

            HelperClass.log.info(
                    "Entered amount successfully : "
                            + amount);

        }

        catch (Exception e) {

            HelperClass.log.error(
                    "Failed to enter amount : "
                            + e.getMessage());

            throw e;
        }
    }

    

    public void validateErrorMessage(
            String expectedMessage) {

        try {

            waitForVisibility(paymentpage.errormsg);

            String actualMessage =
                    getText(paymentpage.errormsg);

            Assert.assertEquals(
                    actualMessage.trim(),
                    expectedMessage.trim());

            HelperClass.log.info(
                    "Error message validated successfully");

        }

        catch (Exception e) {

            HelperClass.log.error(
                    "Error validation failed : "
                            + e.getMessage());

            throw e;
        }
    }

    public void validatePaymentConfirmationTitle() {

        try {

            waitForVisibility(
                    paymentpage.paymentConfirmationTitle);

            String actual =
                    getText(paymentpage.paymentConfirmationTitle);

            Assert.assertTrue(
                    actual.contains("Payment"),
                    "Expected Payment confirmation page but found : "
                            + actual);

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
    public void validateLimitExceededMessage(
            String expectedMessage) {

        try {

            String actualMessage = "";

            if (expectedMessage.contains(
                    "less or equal")) {

                waitForVisibility(
                        paymentpage.limitExceededMsg);

                actualMessage =
                        getText(paymentpage.limitExceededMsg);
            }

            else if (expectedMessage.contains(
                    "positive number")) {

                waitForVisibility(
                        paymentpage.positiveNumberMsg);

                actualMessage =
                        getText(paymentpage.positiveNumberMsg);
            }

            Assert.assertEquals(
                    actualMessage.trim(),
                    expectedMessage.trim());

            HelperClass.log.info(
                    "Limit validation successful");

        }

        catch (Exception e) {

            HelperClass.log.error(
                    "Limit validation failed : "
                            + e.getMessage());

            throw e;
        }
    }

    public void selectSchedulingType(
            String type) {

        try {

            waitForClickable(paymentpage.dropdown);

            scrollIntoView(paymentpage.dropdown);

            click(paymentpage.dropdown);

            if (type.equalsIgnoreCase(
                    "Scheduled")) {

                waitForClickable(
                        paymentpage.scheduledOption);

                click(paymentpage.scheduledOption);
            }

            else if (type.equalsIgnoreCase(
                    "Pay now")) {

                waitForClickable(
                        paymentpage.payNowOption);

                click(paymentpage.payNowOption);
            }

            else if (type.equalsIgnoreCase(
                    "Monthly installments")) {

                waitForClickable(
                        paymentpage.monthlyInstallmentOption);

                click(paymentpage.monthlyInstallmentOption);
            }

            else if (type.equalsIgnoreCase(
                    "Recurring payments")) {

                waitForClickable(
                        paymentpage.recurringPaymentOption);

                click(paymentpage.recurringPaymentOption);
            }

            HelperClass.log.info(
                    "Selected scheduling type successfully : "
                            + type);

        }

        catch (Exception e) {

            HelperClass.log.error(
                    "Failed to select scheduling type : "
                            + e.getMessage());

            throw e;
        }
    }

    public void selectFutureDate(
            String date) {

        try {

            waitForVisibility(paymentpage.futureDate);

            sendKeys(paymentpage.futureDate, date);

            HelperClass.log.info(
                    "Selected future date successfully");

        }

        catch (Exception e) {

            HelperClass.log.error(
                    "Failed to select future date : "
                            + e.getMessage());

            throw e;
        }
    }

    public void enterDescription(
            String description) {

        try {

            waitForVisibility(
                    paymentpage.descriptionField);

            sendKeys(
                    paymentpage.descriptionField,
                    description);

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

    public void enterNumberOfInstallments(
            String value) {

        try {

            waitForVisibility(
                    paymentpage.numberOfInstallments);

            sendKeys(
                    paymentpage.numberOfInstallments,
                    value);

            HelperClass.log.info(
                    "Entered installments successfully");

        }

        catch (Exception e) {

            HelperClass.log.error(
                    "Failed to enter installments : "
                            + e.getMessage());

            throw e;
        }
    }
}