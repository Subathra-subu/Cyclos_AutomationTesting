package com.StepDefinitions;

import java.util.List;
import java.util.Map;

import com.Actions.RegisterAction;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RegisterTest {
	
	RegisterAction registerAction = new RegisterAction();
	
	
	@When("the user clicks the Register link")
	public void the_user_clicks_the_register_link() {
		
		registerAction.clickRegisterLink();
	   
		
	}


	@When("the user clicks submit button")
	public void the_user_clicks_submit_button() {
	    
		registerAction.clickSubmitButton();
		
	}

	
	@When("the user enters the already existing Login name")
	public void the_user_enters_the_already_existing_login_name(io.cucumber.datatable.DataTable dataTable) {
	    
		List<Map<String, String>> data = dataTable.asMaps(String.class,String.class);

		String name = data.get(0).get("name");

		String loginName = data.get(0).get("loginName");
		
		
		registerAction.enterExistingDetails(name,loginName);
		
		
	}

	@When("the user clicks next button")
	public void the_user_clicks_next_button() {
	    
		registerAction.clickNextButton();
		
	}

	@Then("the user should be able to see the {string} message under login name field")
	public void the_user_should_be_able_to_see_the_message_under_login_name_field(String string) {
	   
		registerAction.assertAlreadyExistMessage(string);
		
	}
	
	@When("the user leaves the name,loginName and email input field blank")
	public void the_user_leaves_the_name_login_name_and_email_input_field_blank(io.cucumber.datatable.DataTable dataTable) {
	   
		List<Map<String, String>> data = dataTable.asMaps(String.class,String.class);

		String name = data.get(0).get("name") == null ? "" : data.get(0).get("name");

		String loginName = data.get(0).get("loginName") == null ? "" : data.get(0).get("loginName");

		String email = data.get(0).get("email") == null ? "" : data.get(0).get("email");
		
		registerAction.enterBlankDetails(name,loginName,email);
	}

	@Then("the user should be able to see the {string} message under the blank fields")
	public void the_user_should_be_able_to_see_the_message_under_the_blank_fields(String string) {
	   
		registerAction.assertRequiredMessage(string);
	  
	}

	}

