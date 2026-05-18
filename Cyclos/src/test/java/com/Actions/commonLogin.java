package com.Actions;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.Pages.LoginPage;
import com.StepDefinitions.Hooks;
import com.Utilities.ConfigureClass;
import com.Utilities.HelperClass;

public class commonLogin extends BaseAction {

	LoginPage loginPage = new LoginPage();

	public void loginToApplication() {

		HelperClass.log.info("Navigating to login page and clicking login button");

		click(loginPage.loginButton);

		waitForVisibility(loginPage.usernameTextBox);

		HelperClass.log.info("Login form is visible");

		sendKeys(loginPage.usernameTextBox, ConfigureClass.getUsername());

		HelperClass.log.info("Entered username: " + ConfigureClass.getUsername());

		sendKeys(loginPage.passwordTextBox, ConfigureClass.getPassword());

		HelperClass.log.info("Submitting login form");

		jsClick(loginPage.submitButton);

		HelperClass.log.info("Login form submitted successfully");
	}
}