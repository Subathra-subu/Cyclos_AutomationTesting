package com.StepDefinitions;

import java.io.File;
import java.io.IOException;
import org.testng.Assert;
import com.Actions.LoginAction;
import com.Actions.ReqpaymentActions;
import com.Utilities.HelperClass;

import io.cucumber.java.en.And;
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
        
       
        String downloadDirPath = HelperClass.getDownloadPath();
        
        reqaction.waitForFileDownload(downloadDirPath, ".pdf");

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

        Assert.assertNotNull(downloadedPdf, "Assertion Failed: No PDF file found in folder: " + downloadDirPath);
        Assert.assertTrue(downloadedPdf.exists(), "Assertion Failed: The file object does not exist on disk!");
        HelperClass.log.info("Found file for validation: " + downloadedPdf.getName());

        long fileSizeInBytes = downloadedPdf.length();
        HelperClass.log.info("Downloaded PDF File Size: " + fileSizeInBytes + " bytes");
        
        Assert.assertTrue(fileSizeInBytes > 0, "Assertion Failed: The downloaded PDF file is completely empty (0 bytes)!");
        HelperClass.log.info("PDF Download validation successful! File size and presence verified.");

        downloadedPdf.delete();
    }

   
    @When("the user clicks the Send a new request button")
    public void the_user_clicks_the_send_a_new_request_button() {
        reqaction.clickSendRequest();
    }

    @When("the user enters only the name and amount details from excel leaving the date empty")
    public void the_user_enters_only_the_name_and_amount_details_from_excel_leaving_the_date_empty() throws IOException {
        reqaction.excelDataForEmptyDate();
    }

    @And("clicks the form primary confirm button")
    public void clicks_the_form_primary_confirm_button() {
        reqaction.submitForm();
    }

    @Then("the date field should display an error indicator text message saying {string}")
    public void the_date_field_should_display_an_error_indicator_text_message_saying(String expectedErrorText) {
       Assert.assertEquals(reqaction.assertDateValidationError(),expectedErrorText ); 
    }
}
