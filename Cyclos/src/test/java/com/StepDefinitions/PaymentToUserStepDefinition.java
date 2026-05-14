package com.StepDefinitions;

import org.testng.Assert;

import com.Actions.PaymentToUserActions;
import com.Utilities.HelperClass;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PaymentToUserStepDefinition {

    PaymentToUserActions actions = new PaymentToUserActions();

    @Given("User should be logged into the application and must on home page")
    public void user_should_be_logged_into_the_application_and_must_on_home_page() {
    	HelperClass.setupDriver();
    	HelperClass.openPage();
    	actions.loginbtn();
    	actions.username();
    	actions.password();
    	actions.submit();
    }
    @When("User clicks the payment to user button")
    public void user_clicks_the_payment_to_user_button() {
    	actions.clickPayUser();
    }
    @When("User gives the empty user field {string}")
    public void user_gives_the_empty_user_field(String value) {
    	actions.enterUser(value);
    }
    @Then("User clicks the next button and should validate the error message is displayed")
    public void user_clicks_the_next_button_and_should_validate_the_error_message_is_displayed() {
    	actions.clickNext();
    	Assert.assertEquals(actions.validateErrorMessage(),"This field is required");
    }
}











 

