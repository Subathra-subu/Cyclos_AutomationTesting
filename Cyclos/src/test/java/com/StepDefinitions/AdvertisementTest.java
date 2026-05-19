package com.StepDefinitions;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.Actions.AdvertisementAction;
import com.Actions.LoginAction;
import com.Utilities.HelperClass;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;

public class AdvertisementTest {

    AdvertisementAction action = new AdvertisementAction();
    LoginAction login = new LoginAction();

    @Given("user is logged into the application")
    public void user_logged_in() {
        login.clickLoginLink();
        login.entervaliduserNameAndPassword();
        login.clickSubmitButton();
    }

    @And("user navigates to advertisements page")
    public void navigate_ads_page() {
        action.clickingLinks();
    }

    @When("user searches for a valid keyword {string}")
    public void valid_search(String keyword) {
        action.searchValidKeyword(keyword);
    }

    @Then("matching advertisements should be displayed")
    public void verify_valid() {
        action.verifySearchResult();
    }

    // INVALID
    @When("user searches for invalid keyword {string}")
    public void invalid_search(String keyword) {
        action.searchInvalidKeyword(keyword);
    }

    @Then("no results message should be displayed")
    public void verify_invalid() {
        action.verifyNoResult();
    }

    // EXCEL
    @When("user adds a product to favourites using excel data")
    public void excel_fav() throws IOException {
        action.addProductToFavouritesUsingExcel();
    }

    @Then("product should be added to favourites successfully")
    public void verify_fav() {
        action.verifyProductAddedToFav();
    }

    // DATATABLE
    @Given("user has added below products to favourites")
    public void datatable(DataTable table) {

        List<Map<String, String>> data = table.asMaps(String.class, String.class);

        for (Map<String, String> row : data) {
            action.addProductToFavourite(row.get("product"));
        }
    }

    @When("user navigates to favourites page")
    public void nav_fav() {}

    @Then("favourite products should be displayed")
    public void verify_list() {
        action.verifySearchResult();
    }

    // SORT
    @When("user sorts products using csv data {string}")
    public void sort_csv(String type) {
        action.sortProduct(type);
    }

    @When("user sorts products by {string}")
    public void sort(String type) {
        action.sortProduct(type);
    }

    @Then("products should be displayed in lowest to highest price order")
    public void low() {
        action.verifyLowestPrice();
    }

    @Then("products should be displayed in highest to lowest price order")
    public void high() {
        action.verifyHighestPrice();
    }

    @Then("latest products should be displayed first")
    public void latest() {
        action.verifyLatestProducts();
    }
}