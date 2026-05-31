package com.Actions;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.Pages.AdvertisementPage;
import com.Utilities.CSVUtility;
import com.Utilities.ExcelData;
import com.Utilities.HelperClass;

import io.cucumber.datatable.DataTable;

public class AdvertisementAction extends BaseAction {

    AdvertisementPage advertisementPage =
            new AdvertisementPage();

    public void clickMarketplace() {

        try {
            click(advertisementPage.marketplaceMenu);
            HelperClass.log.info("Clicked Marketplace menu successfully");
        }

        catch (Exception e) {
            HelperClass.log.error("Failed to click Marketplace menu : " + e.getMessage());
            throw e;
        }
    }

    public void navigateToAdvertisement() {

        try {
            waitForVisibility(advertisementPage.marketplaceMenu);
            click(advertisementPage.marketplaceMenu);
            HelperClass.log.info("Clicked Marketplace menu");
            waitForVisibility(advertisementPage.advertisementTab);
            click(advertisementPage.advertisementTab);
            HelperClass.log.info("Clicked Advertisement tab");
            // Validate search field 
            waitForVisibility(advertisementPage.searchInput);
            Assert.assertTrue(isDisplayed(advertisementPage.searchInput));
            HelperClass.log.info("Advertisement page loaded successfully");
        }

        catch (StaleElementReferenceException e) {
            HelperClass.log.info("Handled stale element while opening Advertisement");
            click(advertisementPage.marketplaceMenu);
            click(advertisementPage.advertisementTab);
            waitForVisibility(advertisementPage.searchInput);
        }

        catch (Exception e) {
            HelperClass.log.error("Failed to navigate Advertisement module : "+ e.getMessage());
            throw e;
        }
    }

    public void searchAdvertisement(DataTable dataTable) {

        try {

            List<Map<String, String>> data =dataTable.asMaps(String.class,String.class);

            for (Map<String, String> row : data) {
                String keyword =row.get("keyword");

                try {
                    sendKeys(advertisementPage.searchInput,keyword);
                }

                catch (StaleElementReferenceException e) {
                    HelperClass.log.info("Stale element handled for search field");
                    sendKeys(advertisementPage.searchInput,keyword);
                }

                HelperClass.log.info("Searched advertisement keyword : "+ keyword);
                waitForVisibility(advertisementPage.searchInput);
            }

        }

        catch (Exception e) {

            HelperClass.log.error("Advertisement search failed : " + e.getMessage());
            throw e;
        }
    }

    public void verifySearchResults() {

        try {
            boolean resultsDisplayed =isDisplayed(advertisementPage.advertisementResults);
            boolean noResultDisplayed =isDisplayed(advertisementPage.noResultsMessage);
            Assert.assertTrue(resultsDisplayed || !noResultDisplayed, "Relevant advertisements were not displayed");
            HelperClass.log.info("Advertisement search validated successfully");

        }

        catch (Exception e) {
            HelperClass.log.error("Search result validation failed : " + e.getMessage());
            throw e;
        }
    }
    public void searchInvalidAdvertisementKeyword() {

        try {

            List<String> keywords =
                    CSVUtility.getVoucherCodes(
                            "src/test/resources/testData/InputData.csv");
            
            System.out.println("CSV Value = " + keywords.get(0));

            String keyword =
                    keywords.get(0);

            waitForVisibility(
                    advertisementPage.searchInput);

            sendKeys(
                    advertisementPage.searchInput,
                    keyword);
            

            HelperClass.log.info(
                    "Searched invalid advertisement keyword : "
                            + keyword);
        }

        catch (Exception e) {

            HelperClass.log.error(
                    "Failed to search invalid keyword : "
                            + e.getMessage());

            throw e;
        }
    }
    public void verifyNoSearchResults() {

        try {

            waitForVisibility(advertisementPage.noResultsMessage);
            String actualMessage =getText(advertisementPage.noResultsMessage);
            Assert.assertTrue(actualMessage.contains("No results"));
            HelperClass.log.info("No result message validated successfully");

        }

        catch (Exception e) {
            HelperClass.log.error("Invalid advertisement search validation failed : " + e.getMessage());
            throw e;
        }
    }
    public void addAdvertisementToFavourites() throws IOException {

        try {

            ExcelData excelData = new ExcelData();
            Object[][] data = excelData.advertisementFavourites();

            for (Object[] row : data) {
                String keyword =row[0].toString();
                waitForVisibility(advertisementPage.searchInput);
                sendKeys(advertisementPage.searchInput,keyword);
                HelperClass.log.info("Searched advertisement keyword : " + keyword);
                waitForVisibility( advertisementPage.favouriteIcon);
                jsClick(advertisementPage.favouriteIcon);
                HelperClass.log.info("Added advertisement to favourites : "+ keyword);
            }
        }

        catch (Exception e) {

            HelperClass.log.error("Failed to add advertisement to favourites : " + e.getMessage());
            throw e;
        }
    }
    public void verifyAdvertisementAddedToFavourites() {

        try {
//            waitForVisibility(advertisementPage.advertisementCards);
        	if (isDisplayed(advertisementPage.favouriteSuccessMessage)) {

        	    String text = getText(advertisementPage.favouriteSuccessMessage);

        	    Assert.assertTrue(
        	            text.contains("favourite"));
        	}
        	else {

        	    Assert.fail("Favourite success message not displayed in the page");
        	}
        }

        catch (Exception e) {
            HelperClass.log.error("Favourite advertisement validation failed : " + e.getMessage());
            throw e;
        }
    }
    public void filterByPriceRange(
            String minPrice,
            String maxPrice) {

        try {

            if (isDisplayed(advertisementPage.showMoreFilters)) {

                click(advertisementPage.showMoreFilters);
                HelperClass.log.info("Clicked Show More Filters");
            }
            waitForVisibility(advertisementPage.minPriceField);
            sendKeys(advertisementPage.minPriceField,minPrice);
            sendKeys(advertisementPage.maxPriceField,maxPrice);
            HelperClass.log.info("Applied price filter : "+ minPrice+ " - "+ maxPrice);

        }

        catch (StaleElementReferenceException e) {

            HelperClass.log.info("Handled stale element while applying price filter");
            sendKeys(advertisementPage.minPriceField,minPrice);
            sendKeys(advertisementPage.maxPriceField,maxPrice);
        }

        catch (Exception e) {

            HelperClass.log.error("Price filter failed : " + e.getMessage());
            throw e;
        }
    }
    public void verifyFilteredAdvertisements() {

        try {

            waitForVisibility(advertisementPage.advertisementCard);
            Assert.assertTrue(isDisplayed(advertisementPage.advertisementCard));
            HelperClass.log.info("Filtered advertisements displayed successfully");
        }

        catch (Exception e) {
            HelperClass.log.error("Advertisement filter validation failed : " + e.getMessage());
            throw e;
        }
    }
    public void filterAdvertisementsWithImages() {

        try {

            waitForVisibility(advertisementPage.showMoreFilters);
            click(advertisementPage.showMoreFilters);
            HelperClass.log.info("Clicked Show More Filters");
            waitForVisibility(advertisementPage.withImagesFilter);
            click(advertisementPage.withImagesFilter);
            HelperClass.log.info("Clicked With Images filter");

        }

        catch (StaleElementReferenceException e) {

            HelperClass.log.info("Handled stale element for image filter");
            click(advertisementPage.withImagesFilter);
        }

        catch (Exception e) {

            HelperClass.log.error("Failed to apply image filter : " + e.getMessage());
            throw e;
        }
    }
    public void verifyAdvertisementsWithImages() {

        try {

            waitForVisibility(advertisementPage.advertisementCards);
            Assert.assertTrue(isDisplayed(advertisementPage.advertisementCards));
            HelperClass.log.info("With Images filter applied successfully and advertisements are displayed");
        }

        catch (Exception e) {
            HelperClass.log.error("Image filter validation failed : " + e.getMessage());
            throw e;
        }
    }
    public void filterFavouriteAdvertisements() {

        try {

            waitForVisibility(advertisementPage.showMoreFilters);
            click(advertisementPage.showMoreFilters);
            HelperClass.log.info("Clicked Show More Filters");
            waitForVisibility(advertisementPage.favouritesOnlyFilter);
            click(advertisementPage.favouritesOnlyFilter);
            HelperClass.log.info("Clicked favourite advertisements filter");
            waitForVisibility(advertisementPage.advertisementCards);
        }

        catch (StaleElementReferenceException e) {

            HelperClass.log.info("Handled stale element for favourites filter");
            click(advertisementPage.favouritesOnlyFilter);
        }

        catch (Exception e) {

            HelperClass.log.error("Failed to apply favourites filter : " + e.getMessage());
            throw e;
        }
    }
    public void verifyFavouriteFilteredAdvertisements() {

        try {

            waitForVisibility(advertisementPage.advertisementCards);
            Assert.assertTrue(isDisplayed(advertisementPage.advertisementCards));
            HelperClass.log.info("Favorites filter validated successfully");
        }

        catch (Exception e) {

            HelperClass.log.error("Favorites filter validation failed : " + e.getMessage());
            throw e;
        }
    }
    public void searchInvalidKeyword(
            String invalidKeyword) {

        try {

            waitForVisibility(advertisementPage.searchInput);
            HelperClass.getDriver().findElement(advertisementPage.searchInput).clear();
            sendKeys(advertisementPage.searchInput,invalidKeyword);
            HelperClass.getDriver().findElement(advertisementPage.searchInput).sendKeys(Keys.ENTER);
            HelperClass.log.info("Entered invalid keyword : " + invalidKeyword);
        }

        catch (Exception e) {
            HelperClass.log.error("Invalid keyword search failed : " + e.getMessage());
            throw e;
        }
    }
    public void verifyInvalidKeywordPopup() {
        try {
            waitForVisibility(advertisementPage.invalidKeywordMessage);
            String actualMessage =getText(advertisementPage.invalidKeywordMessage);
            Assert.assertTrue(actualMessage.toLowerCase().contains("invalid keyword"));
            HelperClass.log.info("Invalid keyword popup validated successfully");
        }

        catch (Exception e) {
            HelperClass.log.error("Invalid keyword validation failed : " + e.getMessage());
            throw e;
        }
    }
    public void communityListClick() {
    	try {
    		waitForVisibility(advertisementPage.searchInput);
    		click(advertisementPage.communityList);
    	}
    	catch(Exception e) {
    		HelperClass.log.error("Failed to click the community in advertisement page" + e.getMessage());
    		throw e;
    	}
    }
    public void verifyAdvertisementsList() {
    	try {
    		waitForVisibility(advertisementPage.advertisementCards);
    		Assert.assertTrue(isDisplayed(advertisementPage.favouriteIcon));
            HelperClass.log.info("Advetisements List in page was validated Successfully");
    	}
    	catch(Exception e){
    		HelperClass.log.error("Failed to list Advertisements list" + e.getMessage());
    		throw e;
    	}
    }
}