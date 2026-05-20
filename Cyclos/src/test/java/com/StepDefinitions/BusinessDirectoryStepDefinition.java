package com.StepDefinitions;

import java.util.List;
import java.util.Map;

import com.Actions.BusinessDirectoryActions;
import com.Actions.LoginAction;
import com.Utilities.CSVUtility;
import com.Utilities.ExcelData;
import com.Utilities.HelperClass;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BusinessDirectoryStepDefinition {

	BusinessDirectoryActions actions = new BusinessDirectoryActions();

	LoginAction loginAction = new LoginAction();

	@Given("User logs into the cyclos application for business directory")
	public void user_logs_into_the_cyclos_application_for_business_directory() {

		HelperClass.openPage();

		loginAction.clickLoginLink();

		loginAction.entervaliduserNameAndPassword();

		loginAction.clickSubmitButton();
	}

	@When("User navigates to business directory page")
	public void user_navigates_to_business_directory_page() {

		actions.navigateBusinessDirectory();
	}

	@When("User enters keyword from excel")
	public void user_enters_keyword_from_excel() throws Exception {

		ExcelData excel = new ExcelData();

		Object[][] data = excel.businessDirectoryData();

		String keyword = data[0][0].toString();

		actions.enterKeyword(keyword);
	}

	@Then("Matching business records should be displayed")
	public void matching_business_records_should_be_displayed() {

		actions.validateSearchResults();
	}

	@When("User selects list view option using csv")
	public void user_selects_list_view_option_using_csv() {

		String filePath = "src/test/resources/TestData/BusinessDirectoryView.csv";

		List<String> views = CSVUtility.getVoucherCodes(filePath);

		for (String view : views) {

			if (view.equalsIgnoreCase("list")) {

				actions.clickListView();
			}
		}
	}

	@Then("Business records should display in list view")
	public void business_records_should_display_in_list_view() {

		actions.validateListView();
	}

	@When("User selects tiled view option")
	public void user_selects_tiled_view_option(DataTable dataTable) {

		List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);

		String view = data.get(0).get("view");

		if (view.equalsIgnoreCase("tile")) {

			actions.clickTiledView();
		}
	}

	@Then("Business records should display in tiled view")
	public void business_records_should_display_in_tiled_view() {

		actions.validateTiledView();
	}

	@When("User selects ascending order from orders dropdown")
	public void user_selects_ascending_order_from_orders_dropdown() {

		actions.selectAscendingOrder();
	}

	@Then("Business records should display in ascending order")
	public void business_records_should_display_in_ascending_order() {

		actions.validateAscendingOrder();
	}

	@When("User selects descending order from orders dropdown")
	public void user_selects_descending_order_from_orders_dropdown() {

		actions.selectDescendingOrder();
	}

	@Then("Business records should display in descending order")
	public void business_records_should_display_in_descending_order() {

		actions.validateDescendingOrder();
	}
}