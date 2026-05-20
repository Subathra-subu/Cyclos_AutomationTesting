package com.Actions;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.Pages.MyAdvertisesmentsPage;
import com.StepDefinitions.Hooks;

public class MyAdvertisementsAction extends BaseAction {
	
	MyAdvertisesmentsPage advertisementPage = new MyAdvertisesmentsPage();
	
    public void clickMarketPlaceMenu() {

        try {
            waitForVisibility(advertisementPage.marketPlaceMenu);

            jsClick(advertisementPage.marketPlaceMenu);
        } 
        catch (Exception e) {
            Hooks.logger.error("Unable to click marketplace menu", e);
        }
    }

    public void clickMyAdvertisements() {

        try {
            waitForVisibility(advertisementPage.myAdvertisements);

            jsClick(advertisementPage.myAdvertisements);
        } 
        catch (Exception e) {
            Hooks.logger.error("Unable to click my advertisements", e);
        }

    }

    public void clickNewAdvertisement() {

        try {
            click(advertisementPage.newAdvertisementBtn);
        } 
        catch (Exception e) {
            Hooks.logger.error("Unable to click new advertisement button", e);
        }
    }

    public void enterTitle(String title) {

        try {
            sendKeys(advertisementPage.titleField, title);
        } 
        catch (Exception e) {
            Hooks.logger.error("Unable to enter title", e);
        }
    }

    public void selectCategory(String category) {

        try {
            click(advertisementPage.categoryDropdown);

            By option = advertisementPage.categoryOption(category);

            waitForVisibility(option);

            click(option);
        } 
        catch (Exception e) {
            Hooks.logger.error("Unable to select category", e);
        }
    }

    public void enterPrice(String price) {

        try {
            sendKeys(advertisementPage.priceField, price);
        } 
        catch (Exception e) {
            Hooks.logger.error("Unable to enter price", e);
        }
    }

    public void selectFromDate(String date) {

        try {
            sendKeys(advertisementPage.fromDate, date);
        } 
        catch (Exception e) {
            Hooks.logger.error("Unable to select from date", e);
        }
    }

    public void selectToDate(String date) {

        try {
            sendKeys(advertisementPage.toDate, date);
        } 
        catch (Exception e) {
            Hooks.logger.error("Unable to select to date", e);
        }
    }

    public void enterDescription(String description) {

        try {
            waitForVisibility(advertisementPage.descriptionFrame);

            sendKeys(advertisementPage.descriptionFrame, description);
        } 
        catch (Exception e) {
            Hooks.logger.error("Unable to enter description", e);
        }
    }

    public void clickSave() {

        try {
            waitForVisibility(advertisementPage.saveBtn);

            click(advertisementPage.saveBtn);
        } 
        catch (Exception e) {
            Hooks.logger.error("Unable to click save button", e);
        }
    }

    public String validateMessage() {

        try {
            return getText(advertisementPage.Message);
        } 
        catch (Exception e) {
            Hooks.logger.error("Unable to validate message", e);
        }

        return null;
    }

    public void assertSuccessfullMessage() {

        try {
            isDisplayed(advertisementPage.Message);

            Assert.assertTrue(validateMessage().contains("was saved"));
        } 
        catch (Exception e) {
            Hooks.logger.error("Unable to assert successful message", e);
        }
    }

    public void searchAdvertisement(String title) {

        try {
            sendKeys(advertisementPage.searchField, title);
        } 
        catch (Exception e) {
            Hooks.logger.error("Unable to search advertisement", e);
        }
    }

    public void clickItem() {

        try {
        	waitForVisibility(advertisementPage.item);
            click(advertisementPage.item);
        } 
        catch (Exception e) {
            Hooks.logger.error("Unable to click item", e);
        }
    }

    public void clickEditAdvertisement() {

        try {
            click(advertisementPage.editBtn);
        } 
        catch (Exception e) {
            Hooks.logger.error("Unable to click edit button", e);
        }
    }

    public void clickRemoveAdvertisement() {

        try {
            click(advertisementPage.removeBtn);
        } 
        catch (Exception e) {
            Hooks.logger.error("Unable to click remove button", e);
        }
    }

    public String validateRemovePopup() {

        try {
            return getText(advertisementPage.confirmPopup);
        } 
        catch (Exception e) {
            Hooks.logger.error("Unable to validate remove popup", e);
        }

        return null;
    }

    public void confirmRemoveAdvertisement() {

        try {
            click(advertisementPage.confirmRemoveBtn);
        } 
        catch (Exception e) {
            Hooks.logger.error("Unable to confirm remove advertisement", e);
        }
    }

    public void assertRemovalMessage() {

        try {
            isDisplayed(advertisementPage.Message);

            Assert.assertTrue(validateMessage().contains("was removed"));
        } 
        catch (Exception e) {
            Hooks.logger.error("Unable to assert removal message", e);
        }
    }
}
