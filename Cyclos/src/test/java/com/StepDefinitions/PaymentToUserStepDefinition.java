package com.StepDefinitions;

import java.util.Map;

import com.Actions.LoginAction;
import com.Actions.PaymentToUserActions;
import com.Utilities.HelperClass;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PaymentToUserStepDefinition {

	PaymentToUserActions actions = new PaymentToUserActions();

	LoginAction login = new LoginAction();

	@Given("User should be logged into application and must on home page")
	public void user_should_be_logged_into_application_and_must_on_home_page() {

		HelperClass.openPage();

		login.clickLoginLink();

		login.entervaliduserNameAndPassword();

		login.clickSubmitButton();
	}

	@When("User clicks the payment to user button")
	public void user_clicks_the_payment_to_user_button() {

		actions.clickPayUser();
	}

	@When("User gives the empty user field {string}")
	public void user_gives_the_empty_user_field(String value) {

	}

	@Then("User clicks the next button and should validate the error message is displayed")
	public void user_clicks_the_next_button_and_should_validate_the_error_message_is_displayed() {

		actions.clickNext();

		actions.validateErrorMessage("This field is required");
	}

	@When("User enters payment details")
	public void user_enters_payment_details(DataTable dataTable) {

		Map<String, String> data = dataTable.asMaps(String.class, String.class).get(0);

		actions.enterUser(data.get("username"));

		actions.enterAmount(data.get("amount"));
	}

	@Then("User should successfully complete the payment")
	public void user_should_successfully_complete_the_payment() {

		actions.clickNext();

		actions.validatePaymentConfirmationTitle();
	}

	@When("User enters valid user {string}")
	public void user_enters_valid_user(String username) {

		actions.enterUser(username);
	}

	@When("User enters amount {string}")
	public void user_enters_amount(String amount) {

		actions.enterAmount(amount);
	}

	@Then("User clicks the next button and should validate limit exceeded message {string}")
	public void user_clicks_the_next_button_and_should_validate_limit_exceeded_message(String expectedMessage) {

		actions.clickNext();


	}

	@When("User enters scheduled payment details")
	public void user_enters_scheduled_payment_details(DataTable dataTable) {

		Map<String, String> data = dataTable.asMaps(String.class, String.class).get(0);

		actions.enterUser(data.get("username"));

		actions.enterAmount(data.get("amount"));

		actions.selectSchedulingType(data.get("type"));

		actions.selectFutureDate(data.get("date"));

		actions.enterDescription(data.get("description"));
	}

	@Then("User should successfully schedule the payment")
	public void user_should_successfully_schedule_the_payment() {

		actions.clickNext();

		actions.validatePaymentConfirmationTitle();
	}

	@When("User enters recurring payment details")
	public void user_enters_recurring_payment_details(DataTable dataTable) {

		Map<String, String> data = dataTable.asMaps(String.class, String.class).get(0);

		actions.enterUser(data.get("username"));

		actions.enterAmount(data.get("amount"));

		actions.selectSchedulingType(data.get("type"));

		actions.enterDescription(data.get("description"));
	}

	@Then("Recurring payment should be scheduled successfully")
	public void recurring_payment_should_be_scheduled_successfully() {

		actions.clickNext();

		actions.validatePaymentConfirmationTitle();
	}

	@When("User enters monthly installment payment details")
	public void user_enters_monthly_installment_payment_details(DataTable dataTable) {

		Map<String, String> data = dataTable.asMaps(String.class, String.class).get(0);

		actions.enterUser(data.get("username"));

		actions.enterAmount(data.get("amount"));

		actions.selectSchedulingType(data.get("type"));

		actions.enterNumberOfInstallments(data.get("installments"));

		actions.enterDescription(data.get("description"));
	}

	@Then("Monthly installment payment should be scheduled successfully")
	public void monthly_installment_payment_should_be_scheduled_successfully() {

		actions.clickNext();

		actions.validatePaymentConfirmationTitle();
	}
}