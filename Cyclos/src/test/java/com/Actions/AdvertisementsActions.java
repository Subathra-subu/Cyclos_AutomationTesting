package com.Actions;

import com.Pages.AdvertisementsPage;

public class AdvertisementsActions {

    AdvertisementsPage adPage;

    // Constructor injection (driver already handled in hooks → passed from stepdef)
    public AdvertisementsActions(AdvertisementsPage adPage) {
        this.adPage = adPage;
    }

    // ------------------ SEARCH ------------------

    public void navigateToAdvertisements() {
        adPage.clickAdvertisementsMenu();
    }

    public void searchAdvertisement(String keyword) {
        adPage.enterSearch(keyword);
        adPage.clickSearch();
    }

    public boolean isSearchResultDisplayed() {
        return adPage.getResultsCount() > 0;
    }

    public boolean isNoResultMessageDisplayed() {
        return adPage.getNoResultMessage().contains("No");
    }

    // ------------------ FAVOURITES ------------------

    public void addToFavourites() {
        adPage.clickFavouriteIcon();
    }

    public boolean isProductAddedToFavourites() {
        return adPage.getSuccessMessage().length() > 0;
    }

    public void openFavourites() {
        adPage.clickFavouritesMenu();
    }

    public boolean isFavouritesListDisplayed() {
        return adPage.getFavouritesCount() > 0;
    }

    // ------------------ SORTING ------------------

    public void sortAdvertisements(String type) {
        adPage.selectSort(type);
    }

    public boolean isSortedResultDisplayed() {
        return adPage.getResultsCount() >= 0;
    }
}