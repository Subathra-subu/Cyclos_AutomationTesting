package com.Utilities;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HelperClass {

    // ThreadLocal for parallel-safe driver & wait
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    private static ThreadLocal<WebDriverWait> wait = new ThreadLocal<>();

    // DRIVER SETUP — always creates a fresh driver (singleton removed intentionally)
    public static void setupDriver() {

        ChromeOptions options = new ChromeOptions();

        // DOWNLOAD PATH
        String downloadPath = System.getProperty("user.dir") + "/Downloads";

        // CHROME PREFERENCES
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("download.default_directory", downloadPath);
        prefs.put("download.prompt_for_download", false);
        prefs.put("plugins.always_open_pdf_externally", true);
        // Disable Chrome PDF viewer so files download instead of opening in browser
        prefs.put("pdfjs.disabled", true);

        options.setExperimentalOption("prefs", prefs);

        // HEADLESS MODE
        if (ConfigureClass.isHeadless()) {
            options.addArguments("--headless=new");
            options.addArguments("--disable-gpu");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
        }

        // WEBDRIVER MANAGER
        WebDriverManager.chromedriver().setup();

        WebDriver webDriver;

        // BROWSER SETUP
        String browser = ConfigureClass.getBrowser();

        if (browser.equalsIgnoreCase("chrome")) {
            webDriver = new ChromeDriver(options);
        } else {
            throw new RuntimeException("Browser not supported: " + browser);
        }

        // SET THREAD LOCAL DRIVER
        driver.set(webDriver);

        // EXPLICIT WAIT
        wait.set(new WebDriverWait(
                webDriver,
                Duration.ofSeconds(ConfigureClass.getExplicitWait())
        ));

        // IMPLICIT WAIT
        webDriver.manage().timeouts()
                .implicitlyWait(Duration.ofSeconds(ConfigureClass.getImplicitWait()));

        // PAGE LOAD TIMEOUT
        webDriver.manage().timeouts()
                .pageLoadTimeout(Duration.ofSeconds(ConfigureClass.getPageLoadTimeout()));

        // MAXIMIZE
        webDriver.manage().window().maximize();
    }

    // OPEN APPLICATION
    public static void openPage() {
        getDriver().get(ConfigureClass.getUrl());
    }

    // GET DRIVER
    public static WebDriver getDriver() {
        return driver.get();
    }

    // GET WAIT
    public static WebDriverWait getWait() {
        return wait.get();
    }

    // DRIVER TEARDOWN
    public static void tearDown() {
        if (getDriver() != null) {
            getDriver().quit();
            driver.remove();
            wait.remove();
        }
    }
}