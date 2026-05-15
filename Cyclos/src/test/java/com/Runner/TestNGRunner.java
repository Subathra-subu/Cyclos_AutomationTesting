package com.Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(

    features = "src/test/resources/features/QR_Code.feature",

    glue = "com.StepDefinitions",

    plugin = {
        "pretty",
        "json:target/cucumber.json",
        "html:target/cucumber-reports.html",
        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
        "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
    },

    monochrome = true,
    dryRun = false
    )

public class TestNGRunner extends AbstractTestNGCucumberTests {
}