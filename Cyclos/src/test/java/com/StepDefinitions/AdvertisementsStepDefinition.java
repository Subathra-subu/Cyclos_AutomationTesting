package com.StepDefinitions;

import org.testng.Assert;
import org.openqa.selenium.WebDriver;

import com.Actions.AdvertisementsActions;
import com.Pages.AdvertisementsPage;

import io.cucumber.java.en.*;

public class AdvertisementsStepDefinition {
	
	AdvertisementsActions adsActions = new AdvertisementsActions();

    @Given("user is logged into the application")
    public void given_user_is_logged_into_the_application() {
    	//Done by hooks
    }
    
    @And("user navigates to advertisements page")
    public void user_navigates_to_advertisements_page() {
    	adsActions.clickingLinks();
    }
    
    @When("user searches for a valid keyword{string}")
    public void user_searches_for_keyword(String keyword) {
    	adsActions.searchingProduct(keyword);
    }
    
    @Then("matching advertisements should be displayed")
    public void matching_advertisements_should_be_displayed() {
        adsActions.favtIconCheck();
    }
    
    @When("user searches for invalid keyword {string}")
    public void user_searches_for_invalid_keyword(String keyword) {
    	adsActions.searchingProduct(keyword);
    }
    
    @Then("no results message should be displayed")
    public void no_results_message_should_be_displayed() {
    	adsActions.noresultError();
    }
    
    @When("user adds a product to favourites")
}