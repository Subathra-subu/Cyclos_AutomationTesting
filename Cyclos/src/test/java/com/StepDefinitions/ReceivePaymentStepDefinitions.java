package com.StepDefinitions;

import org.testng.Assert;

import com.Pages.LoginPage;
import com.Actions.LoginAction;
import com.Actions.ReceivePaymentActions;
import com.Utilities.ConfigureClass;
import com.Utilities.HelperClass;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ReceivePaymentStepDefinitions {

    LoginAction loginactions = new LoginAction();
    ReceivePaymentActions receivePaymentPage = new ReceivePaymentActions();

    @Given("Registered user launches the Cyclos application")
    public void registered_user_launches_the_cyclos_application() {
        //Done By hooks
    }

    @When("User logs in with valid credentials")
    public void user_logs_in_with_valid_credentials() {
    	//Done By Hooks
    }

    @When("User navigates to the Receive Payment page")
    public void user_navigates_to_the_receive_payment_page() {
    	receivePaymentPage.clickingLinks();
    }

    @When("User enters payment details with {string}, {string} and {string}")
    public void user_enters_payment_details_with_and(String user, String amount, String description) {
        receivePaymentPage.enterDetails(user, amount, description);
        receivePaymentPage.clickingNext();
    }

    @When("User clicks on the Submit button and confirms the password {string}")
    public void user_clicks_on_the_submit_button(String confirmpass) {
    	receivePaymentPage.submit(confirmpass);
    }

    @Then("Payment should be received successfully")
    public void payment_should_be_received_successfully() {
    	receivePaymentPage.isPaymentSuccessful();
    }
    
    @And("User leaves name field blank and enter details with {string}")
    public void user_enters_invalid_name(String amount) {
    	receivePaymentPage.enterInvalidUserDetails(amount);
    	receivePaymentPage.clickingNext();
    }
    
    @Then("Appropriate error message for invalid user should be displayed")
    public void appropriate_error_message_for_invalid_user_should_be_displayed() {
    	receivePaymentPage.requiredfieldError();
    }

    @And("User enters invalid payment details with {string}, {string} and {string}")
    public void user_enters_invalid_payment_details(String user, String amount, String description) {
        receivePaymentPage.enterDetails(user, amount, description);
    }
    
    @And("User clicks on the next button")
    public void user_clicks_on_the_submit_button() {
    	receivePaymentPage.clickingNext();
    }
    
    @Then("Appropriate error message for amount should be displayed")
    public void appropriate_error_message_should_be_displayed() {
    	receivePaymentPage.errorMessageDisplayed();
    }
    
    @When("User leaves payment fields empty")
    public void user_leaves_payment_fields_empty() {
        receivePaymentPage.clickingNext();
    }
    @Then("Validation message for mandatory fields should be displayed")
    public void validation_message_for_mandatory_fields_should_be_displayed() {
        receivePaymentPage.requiredfieldError();
    }
    
    @Then("the alert message for exceeding limit should be displayed")
    	public void the_alert_message_for_exceeding_limit_should_be_displayed() {
    	receivePaymentPage.isPaymentSuccessful();
    	}
}