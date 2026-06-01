package com.StepDefinitions;

import com.Actions.NotificationsActions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class NotificationsTest {

    NotificationsActions notifications =
            new NotificationsActions();

    @When("User clicks on the Notifications icon")
    public void user_clicks_on_the_notifications_icon() {

        notifications.clickNotificationsIcon();
    }

    @Then("Notifications page should be displayed")
    public void notifications_page_should_be_displayed() {

        notifications.verifyNotificationsPage();
    }
}