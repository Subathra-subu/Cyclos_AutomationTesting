package com.StepDefinitions;

import com.Actions.LoginAction;
import com.Actions.TicketsActions;

import io.cucumber.java.en.Given;

public class LoginSteps {

	LoginAction login = new LoginAction();

	TicketsActions ticketsActions = new TicketsActions();

	@Given("the user Login with the valid data")
	public void the_user_login_with_the_valid_data() {

		login.clickLoginLink();
		login.entervaliduserNameAndPassword();
		login.clickSubmitButton();
	}

	@Given("the user click the Banking menu")
	public void the_user_click_the_banking_menu() {

		ticketsActions.clickOnBankingMenu();
	}

}
