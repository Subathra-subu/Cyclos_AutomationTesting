package com.Actions;

import org.openqa.selenium.By;
import org.testng.Assert;
import com.Pages.MyAdvertisesmentsPage;
import com.StepDefinitions.Hooks;

public class MyAdvertisementsAction extends BaseAction {
    
    MyAdvertisesmentsPage advertisementPage = new MyAdvertisesmentsPage();
    
    public void ensureSidebarExpanded() {
        By menuTrigger = By.xpath("//a[contains(@class,'menu-trigger')] | //button[contains(@class,'navbar-toggler')] | //*[@class='menu-trigger'] | //a[@id='menu-trigger']");
        try {
            if (isDisplayed(menuTrigger) && !isDisplayed(advertisementPage.marketPlaceMenu)) {
                click(menuTrigger);
            }
        } catch (Exception ignored) {}
    }

    public void clickMarketPlaceMenu() {
        ensureSidebarExpanded();
        click(advertisementPage.marketPlaceMenu);
    }

    public void clickMyAdvertisements() {
        ensureSidebarExpanded();
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
        By option = advertisementPage.categoryOption(category);
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
        sendKeys(advertisementPage.descriptionFrame, description);
    }

    public void clickSave() {
        waitForVisibility(advertisementPage.saveBtn);
        click(advertisementPage.saveBtn);
    }

    public String validateSuccessMessage() {
        return getText(advertisementPage.successMessage);
    }

    public void assertSuccessfullMessage() {
        waitForVisibility(advertisementPage.successMessage);
        String msg = validateSuccessMessage().toLowerCase();
        Assert.assertTrue(msg.contains("saved") || msg.contains("success") || msg.contains("created"));
    }

    public void searchAdvertisement(String title) {
        sendKeys(advertisementPage.searchField, title);
    }

    public void clickItem() {
        waitForVisibility(advertisementPage.item);
        click(advertisementPage.item);
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
        jsClick(advertisementPage.confirmRemoveBtn);
    }

    public void assertRemovalMessage() {
        waitForVisibility(advertisementPage.successMessage);
        String msg = validateSuccessMessage().toLowerCase();
        Assert.assertTrue(msg.contains("removed") || msg.contains("success"));
    }
}
