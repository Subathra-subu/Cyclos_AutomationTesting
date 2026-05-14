package com.Actions;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import com.Utilities.HelperClass;

public class BaseAction {

    public void click(By locator) {

        HelperClass.getWait()
                .until(ExpectedConditions.elementToBeClickable(locator));

        HelperClass.getDriver()
                .findElement(locator)
                .click();
    }

    public void type(By locator, String value) {

        HelperClass.getWait()
                .until(ExpectedConditions.visibilityOfElementLocated(locator));

        WebElement element = HelperClass.getDriver()
                .findElement(locator);

        element.clear();

        element.sendKeys(value);
    }

    public boolean isDisplayed(By locator) {
        try {
            return HelperClass.getWait()
                    .until(ExpectedConditions.visibilityOfElementLocated(locator))
                    .isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    

    public String getText(By locator) {

        HelperClass.getWait()
                .until(ExpectedConditions.visibilityOfElementLocated(locator));

        return HelperClass.getDriver()
                .findElement(locator)
                .getText();
    }
    
    public void selectDropdown(By locator, String text) {

        HelperClass.getWait()
                .until(ExpectedConditions.visibilityOfElementLocated(locator));

        WebElement dropdown = HelperClass.getDriver()
                .findElement(locator);

        Select select = new Select(dropdown);

        select.selectByVisibleText(text);
    }
    
    public void acceptAlert() {

        Alert alert = HelperClass.getWait()
                .until(ExpectedConditions.alertIsPresent());

        alert.accept();
    }
}