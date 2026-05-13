package com.StepDefinitions;

import com.Utilities.HelperClass;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class BaseTest {

    @Before
    public void setup() {

        HelperClass.setupDriver();

        HelperClass.openPage();
    }

    @After
    public void tearDown() {

        HelperClass.tearDown();
    }
}