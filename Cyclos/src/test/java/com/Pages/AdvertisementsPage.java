package com.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AdvertisementsPage {

    WebDriver driver;

    public AdvertisementsPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    By advertisementsMenu = By.id("menu_advertisements");
    By searchField = By.id("searchField");
    By searchButton = By.id("searchButton");
    By results = By.className("ad-item");
    By noResults = By.id("noResultsMessage");
    By favIcon = By.className("fav-icon");
    By successMsg = By.id("successMessage");
    By favouritesMenu = By.id("menu_favourites");
    By favItems = By.className("fav-item");
    By sortDropdown = By.id("sortDropdown");

    // Actions
    public void clickAdvertisementsMenu() {
        driver.findElement(advertisementsMenu).click();
    }

    public void enterSearch(String keyword) {
        driver.findElement(searchField).clear();
        driver.findElement(searchField).sendKeys(keyword);
    }

    public void clickSearch() {
        driver.findElement(searchButton).click();
    }

    public int getResultsCount() {
        List<WebElement> list = driver.findElements(results);
        return list.size();
    }

    public String getNoResultMessage() {
        return driver.findElement(noResults).getText();
    }

    public void clickFavouriteIcon() {
        driver.findElement(favIcon).click();
    }

    public String getSuccessMessage() {
        return driver.findElement(successMsg).getText();
    }

    public void clickFavouritesMenu() {
        driver.findElement(favouritesMenu).click();
    }

    public int getFavouritesCount() {
        return driver.findElements(favItems).size();
    }

    public void selectSort(String type) {
        driver.findElement(sortDropdown).click();
        driver.findElement(By.xpath("//option[text()='" + type + "']")).click();
    }
}