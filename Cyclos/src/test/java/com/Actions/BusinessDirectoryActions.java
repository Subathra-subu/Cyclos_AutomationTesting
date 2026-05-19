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

        waitForVisibility(businessPage.listViewButton);

        scrollIntoView(businessPage.listViewButton);

        jsClick(businessPage.listViewButton);
    }

    public void validateListView() {

        waitForVisibility(businessPage.activeListView);

        Assert.assertTrue(
                isDisplayed(businessPage.activeListView));
    }

    public void clickTiledView() {

        waitForVisibility(businessPage.tiledViewButton);

        scrollIntoView(businessPage.tiledViewButton);

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

        List<WebElement> elements =
                HelperClass.getDriver()
                           .findElements(businessPage.businessNames);

        List<String> actualNames =
                elements.stream()
                        .map(WebElement::getText)
                        .collect(Collectors.toList());

        List<String> sortedNames =
                new ArrayList<>(actualNames);

        Collections.sort(sortedNames);

        Assert.assertEquals(actualNames, sortedNames);
    }

    public void selectDescendingOrder() {

        click(businessPage.orderDropdown);

        click(businessPage.descendingOrder);
    }

    public void validateDescendingOrder() {

        waitForVisibility(businessPage.businessCards);

        List<WebElement> elements =
                HelperClass.getDriver()
                           .findElements(businessPage.businessNames);

        List<String> actualNames =
                elements.stream()
                        .map(WebElement::getText)
                        .collect(Collectors.toList());

        List<String> sortedNames =
                new ArrayList<>(actualNames);

        Collections.sort(sortedNames, Collections.reverseOrder());

        Assert.assertEquals(actualNames, sortedNames);
    }
}