package com.StepDefinitions;

import java.io.File;
import org.testng.Assert;
import com.Actions.LoginAction;
import com.Actions.ReqpaymentActions;
import com.Utilities.HelperClass;
import com.Utilities.PDFUtility;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PaymentRequestSteps {

    ReqpaymentActions reqaction = new ReqpaymentActions();
    LoginAction logaction = new LoginAction();

    @Given("the user has logged in with valid credentials")
    public void the_user_has_logged_in_with_valid_credentials() {
        logaction.clickLoginLink();
        logaction.entervaliduserNameAndPassword();
        logaction.clickSubmitButton();
    }

    @Given("the user navigates to the Payment Request page")
    public void the_user_navigates_to_the_payment_request_page() {
        reqaction.navigateToPaymentRequestPage();
    }

    @When("the user selects an existing payment request from the list")
    public void the_user_selects_an_existing_payment_request_from_the_list() {
         reqaction.clickExistingUser();
    }

    @When("the user clicks on the print button")
    public void the_user_clicks_on_the_print_button() {
        reqaction.printRequest();
    }

    @Then("a PDF of the payment request should be generated successfully")
    public void a_pdf_of_the_payment_request_should_be_generated_successfully() {
        
        // 1. UTILIZE HELPER: Get the framework download directory path
        String downloadDirPath = HelperClass.getDownloadPath();
        
        // 2. UTILIZE BASEACTION: Use your built-in fluent wait to track the download completion
        reqaction.waitForFileDownload(downloadDirPath, ".pdf");

        // 3. TARGET THE FRESHLY DOWNLOADED FILE
        File directory = new File(downloadDirPath);
        File[] files = directory.listFiles();
        File downloadedPdf = null;
        long lastModifiedTime = Long.MIN_VALUE;

        if (files != null) {
            for (File file : files) {
                if (file.isFile() && file.getName().toLowerCase().endsWith(".pdf")) {
                    if (file.lastModified() > lastModifiedTime) {
                        downloadedPdf = file;
                        lastModifiedTime = file.lastModified();
                    }
                }
            }
        }

        // 4. ASSERTION 1: Verify the file handle is valid and exists
        Assert.assertNotNull(downloadedPdf, "Assertion Failed: No PDF file found in folder: " + downloadDirPath);
        Assert.assertTrue(downloadedPdf.exists(), "Assertion Failed: The file object does not exist on disk!");
        HelperClass.log.info("Found file for validation: " + downloadedPdf.getName());

        // 5. ASSERTION 2: Verify the file size is greater than 0 bytes (Ensures it downloaded successfully and isn't a corrupted 0 KB file)
        long fileSizeInBytes = downloadedPdf.length();
        HelperClass.log.info("Downloaded PDF File Size: " + fileSizeInBytes + " bytes");
        
        Assert.assertTrue(fileSizeInBytes > 0, "Assertion Failed: The downloaded PDF file is completely empty (0 bytes)!");

        HelperClass.log.info("PDF Download validation successful! File size and presence verified.");

        // 6. CLEANUP: Delete the file so it doesn't leak state into the next test run
        downloadedPdf.delete();
    }
}