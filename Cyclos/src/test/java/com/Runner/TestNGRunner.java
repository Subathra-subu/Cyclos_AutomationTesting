package com.Runner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(


		features = "src/test/resources/Features",

		glue = "com.StepDefinitions",

		monochrome = true,

		publish = false,
	
		plugin = {

				"pretty",
        
				"html:target/CucumberReports/Cucumber.html",

				"json:target/CucumberReports/Cucumber.json",

				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",

				"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm" })

public class TestNGRunner extends AbstractTestNGCucumberTests {

    
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
