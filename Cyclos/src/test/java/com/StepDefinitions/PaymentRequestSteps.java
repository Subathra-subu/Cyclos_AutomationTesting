package com.StepDefinitions;

import com.Actions.LoginAction;
import com.Actions.ReqpaymentActions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PaymentRequestSteps {

	ReqpaymentActions reqaction = new ReqpaymentActions();
	LoginAction logaction = new LoginAction();
	@Given("the user Login with valid credentials")
	public void the_user_login_with_valid_credentials() {
	    // Write code here that turns the phrase above into concrete actions
	    logaction.entervaliduserNameAndPassword();
	    logaction.clickSubmitButton();
	}

	@Given("the user navigates to the Payment Request page")
	public void the_user_navigates_to_the_payment_request_page() {
	    // Write code here that turns the phrase above into concrete actions
	     reqaction.navigatetoPayRequest();
	}

	@When("the user clicks on the Send a new request button")
	public void the_user_clicks_on_the_send_a_new_request_button() {
	    // Write code here that turns the phrase above into concrete actions
	    reqaction.clickSendRequest();
	}

	  @When("the user enters payment request details {string} {string} {string}")
	    public void the_user_enters_payment_request_details(String receiver, String amount, String date) {

		   }

	@When("the user clicks on the Confirm button")
	public void the_user_clicks_on_the_confirm_button() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("the payment request should be created successfully")
	public void the_payment_request_should_be_created_successfully() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("a validation message should be displayed for past expiration date")
	public void a_validation_message_should_be_displayed_for_past_expiration_date() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("a warning message should be displayed")
	public void a_warning_message_should_be_displayed() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("the user selects an existing payment request")
	public void the_user_selects_an_existing_payment_request() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("the user clicks on cancel payment request")
	public void the_user_clicks_on_cancel_payment_request() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("the payment request should be cancelled successfully")
	public void the_payment_request_should_be_cancelled_successfully() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("the user opens the payment request details page")
	public void the_user_opens_the_payment_request_details_page() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("the user clicks on the Print button")
	public void the_user_clicks_on_the_print_button() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("the payment request PDF should be generated successfully")
	public void the_payment_request_pdf_should_be_generated_successfully() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

}
