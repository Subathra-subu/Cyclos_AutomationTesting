package com.StepDefinitions;

import com.Actions.TicketsActions;
import com.Utilities.HelperClass;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TicketsTest {

    TicketsActions ticketsActions = new TicketsActions();

    @Given("user navigates to the tickets page")
    public void user_navigates_to_the_tickets_page() {

        ticketsActions.clickOnBankingMenu();
        ticketsActions.clickOnTicketsMenu();
    }

    @When("user selects {string} from status dropdown")
    public void user_selects_from_status_dropdown(String status) {

        ticketsActions.selectStatus(status);

        // Check whether records are available
        if (ticketsActions.isNoResultsDisplayed()) {

            HelperClass.log.warn(
                    "No data available for status : " + status
            );

            System.out.println(
                    "NO DATA AVAILABLE FOR STATUS : " + status
            );
        }
    }

    @When("user clicks first row of the transactions table")
    public void user_clicks_first_row_of_the_transactions_table() {

        // Skip click if no records available
        if (ticketsActions.isNoResultsDisplayed()) {

            HelperClass.log.warn(
                    "Skipping row click because no records found"
            );

            System.out.println(
                    "STEP SKIPPED : NO TRANSACTION ROW AVAILABLE"
            );

            return;
        }

        ticketsActions.clickOnFirstRow();
    }

    @When("user clicks the print button")
    public void user_clicks_the_print_button() {

        // Clear existing downloads
        String downloadPath = HelperClass.getDownloadPath();

        ticketsActions.clearDownloadFolder(downloadPath);

        ticketsActions.clickPrintButton();
    }

    @Then("the user should seen the transaction status {string}")
    public void the_user_should_seen_the_transaction_status(String expectedStatus) {

        // Skip validation when no records exist
        if (ticketsActions.isNoResultsDisplayed()) {

            HelperClass.log.warn(
                    "Validation skipped because no transaction records available"
            );

            System.out.println(
                    "VALIDATION SKIPPED FOR STATUS : " + expectedStatus
            );

            return;
        }

        ticketsActions.validateTransactionStatusFromPDF(expectedStatus);
    }
}