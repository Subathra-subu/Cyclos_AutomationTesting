package com.StepDefinitions;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.Pages.QRcode_page;

public class QrCode_Steps {

    QRcode_page qrPage = new QRcode_page();

    @Given("the user navigates to the QR Code page")
    public void the_user_navigates_to_the_qr_code_page() {

        qrPage.navigatetoBankingPage();
    }

    @When("the user enters a valid amount {string}")
    public void the_user_enters_a_valid_amount(String amount) {

        qrPage.enter_amount(amount);
    }

    @When("the user enters a blank amount")
    public void the_user_enters_a_blank_amount() {

        qrPage.enter_amount("");
    }

    @When("the user clicks on the generate QR code button")
    public void the_user_clicks_generate_qr_button() {

        qrPage.clickqrButton();
    }

    @Then("the QR code should be generated successfully")
    public void qr_code_should_be_generated_successfully() {

        Assert.assertTrue(qrPage.QrVerification());
    }

    @When("the user clicks on the Generate New QR Code button")
    public void click_generate_new_qr_code() {

        qrPage.clickqrButtonnew();
    }

    @Then("the user should be redirected to the Receive QR Code page")
    public void redirected_to_receive_qr_page() {

        Assert.assertEquals(qrPage.newgen(),"Generate QR code");
    }

    @Then("a Field-level validation error message should be displayed")
    public void validation_error_should_be_displayed() {

        Assert.assertEquals(
                qrPage.errormessage(),
                "This field is required"
        );
    }
}