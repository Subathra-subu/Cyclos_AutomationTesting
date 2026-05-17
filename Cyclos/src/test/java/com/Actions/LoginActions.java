package com.Actions;

import com.Pages.LoginPage;
import com.Utilities.ConfigureClass;
import com.Utilities.HelperClass;

public class LoginActions extends BaseAction {

    LoginPage loginPage = new LoginPage();

    public void loginToApplication() {

       try {
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
		catch (Exception e) {
			HelperClass.log.error("Login failed: " + e.getMessage());
			throw e;
		}
    }
}