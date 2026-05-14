package com.StepDefinitions;

import org.testng.Assert;


import com.Pages.QRcode_page;
import com.Utilities.ConfigureClass;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class QrCode_Steps {
  //valid data scenario
	QRcode_page qpage = new QRcode_page() ;
	@Given("the user launches the Cyclos application")
	public void the_user_launches_the_cyclos_application() {
	    // Write code here that turns the phrase above into concrete actions
		 System.out.println("Application launched");
	}

	@Given("the user logs in with valid credentials")
	public void the_user_logs_in_with_valid_credentials() {
	    // Write code here that turns the phrase above into concrete actions
	    qpage.loginApplication(ConfigureClass.getUsername(),ConfigureClass.getPassword() );
	}

	@Given("the user navigates to the QR Code page")
	public void the_user_navigates_to_the_qr_code_page() {
	    // Write code here that turns the phrase above into concrete actions
	    qpage.navigatetoBankingPage();
	}

	@When("the user enters a valid amount {string}")
	public void the_user_enters_a_valid_amount(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    qpage.enter_amount(string);
	}

	@When("the user clicks on the generate QR code button")
	public void the_user_clicks_on_the_generate_qr_code_button() {
	    // Write code here that turns the phrase above into concrete actions
	   qpage.clickqrButton();
	}

	@Then("the QR code should be generated successfully")
	public void the_qr_code_should_be_generated_successfully() {
	    // Write code here that turns the phrase above into concrete actions
	   Assert.assertTrue(qpage.QrVerification());
	}

	//blank field scenario
	@When("the user enters a valid amount empty")
	public void the_user_enters_a_valid_amount_empty() {
	    // Write code here that turns the phrase above into concrete actions
	   qpage.enter_amount("");
	}

	@Then("a Field-level validation error message should be displayed")
	public void a_field_level_validation_error_message_should_be_displayed() {
	    // Write code here that turns the phrase above into concrete actions
	    Assert.assertEquals(qpage.errormessage(), "This field is required");   
	}
	//new qr code functionality
	@When("the user clicks on the Generate New QR Code button")
	public void the_user_clicks_on_the_generate_new_qr_code_button() {
	    // Write code here that turns the phrase above into concrete actions
	        qpage.clickqrButtonnew();
	}

	@Then("the user should be redirected to the Receive QR Code page")
	public void the_user_should_be_redirected_to_the_receive_qr_code_page() {
	    // Write code here that turns the phrase above into concrete actions
		 Assert.assertEquals(qpage.newgen(), "Generate QR code");
	}

}
