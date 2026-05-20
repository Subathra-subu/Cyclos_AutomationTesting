/*package com.StepDefinitions;

import java.util.Map;

import org.testng.Assert;

import com.Actions.MyAdvertisementsAction;
import com.Actions.LoginAction;
import com.Utilities.CSVUtility;
import com.Utilities.HelperClass;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MyAdvertisementsTest {

	MyAdvertisementsAction actions = new MyAdvertisementsAction();

	LoginAction login = new LoginAction();

	@Given("User should be logged into cyclos application and must on home page")
	public void user_should_be_logged_into_cyclos_application_and_must_on_home_page() {

		HelperClass.openPage();

		login.clickLoginLink();

		login.entervaliduserNameAndPassword();

		login.clickSubmitButton();
	}
	
	
	@When("User clicks Marketplace menu")
	public void user_clicks_marketplace_menu() {
	   
		actions.clickMarketPlaceMenu();
	}

	@When("User clicks Advertisement menu")
	public void user_clicks_advertisement_menu() {

		actions.clickMyAdvertisements();
	}

	@When("User enters advertisement details")
	public void user_enters_advertisement_details(DataTable dataTable) {

		Map<String, String> data = dataTable.asMaps(String.class, String.class).get(0);

		actions.clickNewAdvertisement();

		actions.enterTitle(data.get("title"));

		actions.selectCategory(data.get("category"));

		actions.enterPrice(data.get("price"));

		actions.selectFromDate(data.get("fromDate"));

		actions.selectToDate(data.get("toDate"));

		actions.enterDescription(data.get("description"));

	}

	@Then("User should successfully add advertisement")
	public void user_should_successfully_add_advertisement() {

		actions.clickSave();

		Assert.assertTrue(actions.validateMessage().contains("was saved"));
	}

	@When("User searches advertisement mentioned in the CSV file")
	public void user_searches_advertisement_mentioned_in_the_CSV_file() {
		
		String title = CSVUtility
	            . getVoucherCodes("src/test/resources/TestData/InputData.csv")
	            .get(0);

	    actions.searchAdvertisement(title);

	}
	
	@When("the user click the advertisement")
	public void the_user_click_the_advertisement() {
	    
		actions.clickItem();
		
	}

	@When("User click the edit button and edits advertisement details")
	public void user_click_the_edit_button_and_edits_advertisement_details(io.cucumber.datatable.DataTable dataTable) {
		
		Map<String, String> data = dataTable.asMaps(String.class, String.class).get(0);

		actions.clickEditAdvertisement();

		actions.enterTitle(data.get("title"));

		actions.selectCategory(data.get("category"));

		actions.enterPrice(data.get("price"));

		actions.enterDescription(data.get("description"));
	}

	@Then("User should successfully update advertisement")
	public void user_should_successfully_update_advertisement() {

		actions.clickSave();

		Assert.assertTrue(actions.validateMessage().contains("was saved"));
	}

	@When("User clicks remove advertisement")
	public void user_clicks_remove_advertisement() {

		actions.clickRemoveAdvertisement();
	}

	@Then("User validates remove confirmation popup")
	public void user_validates_remove_confirmation_popup() {

		Assert.assertTrue(actions.validateRemovePopup().contains("Are you sure"));
		actions.confirmRemoveAdvertisement();
	}

	@Then("User confirms advertisement removal")
	public void user_confirms_advertisement_removal() {

		actions.confirmRemoveAdvertisement();
	}

	@Then("Advertisement should be removed successfully")
	public void advertisement_should_be_removed_successfully() {

		Assert.assertTrue(actions.validateMessage().contains("was removed"));

		actions.assertRemovalMessage();
		
	}
}
*/
