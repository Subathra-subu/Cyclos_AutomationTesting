package com.Actions;

import java.io.IOException;
import java.util.List;

import org.testng.Assert;

import com.Pages.AddIntrestPage;
import com.Utilities.ExcelData;
import com.Utilities.HelperClass;

import io.cucumber.datatable.DataTable;

public class AddInterestActions extends BaseAction {

    AddIntrestPage p = new AddIntrestPage();

    // ═══════════════════════════════════════════════════════════════
    //  ASSERTIONS
    // ═══════════════════════════════════════════════════════════════

    public void assertNoresult() {
        try {
            waitForVisibility(p.noResult);
            String actual = getText(p.noResult);
            Assert.assertEquals(actual, "No results match the search criteria",
                    "No-results message mismatch");
            HelperClass.log.info("No-results assertion passed");
        } catch (Exception e) {
            HelperClass.log.error("assertNoresult failed: {}", e.getMessage());
            throw e;
        }
    }

    public void assertDel() {
        try {
            waitForVisibility(p.successToast);
            String msg = getText(p.successToast);
            Assert.assertTrue(msg.contains("was removed"),
                    "Delete toast missing 'was removed'. Actual: " + msg);
            HelperClass.log.info("Delete assertion passed: {}", msg);
        } catch (Exception e) {
            HelperClass.log.error("assertDel failed: {}", e.getMessage());
            throw e;
        }
    }

    public void assertuniqe() {
        try {
            waitForVisibility(p.unique);
            String msg = getText(p.unique);
            Assert.assertTrue(msg.contains("unique"),
                    "Unique toast missing 'unique'. Actual: " + msg);
            HelperClass.log.info("Unique assertion passed: {}", msg);
        } catch (Exception e) {
            HelperClass.log.error("assertuniqe failed: {}", e.getMessage());
            throw e;
        }
    }

    public void assertAdd(String expectedMessage) {
        try {
            waitForVisibility(p.add);
            String actual = getText(p.add);
            Assert.assertEquals(actual, expectedMessage,
                    "Popup message mismatch. Expected: " + expectedMessage + " Actual: " + actual);
            HelperClass.log.info("Popup assertion passed: {}", actual);
        } catch (Exception e) {
            HelperClass.log.error("assertPopup failed: {}", e.getMessage());
            throw e;
        }
    }

    // ═══════════════════════════════════════════════════════════════
    //  NAVIGATION
    // ═══════════════════════════════════════════════════════════════

    public void clickMarketPlace() {
        try {
            waitForPageLoad();
            click(p.marketPlace);
            HelperClass.log.info("Marketplace clicked");
        } catch (Exception e) {
            HelperClass.log.error("clickMarketPlace failed: {}", e.getMessage());
            throw e;
        }
    }

    public void clickAdIntrestLink() {
        try {
            waitForPageLoad();
            waitForVisibility(p.adIntrestLink);
            waitForClickable(p.adIntrestLink);
            jsClick(p.adIntrestLink);
            HelperClass.log.info("Ad interest link clicked");
        } catch (Exception e) {
            HelperClass.log.error("clickAdIntrestLink failed: {}", e.getMessage());
            throw e;
        }
    }

    public void addNew() {
        try {
            waitForPageLoad();
            waitForVisibility(p.addNew);
            waitForClickable(p.addNew);
            jsClick(p.addNew);
            HelperClass.log.info("Add New button clicked");
        } catch (Exception e) {
            HelperClass.log.error("addNew failed: {}", e.getMessage());
            throw e;
        }
    }

    public void clickDeleteButton() {
        try {
            waitForPageLoad();
            waitForVisibility(p.tableRows);
            waitForClickable(p.delFirstRow);
            jsClick(p.delFirstRow);
            HelperClass.log.info("Delete button clicked");
        } catch (Exception e) {
            HelperClass.log.error("clickDeleteButton failed: {}", e.getMessage());
            throw e;
        }
    }

    public void clickConfirm() {
        try {
            waitForPageLoad();
            waitForVisibility(p.confirmDelBtn);
            jsClick(p.confirmDelBtn);
            HelperClass.log.info("Confirm delete clicked");
        } catch (Exception e) {
            HelperClass.log.error("clickConfirm failed: {}", e.getMessage());
            throw e;
        }
    }

    public void clickAll() {
        try {
            waitForVisibility(p.AllFirst);
            waitForClickable(p.AllFirst);
            jsClick(p.AllFirst);
            HelperClass.log.info("Category dropdown opened");
        } catch (Exception e) {
            HelperClass.log.error("clickAll failed: {}", e.getMessage());
            throw e;
        }
    }

    public void clickCatagry() {
        try {
            waitForVisibility(p.categry);
            waitForClickable(p.categry);
            jsClick(p.categry);
            HelperClass.log.info("Category option selected");
        } catch (Exception e) {
            HelperClass.log.error("clickCatagry failed: {}", e.getMessage());
            throw e;
        }
    }

    public void clickSubmit() {
        try {
            waitForVisibility(p.subMit);
            waitForClickable(p.subMit);
            jsClick(p.subMit);
            HelperClass.log.info("Submit clicked");
        } catch (Exception e) {
            HelperClass.log.error("clickSubmit failed: {}", e.getMessage());
            throw e;
        }
    }

    // ═══════════════════════════════════════════════════════════════
    //  STATE CHECKS
    // ═══════════════════════════════════════════════════════════════

    public boolean isVisibleResult() {
        return isDisplayed(p.noResult, 3);
    }

    public boolean isUniqueVisible() {
        return isDisplayed(p.unique, 3);
    }

    // ═══════════════════════════════════════════════════════════════
    //  FORM FILLERS
    // ═══════════════════════════════════════════════════════════════

    public void add(String name, String keyword, String by, String min, String max) {
        try {
            sendKeys(p.name, name);
            sendKeys(p.keyWord, keyword);
            sendKeys(p.doneBy, by);
            clickAll();
            clickCatagry();
            sendKeys(p.min, min);
            sendKeys(p.max, max);
            clickSubmit();
            HelperClass.log.info("Ad interest created: {}", name);
        } catch (Exception e) {
            HelperClass.log.error("add failed: {}", e.getMessage());
            throw e;
        }
    }

    public void excelData() throws IOException {
        ExcelData excelData = new ExcelData();
        Object[][] data = excelData.validData();
        for (Object[] row : data) {
            add(
                row[0].toString(),
                row[1].toString(),
                row[2].toString(),
                row[3].toString(),
                row[4].toString()
            );
        }
    }

    // ═══════════════════════════════════════════════════════════════
    //  DATA TABLE – iterative validation
    // ═══════════════════════════════════════════════════════════════

    public void dataTable(DataTable table, String expectedMessage) {
        try {
            List<List<String>> data = table.asLists(String.class);

            for (int i = 1; i < data.size(); i++) {
                // First row already opened from feature file step
                if (i > 1) {
                    HelperClass.getDriver().navigate().back();
                    waitForPageLoad();
                    addNew();
                }

                List<String> row = data.get(i);
                String keyword = row.get(0);
                String by      = row.get(1);
                String min     = row.get(2);
                String max     = row.get(3);

                if (!keyword.trim().isEmpty()) sendKeys(p.keyWord, keyword);
                if (!by.trim().isEmpty())      sendKeys(p.doneBy, by);

                clickAll();
                clickCatagry();

                if (!min.trim().isEmpty()) sendKeys(p.min, min);
                if (!max.trim().isEmpty()) sendKeys(p.max, max);

                clickSubmit();

                waitForVisibility(p.requiredMessage);
                String actual = getText(p.requiredMessage);
                Assert.assertEquals(actual, expectedMessage,
                        "Row " + i + " validation failed. Expected: " + expectedMessage + " Actual: " + actual);
                HelperClass.log.info("Row {} validation passed", i);
            }

        } catch (Exception e) {
            HelperClass.log.error("dataTable failed: {}", e.getMessage());
            throw e;
        }
    }

    public void navigateBack() {
        HelperClass.getDriver().navigate().back();
        waitForPageLoad();
    }
}