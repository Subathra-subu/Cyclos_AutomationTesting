package com.StepDefinitions;

import java.io.IOException;

import com.Actions.AdvertisementAction;
import com.Actions.LoginAction;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AdvertisementTest {

    AdvertisementAction advertisementAction =
            new AdvertisementAction();

    LoginAction loginAction =
            new LoginAction();

    @Given("the user login to the cyclos website")
    public void the_user_login_to_the_cyclos_website() {

        loginAction.clickLoginLink();
        loginAction.entervaliduserNameAndPassword();
        loginAction.clickSubmitButton();
    }

    @And("the user navigates to Marketplace Advertisement module")
    public void the_user_navigates_to_marketplace_advertisement_module() {

        advertisementAction.clickMarketplace();
        advertisementAction.navigateToAdvertisement();
    }

    @When("the user searches advertisements using the following details")
    public void the_user_searches_advertisements_using_the_following_details(
            DataTable dataTable) {

        advertisementAction.searchAdvertisement(
                dataTable);
    }

    @Then("relevant advertisements should be displayed")
    public void relevant_advertisements_should_be_displayed() {

        advertisementAction.verifySearchResults();
    }
    
    @When("user searches advertisement with not available products keyword")
    public void user_searches_advertisement_with_not_available_products_keyword() {

        advertisementAction.searchInvalidAdvertisementKeyword();
    }

    @Then("no matching advertisements should be displayed")
    public void no_matching_advertisements_should_be_displayed() {

        advertisementAction.verifyNoSearchResults();
    }
    @When("user adds advertisements to favourites using excel data")
    public void user_adds_advertisements_to_favourites_using_excel_data()
            throws IOException {

        advertisementAction.addAdvertisementToFavourites();
    }

    @Then("selected advertisements should be added to favourites")
    public void selected_advertisements_should_be_added_to_favourites() {

        advertisementAction.verifyAdvertisementAddedToFavourites();
    }
    @When("user filters advertisements with minimum price {string} and maximum price {string}")
    public void user_filters_advertisements_with_minimum_price_and_maximum_price(
            String minPrice,
            String maxPrice) {

        advertisementAction
                .filterByPriceRange(
                        minPrice,
                        maxPrice);
    }

    @Then("filtered advertisements should be displayed")
    public void filtered_advertisements_should_be_displayed() {

        advertisementAction
                .verifyFilteredAdvertisements();
    }
    @When("user filters advertisements with images")
    public void user_filters_advertisements_with_images() {

        advertisementAction
                .filterAdvertisementsWithImages();
    }

    @Then("advertisements containing images should be displayed")
    public void advertisements_containing_images_should_be_displayed() {

        advertisementAction
                .verifyAdvertisementsWithImages();
    }
    @When("user filters favourite advertisements")
    public void user_filters_favourite_advertisements() {

        advertisementAction.filterFavouriteAdvertisements();
    }

    @Then("only favourite advertisements should be displayed")
    public void only_favourite_advertisements_should_be_displayed() {

        advertisementAction.verifyFavouriteFilteredAdvertisements();
    }
    
    @When("user searches advertisement with invalid keyword")
    public void user_searches_advertisement_with_invalid_keyword() {

        advertisementAction
                .searchInvalidKeyword("@@@@@");
    }

    @Then("invalid keyword search result should be displayed")
    public void invalid_keyword_search_result_should_be_displayed() {

        advertisementAction
                .verifyInvalidKeywordPopup();
    }
    
    @When("user clicks any one of the listed advertisement in the page")
    public void user_clicks_any_one_of_the_listed_advertisement_in_the_page() {
    	advertisementAction.communityListClick();
    }
    @Then("the respective advertisement details should be shown successfully")
    public void the_respective_advertisement_details_should_be_shown_successfully() {
    	
    }
}