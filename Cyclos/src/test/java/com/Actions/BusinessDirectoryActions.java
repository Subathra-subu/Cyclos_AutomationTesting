package com.Actions;

import org.testng.Assert;

import com.Pages.BusinessDirectoryPage;

public class BusinessDirectoryActions extends BaseAction {

    BusinessDirectoryPage businessPage =  new BusinessDirectoryPage();

   
    public void navigateBusinessDirectory() {

        waitForVisibility(businessPage.businessDirectoryMenu);

        click(businessPage.businessDirectoryMenu);
    }

   
    public void enterKeyword(String keyword) {

        waitForVisibility(businessPage.keywordField);

        sendKeys(businessPage.keywordField, keyword);
    }

   
    public void validateSearchResults() {

        Assert.assertTrue(isDisplayed(businessPage.businessCards));
    }

   

   
    public void clickListView() {

        scrollIntoView(businessPage.listViewButton);

        waitForClickable(businessPage.listViewButton);

        jsClick(businessPage.listViewButton);
    }


    public void validateListView() {

        Assert.assertTrue(isDisplayed(businessPage.businessCards));
    }

    public void clickTiledView() {

        scrollIntoView(businessPage.tiledViewButton);

        jsClick(businessPage.tiledViewButton);
    }
   
    public void validateTiledView() {

        Assert.assertTrue(isDisplayed(businessPage.businessCards));
    }

  
    public void selectAscendingOrder() {

        click(businessPage.orderDropdown);

        click(businessPage.ascendingOrder);
    }

   
    public void validateAscendingOrder() {

        Assert.assertTrue(isDisplayed(businessPage.businessCards));
    }


    public void selectDescendingOrder() {

        click(businessPage.orderDropdown);

        click(businessPage.descendingOrder);
    }

    public void validateDescendingOrder() {

        Assert.assertTrue(isDisplayed(businessPage.businessCards));
    }
}