package com.StepDefinitions;

import com.Actions.NotificationsActions;

import io.cucumber.java.en.And;
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
    
    @And("User is on the Notifications page")
    public void user_is_on_the_notifications_page() {
    	notifications.openNotifications();
    }

    @When("User unchecks the Unread Only checkbox")
    public void user_unchecks_the_unread_only_checkbox() {
    	notifications.uncheckUnreadOnly();
    }

    @Then("All notifications should be displayed")
    public void all_notifications_should_be_displayed() {
    	notifications.verifyNotificationsDisplayed();    }
}