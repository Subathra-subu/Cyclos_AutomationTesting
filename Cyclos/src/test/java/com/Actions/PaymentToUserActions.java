package com.Actions;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.Pages.PaymentToUserPage;
import com.Utilities.HelperClass;

public class PaymentToUserActions extends BaseAction {

    PaymentToUserPage paymentpage =
            new PaymentToUserPage();

    public void clickPayUser() {

        try {

            waitForVisibility(paymentpage.payuser);

            click(paymentpage.payuser);

            HelperClass.log.info(
                    "Clicked payment to user");

        } catch (Exception e) {

            HelperClass.log.error(
                    "Failed to click payment user : "
                            + e.getMessage());

            throw e;
        }
    }

    public void enterUser(String value) {

        try {

            waitForVisibility(paymentpage.userfield);

            sendKeys(paymentpage.userfield, value);

            By suggestion =
                    By.xpath("//a[contains(text(),'"
                            + value + "')]");

            waitForVisibility(suggestion);

            click(suggestion);

            HelperClass.log.info(
                    "Entered user : " + value);

        } catch (Exception e) {

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
                    "Entered amount : " + amount);

        } catch (Exception e) {

            HelperClass.log.error(
                    "Failed to enter amount : "
                            + e.getMessage());

            throw e;
        }
    }

    public void clickNext() {

        try {

            waitForVisibility(paymentpage.nextBtn);

            scrollIntoView(paymentpage.nextBtn);

            jsClick(paymentpage.nextBtn);

            HelperClass.log.info(
                    "Clicked next button");

        } catch (Exception e) {

            HelperClass.log.error(
                    "Failed to click next : "
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
                    "Error validated successfully");

        } catch (Exception e) {

            HelperClass.log.error(
                    "Validation failed : "
                            + e.getMessage());

            throw e;
        }
    }

    public void validatePaymentConfirmationTitle() {

        try {

            waitForVisibility(
                    paymentpage.paymentConfirmationTitle);

            String actual =
                    getText(
                            paymentpage.paymentConfirmationTitle);

            Assert.assertTrue(
                    actual.contains("Payment"));

            HelperClass.log.info(
                    "Payment confirmation validated");

        } catch (Exception e) {

            HelperClass.log.error(
                    "Payment validation failed : "
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
                        getText(
                                paymentpage.limitExceededMsg);
            }

            else if (expectedMessage.contains(
                    "positive number")) {

                waitForVisibility(
                        paymentpage.positiveNumberMsg);

                actualMessage =
                        getText(
                                paymentpage.positiveNumberMsg);
            }

            Assert.assertEquals(
                    actualMessage.trim(),
                    expectedMessage.trim());

            HelperClass.log.info(
                    "Limit validation successful");

        } catch (Exception e) {

            HelperClass.log.error(
                    "Limit validation failed : "
                            + e.getMessage());

            throw e;
        }
    }

    public void selectSchedulingType(
            String type) {

        try {

            waitForVisibility(paymentpage.dropdown);

            click(paymentpage.dropdown);

            if (type.equalsIgnoreCase(
                    "Scheduled")) {

                click(paymentpage.scheduledOption);
            }

            else if (type.equalsIgnoreCase(
                    "Pay now")) {

                click(paymentpage.payNowOption);
            }

            else if (type.equalsIgnoreCase(
                    "Monthly installments")) {

                click(
                        paymentpage.monthlyInstallmentOption);
            }

            else if (type.equalsIgnoreCase(
                    "Recurring payments")) {

                click(
                        paymentpage.recurringPaymentOption);
            }

            HelperClass.log.info(
                    "Scheduling selected : " + type);

        } catch (Exception e) {

            HelperClass.log.error(
                    "Scheduling selection failed : "
                            + e.getMessage());

            throw e;
        }
    }

    public void selectFutureDate(String date) {

        try {

            waitForVisibility(paymentpage.futureDate);

            sendKeys(paymentpage.futureDate, date);

            HelperClass.log.info(
                    "Date entered");

        } catch (Exception e) {

            HelperClass.log.error(
                    "Date selection failed : "
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
                    "Description entered");

        } catch (Exception e) {

            HelperClass.log.error(
                    "Description failed : "
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
                    "Installments entered");

        } catch (Exception e) {

            HelperClass.log.error(
                    "Installments failed : "
                            + e.getMessage());

            throw e;
        }
    }
}