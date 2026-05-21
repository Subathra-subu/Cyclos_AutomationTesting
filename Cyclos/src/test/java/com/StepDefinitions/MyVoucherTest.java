package com.StepDefinitions;

import java.util.List;


import com.Actions.LoginAction;

import com.Actions.MyVoucherActions;
import com.Utilities.CSVUtility;
import com.Utilities.HelperClass;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MyVoucherTest

{
//	List<String> data = 

	MyVoucherActions MyVouAcc = new MyVoucherActions();

	
	LoginAction login = new LoginAction();
	
	@Given("the user login with the valid data")
	public void the_user_login_with_the_valid_data() {
	    // Write code here that turns the phrase above into concrete actions
	    login.clickLoginLink();
	    login.entervaliduserNameAndPassword();
	    login.clickSubmitButton();
	}

	@Given("the user navigate to the Marketplace place page")
	public void the_user_navigate_to_the_marketplace_place_page() {
	    // Write code here that turns the phrase above into concrete actions
		MyVouAcc.clickMarkPlace();
	}


	@Given("the user click the MyVochers")
	public void the_user_click_the_my_vochers() {
		// Write code here that turns the phrase above into concrete actions
		MyVouAcc.clickVoucher();
	}

	@When("the user clicks the Buy Voucher button")
	public void the_user_clicks_the_buy_voucher_button() {
		MyVouAcc.clickBuyVoucher();
	}

	@When("the user clicks the Cinema voucher in button")
	public void the_user_clicks_the_cinema_voucher_in_button() {
		// Write code here that turns the phrase above into concrete actions
		MyVouAcc.clickCinema();
	}

	@When("the user enter the Number of vochers {string} and enter amount {string}")
	public void the_user_enter_the_number_of_vochers_and_enter_amount(String string, String string2) {
		// Write code here that turns the phrase above into concrete actions
		MyVouAcc.amountAndNumber(string, string2);
	}

	@When("the user click the next button")
	public void the_user_click_the_next_button() {
		// Write code here that turns the phrase above into concrete actions
		MyVouAcc.next();
	}

	@When("the user clicks the Confirm button")
	public void the_user_clicks_the_confirm_button() {
		// Write code here that turns the phrase above into concrete actions
		if (MyVouAcc.isDisplayedAlert()) {
			HelperClass.log.info("Alert present");
		}

		else {
			MyVouAcc.confirm();
		}
	}

	@Then("the user should seen the {string}")
	public void the_user_should_seen_the(String string) {
		// Write code here that turns the phrase above into concrete actions
		if (MyVouAcc.isDisplayedAlert()) {
			
			
			MyVouAcc.isAlertAssert();

		} else {
			MyVouAcc.assertion(string);
		}
	}

	@When("the user clicks the gift voucher in button")
	public void the_user_clicks_the_gift_voucher_in_button() {
	    // Write code here that turns the phrase above into concrete actions
	    MyVouAcc.clickGift();
	}
	
	@When("the user clicks the restaruant voucher in button")
	public void the_user_clicks_the_restaruant_voucher_in_button() {
	    // Write code here that turns the phrase above into concrete actions
	    MyVouAcc.clickrestaurant();
	}
	
	

	@When("the user click the result")
	public void the_user_click_the_result() {

	    HelperClass.log.info(
	            "Result clicked from CSV execution");
	}

	@Then("the user should seen the Qr code code")
	public void the_user_should_seen_the_qr_code_code() {

	    HelperClass.log.info(
	            "QR code validated from CSV execution");
	}
	
	@When("the user enter the valid voucher code")
	public void the_user_enter_the_valid_voucher_code() {

	    List<String> voucherCodes =
	            CSVUtility.getVoucherCodes(
	                    "src/test/resources/testData/VoucherCode.csv");

	    for (String code : voucherCodes) {

	        MyVouAcc.enterVoucherCode(code);

	        MyVouAcc.AssertResult();
	    }
	}


}

