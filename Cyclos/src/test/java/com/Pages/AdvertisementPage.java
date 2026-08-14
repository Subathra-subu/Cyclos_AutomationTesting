package com.Pages;

import org.openqa.selenium.By;

public class AdvertisementPage {

    public By marketplaceMenu = By.xpath("//div[text()='Marketplace']/parent::a");
    public By advertisementTab = By.xpath("//div[contains(normalize-space(),'Advertisements')]/parent::a");
    public By activeAdvertisementTab = By.xpath("//a[contains(@class,'active')]//div[contains(normalize-space(),'Advertisements')]");
    public By searchInput = By.xpath("(//search-ads//input)[1]");
    public By advertisementResults = By.cssSelector("tbody tr");
    public By noResultsMessage = By.xpath("//*[contains(normalize-space(),'No results')]");
    public By firstAdvertisementCard = By.xpath("(//div[contains(@class,'card')])[1]");
    public By advertisementCard = By.xpath("//div[contains(@class,'card')]");
    public By advertisementCards = By.xpath("//*[contains(text(),'Published') or contains(text(),'published')]");
    public By advertisementContainer =By.xpath("//div[contains(@class,'card') or contains(@class,'result')]");
    public By advertisementImage = By.xpath("(//img[contains(@src,'content') or contains(@src,'image')])[1]");
    public By favouriteIcon = By.xpath("(//*[contains(@class,'favorite')]/*)[1]");
    public By favouriteSuccessMessage  = By.xpath("/html/body/ui-root/snack-bar");
    public By favouritesOnlyFilter = By.xpath("//boolean-field//label-value//label");
    public By showMoreFilters = By.xpath("//*[contains(text(),'Show more filters')]");
    public By minPriceField = By.xpath("(//input[@type='tel'])[1]");
    public By maxPriceField = By.xpath("(//input[@type='tel'])[2]");
    public By withImagesFilter = By.xpath("//*[contains(text(),'With images')]");
    public By invalidKeywordMessage = By.xpath("//*[contains(text(),'invalid keyword') or contains(text(),'Invalid keyword')]");
    public By communityList = By.xpath("//page-content/descendant::a[1]");

}