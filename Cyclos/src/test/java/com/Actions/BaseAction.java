package com.Actions;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import com.Pages.LoginPage;
import com.Utilities.HelperClass;

public class BaseAction {
	
	public LoginPage loginPage = new LoginPage();
	
	public JavascriptExecutor js = (JavascriptExecutor) HelperClass.getDriver();
	
	public void click(By locator) {

        waitForClickable(locator);

        HelperClass.getDriver().findElement(locator).click();
    }

   
    public void jsClick(By locator) {

        WebElement element = HelperClass.getWait().until(ExpectedConditions.elementToBeClickable(locator));

        js.executeScript("arguments[0].click();",element);
    }

    
    public void sendKeys(By locator,String value) {

        waitForVisibility(locator);

        WebElement element = HelperClass.getDriver().findElement(locator);

        element.clear();

        element.sendKeys(value);
    }

    
    public String getText(By locator) {

        waitForVisibility(locator);

        return HelperClass.getDriver().findElement(locator).getText();
    }

    
    public void waitForVisibility(By locator) {

        HelperClass.getWait().until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    
    public void waitForClickable(By locator) {

        HelperClass.getWait().until(ExpectedConditions.elementToBeClickable(locator));
    }

    
    public void waitForInvisibility(By locator) {

        HelperClass.getWait().until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    
    public void scrollIntoView(By locator) {

        WebElement element =HelperClass.getDriver().findElement(locator);

        JavascriptExecutor js = (JavascriptExecutor) HelperClass.getDriver();

        js.executeScript("arguments[0].scrollIntoView({block:'center'});",element);
    }

    
    public void mouseHover(By locator) {

        WebElement element = HelperClass.getDriver().findElement(locator);

        Actions actions = new Actions(HelperClass.getDriver());

        actions.moveToElement(element).perform();
    }

    
    public boolean isDisplayed(By locator) {

        try {

            return HelperClass.getDriver().findElement(locator).isDisplayed();

        } catch (Exception e) {

            return false;
        }
    }

    
    public void clearDownloadFolder(String downloadPath) {

        File folder = new File(downloadPath);

        File[] files = folder.listFiles();

        if (files != null) {

            for (File file : files) {

                if (file.isFile()) {

                    file.delete();
                }
            }
        }
    }

   
    public void waitForFileDownload(String downloadPath,String fileExtension) {

        FluentWait<WebDriver> wait = new FluentWait<>(HelperClass.getDriver())
                        .withTimeout(Duration.ofSeconds(60))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(Exception.class);

        wait.until(driver -> {

            File folder = new File(downloadPath);

            File[] files = folder.listFiles();

            if (files != null) {

                for (File file : files) {

                    if (file.getName().contains(fileExtension)
                            && !file.getName().endsWith(".crdownload")
                            && !file.getName().endsWith(".tmp")) {

                        return true;
                    }
                }
            }

            return false;
        });
    }
	
}
