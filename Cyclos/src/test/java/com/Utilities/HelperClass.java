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

    private static final ThreadLocal<WebDriver>     driver      = new ThreadLocal<>();
    private static final ThreadLocal<WebDriverWait> wait        = new ThreadLocal<>();
    private static final ThreadLocal<String>        downloadDir = new ThreadLocal<>();

    private static volatile boolean wdmSetupDone = false;
    private static final Object     wdmLock      = new Object();

    public static final Logger log = LogManager.getLogger(HelperClass.class);

    public static String getDownloadPath() {
        String path = downloadDir.get();
        if (path == null) {
            path = System.getProperty("user.dir") + File.separator + "Downloads"
                    + File.separator + "thread-" + Thread.currentThread().getId();
            downloadDir.set(path);
        }
        return path;
    }

    public static void setupDriver() {

        ChromeOptions options = new ChromeOptions();

        String downloadPath = getDownloadPath();
        new File(downloadPath).mkdirs();

        Map<String, Object> prefs = new HashMap<>();
        prefs.put("download.default_directory",        downloadPath);
        prefs.put("download.prompt_for_download",      false);
        prefs.put("download.directory_upgrade",        true);
        prefs.put("safebrowsing.enabled",              true);
        prefs.put("plugins.always_open_pdf_externally", true);

        prefs.put("printing.print_preview_sticky_settings.appState",
                "{\"recentDestinations\":[{\"id\":\"Save as PDF\",\"origin\":\"local\",\"account\":\"\"}],"
                + "\"selectedDestinationId\":\"Save as PDF\",\"version\":2}");
        prefs.put("savefile.default_directory", downloadPath);
        prefs.put("credentials_enable_service",             false);
        prefs.put("profile.password_manager_enabled",       false);
        prefs.put("profile.password_manager_leak_detection", false);

        options.setExperimentalOption("prefs", prefs);
        options.addArguments("--disable-pdf-viewer");
        options.addArguments("--kiosk-printing");
        options.addArguments("--disable-print-preview");
        options.addArguments("--disable-save-password-bubble");
        options.addArguments("--disable-features=PasswordLeakDetection");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-infobars");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--window-size=1920,1080");
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-blink-features=AutomationControlled");
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        options.setExperimentalOption("useAutomationExtension", false);

        if (ConfigureClass.isHeadless()) {
            options.addArguments("--headless=new");
            options.addArguments("--disable-gpu");
        }

        synchronized (wdmLock) {
            if (!wdmSetupDone) {
                WebDriverManager.chromedriver().setup();
                wdmSetupDone = true;
                log.info("WebDriverManager chromedriver setup complete");
            }
        }

        WebDriver webDriver = new ChromeDriver(options);
        driver.set(webDriver);
        wait.set(new WebDriverWait(webDriver, Duration.ofSeconds(ConfigureClass.getExplicitWait())));

        webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(ConfigureClass.getPageLoadTimeout()));
        webDriver.manage().window().setSize(new org.openqa.selenium.Dimension(1920, 1080));

        if (!ConfigureClass.isHeadless()) {
            webDriver.manage().window().maximize();
        }

        log.info("Thread [{}] browser created, download: {}", Thread.currentThread().getName(), downloadPath);
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
        try {
            if (getDriver() != null) {
                getDriver().quit();
                log.info("Thread [{}] browser closed", Thread.currentThread().getName());
            }
        } catch (Exception e) {
            log.warn("Browser quit failed: {}", e.getMessage());
        } finally {
            driver.remove();
            wait.remove();
            downloadDir.remove();
        }
    }
}