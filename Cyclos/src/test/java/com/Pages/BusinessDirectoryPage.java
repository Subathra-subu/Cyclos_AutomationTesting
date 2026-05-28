package com.Pages;

import org.openqa.selenium.By;

public class BusinessDirectoryPage {

	public By businessDirectoryMenu = By.xpath("//a[@href='/users/search']");

	public By keywordField = By.xpath("//input[@type='text']");

	public By tiledViewButton = By.xpath("//*[contains(@class,'resultType-tiles')]");

	public By listViewButton = By.xpath("//*[contains(@class,'resultType-list')]");

	public By businessCards = By.xpath("//div[contains(@class,'card-body')]");

	public By businessNames = By.xpath("//div[contains(@class,'card-body')]//h3");

	public By orderDropdown = By.xpath("//button[contains(@class,'custom-select')]");

	public By ascendingOrder = By.xpath("(//a[@class='select-option undefined level0 mt-1'])[1]");

	public By descendingOrder = By.xpath("(//a[@class='select-option undefined level0 mt-1'])[2]");

	public By activeListView = By.xpath("//*[contains(@class,'resultType-list') and contains(@class,'active')]");

	public By activeTiledView = By.xpath("//*[contains(@class,'resultType-tiles') and contains(@class,'active')]");
}