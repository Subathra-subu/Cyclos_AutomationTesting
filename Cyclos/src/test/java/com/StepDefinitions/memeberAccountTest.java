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
	
	@When("the user clicks the excel option")
	public void the_user_clicks_the_excel_option() {
	    // Write code here that turns the phrase above into concrete actions
	    actions.clickexcelOption();
	}

	@Then("the user should see the member account details in Excel file")
	public void the_user_should_see_the_member_account_details_in_excel_file() {
	    // Write code here that turns the phrase above into concrete actions
	    actions.validateMemberAccountExcel();
	}
	
	@When("the user clicks the CSV option")
	public void the_user_clicks_the_csv_option() 
	{
	    // Write code here that turns the phrase above into concrete actions
	    actions.clickCsvOption();
	}

	@Then("the user should see the member account details in CSV file")
	public void the_user_should_see_the_member_account_details_in_csv_file() 
	{
	    // Write code here that turns the phrase above into concrete actions
		
		  actions.validateMemberAccountCSV();
	   
	}


}
