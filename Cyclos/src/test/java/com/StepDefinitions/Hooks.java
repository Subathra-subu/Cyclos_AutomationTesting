package com.StepDefinitions;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.Actions.LoginActions;
import com.Utilities.HelperClass;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

    public static final Logger logger = LogManager.getLogger(Hooks.class);

    LoginActions loginActions = new LoginActions();

    @Before
    public void setUp(Scenario scenario) {
        logger.info("=== Scenario STARTED: {} ===", scenario.getName());

        HelperClass.setupDriver();
        HelperClass.openPage();
        loginActions.loginToApplication();

        logger.info("Setup complete. Browser ready.");
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {

            try {
                byte[] screenshotBytes =
                        ((TakesScreenshot) HelperClass.getDriver())
                                .getScreenshotAs(OutputType.BYTES);

                
                scenario.attach(screenshotBytes, "image/png", "Failure Screenshot");

                
                File screenshotsDir = new File("screenshots");
                if (!screenshotsDir.exists()) screenshotsDir.mkdirs();

                File screenshotFile =
                        ((TakesScreenshot) HelperClass.getDriver())
                                .getScreenshotAs(OutputType.FILE);

                File destinationFile = new File(
                        "screenshots"
                                + File.separator
                                + scenario.getName().replaceAll("[^a-zA-Z0-9]", "_")
                                + ".png");

                FileUtils.copyFile(screenshotFile, destinationFile);

                logger.error("=== Scenario FAILED: {} — screenshot saved ===",
                        scenario.getName());

            } catch (Exception e) {
                logger.error("Failed to save screenshot for scenario '{}': {}",
                        scenario.getName(), e.getMessage());
            }

        } else {
            logger.info("=== Scenario PASSED: {} ===", scenario.getName());
        }

        HelperClass.tearDown();
    }
}