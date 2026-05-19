package com.Pages;

import org.openqa.selenium.By;

public class AdvertisementPage {

	public By marketPlace = By.xpath("//div[@class='menu-text'][normalize-space()='Marketplace']");
	public By advertisement = By.xpath("//div[normalize-space()='Advertisements']");
    public By searchBox = By.xpath("(//search-ads//input)[1]");
    public By searchBtn = By.xpath("//button[@type='submit']");
    public By favt = By.xpath("(//ad-favorite//button)[1]");
    public By noResultMsg =	By.xpath("//search-ads//*[contains(text(),'No results') or contains(text(),'No advertisements')]");

    public By favouriteIcon = By.xpath("(//button[contains(@class,'favorite')])[1]");

    public By sortDropdown = By.xpath("//select");

    public By sortOption(String value) {
        return By.xpath("//option[text()='" + value + "']");
    }
}