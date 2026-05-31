package com.StepDefinitions;

import com.Actions.MessagesAction;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MessagesTest {

    MessagesAction messagesAction =
            new MessagesAction();

    @When("User clicks Message icon")
    public void user_clicks_message_icon() {

        messagesAction.clickMessageIcon();
    }

    @When("User clicks on New Message link")
    public void user_clicks_on_new_message_link() {

        messagesAction.clickNewMessageLink();
    }

    @When("User enters the required details")
    public void user_enters_the_required_details() {
    	
    	messagesAction.ClickSendTo();
        messagesAction.UserFeild();
    }

    @When("User clicks on Send button")
    public void user_clicks_on_send_button() {

        messagesAction.clickSendButton();
    }

    @Then("User should see popup message {string}")
    public void user_should_see_popup_message(
            String expectedMessage) {

        messagesAction.verifyMessageSentPopup(
                expectedMessage);
    }
}