package com.Actions;

import org.testng.Assert;

import com.Pages.BusinessDirectoryPage;

public class BusinessDirectoryActions extends BaseAction {

    BusinessDirectoryPage businessPage =
            new BusinessDirectoryPage();

    public void navigateBusinessDirectory() {

        waitForVisibility(businessPage.businessDirectoryMenu);

        click(businessPage.businessDirectoryMenu);
    }

    public void enterKeyword(String keyword) {

        waitForVisibility(businessPage.keywordField);

        sendKeys(businessPage.keywordField, keyword);
    }

    public void validateSearchResults() {

        waitForVisibility(businessPage.businessCards);

        Assert.assertTrue(
                isDisplayed(businessPage.businessCards));
    }

    public void clickListView() {

        scrollIntoView(businessPage.listViewButton);

        waitForClickable(businessPage.listViewButton);

        jsClick(businessPage.listViewButton);
    }

    public void validateListView() {

        waitForVisibility(businessPage.activeListView);

        Assert.assertTrue(
                isDisplayed(businessPage.activeListView));
    }

    public void clickTiledView() {

        scrollIntoView(businessPage.tiledViewButton);

        waitForClickable(businessPage.tiledViewButton);

        jsClick(businessPage.tiledViewButton);
    }

    public void validateTiledView() {

        waitForVisibility(businessPage.activeTiledView);

        Assert.assertTrue(
                isDisplayed(businessPage.activeTiledView));
    }

    public void selectAscendingOrder() {

        click(businessPage.orderDropdown);

        click(businessPage.ascendingOrder);
    }

    public void validateAscendingOrder() {

        waitForVisibility(businessPage.businessCards);

        Assert.assertTrue(
                isDisplayed(businessPage.businessCards));
    }

    public void selectDescendingOrder() {

        click(businessPage.orderDropdown);

        click(businessPage.descendingOrder);
    }

    public void validateDescendingOrder() {

        waitForVisibility(businessPage.businessCards);

        Assert.assertTrue(
                isDisplayed(businessPage.businessCards));
    }
}