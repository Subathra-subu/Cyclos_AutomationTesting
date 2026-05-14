package com.Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/Features",
        glue = "com.StepDefinitions",

        plugin = {
                "pretty",
                "html:target/cucumber-reports.html",

               
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        },

        monochrome = true
)

public class TestNGRunner
        extends AbstractTestNGCucumberTests {

}