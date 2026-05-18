package com.Pages;

import org.openqa.selenium.By;

public class AdvertisementsPage {

    public By marketPlaceLink = By.xpath("//div[contains(@class,'menu-text') and normalize-space()='Marketplace']");
    public By advertisementsLink = By.xpath("//div[normalize-space()='Advertisements']");
    public By searching = By.xpath("(//search-ads//input)[1]");
    public By productResults = By.xpath("//tiled-result");
    public By favIcon = By.cssSelector("ad-favorite button");
    public By noResults = By.xpath("//ads-results//page-content//div[contains(@class,'results')]");

}