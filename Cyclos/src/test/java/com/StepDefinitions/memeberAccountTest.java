package com.StepDefinitions;

import com.Actions.memberAction;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class memeberAccountTest {

	memberAction actions = new memberAction();

	@Given("the user click the Member Account button")
	public void the_user_click_the_member_account_button() {

		actions.clickOnMemberAccountButton();
	}

	@When("user clicks the download button")
	public void user_clicks_the_download_button() {

		actions.clickDownloadButton();
	}

	@When("the user clicks the pdf option")
	public void the_user_clicks_the_pdf_option() {

		actions.clickPdfOption();
	}

	@Then("the user should see the member account details in PDF format")
	public void the_user_should_see_the_member_account_details_in_pdf_format() {

		actions.validateMemberAccountPDF();
	}

}
