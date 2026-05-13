package com.Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"com.StepDefinitions"},
        plugin = {"pretty", "html:target/report.html"},
        monochrome = true
)
public class TestNGRunner extends AbstractTestNGCucumberTests {
}