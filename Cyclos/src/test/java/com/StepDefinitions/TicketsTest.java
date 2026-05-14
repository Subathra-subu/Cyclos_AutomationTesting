package com.StepDefinitions;

import java.io.File;

import com.Actions.TicketsActions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TicketsTest {

    TicketsActions ticketsActions =
            new TicketsActions();

    @Given("user navigates to the tickets page")
    public void user_navigates_to_the_tickets_page() {

        ticketsActions.clickOnBankingMenu();

        ticketsActions.clickOnTicketsMenu();
    }

    @When("user selects {string} from status dropdown")
    public void user_selects_from_status_dropdown(String status) {

        ticketsActions.selectStatus(status);
    }

    @When("user clicks first row of the transactions table")
    public void user_clicks_first_row_of_the_transactions_table() {

        ticketsActions.clickOnFirstRow();
    }

    @When("user clicks the print button")
    public void user_clicks_the_print_button() {

        String downloadPath =
                System.getProperty("user.dir")
                        + File.separator
                        + "Downloads";

        ticketsActions.clearDownloadFolder(downloadPath);

        ticketsActions.clickPrintButton();
    }

    @Then("the user should seen the transaction status {string}")
    public void the_user_should_seen_the_transaction_status(String expectedStatus) {

        ticketsActions.validateTransactionStatusFromPDF(expectedStatus);
    }
}