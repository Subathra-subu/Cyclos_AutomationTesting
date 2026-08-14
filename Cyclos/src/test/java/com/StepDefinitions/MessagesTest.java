package com.StepDefinitions;

import com.Actions.MessagesAction;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MessagesTest {

	MessagesAction messagesAction = new MessagesAction();

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
	public void user_should_see_popup_message(String expectedMessage) {

		messagesAction.verifyMessageSentPopup(expectedMessage);
	}


	@When("User clicks on Sent button")
	public void user_clicks_on_sent_button() {
		messagesAction.clickSentTab();
	}

	@Then("User should see Sent messages")
	public void user_should_see_sent_messages() {
		messagesAction.verifySentMessages();
	}

	@When("User clicks on Trash button")
	public void user_clicks_on_trash_button() {
		messagesAction.clickTrashTab();
	}

	@Then("User should see Trash messages")
	public void user_should_see_trash_messages() {
		messagesAction.verifyTrashMessages();
	}
	
	@Then("Messages page should be displayed")
    public void messages_page_should_be_displayed() {
		messagesAction.verifyMessagesPageDisplayed();
    }
	
	@When("the user selects the Send to message box option")
	public void the_user_selects_the_send_to_message_box_option() {
		messagesAction.clickSentTab();
	}

	@When("the user selects a username in the user tab")
	public void the_user_selects_a_username_in_the_user_tab() {
		messagesAction.UserFeild();
	}

	@Then("the user should be able to see only the messages sent to the selected user")
	public void the_user_should_be_able_to_see_only_the_messages_sent_to_the_selected_user() throws InterruptedException {
		messagesAction.checkDisplayedUsers();
	}
}