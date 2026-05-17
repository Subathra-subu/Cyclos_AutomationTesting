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

import io.github.bonigarcia.wdm.WebDriverManager;

public class HelperClass {

    private static ThreadLocal<WebDriver> driver =
            new ThreadLocal<>();

    private static ThreadLocal<WebDriverWait> wait =
            new ThreadLocal<>();

    public static Logger log =
            LogManager.getLogger(HelperClass.class);

   
    public static String getDownloadPath() {
        return System.getProperty("user.dir")
                + File.separator
                + "Downloads";
    }

    public static void setupDriver() {

        ChromeOptions options = new ChromeOptions();

        
        String downloadPath = getDownloadPath();

        new File(downloadPath).mkdirs();

        Map<String, Object> prefs = new HashMap<>();
        prefs.put("download.default_directory", downloadPath);
        prefs.put("download.prompt_for_download", false);
        prefs.put("download.directory_upgrade", true);
        prefs.put("safebrowsing.enabled", true);
        prefs.put("plugins.always_open_pdf_externally", true);

        options.setExperimentalOption("prefs", prefs);
        options.addArguments("--disable-pdf-viewer");

        // FIX: Always add these for Jenkins/CI headless environments
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-extensions");
        options.addArguments("--window-size=1920,1080");

        if (ConfigureClass.isHeadless()) {
            options.addArguments("--headless=new");
            options.addArguments("--disable-gpu");
        }

        WebDriverManager.chromedriver().setup();

        WebDriver webDriver;
        String browser = ConfigureClass.getBrowser();

        if (browser.equalsIgnoreCase("chrome")) {
            webDriver = new ChromeDriver(options);
        } else {
            throw new RuntimeException("Browser not supported: " + browser);
        }

        driver.set(webDriver);

        wait.set(new WebDriverWait(
                webDriver,
                Duration.ofSeconds(ConfigureClass.getExplicitWait())));

        webDriver.manage().timeouts()
                .pageLoadTimeout(Duration.ofSeconds(ConfigureClass.getPageLoadTimeout()));

        webDriver.manage().window().maximize();
    }

    public static void openPage() {
        getDriver().get(ConfigureClass.getUrl());
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static WebDriverWait getWait() {
        return wait.get();
    }

    public static void tearDown() {
        if (getDriver() != null) {
            getDriver().quit();
            driver.remove();
            wait.remove();
        }
    }
}