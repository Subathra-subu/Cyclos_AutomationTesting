package com.StepDefinitions;

import org.testng.Assert;

import com.Pages.LoginPage;
import com.Pages.ReceivePaymentPage;
import com.Utilities.ConfigureClass;
import com.Utilities.HelperClass;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ReceivePaymentStepDefinitions {

    LoginPage loginPage = new LoginPage();
    ReceivePaymentPage receivePaymentPage = new ReceivePaymentPage();

    @Given("Registered user launches the Cyclos application")
    public void registered_user_launches_the_cyclos_application() {
        HelperClass.setupDriver();
        HelperClass.openPage();
    }

    @When("User logs in with valid credentials")
    public void user_logs_in_with_valid_credentials() {

        loginPage.loginToTheWebsite(
                ConfigureClass.getUsername(), ConfigureClass.getPassword());
    }

    @When("User navigates to the Receive Payment page")
    public void user_navigates_to_the_receive_payment_page() {
    	receivePaymentPage.clickingLinks();
    }

    @When("User enters payment details with {string}, {string} and {string}")
    public void user_enters_payment_details_with_and(String user, String amount, String description) {
        receivePaymentPage.enterDetails(user, amount, description);
    }



    @When("User clicks on the Submit button and confirms the password {string}")
    public void user_clicks_on_the_submit_button(String confirmpass) {
//    	receivePaymentPage.submit(confirmpass);
    }

    @Then("Payment should be received successfully")
    public void payment_should_be_received_successfully() {
//    	Assert.assertTrue(receivePaymentPage.isPaymentSuccessful());
    }

}