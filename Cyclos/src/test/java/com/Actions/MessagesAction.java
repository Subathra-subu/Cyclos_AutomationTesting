package com.Actions;

import org.testng.Assert;

import com.Pages.MessagesPage;
import com.Utilities.HelperClass;

public class MessagesAction extends BaseAction {

	MessagesPage messagesPage = new MessagesPage();

	public void clickMessageIcon() {

		try {

			waitForVisibility(messagesPage.messageIcon);
			click(messagesPage.messageIcon);
			jsClick(messagesPage.messageIcon);

			HelperClass.log.info("Clicked Message icon successfully");
		}

		catch (Exception e) {

			HelperClass.log.error("Failed to click Message icon : " + e.getMessage());

			throw e;
		}
	}

	public void clickNewMessageLink() {

		try {

			waitForVisibility(messagesPage.newMessageLink);

			jsClick(messagesPage.newMessageLink);

			HelperClass.log.info("Clicked New Message link");
		}

		catch (Exception e) {

			HelperClass.log.error("Failed to click New Message : " + e.getMessage());

			throw e;
		}
	}

	public void ClickSendTo() {

		try {

			waitForVisibility(messagesPage.recipientField);

			click(messagesPage.recipientField);
			waitForVisibility(messagesPage.userField);

			click(messagesPage.userField);

			HelperClass.log.info("Clicked SendTo");
		}


		catch (Exception e) {

			HelperClass.log.error("Failed to enter message details : " + e.getMessage());

			throw e;
		}
	}
	public void UserFeild() {

		try {

			waitForVisibility(messagesPage.user);

			click(messagesPage.user);

			waitForVisibility(messagesPage.user_name);

			click(messagesPage.user_name);

			waitForVisibility(messagesPage.userField);

			click(messagesPage.userField);
			
			sendKeys(messagesPage.user,"Active walking");

			HelperClass.log.info("Clicked UserField");
		}

		catch (Exception e) {

			HelperClass.log.error("Failed to enter message details : " + e.getMessage());

			throw e;
		}
	}

	public void clickSendButton() {

		try {

			waitForVisibility(messagesPage.sendButton);

			jsClick(messagesPage.subjectField);

			sendKeys(messagesPage.subjectField, "About Walking");

			sendKeys(messagesPage.textField, "Active Walking...");

			waitForVisibility(messagesPage.sendButton);

			click(messagesPage.sendButton);

			HelperClass.log.info("Clicked Send button");
		}

		catch (Exception e) {

			HelperClass.log.error("Failed to click Send button : " + e.getMessage());

			throw e;
		}
	}

	public void verifyMessageSentPopup(String expectedMessage) {

		try {

			waitForVisibility(messagesPage.successPopup);

			String actualMessage = getText(messagesPage.successPopup);

			Assert.assertTrue(actualMessage.contains(expectedMessage));

			HelperClass.log.info("Message sent popup validated successfully");
		}

		catch (Exception e) {

			HelperClass.log.error("Popup validation failed : " + e.getMessage());

			throw e;
		}
	}

	public void verifyInboxMessages() {

		Assert.assertTrue(isDisplayed(messagesPage.activeInboxTab));

		HelperClass.log.info("Inbox tab displayed successfully");
	}

	public void clickSentTab() {

		click(messagesPage.sentTab);

		HelperClass.log.info("Clicked Sent tab");
	}

	public void verifySentMessages() {

		Assert.assertTrue(isDisplayed(messagesPage.activeSentTab));

		HelperClass.log.info("Sent tab displayed successfully");
	}

	public void clickTrashTab() {

		click(messagesPage.trashTab);

		HelperClass.log.info("Clicked Trash tab");
	}

	public void verifyTrashMessages() {

		Assert.assertTrue(isDisplayed(messagesPage.activeTrashTab));

		HelperClass.log.info("Trash tab displayed successfully");
	}

	public void clickInboxTab() {
		
		click(messagesPage.inboxTab);

		HelperClass.log.info("Clicked inbox tab");
		
	}
}