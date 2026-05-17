package com.StepDefinitions;

import com.Actions.BusinessDirectoryActions;
import com.Actions.LoginAction;
import com.Utilities.HelperClass;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BusinessDirectoryStepDefinition {

    BusinessDirectoryActions actions =  new BusinessDirectoryActions();

    LoginAction loginAction = new LoginAction();

    @Given("User logs into the cyclos application for business directory")
    public void user_logs_into_the_cyclos_application_for_business_directory() {

        HelperClass.openPage();

        loginAction.clickLoginLink();

        loginAction.entervaliduserNameAndPassword();

        loginAction.clickSubmitButton();
    }

    @When("User navigates to business directory page")
    public void user_navigates_to_business_directory_page() {

        actions.navigateBusinessDirectory();
    }

    @When("User enters keyword {string}")
    public void user_enters_keyword(String keyword) {

        actions.enterKeyword(keyword);
    }

    @Then("Matching business records should be displayed")
    public void matching_business_records_should_be_displayed() {

        actions.validateSearchResults();
    }

   

    @When("User clicks on list view option")
    public void user_clicks_on_list_view_option() {

        actions.clickListView();
    }

    @Then("Business records should display in list view")
    public void business_records_should_display_in_list_view() {

        actions.validateListView();
    }

    @When("User clicks on tiled view option")
    public void user_clicks_on_tiled_view_option() {

        actions.clickTiledView();
    }

    @Then("Business records should display in tiled view")
    public void business_records_should_display_in_tiled_view() {

        actions.validateTiledView();
    }

    @When("User selects ascending order from orders dropdown")
    public void user_selects_ascending_order_from_orders_dropdown() {

        actions.selectAscendingOrder();
    }

    @Then("Business records should display in ascending order")
    public void business_records_should_display_in_ascending_order() {

        actions.validateAscendingOrder();
    }

    @When("User selects descending order from orders dropdown")
    public void user_selects_descending_order_from_orders_dropdown() {

        actions.selectDescendingOrder();
    }

    @Then("Business records should display in descending order")
    public void business_records_should_display_in_descending_order() {

        actions.validateDescendingOrder();
        
    }
}