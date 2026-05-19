package com.StepDefinitions;

import com.Actions.AdvertisementAction;
import com.Actions.LoginAction;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class AdvertisementTest {

    AdvertisementAction advertisementActions = new AdvertisementAction();

    @Given("user is logged into the application")
    public void user_is_logged_into_the_application() {
    	advertisementActions.loginToApplication();

    }

    @Given("user navigates to advertisements page")
    public void user_navigates_to_advertisements_page() {
        advertisementActions.navigateToAdvertisements();
    }

    @When("user searches for a valid keyword {string}")
    public void user_searches_for_a_valid_keyword(String keyword) {
        advertisementActions.searchValidKeyword(keyword);
    }

    @Then("matching advertisements should be displayed")
    public void matching_advertisements_should_be_displayed() {
        advertisementActions.verifySearchResultsDisplayed();
    }

    @When("user searches for invalid keyword {string}")
    public void user_searches_for_invalid_keyword(String keyword) {
        advertisementActions.searchInvalidKeyword(keyword);
    }

    @Then("no results message should be displayed")
    public void no_results_message_should_be_displayed() {
        advertisementActions.verifyNoResultsDisplayed();
    }

    @When("user adds a product to favourites using excel data")
    public void user_adds_a_product_to_favourites_using_excel_data() throws IOException {
        advertisementActions.addProductToFavouritesUsingExcel();
    }

    @Then("product should be added to favourites successfully")
    public void product_should_be_added_to_favourites_successfully() {
        advertisementActions.verifyProductAddedToFavourites();
    }

    @Given("user has added below products to favourites")
    public void user_has_added_below_products_to_favourites(DataTable dataTable) {

        List<Map<String, String>> data =
                dataTable.asMaps(String.class, String.class);

        advertisementActions.addProductsFromDataTable(data);
    }

    @When("user navigates to favourites page")
    public void user_navigates_to_favourites_page() {
        advertisementActions.navigateToFavouritesPage();
    }

    @Then("favourite products should be displayed")
    public void favourite_products_should_be_displayed() {
        advertisementActions.verifyFavouriteProductsDisplayed();
    }

    @When("user sorts products using csv data {string}")
    public void user_sorts_products_using_csv_data(String sortType) {
        advertisementActions.sortProducts(sortType);
    }

    @When("user sorts products by {string}")
    public void user_sorts_products_by(String sortType) {
        advertisementActions.sortProducts(sortType);
    }

    @Then("products should be displayed in lowest to highest price order")
    public void products_should_be_displayed_in_lowest_to_highest_price_order() {
        advertisementActions.verifyLowestPriceSorting();
    }

    @Then("products should be displayed in highest to lowest price order")
    public void products_should_be_displayed_in_highest_to_lowest_price_order() {
        advertisementActions.verifyHighestPriceSorting();
    }

    @Then("latest products should be displayed first")
    public void latest_products_should_be_displayed_first() {
        advertisementActions.verifyLatestProductsSorting();
    }
}