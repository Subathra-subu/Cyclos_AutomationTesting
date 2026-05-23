package com.Actions;

import org.testng.Assert;

import com.Pages.MyVouchersPages;
import com.Utilities.HelperClass;

public class MyVoucherActions extends BaseAction {

    MyVouchersPages p = new MyVouchersPages();

    public void clickMarkPlace() {
        try {
            waitForPageLoad();
            waitForClickable(p.markPlace);
            click(p.markPlace);
            HelperClass.log.info("Marketplace clicked");
        } catch (Exception e) {
            HelperClass.log.error("Failed to click Marketplace: {}", e.getMessage());
            throw e;
        }
    }

    public void clickVoucher() {
        try {
            waitForPageLoad();
            waitForClickable(p.voucher);
            click(p.voucher);
            HelperClass.log.info("Voucher menu clicked");
        } catch (Exception e) {
            HelperClass.log.error("Failed to click Voucher: {}", e.getMessage());
            throw e;
        }
    }

    public void clickBuyVoucher() {
        try {
            waitForPageLoad();
            waitForVisibility(p.buyVocher);
            jsClick(p.buyVocher);
            HelperClass.log.info("Buy Voucher button clicked");
        } catch (Exception e) {
            HelperClass.log.error("Failed to click Buy Voucher: {}", e.getMessage());
            throw e;
        }
    }

    public void clickCinema() {
        try {
            waitForPageLoad();
            waitForClickable(p.cinema);
            click(p.cinema);
            HelperClass.log.info("Cinema voucher clicked");
        } catch (Exception e) {
            HelperClass.log.error("Failed to click Cinema: {}", e.getMessage());
            throw e;
        }
    }

    public void clickGift() {
        try {
            waitForPageLoad();
            waitForClickable(p.gift);
            click(p.gift);
            HelperClass.log.info("Gift voucher clicked");
        } catch (Exception e) {
            HelperClass.log.error("Failed to click Gift: {}", e.getMessage());
            throw e;
        }
    }

    public void clickrestaurant() {
        try {
            waitForPageLoad();
            waitForClickable(p.restaurant);
            click(p.restaurant);
            HelperClass.log.info("Restaurant voucher clicked");
        } catch (Exception e) {
            HelperClass.log.error("Failed to click Restaurant: {}", e.getMessage());
            throw e;
        }
    }

    public void amountAndNumber(String number, String amount) {
        try {
            sendKeys(p.number, number);
            sendKeys(p.amount, amount);
            HelperClass.log.info("Entered number: {} amount: {}", number, amount);
        } catch (Exception e) {
            HelperClass.log.error("Failed to enter amount/number: {}", e.getMessage());
            throw e;
        }
    }

    public void next() {
        try {
            waitForPageLoad();
            waitForClickable(p.next);
            click(p.next);
            HelperClass.log.info("Next clicked");
        } catch (Exception e) {
            HelperClass.log.error("Failed to click Next: {}", e.getMessage());
            throw e;
        }
    }

    public void confirm() {
        try {
            waitForPageLoad();
            waitForClickable(p.confirm);
            click(p.confirm);
            HelperClass.log.info("Confirm clicked");
        } catch (Exception e) {
            HelperClass.log.error("Failed to click Confirm: {}", e.getMessage());
            throw e;
        }
    }

    public void assertion(String expected) {
        try {
            waitForVisibility(p.assertPopUp);
            String actual = getText(p.assertPopUp);
            Assert.assertEquals(actual, expected,
                    "Voucher assertion failed. Expected: " + expected + " Actual: " + actual);
            HelperClass.log.info("Voucher assertion passed: {}", actual);
        } catch (Exception e) {
            HelperClass.log.error("assertion failed: {}", e.getMessage());
            throw e;
        }
    }

    public void isAlertAssert() {
        try {
            waitForVisibility(p.assertAlert);
            String actual = getText(p.assertAlert);
            Assert.assertTrue(actual.contains("The current user exceeds the maximum allowed open amount"),
                    "Alert message mismatch. Actual: " + actual);
            HelperClass.log.info("Alert assertion passed: {}", actual);
        } catch (Exception e) {
            HelperClass.log.error("isAlertAssert failed: {}", e.getMessage());
            throw e;
        }
    }

    public boolean isDisplayedAlert() {
        return isDisplayed(p.assertAlert, 3);
    }

    public void enterVoucherCode(String code) {
        try {
            waitForVisibility(p.voucherCode);
            highlightElement(p.voucherCode);
            sendKeys(p.voucherCode, code);
            HelperClass.log.info("Voucher code entered: {}", code);
        } catch (Exception e) {
            HelperClass.log.error("Failed to enter voucher code: {}", e.getMessage());
            throw e;
        }
    }

    public void AssertResult() {
        try {
            waitForVisibility(p.result);
            Assert.assertTrue(isDisplayed(p.result), "Result not displayed for voucher code");
            HelperClass.log.info("Result verified for voucher code");
        } catch (Exception e) {
            HelperClass.log.error("AssertResult failed: {}", e.getMessage());
            throw e;
        }
    }
}
