package com.StepDefinitions;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.Utilities.HelperClass;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {
	
	public static final Logger logger = LogManager.getLogger(Hooks.class);
	
	@Before
	public static void setUp(Scenario scenario) {
		
		HelperClass.setupDriver();
		
		logger.info("Scenario started: {}",scenario.getName());
	}
	
	@After
	public static void tearDown(Scenario scenario) {

	    if (scenario.isFailed()) {

	        File screenshotFile = ((TakesScreenshot) HelperClass.getDriver())
	                .getScreenshotAs(OutputType.FILE);

	        try {
	            File destinationFile = new File(
	                    "screenshots/" + scenario.getName().replaceAll(" ", "_") + ".png");

	            FileUtils.copyFile(screenshotFile, destinationFile);

	            byte[] screenshotBytes = ((TakesScreenshot) HelperClass.getDriver())
	                    .getScreenshotAs(OutputType.BYTES);

	            scenario.attach(screenshotBytes, "image/png", "Failure Screenshot");

	            logger.error("Scenario failed: {}", scenario.getName());

	        } catch (Exception e) {
	            logger.error("Failed to save screenshot: {}", e.getMessage());
	        }
	    } else {
	        logger.info("Scenario passed : {}", scenario.getName());
	    }

	    HelperClass.tearDown();
	}

}