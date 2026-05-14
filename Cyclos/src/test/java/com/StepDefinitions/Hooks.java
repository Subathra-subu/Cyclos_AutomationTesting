package com.StepDefinitions;

import com.Actions.LoginActions;
import com.Utilities.HelperClass;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    LoginActions loginActions = new LoginActions();

    @Before
    public void setup() {
       
        HelperClass.setupDriver();

       
        HelperClass.openPage();

        
        loginActions.loginToApplication();
    }

    @After
    public void tearDown() {
       
        HelperClass.tearDown();
    }
}