package com.Actions;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.Pages.AdvertisementPage;
import com.Utilities.ExcelUtilities;
import com.Utilities.HelperClass;

public class AdvertisementAction extends BaseAction {

    AdvertisementPage advertisementPage = new AdvertisementPage();
    LoginAction login = new LoginAction();

    public void loginToApplication() {
    	HelperClass.log.info("Logging into the application");
    	login.clickLoginLink();
	    login.entervaliduserNameAndPassword();
	    login.clickSubmitButton();
    }
    public void navigateToAdvertisements() {
        HelperClass.log.info("Navigating to Marketplace");
        isDisplayed(advertisementPage.marketplaceMenu);
        waitForClickable(advertisementPage.marketplaceMenu);
        click(advertisementPage.marketplaceMenu);

        HelperClass.log.info("Navigating to Advertisements");
        click(advertisementPage.advertisementsMenu);
    }

    public void searchValidKeyword(String keyword) {
        HelperClass.log.info("Searching valid keyword: " + keyword);

        clearAndType(advertisementPage.searchBox, keyword);
        click(advertisementPage.searchButton);
    }

    public void verifySearchResultsDisplayed() {
        HelperClass.log.info("Verifying search results are displayed");
        isDisplayed(advertisementPage.searchResult);
    }

    public void searchInvalidKeyword(String keyword) {
        HelperClass.log.info("Searching invalid keyword: " + keyword);

        clearAndType(advertisementPage.searchBox, keyword);
        click(advertisementPage.searchButton);
    }

    public void verifyNoResultsDisplayed() {
        HelperClass.log.info("Verifying no results message");
        isDisplayed(advertisementPage.noResultsMessage);
    }

    public void addProductToFavouritesUsingExcel() throws IOException {

        HelperClass.log.info("Reading products from Excel");

        String path = "src/test/resources/TestData/AdvertisementsData.xlsx";

        String product1 = ExcelUtilities.getCellData(path, "Favourites", 1, 0);
        String product2 = ExcelUtilities.getCellData(path, "Favourites", 2, 0);

        addProductToFavourite(product1);
        addProductToFavourite(product2);
    }

    public void addProductToFavourite(String product) {

        HelperClass.log.info("Adding product to favourite: " + product);

        clearAndType(advertisementPage.searchBox, product);
        click(advertisementPage.searchButton);
        click(advertisementPage.favouriteIcon);
    }

    public void verifyProductAddedToFavourites() {
        HelperClass.log.info("Verifying product added to favourites");
        isDisplayed(advertisementPage.favouriteSuccessMessage);
    }

    // 🔹 DATATABLE
    public void addProductsFromDataTable(List<Map<String, String>> data) {

        HelperClass.log.info("Adding multiple products using DataTable");

        for (Map<String, String> row : data) {
            String product = row.get("product");
            addProductToFavourite(product);
        }
    }

    public void navigateToFavouritesPage() {
        HelperClass.log.info("Navigating to Favourites page");
        click(advertisementPage.favouritesMenu);
    }

    public void verifyFavouriteProductsDisplayed() {
        HelperClass.log.info("Verifying favourite products displayed");
        isDisplayed(advertisementPage.favouriteProductsList);
    }

    public void sortProducts(String sortType) {

        HelperClass.log.info("Sorting products by: " + sortType);

        selectByVisibleText(advertisementPage.sortDropdown, sortType);
    }

    public void verifyLowestPriceSorting() {
        HelperClass.log.info("Verifying lowest price sorting");
        isDisplayed(advertisementPage.productList);
    }

    public void verifyHighestPriceSorting() {
        HelperClass.log.info("Verifying highest price sorting");
        isDisplayed(advertisementPage.productList);
    }

    public void verifyLatestProductsSorting() {
        HelperClass.log.info("Verifying latest products sorting");
        isDisplayed(advertisementPage.productList);
    }

    public void clearAndType(By locator, String text) {

        HelperClass.log.info("Entering text: " + text);
        HelperClass.getDriver().findElement(locator).clear();
        sendKeys(locator, text);
    }
    
    public void selectByVisibleText(By locator, String text) {

        HelperClass.log.info("Selecting value: " + text);
        WebElement element = HelperClass.getDriver().findElement(locator);
        Select select = new Select(element);
        select.selectByVisibleText(text);
    }
}