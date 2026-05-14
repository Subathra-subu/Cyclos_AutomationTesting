package com.Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
plugin = {"pretty", "html:reports/cucumber.html", "json:reports/cucumber.json"},
features = "src/test/resources/features",
glue = {"com.StepDefinitions"},
tags="@ReceivePaymentWithValidDetails")

public class TestNGRunner extends AbstractTestNGCucumberTests {

}