package com.Pages;

import org.openqa.selenium.By;

public class MyAdvertisesmentsPage {
	
		public By marketPlaceMenu = By.xpath("//div[@class='menu-text'][normalize-space()='Marketplace']");
		
	    public By myAdvertisements =  By.xpath("//div[normalize-space()='My advertisements']");

	    public By newAdvertisementBtn = By.xpath("//div[contains(text(),'Add new')]");

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

	    public By saveBtn = By.xpath("//span[text()='Save']");

	    public By Message = By.xpath("//ui-root[@class='flex-grow-1 d-flex root']/child::snack-bar");

	    public By searchField = By.xpath("//input[@placeholder='Search']");

	    public By editBtn = By.xpath("//div[text()='Edit']");

	    public By removeBtn = By.xpath("//div[text()='Remove']");

	    public By confirmPopup = By.xpath("//div[contains(text(),'Are you sure')]");

	    public By confirmRemoveBtn = By.xpath("//button[contains(text(),'Remove')]");
	    
	}

