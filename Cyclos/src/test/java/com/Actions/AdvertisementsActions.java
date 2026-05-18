package com.Actions;

import org.testng.Assert;

import com.Pages.AdvertisementsPage;

public class AdvertisementsActions extends BaseAction {
 
    AdvertisementsPage adPage = new AdvertisementsPage();
    
    public void clickingLinks() {
    	click(adPage.marketPlaceLink);
    	click(adPage.advertisementsLink);
    }
    public void searchingProduct(String keyword) {
    	sendKeys(adPage.searching, keyword);
    }
    public void favtIconCheck() {
    	waitForVisibility(adPage.favIcon);
    	Assert.assertTrue(isDisplayed(adPage.favIcon), "Products based on keyword is diplayed");
    }
    

    
}