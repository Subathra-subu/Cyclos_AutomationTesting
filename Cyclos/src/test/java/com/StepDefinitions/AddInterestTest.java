package com.StepDefinitions;

import java.io.IOException;

import com.Actions.AddInterestActions;
import com.Actions.LoginAction;
import com.Utilities.ExcelData;
import com.Utilities.HelperClass;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddInterestTest {

	AddInterestActions addInterestActions = new AddInterestActions();

	LoginAction login = new LoginAction();

	@Given("the user login with valid credentials")
	public void the_user_login_with_valid_credentials() {
		// Write code here that turns the phrase above into concrete actions
		login.clickLoginLink();
		login.entervaliduserNameAndPassword();
		login.clickSubmitButton();

	}

	@Given("the user click the Marketplace menu")
	public void the_user_click_the_marketplace_menu() {
		// Write code here that turns the phrase above into concrete actions
		addInterestActions.clickMarketPlace();
	}

	@When("the user clicks the Advertisement Interests button")
	public void the_user_clicks_the_advertisement_interests_option()

	{
		// Write code here that turns the phrase above into concrete actions
		addInterestActions.clickAdIntrestLink();
	}

	@When("the user clicks the Delete button")
	public void the_user_clicks_the_delete_button() {
		// Write code here that turns the phrase above into concrete actions
		if (addInterestActions.isVisibleResult()) {
			HelperClass.log.info("no row is present");
		}

		else {
			addInterestActions.clickDeleteButton();
		}
	}

	@When("the user confirms the deletion popup")
	public void the_user_confirms_the_deletion_popup() {
		// Write code here that turns the phrase above into concrete actions
		if (addInterestActions.isVisibleResult()) {
			HelperClass.log.info("no row is present");
		}

		else {
			addInterestActions.clickConfirm();
		}
	}

	@Then("the user should see the success message")
	public void the_user_should_see_the_success_message() {
		// Write code here that turns the phrase above into concrete actions
		if (addInterestActions.isVisibleResult()) {
			addInterestActions.assertNoresult();
		}

		else {
			addInterestActions.assertDel();
		}
	}

	

	@When("the user clicks the Add New button")
	public void the_user_clicks_the_add_new_button() {
		// Write code here that turns the phrase above into concrete actions
		addInterestActions.addNew();
	}

	@When("the user enters all required details {string} , {string} , {string} , {string} , {string} and submit it.")
	public void the_user_enters_all_required_details_and_submit_it(String string, String string2, String string3,
			String string4, String string5) throws IOException {
		// Write code here that turns the phrase above into concrete actions
		addInterestActions.excelData();
	}

	@Then("the user enters the details without name fields and should see the {string} message")
	public void the_user_enters_the_details_without_name_fields_and_should_see_the_message(String expectedMessage,
			DataTable dataTable) {
		addInterestActions.dataTable(dataTable, expectedMessage);

	}

	
	
	@Then("the user should see AddInterst text")
	public void the_user_should_see_add_interst_text() {
	    // Write code here that turns the phrase above into concrete actions
		if (addInterestActions.isUniqueVisible()) {
			addInterestActions.assertuniqe();
		}

		else {
			addInterestActions.assertAdd(" Advertisement interests ");

		}
	}


}