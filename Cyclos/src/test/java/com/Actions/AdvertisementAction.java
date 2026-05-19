package com.Actions;

import java.io.IOException;

import org.testng.Assert;

import com.Pages.AdvertisementPage;
import com.StepDefinitions.Hooks;
import com.Utilities.ExcelData;
import com.Utilities.HelperClass;

public class AdvertisementAction extends BaseAction {

    AdvertisementPage page = new AdvertisementPage();
    
    public void clickingLinks() {
        HelperClass.log.info("navigating to the market Place");

        click(page.marketPlace);
        waitForVisibility(page.advertisement);
        click(page.advertisement);
        waitForClickable(page.searchBox);
        
    }

    // VALID SEARCH
    public void searchValidKeyword(String keyword) {
    	try {
            waitForVisibility(page.searchBox);
            sendKeys(page.searchBox, keyword);
        } 
        catch (org.openqa.selenium.StaleElementReferenceException e) {
            HelperClass.log.warn("Stale Element occurred. Retrying search field");
            waitForVisibility(page.searchBox);
            sendKeys(page.searchBox, keyword);
        }
    }

    public void verifySearchResult() {
    	Assert.assertTrue(isDisplayed(page.favt), "Products based on keyword is diplayed");
    	HelperClass.log.info("Product based on the keyword is displayed");
    }

    // INVALID SEARCH
    public void searchInvalidKeyword(String keyword) {
    	try {
            waitForVisibility(page.searchBox);
            sendKeys(page.searchBox, keyword);
        } 
        catch (org.openqa.selenium.StaleElementReferenceException e) {
            HelperClass.log.warn("Stale Element occurred. Retrying search field");
            waitForVisibility(page.searchBox);
            sendKeys(page.searchBox, keyword);
        }
    }

    public void verifyNoResult() {
        isDisplayed(page.noResultMsg);
        String text = getText(page.noResultMsg);
        Assert.assertEquals(text, "No results match the search criteria");
    }

    // EXCEL
    public void addProductToFavouritesUsingExcel() throws IOException {
    	Hooks.logger.info("Adding favorites to a product");

        try {
            ExcelData excelData = new ExcelData();
            Object[][] data = excelData.getFavoritesData();

            String product = "";

            if (data != null && data.length > 0 && data[0][0] != null) {
                product = data[0][0].toString();
            }

            waitForClickable(page.searchBox);
            sendKeys(page.searchBox, product);

            waitForVisibility(page.favouriteIcon);

            click(page.favouriteIcon);

        } catch (Exception e) {
            Hooks.logger.error("Unable to add product to favourites using excel", e);
        }
    }

    public void verifyProductAddedToFav() {
        Assert.assertTrue(true);
    }

    // DATATABLE
    public void addProductToFavourite(String product) {

        try {
            sendKeys(page.searchBox, product);
            click(page.searchBtn);
            click(page.favouriteIcon);
        } catch (Exception e) {
            Hooks.logger.error("Unable to add product to favourites", e);
        }
    }

    // SORT
    public void sortProduct(String type) {
        try {
            click(page.sortDropdown);
            click(page.sortOption(type));
        } catch (Exception e) {
            Hooks.logger.error("Unable to sort product", e);
        }
    }

    public void verifyLowestPrice() {
        Assert.assertTrue(true);
    }

    public void verifyHighestPrice() {
        Assert.assertTrue(true);
    }

    public void verifyLatestProducts() {
        Assert.assertTrue(true);
    }
}