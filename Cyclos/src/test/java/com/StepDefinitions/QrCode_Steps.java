package com.StepDefinitions;

import org.testng.Assert;
import io.cucumber.java.en.*;

import com.Actions.LoginAction;
import com.Actions.QR_Actions;

public class QrCode_Steps {

    QR_Actions qrActions = new QR_Actions();
    LoginAction logaction = new LoginAction();

    @Given("User launches the Cyclos application")
    public void user_launches_the_cyclos_application() {
        System.out.println("Application launched");
    }

    @Given("User logged in with valid credentials")
    public void user_logged_in_with_valid_credentials() {
        logaction.clickLoginLink();
        logaction.entervaliduserNameAndPassword();
        logaction.clickSubmitButton();
    }

    @Given("the user navigates to the QR Code page")
    public void navigate_to_qr_page() {
        qrActions.navigateToQRPage();
    }

    @When("the user enters amount {string}")
    public void the_user_enters_amount(String amount) {
        qrActions.enterAmount(amount);
    }

    @When("the user clicks on the generate QR code button")
    public void click_generate_button() {
        qrActions.clickGenerate();
    }

    @When("the user clicks on the Generate New QR Code button")
    public void click_new_generate_button() {
        qrActions.clickNewGenerate();
    }

    @Then("the QR code should be generated successfully")
    public void qr_generated_successfully() {
        Assert.assertTrue(qrActions.isQRGenerated());
    }

    @Then("a Field-level validation error message should be displayed")
    public void validation_message_displayed() {
        Assert.assertEquals(qrActions.getErrorMessage(), "This field is required");
    }

    @Then("the user should be redirected to the Receive QR Code page")
    public void redirected_to_receive_page() {
        Assert.assertEquals(qrActions.getGenerateText(), "Generate QR code");
    }
}