package com.Pages;

import org.openqa.selenium.By;

public class BusinessDirectoryPage {

    public By businessDirectoryMenu =By.xpath("//a[@href='/users/search']//div[@class='quick-access-icon']//icon//*[name()='svg']");

    public By keywordField =By.xpath("//input[@type='text']");

    public By tiledViewButton = By.xpath("//label[@class=\"btn btn-icon focusable resultType-tiles active\"]");

    public By listViewButton =By.xpath("//label[@class=\"btn btn-icon focusable resultType-list\"]");

    public By businessCards =By.xpath("//div[contains(@class,'card-body')]");

    public By orderDropdown =By.xpath("//button[contains(@class,'custom-select')]");

    public By ascendingOrder =By.xpath("//a[contains(text(),'Name (A-Z)')]");

    public By descendingOrder =By.xpath("//a[contains(text(),'Name (Z-A)')]");
    
    public By activeListView =By.xpath("//label[contains(@class,'resultType-list') and contains(@class,'active')]");

    public By activeTiledView =By.xpath("//label[contains(@class,'resultType-tiles') and contains(@class,'active')]");

    public By firstBusinessName =By.xpath("(//div[contains(@class,'card-body')]//a)[1]");
}