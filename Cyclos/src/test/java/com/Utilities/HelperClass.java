package com.Utilities;

import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebDriver;

public class HelperClass {
	
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	
	private static ThreadLocal<WebDriverWait> wait = new ThreadLocal<>();

	private static HelperClass helperClass;

	HelperClass() {

		ChromeOptions options = new ChromeOptions();

		if (ConfigureClass.isHeadless()) {
			options.addArguments("--headless=new");
		}

		WebDriver webDriver = null;

		if (ConfigureClass.getBrowser().equalsIgnoreCase("chrome")) {

			webDriver = new ChromeDriver(options);

		} else {

			System.out.println("Browser not supported");
		}

		driver.set(webDriver);

		wait.set(new WebDriverWait(webDriver, Duration.ofSeconds(20)));

		webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));

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

	public static void setupDriver() {

		if (helperClass == null) {
			helperClass = new HelperClass();
		}
	}

	public static void tearDown() {

		if (getDriver() != null) {

			getDriver().quit();

			driver.remove();
			wait.remove();
		}

		helperClass = null;
	}
}
