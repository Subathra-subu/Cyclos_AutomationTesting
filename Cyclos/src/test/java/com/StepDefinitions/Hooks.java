package com.StepDefinitions;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.Utilities.ConfigureClass;
import com.Utilities.HelperClass;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

    public static final Logger logger = LogManager.getLogger(Hooks.class);

    @Before(order = 0)
    public void setUp(Scenario scenario) {
        logger.info("=== SCENARIO START: [{}] | Thread: [{}] ===",
                scenario.getName(), Thread.currentThread().getName());

        try {
            HelperClass.setupDriver();
            HelperClass.openPage();
            logger.info("Browser ready for: [{}]", scenario.getName());
        } catch (Exception e) {
            logger.error("Browser setup FAILED: {}", e.getMessage());
            throw new RuntimeException("Browser setup failed", e);
        }
    }

    @After(order = 0)
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            logger.error("=== SCENARIO FAILED: [{}] | Thread: [{}] ===",
                    scenario.getName(), Thread.currentThread().getName());
            captureScreenshot(scenario);
        } else {
            logger.info("=== SCENARIO PASSED: [{}] | Thread: [{}] ===",
                    scenario.getName(), Thread.currentThread().getName());
        }
        HelperClass.tearDown();
    }

    private void captureScreenshot(Scenario scenario) {
        try {
            if (HelperClass.getDriver() == null) return;

            byte[] bytes = ((TakesScreenshot) HelperClass.getDriver())
                    .getScreenshotAs(OutputType.BYTES);
            scenario.attach(bytes, "image/png", "Failure Screenshot");

            File srcFile = ((TakesScreenshot) HelperClass.getDriver())
                    .getScreenshotAs(OutputType.FILE);

            String safeName = scenario.getName()
                    .replaceAll("[^a-zA-Z0-9_\\-]", "_");
            String destPath = ConfigureClass.getScreenshotPath()
                    + safeName + "_" + Thread.currentThread().getName() + ".png";

            FileUtils.copyFile(srcFile, new File(destPath));
            logger.info("Screenshot saved: {}", destPath);

        } catch (Exception e) {
            logger.warn("Screenshot failed: {}", e.getMessage());
        }
    }
}
