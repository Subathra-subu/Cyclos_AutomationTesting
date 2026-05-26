package com.Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigureClass {

    private static final Properties properties;

    static {
        try {
            FileInputStream fis = new FileInputStream(
                    System.getProperty("user.dir")
                            + "/src/test/resources/Configure.properties");

            properties = new Properties();
            properties.load(fis);

        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(
                    "Failed to load Configure.properties. " +
                    "Ensure it exists at src/test/resources/Configure.properties");
        }
    }

    public static String getBrowser() {
        return properties.getProperty("browser", "chrome");
    }

    public static String getUrl() {
        return properties.getProperty("url");
    }

    public static String getUsername() {
        return properties.getProperty("username");
    }

    public static String getPassword() {
        return properties.getProperty("password");
    }

    public static int getExplicitWait() {
        return Integer.parseInt(properties.getProperty("explicitWait", "40"));
    }

    public static int getPageLoadTimeout() {
        return Integer.parseInt(properties.getProperty("pageLoadTimeout", "90"));
    }

    /** Dedicated timeout (seconds) used only for post-login dashboard wait */
    public static int getLoginWaitTimeout() {
        return Integer.parseInt(properties.getProperty("loginWaitTimeout", "60"));
    }

    /** How many times the login step retries before throwing */
    public static int getLoginRetryCount() {
        return Integer.parseInt(properties.getProperty("loginRetryCount", "2"));
    }

    public static boolean isHeadless() {
        return Boolean.parseBoolean(properties.getProperty("headless", "false"));
    }

    public static String getScreenshotPath() {
        return properties.getProperty("screenshotPath", "screenshots/");
    }

    public static String getReportPath() {
        return properties.getProperty("reportPath", "reports/");
    }

    public static boolean isParallel() {
        return Boolean.parseBoolean(properties.getProperty("parallel", "false"));
    }
}