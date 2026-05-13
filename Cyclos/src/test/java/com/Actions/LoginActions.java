package com.Actions;

import com.Pages.LoginPage;
import com.Utilities.ConfigureClass;

public class LoginActions extends BaseAction {

    LoginPage loginPage =

            new LoginPage();

    public void loginToApplication() {

        // CLICK LOGIN BUTTON

        click(loginPage.loginButton);

        // WAIT FOR USERNAME FIELD

        waitForVisibility(

                loginPage.usernameTextBox);

        // ENTER USERNAME

        sendKeys(

                loginPage.usernameTextBox,

                ConfigureClass.getUsername());

        // ENTER PASSWORD

        sendKeys(

                loginPage.passwordTextBox,

                ConfigureClass.getPassword());

        // CLICK SUBMIT BUTTON

        jsClick(loginPage.submitButton);
    }
}