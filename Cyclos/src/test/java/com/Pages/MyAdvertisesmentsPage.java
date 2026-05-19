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

<<<<<<< HEAD
	    public By uploadImageBtn = By.xpath("//input[@type='file']");

	    public By saveBtn = By.xpath("//button[contains(text(),'Save')]");
=======
	    public By saveBtn = By.xpath("//span[text()='Save']");
>>>>>>> 54618e4eca3f4ae10a01bdd265fadc8d6438dfa9

	    public By successMessage = By.xpath("//div[contains(@class,'notification-message')]");

	    public By searchField = By.xpath("//input[@class='form-control w-100 ng-untouched ng-pristine ng-valid']");
	    
	    public By item = By.xpath("(//div[@class='avatar-container full-size'])[1]");

	    public By editBtn = By.xpath("//div[contains(text(),'Edit')]");

	    public By removeBtn = By.xpath("//div[contains(text(),'Remove')]");

	    public By confirmPopup = By.xpath("//div[@class='modal-content']/child::*");

<<<<<<< HEAD
	    public By confirmRemoveBtn = By.xpath("//button[contains(text(),'Remove')]");
=======
	    public By confirmRemoveBtn = By.xpath("//span[text()='Confirm']");
	    
>>>>>>> 54618e4eca3f4ae10a01bdd265fadc8d6438dfa9
	}

