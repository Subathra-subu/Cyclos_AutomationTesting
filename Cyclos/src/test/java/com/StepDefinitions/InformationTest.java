package com.StepDefinitions;

import java.util.Map;

import com.Actions.InformationAction;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class InformationTest {

	InformationAction informationAction = new InformationAction();

	@When("the user click the Information menu")
	public void the_user_click_the_information_menu() {
		informationAction.clickInformationMenu();
	}

	@When("the user clicks the Contact form")
	public void the_user_clicks_the_contact_form() {
		informationAction.clickContactForm();
		informationAction.dumpPageSource();
	}

	@When("the user fills the contact form with following details")
	public void the_user_fills_the_contact_form_with_following_details(DataTable dataTable) {
		Map<String, String> data = dataTable.asMaps(String.class, String.class).get(0);
		informationAction.fillContactForm(
				data.get("from"),
				data.get("email"),
				data.get("subject"),
				data.get("message"));
	}

	@When("the user fills the captcha")
	public void the_user_fills_the_captcha() {
		informationAction.fillCaptcha();
	}

	@When("the user dumps the contact form html")
	public void the_user_dumps_the_contact_form_html() {
		informationAction.dumpPageSource();
	}

	@When("the user submits the contact form")
	public void the_user_submits_the_contact_form() {
		informationAction.clickSubmitButton();
	}

	@Then("the user should see the contact form success message")
	public void the_user_should_see_the_contact_form_success_message() {
		informationAction.verifySuccessMessage();
	}

	@Then("the user should see the required field error")
	public void the_user_should_see_the_required_field_error() {
		informationAction.verifyRequiredFieldError();
	}

}
