package com.StepDefinitions;

import com.Actions.LoginActions;
import com.Utilities.HelperClass;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    LoginActions loginActions = new LoginActions();

    @Before
    public void setup() {
        // SETUP DRIVER — always creates a fresh instance per scenario
        HelperClass.setupDriver();

        // OPEN APPLICATION
        HelperClass.openPage();

        // LOGIN
        loginActions.loginToApplication();
    }

    @After
    public void tearDown() {
        // CLOSE BROWSER
        HelperClass.tearDown();
    }
}