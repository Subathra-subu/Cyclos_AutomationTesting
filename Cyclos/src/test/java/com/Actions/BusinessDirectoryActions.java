package com.Actions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.Pages.BusinessDirectoryPage;
import com.Utilities.HelperClass;

public class BusinessDirectoryActions extends BaseAction {

    BusinessDirectoryPage businessPage =
            new BusinessDirectoryPage();

    public void navigateBusinessDirectory() {

        try {

            waitForVisibility(
                    businessPage.businessDirectoryMenu);

            scrollIntoView(
                    businessPage.businessDirectoryMenu);

            jsClick(
                    businessPage.businessDirectoryMenu);

            HelperClass.log.info(
                    "Navigated to business directory successfully");

        }

        catch (Exception e) {

            HelperClass.log.error(
                    "Failed to navigate business directory : "
                            + e.getMessage());

            throw e;
        }
    }

    public void enterKeyword(
            String keyword) {

        try {

            waitForVisibility(
                    businessPage.keywordField);

            sendKeys(
                    businessPage.keywordField,
                    keyword);

            HelperClass.log.info(
                    "Entered keyword successfully : "
                            + keyword);

        }

        catch (Exception e) {

            HelperClass.log.error(
                    "Failed to enter keyword : "
                            + e.getMessage());

            throw e;
        }
    }

    public void validateSearchResults() {

        try {

            waitForVisibility(
                    businessPage.businessCards);

            Assert.assertTrue(
                    isDisplayed(
                            businessPage.businessCards));

            HelperClass.log.info(
                    "Business search results validated successfully");

        }

        catch (Exception e) {

            HelperClass.log.error(
                    "Business search result validation failed : "
                            + e.getMessage());

            throw e;
        }
    }

    public void clickListView() {

        try {

            waitForVisibility(
                    businessPage.listViewButton);

            scrollIntoView(
                    businessPage.listViewButton);

            jsClick(
                    businessPage.listViewButton);

            HelperClass.log.info(
                    "Clicked list view successfully");

        }

        catch (Exception e) {

            HelperClass.log.error(
                    "Failed to click list view : "
                            + e.getMessage());

            throw e;
        }
    }

    public void validateListView() {

        try {

            waitForVisibility(
                    businessPage.activeListView);

            Assert.assertTrue(
                    isDisplayed(
                            businessPage.activeListView));

            HelperClass.log.info(
                    "List view validated successfully");

        }

        catch (Exception e) {

            HelperClass.log.error(
                    "List view validation failed : "
                            + e.getMessage());

            throw e;
        }
    }

    public void clickTiledView() {

        try {

            waitForVisibility(
                    businessPage.tiledViewButton);

            scrollIntoView(
                    businessPage.tiledViewButton);

            jsClick(
                    businessPage.tiledViewButton);

            HelperClass.log.info(
                    "Clicked tiled view successfully");

        }

        catch (Exception e) {

            HelperClass.log.error(
                    "Failed to click tiled view : "
                            + e.getMessage());

            throw e;
        }
    }

    public void validateTiledView() {

        try {

            waitForVisibility(
                    businessPage.activeTiledView);

            Assert.assertTrue(
                    isDisplayed(
                            businessPage.activeTiledView));

            HelperClass.log.info(
                    "Tiled view validated successfully");

        }

        catch (Exception e) {

            HelperClass.log.error(
                    "Tiled view validation failed : "
                            + e.getMessage());

            throw e;
        }
    }

    public void selectAscendingOrder() {

        try {

            waitForClickable(
                    businessPage.orderDropdown);

            click(
                    businessPage.orderDropdown);

            waitForClickable(
                    businessPage.ascendingOrder);

            click(
                    businessPage.ascendingOrder);

            HelperClass.log.info(
                    "Ascending order selected successfully");

        }

        catch (Exception e) {

            HelperClass.log.error(
                    "Failed to select ascending order : "
                            + e.getMessage());

            throw e;
        }
    }

    public void validateAscendingOrder() {

        try {

            waitForVisibility(
                    businessPage.businessCards);

            List<WebElement> elements =
                    HelperClass.getDriver()
                               .findElements(
                                       businessPage.businessNames);

            List<String> actualNames =
                    elements.stream()
                            .map(WebElement::getText)
                            .collect(Collectors.toList());

            List<String> sortedNames =
                    new ArrayList<>(actualNames);

            Collections.sort(sortedNames);

            Assert.assertEquals(
                    actualNames,
                    sortedNames);

            HelperClass.log.info(
                    "Ascending order validated successfully");

        }

        catch (Exception e) {

            HelperClass.log.error(
                    "Ascending order validation failed : "
                            + e.getMessage());

            throw e;
        }
    }

    public void selectDescendingOrder() {

        try {

            waitForClickable(
                    businessPage.orderDropdown);

            click(
                    businessPage.orderDropdown);

            waitForClickable(
                    businessPage.descendingOrder);

            click(
                    businessPage.descendingOrder);

            HelperClass.log.info(
                    "Descending order selected successfully");

        }

        catch (Exception e) {

            HelperClass.log.error(
                    "Failed to select descending order : "
                            + e.getMessage());

            throw e;
        }
    }

    public void validateDescendingOrder() {

        try {

            waitForVisibility(
                    businessPage.businessCards);

            List<WebElement> elements =
                    HelperClass.getDriver()
                               .findElements(
                                       businessPage.businessNames);

            List<String> actualNames =
                    elements.stream()
                            .map(WebElement::getText)
                            .collect(Collectors.toList());

            List<String> sortedNames =
                    new ArrayList<>(actualNames);

            Collections.sort(
                    sortedNames,
                    Collections.reverseOrder());

            Assert.assertEquals(
                    actualNames,
                    sortedNames);

            HelperClass.log.info(
                    "Descending order validated successfully");

        }

        catch (Exception e) {

            HelperClass.log.error(
                    "Descending order validation failed : "
                            + e.getMessage());

            throw e;
        }
    }
}