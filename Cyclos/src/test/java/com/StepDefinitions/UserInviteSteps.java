package com.StepDefinitions;

import org.testng.Assert;

import com.Pages.InviteUserPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UserInviteSteps {

    InviteUserPage invitePage = new InviteUserPage();

    @Given("User launches Cyclos application")
    public void user_launches_cyclos_application() {

        System.out.println("Application launched");
    }

    @Given("User logs in with valid credentials")
    public void user_logs_in_with_valid_credentials() {

        invitePage.loginApplication("demo", "1234");
    }

    @When("User navigates to Invite Users page")
    public void user_navigates_to_invite_users_page() {

        invitePage.navigateToInvitePage();
    }

    @When("User enters valid email {string}")
    public void user_enters_valid_email(String email) {

        invitePage.enterEmail(email);
    }

    @When("User clicks on submit invite button")
    public void user_clicks_on_submit_invite_button() {

        invitePage.clickSendInvitation();
    }

    @Then("Invite should be sent successfully")
    public void invite_should_be_sent_successfully() {

        Assert.assertTrue(invitePage.verifySuccessMessage());
    }

    @When("User enters invalid email {string}")
    public void user_enters_invalid_email(String email) {

        invitePage.enterEmail(email);
    }

    @Then("Proper validation message should be displayed")
    public void proper_validation_message_should_be_displayed() {

        Assert.assertTrue(invitePage.verifyValidationMessage());
    }
}