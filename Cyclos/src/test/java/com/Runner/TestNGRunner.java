package com.Runner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(

		features = "src/test/resources/Features/AdInterest.feature",

		glue = "com.StepDefinitions",

		monochrome = true,

		publish = false,

		tags = "@delete",

		plugin = {

				"pretty",

				"html:target/CucumberReports/Cucumber.html",

				"json:target/CucumberReports/Cucumber.json",

				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",

				"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm" })

public class TestNGRunner extends AbstractTestNGCucumberTests {

	
}