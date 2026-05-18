package com.Utilities;

import java.io.File;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HelperClass {

    private static ThreadLocal<WebDriver> driver =
            new ThreadLocal<>();

    private static ThreadLocal<WebDriverWait> wait =
            new ThreadLocal<>();

    private static HelperClass helperClass;

    public static Logger log = LogManager.getLogger(HelperClass.class);

    // Download Path
    public static String getDownloadPath() {

        return System.getProperty("user.dir")
                + File.separator
                + "Downloads";
    }

    // Constructor
    HelperClass() {

        ChromeOptions options = new ChromeOptions();

        // Download setup
        String downloadPath = getDownloadPath();

        new File(downloadPath).mkdirs();

        Map<String, Object> prefs = new HashMap<>();

        prefs.put("download.default_directory", downloadPath);
        prefs.put("download.prompt_for_download", false);
        prefs.put("download.directory_upgrade", true);
        prefs.put("safebrowsing.enabled", true);
        prefs.put("plugins.always_open_pdf_externally", true);

        options.setExperimentalOption("prefs", prefs);

        // Browser options
        options.addArguments("--disable-pdf-viewer");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-extensions");
        options.addArguments("--window-size=1920,1080");

        // Headless mode
        if (ConfigureClass.isHeadless()) {

            options.addArguments("--headless=new");
            options.addArguments("--disable-gpu");
        }

        WebDriver webDriver = null;

        // Browser setup
        if (ConfigureClass.getBrowser().equalsIgnoreCase("chrome")) {

            webDriver = new ChromeDriver(options);

        } else {

            throw new RuntimeException(
                    "Browser not supported");
        }

        driver.set(webDriver);

        // Using direct values instead of ConfigureClass methods
        wait.set(new WebDriverWait(
                webDriver,
                Duration.ofSeconds(10)));

        webDriver.manage().timeouts()
                .implicitlyWait(Duration.ofSeconds(20));

        webDriver.manage().timeouts()
                .pageLoadTimeout(Duration.ofSeconds(20));

        webDriver.manage().window().maximize();
    }

    // Setup Driver
    public static void setupDriver() {

        if (helperClass == null) {

            helperClass = new HelperClass();
        }
    }

    // Open URL
    public static void openPage() {

        getDriver().get(ConfigureClass.getUrl());
    }

    // Get Driver
    public static WebDriver getDriver() {

        return driver.get();
    }

    // Get Wait
    public static WebDriverWait getWait() {

        return wait.get();
    }

    // Tear Down
    public static void tearDown() {

        if (getDriver() != null) {

            getDriver().quit();

            driver.remove();
            wait.remove();
        }

        helperClass = null;
    }
}