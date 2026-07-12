package com.StepDefinitions;

import org.testng.Assert;
import io.cucumber.java.en.*;

import com.Actions.LoginAction;
import com.Actions.systempaymentAction;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class systempaymentsteps {
    systempaymentAction systempaymentaction = new systempaymentAction();
    
    LoginAction logaction = new LoginAction();

    @Given("User launched the Cyclos application")
    public void user_loads_the_cyclos_application() {
        System.out.println("Application launched");
    }

    @Given("User logged in with the  valid credential")
    public void user_logs_in_to_the_application_with_valid_credentials() {
        logaction.clickLoginLink();
        logaction.entervaliduserNameAndPassword();
        logaction.clickSubmitButton();
    }

	@Given("the user navigates to the Payment to System page")
	public void the_user_navigates_to_the_payment_to_system_page() {
	    // Write code here that turns the phrase above into concrete actions
		systempaymentaction.navigateToPaymentToSystemPage();
	}
	@When("the user enters valid amount {string}")
	public void the_user_enters_valid_amount(String amount) {
	    systempaymentaction.enterAmount(amount);
	}
	@When("clicks on the Next button")
	public void clicks_on_the_next_button() {
	    // Write code here that turns the phrase above into concrete actions
		systempaymentaction.clicknextButton();
	}

	@When("the user clicks on the Confirm button")
	public void the_user_clicks_on_the_confirm_button() {
	    // Write code here that turns the phrase above into concrete actions
	    systempaymentaction.clickConfirmButton();
	}

	@Then("the user should see a confirmation message {string}")
	public void the_user_should_see_a_confirmation_message(String expectedMessage) {

	    String actualMessage = systempaymentaction.getConfirmationMessage();

	    Assert.assertEquals(expectedMessage, actualMessage);
	}
	
	@Then("the user should see a validation error message {string}")
	public void the_user_should_see_a_validation_error_message(String expectedError) {

	    String actualError = systempaymentaction.getValidationErrorMessage();

	    Assert.assertEquals(actualError, expectedError);
	}
	
	@When("the user selects the payment method and choose date")
	public void the_user_selects_the_payment_method_and_choose_date() {
	    systempaymentaction.selectPaymentMethodAndDate();
	}
}
