package com.Actions;

import org.testng.Assert;

import com.Pages.AdvertisementsPage;
import com.Utilities.HelperClass;

public class AdvertisementsActions extends BaseAction {
 
    AdvertisementsPage adPage = new AdvertisementsPage();
    
    public void clickingLinks() {
    	click(adPage.marketPlaceLink);
    	click(adPage.advertisementsLink);
    	HelperClass.log.info("Clicked on Advertisement on the Page of Market place");
    }
    public void searchingProduct(String keyword) {

        try {
            waitForVisibility(adPage.searching);
            sendKeys(adPage.searching, keyword);
        } 
        catch (org.openqa.selenium.StaleElementReferenceException e) {
            HelperClass.log.warn("Stale Element occurred. Retrying search field");
            waitForVisibility(adPage.searching);
            sendKeys(adPage.searching, keyword);
        }

        HelperClass.log.info("Entered search keyword : " + keyword);
    }
    public void favtIconCheck() {
    	isDisplayed(adPage.searching);
    	Assert.assertTrue(isDisplayed(adPage.favIcon), "Products based on keyword is diplayed");
    	HelperClass.log.info("Product based on the keyword is displayed");
    }
	public void noresultError() {
		
	}
    

    
}