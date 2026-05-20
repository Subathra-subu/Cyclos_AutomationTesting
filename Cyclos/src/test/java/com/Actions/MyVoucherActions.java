package com.Actions;

import org.testng.Assert;

import com.Pages.MyVouchersPages;
import com.Utilities.HelperClass;

public class MyVoucherActions extends BaseAction {
	MyVouchersPages myvov = new MyVouchersPages();

	public void clickMarkPlace() {
		try {
			waitForClickable(myvov.markPlace);

			click(myvov.markPlace);

			HelperClass.log.info("Clicked Marketplace successfully");
		}

		catch (Exception e) {
			HelperClass.log.error("Failed to click Marketplace: " + e.getMessage());

			throw e;
		}
	}

	public void clickVoucher()

	{
		try {
			waitForClickable(myvov.voucher);
			click(myvov.voucher);

			HelperClass.log.info("Current URL after clicking Voucher: " + HelperClass.getDriver().getCurrentUrl());
		} catch (Exception e) {
			HelperClass.log.error("Failed to click Voucher: " + e.getMessage());
			throw e;
		}
	}

	public void clickBuyVoucher() {
		try

		{

			HelperClass.log.info("Current URL before Buy Voucher: " + HelperClass.getDriver().getCurrentUrl());
			HelperClass.log.info("Page title: " + HelperClass.getDriver().getTitle());
			waitForVisibility(myvov.buyVocher);
			jsClick(myvov.buyVocher);
		} catch (Exception e) {
			HelperClass.log.error("Failed to click Buy Voucher: " + e.getMessage());
			throw e;
		}
	}

	public void clickCinema() {
		try {
			waitForClickable(myvov.cinema);

			click(myvov.cinema);

			HelperClass.log.info("Clicked Cinema voucher successfully");
		}

		catch (Exception e) {
			HelperClass.log.error("Failed to click Cinema voucher: " + e.getMessage());

			throw e;
		}
	}

	public void amountAndNumber(String number, String amount) {
		try {
			sendKeys(myvov.number, number);

			sendKeys(myvov.amount, amount);

			HelperClass.log.info("Entered mobile number and amount successfully");
		}

		catch (Exception e) {
			HelperClass.log.error("Failed to enter mobile number and amount: " + e.getMessage());

			throw e;
		}
	}

	public void next() {
		try {
			waitForClickable(myvov.next);

			click(myvov.next);

			HelperClass.log.info("Clicked Next button successfully");
		}

		catch (Exception e) {
			HelperClass.log.error("Failed to click Next button: " + e.getMessage());

			throw e;
		}
	}

	public void confirm() {
		try {
			waitForClickable(myvov.confirm);

			click(myvov.confirm);

			HelperClass.log.info("Clicked Confirm button successfully");
		}

		catch (Exception e) {
			HelperClass.log.error("Failed to click Confirm button: " + e.getMessage());

			throw e;
		}
	}

	public void assertion(String expected) {
		try {
			waitForVisibility(myvov.assertPopUp);

			String actual = getText(myvov.assertPopUp);

			Assert.assertEquals(actual, expected);

			HelperClass.log.info("Voucher assertion successful");
		}

		catch (Exception e) {
			HelperClass.log.error("Voucher assertion failed: " + e.getMessage());

			throw e;
		}
	}

	public void isAlertAssert() {
		try {
			String expectedPartial = "The current user exceeds the maximum allowed open amount";

			waitForVisibility(myvov.assertAlert);

			String actual = getText(myvov.assertAlert);

			Assert.assertTrue(actual.contains(expectedPartial), "Alert message mismatch. Actual: " + actual);

			HelperClass.log.info("Alert assertion successful. Message: " + actual);

		} catch (Exception e) {
			HelperClass.log.error("Alert assertion failed: " + e.getMessage());
			throw e;
		}
	}
	
	public void clickGift()
	{
		try {
			waitForClickable(myvov.gift);

			click(myvov.gift);

			HelperClass.log.info("Clicked GIFT voucher successfully");
		}

		catch (Exception e) {
			HelperClass.log.error("Failed to GIFT Cinema voucher: " + e.getMessage());

			throw e;
		}
	}

	public void clickrestaurant()
	{
		try {
			waitForClickable(myvov.restaurant);

			click(myvov.restaurant);

			HelperClass.log.info("Clicked GIFT voucher successfully");
		}

		catch (Exception e) {
			HelperClass.log.error("Failed to GIFT Cinema voucher: " + e.getMessage());

			throw e;
		}
	}
	public boolean isDisplayedAlert() {
		try {
			boolean status = isDisplayed(myvov.assertAlert);

			HelperClass.log.info("Alert visibility status: " + status);

			return status;
		}

		catch (Exception e) {
			HelperClass.log.error("Failed to check alert visibility: " + e.getMessage());

			return false;
		}
	}

}