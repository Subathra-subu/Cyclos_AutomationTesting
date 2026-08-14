
package com.StepDefinitions;

import com.Actions.ContactActions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ContactTest

{
	ContactActions contactActions = new ContactActions();

	@When("the user click the person menu")
	public void the_user_click_the_person_menu() {
	    contactActions.clickPersonMenu();
	}

	@When("the user clicks the contact button")
	public void the_user_clicks_the_contact_button() {
	    contactActions.clickContactButton();
	}

	@When("the user clicks the Add new button")
	public void the_user_clicks_the_add_new_button() {
	    contactActions.clickAddNewButton();
	}

	@When("the user enters the contact {string}")
	public void the_user_enters_the_contact(String contactName) {
	    contactActions.enterContactName(contactName);
	}

	@When("the user submits the form")
	public void the_user_submits_the_form() {
	    contactActions.clickSubmitButton();
	}

	@Then("the user should see the {string}")
	public void the_user_should_see_the(String expectedMessage) {
	    contactActions.verifyContactCreated(expectedMessage);
	}
	
	@When("the user clicks the contact list view button")
	public void the_user_clicks_the_contact_list_view_button() {

	    contactActions.clickContactListViewButton();
	}

	@Then("the user should see the contact list view page with a user message")
	public void the_user_should_see_the_contact_list_view_page_with_a_user_message() {

	    contactActions.verifyUserColumnDisplayed();
	}
	
	@When("the user clicks the contact tiled view button")
	public void the_user_clicks_the_contact_tiled_view_button() {
	    // Write code here that turns the phrase above into concrete actions
	    contactActions.clickContactTiledViewButton();
	}

	@Then("the user should see the contact tiled view page with a user message")
	public void the_user_should_see_the_contact_tiled_view_page_with_a_user_message() {
	    // Write code here that turns the phrase above into concrete actions
	    contactActions.verifyContactTiledViewDisplayed();
	}


}