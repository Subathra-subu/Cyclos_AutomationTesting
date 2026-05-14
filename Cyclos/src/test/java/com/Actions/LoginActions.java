package com.Actions;

import com.Pages.LoginPage;
import com.Utilities.ConfigureClass;
import com.Utilities.HelperClass;

public class LoginActions extends BaseAction {

    LoginPage loginPage =

            new LoginPage();

    public void loginToApplication() {

       
    	HelperClass.log.info("Logging in to the application");
    	
        click(loginPage.loginButton);

        

        waitForVisibility(

                loginPage.usernameTextBox);

        HelperClass.log.info("Login form is visible");

        sendKeys(

                loginPage.usernameTextBox,

                ConfigureClass.getUsername());

        HelperClass.log.info("Entered username: " + ConfigureClass.getUsername());

        sendKeys(

                loginPage.passwordTextBox,

                ConfigureClass.getPassword());

        
        HelperClass.log.info("Submitting login form");
        jsClick(loginPage.submitButton);
    }
}