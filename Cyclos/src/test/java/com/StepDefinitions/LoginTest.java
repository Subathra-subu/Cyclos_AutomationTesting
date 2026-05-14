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
		
		loginAction.enterUserNameAndPassword();
	    
	}
	
	@When("click submit button")
	public void click_submit_button() {
	
		loginAction.clickSubmitButton();
	}

	@Then("the user should be able to see the dashboard page")
	public void the_user_should_be_able_to_see_the_dashboard_page() {
	    
		dashBoardAction.successfullLogin();
		
	}

}
