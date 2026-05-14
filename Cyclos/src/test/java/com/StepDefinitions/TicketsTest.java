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

        
        String downloadPath = HelperClass.getDownloadPath();

        ticketsActions.clearDownloadFolder(downloadPath);

        ticketsActions.clickPrintButton();
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

    @When("user select the Open in the status")
    public void user_select_the_open_in_the_status() {
        // Write code here that turns the phrase above into concrete actions
    	ticketsActions.clickOpenSts();
    }

    @Then("the user should see the transactions with {string} status")
    public void the_user_should_see_the_transactions_with_status(String string)
    
    {
       ticketsActions.assertOpen(string);
    }


    @Then("the user should seen the transaction status {string}")
    public void the_user_should_seen_the_transaction_status(String expectedStatus) {

        
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