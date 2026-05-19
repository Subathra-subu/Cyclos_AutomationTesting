package com.StepDefinitions;

import com.Actions.LoginAction;
import com.Actions.TicketsActions;
import com.Utilities.HelperClass;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TicketsTest {

	TicketsActions ticketsActions = new TicketsActions();


	LoginAction login = new LoginAction();

	@Given("the user Login with the valid data")
	public void the_user_login_with_the_valid_data() {
	    // Write code here that turns the phrase above into concrete actions
		login.clickLoginLink();
	    login.entervaliduserNameAndPassword();
	    login.clickSubmitButton();
	}

	@Given("the user click the Banking menu")
	public void the_user_click_the_banking_menu() {
	    // Write code here that turns the phrase above into concrete actions
		ticketsActions.clickOnBankingMenu();
	}

	@Given("the user navigate to  the Tickets Page")
	public void the_user_navigate_to_the_tickets_page() {
	    // Write code here that turns the phrase above into concrete actions
		ticketsActions.clickOnTicketsMenu();
	}


	@When("user selects {string} from status dropdown")
	public void user_selects_from_status_dropdown(String status) {

		ticketsActions.selectStatus(status);

	}

	@When("user clicks the print button")
	public void user_clicks_the_print_button() {

		if (ticketsActions.isNoResultsDisplayed()) {

			HelperClass.log.warn("Skipping print action because no records found");
		}

		else
		{
		String downloadPath = HelperClass.getDownloadPath();

		ticketsActions.clearDownloadFolder(downloadPath);

		ticketsActions.clickPrintButton();
		}
	}

	@When("user clicks first row of the transactions table")
	public void user_clicks_first_row_of_the_transactions_table() {

		if (ticketsActions.isNoResultsDisplayed()) {

			HelperClass.log.warn("Skipping first row click because no records found");
		}

		else
		{
		ticketsActions.clickOnFirstRow();
		}
	}

	@When("user clicks on the filter link")
	public void user_clicks_on_the_filter_link()

	{

		ticketsActions.filterClick();

	}

	@When("user clicks on the status filter dropdown")
	public void user_clicks_on_the_status_filter_dropdown()

	{
		ticketsActions.filterStsClick();

	}

	@When("user select the {string} status")
	public void user_select_the_status(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    ticketsActions.clickStatus(string);
	}

	@Then("the user should see the transactions with {string} status")
	public void the_user_should_see_the_transactions_with_status(String string)

	{
		if (ticketsActions.isNoResultsDisplayed()) {

			HelperClass.log.warn("Validation skipped because no transaction records available");

			System.out.println("VALIDATION SKIPPED FOR STATUS : " + string);

			return;
		}
		ticketsActions.assertOpen(string);
	}

	@Then("the user should seen the transaction status {string}")
	public void the_user_should_seen_the_transaction_status(String expectedStatus) {

		if (ticketsActions.isNoResultsDisplayed()) {

			ticketsActions.assertNoResultsMessage();
		}

		else
		{
		ticketsActions.validateTransactionStatusFromPDF(expectedStatus);
		}
	}
}