package com.Pages;

import org.openqa.selenium.By;

public class MyAdvertisesmentsPage {
    
    public By marketPlaceMenu = By.xpath("//div[@class='menu-text'][normalize-space()='Marketplace']");
    
    public By myAdvertisements = By.xpath("//div[normalize-space()='My advertisements']");

    public By newAdvertisementBtn = By.xpath("//div[contains(text(),'Add new')] | //button[contains(.,'Add new')] | //span[contains(.,'Add new')] | //a[contains(.,'Add new')]");

    public By titleField = By.xpath("//input[@type='text']");

    public By categoryDropdown = By.xpath("//button[contains(@class,'form-control')]");

    public By categoryOption(String category) {
        return By.xpath("//a[contains(text(),'" + category + "')]");
    }

    public By priceField = By.xpath("//input[@type='tel']");

    public By fromDate = By.xpath("(//input[@type='date'])[1]");

    public By toDate = By.xpath("(//input[@type='date'])[2]");

    public By descriptionFrame = By.xpath("//div[contains(@class,'editor')]");

    public By uploadImageBtn = By.xpath("//input[@type='file']");

    public By saveBtn = By.xpath("//button[contains(.,'Save')] | //span[text()='Save']");

    public By successMessage = By.xpath("//div[contains(@class,'notification-message')] | //notification-message | //*[contains(text(),'was saved') or contains(text(),'was removed') or contains(text(),'success') or contains(text(),'successful')]");

    public By searchField = By.xpath("//input[@placeholder='Keywords'] | //input[@placeholder='Search'] | //label[contains(normalize-space(),'Keywords')]/following::input[1] | //label[contains(normalize-space(),'Keywords')]/following-sibling::input[1] | //input[contains(@class, 'form-control') and (@type='text' or @type='search')]");
    
    public By item = By.xpath("(//div[@class='avatar-container full-size'])[1]");

    public By editBtn = By.xpath("//*[self::div or self::a or self::button or self::span][contains(text(),'Edit')] | //a[contains(.,'Edit')] | //button[contains(.,'Edit')]");

    public By removeBtn = By.xpath("//*[self::div or self::a or self::button or self::span][contains(text(),'Remove')] | //a[contains(.,'Remove')] | //button[contains(.,'Remove')]");

    public By confirmPopup = By.xpath("//div[@class='modal-content']/child::*");

    public By confirmRemoveBtn = By.xpath("//button[contains(.,'Remove')] | //button[contains(.,'Confirm')] | //span[text()='Confirm'] | //span[text()='Confirm']/parent::button");
}
