package com.Runner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(


		features = "src/test/resources/Features",

<<<<<<< HEAD
        
		glue = "com.StepDefinitions",
=======

		glue = "com.StepDefinitions", tags="@krishna",
>>>>>>> 12bfa088ceaf25659eda226ada0097c5af438ec8

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
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
