package com.Runner;


import org.testng.annotations.Test;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@Test
@CucumberOptions(

		features = {"@target/failedrerun.txt"},

		glue = "com.StepDefinitions",

		monochrome = true,

		publish = false,

		tags = "@SRIRAM",

		plugin = {

				"pretty",

				"html:target/CucumberReports/Cucumber.html",

				"json:target/CucumberReports/Cucumber.json",

				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",

				"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm", "rerun:target/failedrerun.txt"

		})

public class Rerunner extends AbstractTestNGCucumberTests {

}
