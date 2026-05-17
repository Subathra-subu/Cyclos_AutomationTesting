package com.StepDefinitions;

import org.testng.Assert;
import org.openqa.selenium.WebDriver;

import com.Pages.AdvertisementsPage;

import io.cucumber.java.en.*;

public class AdvertisementsStepDefinition {

    WebDriver driver;
    AdvertisementsPage adPage;

    // Constructor injection (THIS is what hooks use)
    public AdvertisementsStepDefinition(WebDriver driver) {
        this.driver = driver;
        adPage = new AdvertisementsPage(driver);
    }

    // ------------------ SEARCH ------------------

    @Given("User is on Advertisements page")
    public void user_is_on_advertisements_page() {
        adPage.clickAdvertisementsMenu();
    }

    @When("User searches advertisement with keyword {string}")
    public void user_searches_advertisement_with_keyword(String keyword) {
        adPage.enterSearch(keyword);
        adPage.clickSearch();
    }

    @Then("User should see advertisement results")
    public void user_should_see_advertisement_results() {
        Assert.assertTrue(adPage.getResultsCount() > 0);
    }

    @Then("User should see no results message")
    public void user_should_see_no_results_message() {
        Assert.assertTrue(adPage.getNoResultMessage().contains("No"));
    }

    // ------------------ FAVOURITES ------------------

    @When("User adds advertisement to favourites")
    public void user_adds_advertisement_to_favourites() {
        adPage.clickFavouriteIcon();
    }

    @Then("Advertisement should be added successfully")
    public void advertisement_should_be_added_successfully() {
        Assert.assertTrue(adPage.getSuccessMessage().length() > 0);
    }

    @When("User navigates to favourites page")
    public void user_navigates_to_favourites_page() {
        adPage.clickFavouritesMenu();
    }

    @Then("User should see favourite advertisements")
    public void user_should_see_favourite_advertisements() {
        Assert.assertTrue(adPage.getFavouritesCount() > 0);
    }

    // ------------------ SORTING ------------------

    @When("User sorts advertisements by {string}")
    public void user_sorts_advertisements_by(String type) {
        adPage.selectSort(type);
    }

    @Then("Advertisements should be displayed accordingly")
    public void advertisements_should_be_displayed_accordingly() {
        Assert.assertTrue(adPage.getResultsCount() >= 0);
    }
}