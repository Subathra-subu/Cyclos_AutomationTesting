package com.StepDefinitions;

import java.io.File;

import org.testng.Assert;

import com.Actions.TicketsActions;
import com.Utilities.FileUtility;
import com.Utilities.PDFUtility;

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
    }

    @When("user clicks transaction id {string}")
    public void user_clicks_transaction_id(String transactionId) {
        ticketsActions.clickTransactionId(transactionId);
    }

    @When("user clicks the print button")
    public void user_clicks_the_print_button() {
        ticketsActions.clickPrintButton();
    }

    @Then("transaction pdf should contain {string}")
    public void transaction_pdf_should_contain(String transactionId) {

        // Use File.separator so this works on both Windows and Linux/Mac
        String downloadPath = System.getProperty("user.dir")
                + File.separator + "Downloads";

        String fileExtension = ".pdf";

        // WAIT FOR DOWNLOAD TO COMPLETE
        ticketsActions.waitForFileDownload(downloadPath, fileExtension);

        // VERIFY FILE EXISTS
        Assert.assertTrue(
                FileUtility.isFileDownloaded(downloadPath, fileExtension),
                "PDF file was NOT downloaded to: " + downloadPath
        );

        // FIX: Find the actual downloaded PDF file dynamically instead of
        //      hardcoding "transaction.pdf" — the real filename may differ
        String pdfPath = FileUtility.getDownloadedFilePath(downloadPath, fileExtension);

        Assert.assertNotNull(pdfPath,
                "Could not locate downloaded PDF in: " + downloadPath);

        // READ PDF CONTENT
        String pdfContent = PDFUtility.readPDF(pdfPath);
        System.out.println("PDF Content:\n" + pdfContent);

        // ASSERT PDF CONTAINS TRANSACTION ID
        Assert.assertTrue(
                pdfContent.contains(transactionId),
                "Transaction ID [" + transactionId + "] NOT found inside PDF.\nPDF Content:\n" + pdfContent
        );
    }

    @Then("transaction status should be {string}")
    public void transaction_status_should_be(String expectedStatus) {
        String actualStatus = ticketsActions.getSelectedStatus();
        Assert.assertEquals(
                actualStatus,
                expectedStatus,
                "Status mismatch — Expected: [" + expectedStatus + "] | Actual: [" + actualStatus + "]"
        );
    }
}