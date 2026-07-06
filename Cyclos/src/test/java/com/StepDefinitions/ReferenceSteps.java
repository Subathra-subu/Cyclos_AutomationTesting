package com.StepDefinitions;

import org.testng.Assert;

import com.Actions.ReferenceActions;

import io.cucumber.java.en.*;

public class ReferenceSteps {

	ReferenceActions referenceActions = new ReferenceActions();

	@When("the user click the personal menu")
	public void the_user_click_the_personal_menu() {
		referenceActions.clickPersonalMenu();
	}

	@When("the user clicks the References menu")
	public void the_user_clicks_the_references_menu() {
		referenceActions.clickReferencesMenu();
	}

	@When("the user clicks the received reference")
	public void the_user_clicks_the_received_reference() {
		referenceActions.clickReceivedReference();
	}

	@When("the user clicks the delete button")
	public void the_user_clicks_the_delete_button() {
		referenceActions.clickDeleteButton();
	}

	@When("the user confirms the deletion")
	public void the_user_confirms_the_deletion() {
		referenceActions.confirmDeletion();
	}

	@Then("the user should see the reference deleted successfully message")
	public void the_user_should_see_the_reference_deleted_successfully_message() {
		Assert.assertTrue(referenceActions.isSuccessMessageDisplayed());
	}
}
