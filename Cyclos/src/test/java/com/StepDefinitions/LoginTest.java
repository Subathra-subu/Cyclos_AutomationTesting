package com.StepDefinitions;

import com.Actions.DashBoardAction;
import com.Actions.LoginAction;
import com.Utilities.HelperClass;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginTest {
	
	LoginAction loginAction = new LoginAction();
	
	DashBoardAction dashBoardAction = new DashBoardAction();
	
	@Given("that the user launches the application")
	public void that_the_user_launches_the_application() {
		
		HelperClass.openPage();
	    
	}

	@When("the user clicks the Login link")
	public void the_user_clicks_the_login_link() {
		
		loginAction.clickLoginLink();
	    
	}

	@When("the user enters the valid userName and valid password")
	public void the_user_enters_the_valid_user_name_and_valid_password() {
		
		loginAction.entervaliduserNameAndPassword();
	    
	}
	
	@When("click submit button")
	public void click_submit_button() {
	
		loginAction.clickSubmitButton();
	}

	@Then("the user should be able to see the dashboard page")
	public void the_user_should_be_able_to_see_the_dashboard_page() {
	    
		dashBoardAction.successfullLogin();
		
	}
	
	@When("the user enters the invalid username as {string} and invalid password as {string}")
	public void the_user_enters_the_invalid_username_as_and_invalid_password_as(String string, String string2) {
	   
		loginAction.enterinvalidUsernameandPassword(string,string2);
		
	}

	@Then("the user should see the {string} alert meaasage")
	public void the_user_should_see_the_alert_meaasage(String string) {
	    
		loginAction.assertAlertMessage();
		
	}
	
	@When("the user enters a valid password and leaves the username field blank")
	public void the_user_enters_a_valid_password_and_leaves_the_username_field_blank() {
	   
		loginAction.enterBlankUserName();
		
	}

	@Then("the user should be able to see the {string} error message under username filed")
	public void the_user_should_be_able_to_see_the_error_message_under_username_filed(String string) {
	   
		loginAction.assertUsernameRequired();
		
	}
	
	@When("the user enter a valid userName and leaves the password field blank")
	public void the_user_enter_a_valid_user_name_and_leaves_the_password_field_blank() {
		
		loginAction.enterBlankPassword();
		
	}

	@Then("the user should be able to see the {string} message under password filed")
	public void the_user_should_be_able_to_see_the_message_under_password_filed(String string) {
	    
		loginAction.assertPasswordRequired();
		
	}

}
