package com.StepDefinitions;

import java.util.Map;

import com.Actions.LoginAction;
import com.Actions.PayExternalUserAction;
import com.Utilities.HelperClass;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;

public class PayExternalUserStepDefinition {

    PayExternalUserAction actions =
            new PayExternalUserAction();

    LoginAction login =
            new LoginAction();

    @Given("User should login successfully")
    public void user_should_login_successfully() {

        HelperClass.openPage();

        login.clickLoginLink();

        login.entervaliduserNameAndPassword();

        login.clickSubmitButton();
    }

    @When("User clicks pay user option")
    public void user_clicks_pay_user_option() {

        actions.clickPayUser();
    }

    @When("User clicks external payments option")
    public void user_clicks_external_payments_option() {

        actions.clickExternalPayments();
    }

    @When("User clicks pay external user option")
    public void user_clicks_pay_external_user_option() {

        actions.clickPayExternalUser();
    }

    @When("User enters external payment details")
    public void user_enters_external_payment_details(
            DataTable dataTable) {

        Map<String, String> data =
            dataTable.asMaps(
                String.class,
                String.class).get(0);

        actions.enterEmail(
                data.get("email"));

        actions.enterAmount(
                data.get("amount"));

        actions.enterDescription(
                data.get("description"));
    }

    @Then("User should navigate to payment confirmation page")
    public void user_should_navigate_to_payment_confirmation_page() {

        actions.clickNext();

        actions.validatePaymentConfirmationPage();
    }

    @When("User clicks confirm button")
    public void user_clicks_confirm_button() {

        actions.clickConfirm();
    }

    @Then("External payment should complete successfully")
    public void external_payment_should_complete_successfully() {

        actions.validateSuccessMessage();

        actions.validatePendingStatus();
    }

    @When("User leaves email field empty")
    public void user_leaves_email_field_empty() {

    }

    @When("User enters amount and description")
    public void user_enters_amount_and_description(
            DataTable dataTable) {

        Map<String, String> data =
            dataTable.asMaps(
                String.class,
                String.class).get(0);

        actions.enterAmount(
                data.get("amount"));

        actions.enterDescription(
                data.get("description"));
    }

    @Then("User should validate email error message {string}")
    public void user_should_validate_email_error_message(
            String expectedMessage) {

        actions.clickNext();

        actions.validateEmailErrorMessage(
                expectedMessage);
    }
    @When("User opens the payment with description {string}")
    public void user_opens_the_payment_with_description(String description) {

        actions.openPayment(description);
    }
    @When("User clicks {string}")
    public void user_clicks(String button) {

        actions.clickCancelPayment();
    }
    @When("User enters cancellation comment {string}")
    public void user_enters_cancellation_comment(String comment) {

        actions.enterCancellationComment(comment);
    }
    @When("User clicks Confirm")
    public void user_clicks_confirm() {

        actions.clickConfirmCancellation();
    }
    @Then("External payment should be cancelled successfully")
    public void external_payment_should_be_cancelled_successfully() {

        actions.validateCancellationSuccess();
    }
    @Then("User should validate invalid email error message")
    public void user_should_validate_invalid_email_error_message() {

        actions.clickNext();

        actions.validateInvalidEmailErrorMessage();
    }
}