package com.Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigureClass {

    private static Properties properties;

    static {

        try {

            FileInputStream fis =
                    new FileInputStream(

                            System.getProperty("user.dir")

                                    + "/src/test/resources/Configure.properties");

            properties = new Properties();

            properties.load(fis);

        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    // BROWSER

    public static String getBrowser() {

        return properties.getProperty("browser");
    }

    // URL

    public static String getUrl() {

        return properties.getProperty("url");
    }

    // USERNAME

    public static String getUsername() {

        return properties.getProperty("username");
    }

    // PASSWORD

    public static String getPassword() {

        return properties.getProperty("password");
    }

    // IMPLICIT WAIT

    public static int getImplicitWait() {

        return Integer.parseInt(

                properties.getProperty(
                        "implicitWait"));
    }

    // EXPLICIT WAIT

    public static int getExplicitWait() {

        return Integer.parseInt(

                properties.getProperty(
                        "explicitWait"));
    }

    // HEADLESS

    public static boolean isHeadless() {

        return Boolean.parseBoolean(

                properties.getProperty(
                        "headless"));
    }

    // SCREENSHOT PATH

    public static String getScreenshotPath() {

        return properties.getProperty(
                "screenshotPath");
    }

    // REPORT PATH

    public static String getReportPath() {

        return properties.getProperty(
                "reportPath");
    }

    // PARALLEL EXECUTION

    public static boolean isParallel() {

        return Boolean.parseBoolean(

                properties.getProperty(
                        "parallel"));
    }

    // PAGE LOAD TIMEOUT

    public static int getPageLoadTimeout() {

        return Integer.parseInt(

                properties.getProperty(
                        "pageLoadTimeout"));
    }
}