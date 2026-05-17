package com.Runner;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@Test
@CucumberOptions(
		features = "src/test/resources/features/Login.feature",
		
//		features = "@target/rerun.txt",
		
		glue = "com.StepDefinitions",
//		tags="@BlankUsername",
		plugin = {
				"pretty",
				"html:target/cucumber-reports.html",
				"json:target/cucumber.json",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
				"rerun:target/rerun.txt"
		},
		
		monochrome=true)

public class TestNGRunner extends AbstractTestNGCucumberTests {

	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios() {
	    return super.scenarios();
	}
}
