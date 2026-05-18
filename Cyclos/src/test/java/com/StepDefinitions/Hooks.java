package com.StepDefinitions;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.Actions.commonLoginAction;
import com.Utilities.HelperClass;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

    public static final Logger logger = LogManager.getLogger(Hooks.class);

    commonLoginAction loginActions = new commonLoginAction();

    @Before("@UserLogin")
    public void setUplogin(Scenario scenario) {
    	
        logger.info("=== Scenario STARTED: {} ===", scenario.getName());

        HelperClass.setupDriver();
        HelperClass.openPage();
        
        
        

        logger.info("Setup complete. Browser ready.");
    }
    @Before
    public void setUp(Scenario scenario) {
        logger.info("=== Scenario STARTED: {} ===", scenario.getName());

        HelperClass.setupDriver();
        HelperClass.openPage();
        loginActions.loginToApplication();

        logger.info("Setup complete. Browser ready.");
    }

    // AI refer 
    @After
  
    public void tearDown(Scenario scenario) {

        if (scenario.isFailed()) {

            try {

                byte[] screenshotBytes = ((TakesScreenshot) HelperClass.getDriver())
                        .getScreenshotAs(OutputType.BYTES);

                scenario.attach(screenshotBytes, "image/png", "Failure Screenshot");

                File screenshotFile = ((TakesScreenshot) HelperClass.getDriver())
                        .getScreenshotAs(OutputType.FILE);

                
                String fileName = scenario.getName().replace(" ", "_");

                FileUtils.copyFile(
                        screenshotFile,
                        new File("screenshots/" + fileName + ".png"));

                logger.error("Scenario Failed : " + scenario.getName());

            } catch (Exception e) {

                logger.error("Screenshot capture failed");
            }

        } else {

            logger.info("Scenario Passed : " + scenario.getName());
        }

        HelperClass.tearDown();
    }
}