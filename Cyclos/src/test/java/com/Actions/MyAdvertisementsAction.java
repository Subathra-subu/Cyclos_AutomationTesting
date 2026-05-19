package com.Actions;

import org.openqa.selenium.By;

import com.Pages.MyAdvertisesmentsPage;

public class MyAdvertisementsAction extends BaseAction {
	
	MyAdvertisesmentsPage advertisementPage = new MyAdvertisesmentsPage();
	
	public void clickMarketPlaceMenu() {
		
		click(advertisementPage.marketPlaceMenu);
		
	}

    public void clickMyAdvertisements() {
    	
    	scrollIntoView(advertisementPage.myAdvertisements);

        click(advertisementPage.myAdvertisements);
    }

    public void clickNewAdvertisement() {

        click(advertisementPage.newAdvertisementBtn);
    }

    public void enterTitle(String title) {
        
        sendKeys(advertisementPage.titleField, title);
    }

    public void selectCategory(String category) {

        click(advertisementPage.categoryDropdown);

        By option =
                advertisementPage.categoryOption(category);

        waitForVisibility(option);

        click(option);
    }

    public void enterPrice(String price) {

        sendKeys(advertisementPage.priceField, price);
    }

    public void selectFromDate(String date) {

        sendKeys(advertisementPage.fromDate, date);
    }

    public void selectToDate(String date) {

        sendKeys(advertisementPage.toDate, date);
    }

    public void enterDescription(String description) {

        waitForVisibility(advertisementPage.descriptionFrame);

        sendKeys(advertisementPage.descriptionFrame,
                description);
    }


    public void clickSave() {

        waitForVisibility(advertisementPage.saveBtn);

        click(advertisementPage.saveBtn);
    }

    public String validateSuccessMessage() {

        return getText(advertisementPage.successMessage);
    }

    public void searchAdvertisement(String title) {

        sendKeys(advertisementPage.searchField, title);
    }

    public void clickEditAdvertisement() {

        click(advertisementPage.editBtn);
    }

    public void clickRemoveAdvertisement() {

        click(advertisementPage.removeBtn);
    }

    public String validateRemovePopup() {

        return getText(advertisementPage.confirmPopup);
    }

    public void confirmRemoveAdvertisement() {

        click(advertisementPage.confirmRemoveBtn);
    }
}

