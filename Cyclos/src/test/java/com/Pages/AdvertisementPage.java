package com.Pages;

import org.openqa.selenium.By;

public class AdvertisementPage {

    public By marketplaceMenu =
    		By.xpath("//a[.//span[text()='Marketplace']]");

    public By advertisementsMenu =
            By.xpath("//div[contains(normalize-space(),'Advertisements')]");

    public By searchBox =
            By.xpath("//input[@type='search']");

    public By searchButton =
            By.xpath("//button[contains(@class,'search-button')]");

    public By searchResult =
            By.xpath("//div[contains(@class,'card')]");

    public By noResultsMessage =
            By.xpath("//*[contains(text(),'No advertisements found')]");

    public By favouriteIcon =
            By.xpath("//button[contains(@class,'favorite')]");

    public By favouriteSuccessMessage =
            By.xpath("//*[contains(text(),'added to favorites')]");

    public By favouritesMenu =
            By.xpath("//*[contains(text(),'Favorites')]");

    public By favouriteProductsList =
            By.xpath("//div[contains(@class,'card')]");

    public By sortDropdown =
            By.xpath("//select");

    public By productList =
            By.xpath("//div[contains(@class,'card')]");
}