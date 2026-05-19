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

	@When("the user upload profile image")
	public void the_user_upload_profile_image() {
		
		// try {
		// 	registerAction.uploadImage("D:\\ProfileImage.jpg");
		// } 
		
		// catch (Exception e) {
		// 	e.printStackTrace();
		// }
		
	}

	@When("the user enters the valid credentials and click next button")
	public void hen_the_user_enters_the_valid_credentials_and_click_next_button(io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
		
		List<Map<String, String>> data = dataTable.asMaps(String.class,String.class);

		String name = data.get(0).get("name");

		String loginName = data.get(0).get("loginName");

		String email = data.get(0).get("email");

		String website = data.get(0).get("website");

		String mobile = data.get(0).get("mobile");

		String landline = data.get(0).get("landline");

		String address = data.get(0).get("address");

		String zip = data.get(0).get("zip");

		String city = data.get(0).get("city");

		String region = data.get(0).get("region");

		String password = data.get(0).get("password");

		registerAction.enterValidDetails(name,loginName,email,website,mobile,landline,address,zip,city,region,password);

	}

	@When("the user clicks submit button")
	public void the_user_clicks_submit_button() {
	    
		registerAction.clickSubmitButton();
		
	}

	@Then("the user should be able to see the {string} message")
	public void the_user_should_be_able_to_see_the_message(String string) {
	    
		registerAction.assertSuccessfullLogin(string);
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

	@When("the user enters the mandatory credentials and click next button")
	public void the_user_enters_the_mandatory_credentials_and_click_next_button(io.cucumber.datatable.DataTable dataTable) {
	    
		
		List<Map<String, String>> data = dataTable.asMaps(String.class,String.class);

		String name = data.get(0).get("name");

		String loginName = data.get(0).get("loginName");

		String email = data.get(0).get("email");

		String password = data.get(0).get("password");

		try {
			registerAction.enterMandatoryDetails(name, loginName, email,password);
		} 
		catch (InterruptedException e) {

			e.printStackTrace();
		}
		
	}

}
