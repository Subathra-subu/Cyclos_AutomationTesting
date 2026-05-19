
package com.StepDefinitions;
//
import org.testng.Assert;

import com.Actions.InviteUserActions;
import com.Actions.LoginAction;
import com.Pages.InviteUserPage;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;

public class UserInviteSteps {

    InviteUserPage invitePage = new InviteUserPage();
    InviteUserActions inviteActions = new InviteUserActions(invitePage);
    LoginAction logaction = new LoginAction();

    @Given("User loads the Cyclos application")
    public void user_loads_the_cyclos_application() {
        System.out.println("Application launched");
    }

    @Given("user logs in to the application with valid credentials")
    public void user_logs_in_to_the_application_with_valid_credentials() {
    	logaction.clickLoginLink();
        logaction.entervaliduserNameAndPassword();
        logaction.clickSubmitButton();
    }

    @When("User navigates to Invite Users page")
    public void user_navigates_to_invite_users_page() {
        inviteActions.navigateToInvitePage();
    }

    @When("User enters valid email {string}")
    public void user_enters_valid_email(String email) {
        inviteActions.enterEmail(email);
    }

    @When("User clicks on submit invite button")
    public void user_clicks_on_submit_invite_button() {
        inviteActions.clickSendInvitation();
    }

    @Then("Invite should be sent successfully")
    public void invite_should_be_sent_successfully() {
        Assert.assertTrue(inviteActions.isSuccessMessageDisplayed());
    }

    @When("User enters invalid email {string}")
    public void user_enters_invalid_email(String email) {
        inviteActions.enterEmail(email);
    }

    @Then("Proper validation message should be displayed")
    public void proper_validation_message_should_be_displayed() {
        Assert.assertTrue(inviteActions.isValidationMessageDisplayed());
    }
}

