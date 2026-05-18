package com.StepDefinitions;

import java.io.IOException;

import com.Actions.DashBoardAction;
import com.Actions.LoginAction;
import com.Utilities.ExcelData;
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
	    
		loginAction.assertAlertMessage(string);
		
	}
	
	@When("the user enters a valid password and leaves the username field blank")
	public void the_user_enters_a_valid_password_and_leaves_the_username_field_blank() throws IOException {
		
		String path = System.getProperty("user.dir") + "/src/test/resources/testData/LoginData.xlsx";

	    String username = ExcelData.getCellData(path,"Sheet1",1,0);

	    String password = ExcelData.getCellData(path,"Sheet1",1,1);

	    loginAction.enterBlankUserName(username,password);
	   
		
	}

	@Then("the user should be able to see the {string} error message under username filed")
	public void the_user_should_be_able_to_see_the_error_message_under_username_filed(String string) {
	   
		loginAction.assertUsernameRequired(string);
		
	}
	
	@When("the user enter a valid userName and leaves the password field blank")
	public void the_user_enter_a_valid_user_name_and_leaves_the_password_field_blank() throws IOException {
		
		String path = System.getProperty("user.dir") + "/src/test/resources/testData/LoginData.xlsx";

	    String username = ExcelData.getCellData(path,"Sheet1",2,0);

	    String password = ExcelUtilities.getCellData(path,"Sheet1",2,1);

	    loginAction.enterBlankPassword(username,password);
		
		
	}

	@Then("the user should be able to see the {string} message under password filed")
	public void the_user_should_be_able_to_see_the_message_under_password_filed(String string) {
	    
		loginAction.assertPasswordRequired(string);
		
	}
	
	
	@When("the user leaves the userName and password fields blank")
	public void the_user_leaves_the_user_name_and_password_fields_blank() throws IOException {
		
		String path = System.getProperty("user.dir") + "/src/test/resources/testData/LoginData.xlsx";

	    String username = ExcelData.getCellData(path,"Sheet1",3,0);

	    String password = ExcelData.getCellData(path,"Sheet1",3,1);

	    loginAction.enterBlankInputs(username,password);
	   
		
	}

	@Then("the user should be able to see the {string} message under userName and password fileds")
	public void the_user_should_be_able_to_see_the_message_under_user_name_and_password_fileds(String string) {
	   
		loginAction.assertBothRequiredMessage(string);
		
	}
	
	@When("the logs into the application with valid credentials")
	public void the_logs_into_the_application_with_valid_credentials() {
	  
		loginAction.clickLoginLink();
		
		loginAction.entervaliduserNameAndPassword();
		
		loginAction.clickSubmitButton();
		
	}
	
	
	@When("the clicks logout link")
	public void the_clicks_logout_link() {
	   
		dashBoardAction.clickLogoutLink();
		
	}

	@Then("the user should be able to logout the application successfully")
	public void the_user_should_be_able_to_logout_the_application_successfully() {
	    
		loginAction.checkLogout();
		
	}

}
