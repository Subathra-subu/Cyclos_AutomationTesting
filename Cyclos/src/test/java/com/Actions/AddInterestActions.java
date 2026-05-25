package com.Actions;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Pages.AddIntrestPage;
import com.Utilities.ExcelData;
import com.Utilities.HelperClass;

import io.cucumber.datatable.DataTable;

public class AddInterestActions extends BaseAction {

	AddIntrestPage addInterst = new AddIntrestPage();

	public void assertNoresult()

	{
		try {
			String expect = "No results match the search criteria";

			String actual = getText(addInterst.noResult);

			Assert.assertEquals(expect, actual);

			HelperClass.log.info("No result assert SucessFull");

		} catch (Exception e) {

			HelperClass.log.error("assertion failed: " + e.getMessage());

			throw e;
		}

	}

	public void addNew() {

		try {

			waitForVisibility(addInterst.addNew);

			waitForClickable(addInterst.addNew);

			jsClick(addInterst.addNew);

			HelperClass.log.info("Clicked Add New button successfully");

		} catch (Exception e) {

			HelperClass.log.error("Failed to click Add New button: " + e.getMessage());

			throw e;
		}
	}

	public void assertDel() {

		try {

			waitForVisibility(addInterst.successToast);

			String actualMessage = getText(addInterst.successToast);

			HelperClass.log.info("Toast Message: " + actualMessage);

			Assert.assertTrue(actualMessage.contains("was removed"));

			HelperClass.log.info("Delete assertion successful");

		} catch (Exception e) {

			HelperClass.log.error("Delete assertion failed: " + e.getMessage());

			throw e;
		}
	}
	
	public void assertuniqe() {

		try {

			waitForVisibility(addInterst.unique);

			String actualMessage = getText(addInterst.unique);

			HelperClass.log.info("Toast Message: " + actualMessage);

			Assert.assertTrue(actualMessage.contains("unique"));

			HelperClass.log.info("unique assertion successful");

		} catch (Exception e) {

			HelperClass.log.error("unique assertion failed: " + e.getMessage());

			throw e;
		}
	}


	public void clickMarketPlace() {

		try {

			click(addInterst.marketPlace);

			HelperClass.log.info("Clicked on Marketplace successfully");

		} catch (Exception e) {

			HelperClass.log.error("Failed to click Marketplace: " + e.getMessage());

			throw e;
		}
	}

	public void add(String name, String keyword, String by, String min, String max) {
		try {

			sendKeys(addInterst.name, name);

			sendKeys(addInterst.keyWord, keyword);

			sendKeys(addInterst.doneBy, by);

			clickAll();

			clickCatagry();

			sendKeys(addInterst.min, min);

			sendKeys(addInterst.max, max);

			clickSubmit();

			
			HelperClass.log.info("Entered all add details successfully");
		}

		catch (Exception e) {

			HelperClass.log.error("Failed to enter add details: " + e.getMessage());

			throw e;
		}
	}

	public void clickAll() {
		try {
			waitForVisibility(addInterst.AllFirst);

			waitForClickable(addInterst.AllFirst);

			jsClick(addInterst.AllFirst);

			HelperClass.log.info("Clicked category dropdown successfully");
		}

		catch (Exception e) {
			HelperClass.log.error("Failed to click category dropdown: " + e.getMessage());

			throw e;
		}
	}

	public void clickSubmit() {
		try {
			waitForVisibility(addInterst.subMit);

			waitForClickable(addInterst.subMit);

			jsClick(addInterst.subMit);

			HelperClass.log.info("Clicked Submit button successfully");
		}

		catch (Exception e) {
			HelperClass.log.error("Failed to click Submit button: " + e.getMessage());

			throw e;
		}
	}

	public void clickCatagry() {
		waitForVisibility(addInterst.categry);

		waitForClickable(addInterst.categry);

		jsClick(addInterst.categry);

		HelperClass.log.info("Clicked all cetaogry  successfully");

	}

	public void clickAdIntrestLink() {

		try {

			waitForVisibility(addInterst.adIntrestLink);

			waitForClickable(addInterst.adIntrestLink);

			jsClick(addInterst.adIntrestLink);

			HelperClass.log.info("Clicked Advertisement Interest link successfully");

		} catch (Exception e) {

			HelperClass.log.error("Failed to click Advertisement Interest link: " + e.getMessage());

			throw e;
		}
	}

	public void clickDeleteButton() {

		try {

			waitForVisibility(addInterst.tableRows);

			waitForClickable(addInterst.delFirstRow);

			jsClick(addInterst.delFirstRow);

			HelperClass.log.info("Clicked Delete button successfully");

		} catch (Exception e) {

			HelperClass.log.error("Failed to click Delete button: " + e.getMessage());

			throw e;
		}
	}

	public void clickConfirm() {

		try {

			waitForVisibility(addInterst.confirmDelBtn);

			jsClick(addInterst.confirmDelBtn);

			HelperClass.log.info("Clicked Confirm button successfully");

		} catch (Exception e) {

			HelperClass.log.error("Failed to click Confirm button: " + e.getMessage());

			throw e;
		}
	}

	public boolean isVisibleResult() {
		return isDisplayed(addInterst.noResult);
	}

	
	public boolean isUniqueVisible()
	{
		return isDisplayed(addInterst.unique);
	}
	public void assertPopup(String expectedMessage) {
		try {
			waitForVisibility(addInterst.popUp);

			String actualMessage = getText(addInterst.popUp);

			HelperClass.log.info("Actual Popup Message: " + actualMessage);

			Assert.assertEquals(actualMessage, expectedMessage);

			HelperClass.log.info("Popup assertion successful");
		}

		catch (Exception e) {
			HelperClass.log.error("Popup assertion failed: " + e.getMessage());

			throw e;
		}
	}

	public void dataTable(DataTable table, String expectedMessage) {
		try {
			List<List<String>> data = table.asLists(String.class);

			for (int i = 1; i < data.size(); i++) {
				// First iteration already opened from feature file
				if (i > 1) {
					HelperClass.getDriver().navigate().back();

					addNew();
				}

				List<String> row = data.get(i);

				String keyword = row.get(0);

				String by = row.get(1);

				String min = row.get(2);

				String max = row.get(3);

				// Name field intentionally skipped

				if (!keyword.trim().isEmpty()) {
					sendKeys(addInterst.keyWord, keyword);
				}

				if (!by.trim().isEmpty()) {
					sendKeys(addInterst.doneBy, by);
				}

				clickAll();

				clickCatagry();

				if (!min.trim().isEmpty()) {
					sendKeys(addInterst.min, min);
				}

				if (!max.trim().isEmpty()) {
					sendKeys(addInterst.max, max);
				}

				clickSubmit();

				waitForVisibility(addInterst.requiredMessage);

				String actualMessage = getText(addInterst.requiredMessage);

				Assert.assertEquals(actualMessage, expectedMessage);

				HelperClass.log.info("Required validation asserted successfully");
			}
		}

		catch (Exception e) {
			HelperClass.log.error("DataTable execution failed: " + e.getMessage());

			throw e;
		}
	}

	public void navigateBack() {
		HelperClass.getDriver().navigate().back();
	}

	public void excelData() throws IOException {
		ExcelData excelData = new ExcelData();

		Object[][] data = excelData.validData();

		for (Object[] row : data) {
			String name = row[0].toString();

			String keyword = row[1].toString();

			String by = row[2].toString();

			String min = row[3].toString();

			String max = row[4].toString();

			add(name, keyword, by, min, max);
		}
	}

}