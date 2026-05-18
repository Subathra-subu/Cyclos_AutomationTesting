package com.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AdvertisementsPage {

	public By marketPlaceLink = By.xpath("//div[@class='menu-text'][normalize-space()='Marketplace']");
	public By advertisementsLink = By.xpath("//div[@class='main-container container-md d-flex flex-column flex-grow-1']//a[2]");
    public By searching = By.id("id_48");
    public By favtIcon = By.xpath("(//ad-favorite//button)[1]");
    public By advertisementsMenu = By.id("menu_advertisements");
    public By searchField = By.id("searchField");
    public By searchButton = By.id("searchButton");
    public By results = By.className("ad-item");
    public By noResults = By.id("noResultsMessage");
    public By favIcon = By.className("fav-icon");
    public By successMsg = By.id("successMessage");
    public By favouritesMenu = By.id("menu_favourites");
    public By favItems = By.className("fav-item");
    public By sortDropdown = By.id("sortDropdown");

}