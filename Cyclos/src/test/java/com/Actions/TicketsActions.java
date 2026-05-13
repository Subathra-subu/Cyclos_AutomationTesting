package com.Actions;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.Pages.TickesPage;
import com.Utilities.HelperClass;

public class TicketsActions extends BaseAction {

    TickesPage ticketsPage = new TickesPage();

    // CLICK BANKING MENU
    // FIX: After clicking Banking, wait for the sub-menu to become visible
    //      before attempting to click Tickets. The lag you experienced is
    //      because the sidebar expands with an animation — the old code
    //      tried to click Tickets before it was interactable.
    public void clickOnBankingMenu() {
        waitForClickable(ticketsPage.bankingMenu);
        click(ticketsPage.bankingMenu);

        // Wait for the banking sub-menu container to appear after click
        HelperClass.getWait().until(
                ExpectedConditions.visibilityOfElementLocated(ticketsPage.ticketsMenu));
    }

    // CLICK TICKETS MENU
    // FIX: No need for extra waitForVisibility here because clickOnBankingMenu
    //      already waits for it. Just scroll and click.
    public void clickOnTicketsMenu() {
        scrollIntoView(ticketsPage.ticketsMenu);
        waitForClickable(ticketsPage.ticketsMenu);
        jsClick(ticketsPage.ticketsMenu);

        // Wait for the page to load after clicking Tickets
        HelperClass.getWait().until(
                ExpectedConditions.visibilityOfElementLocated(ticketsPage.statusBtn));
    }

    // SELECT STATUS
    public void selectStatus(String status) {
        waitForClickable(ticketsPage.statusBtn);
        click(ticketsPage.statusBtn);

        By statusOption = By.xpath(
                "//div[contains(@id,'dropdown-menu')]"
                        + "//a[normalize-space()='"
                        + status + "']");

        waitForVisibility(statusOption);
        click(statusOption);

        // Wait for the dropdown to close after selection
        waitForInvisibility(statusOption);
    }

    // CLICK TRANSACTION ID
    public void clickTransactionId(String transactionId) {
        By transaction = By.xpath(
                "//tbody//td[contains(text(),'" + transactionId + "')]");

        waitForVisibility(transaction);
        scrollIntoView(transaction);
        jsClick(transaction);
    }

    // CLICK PRINT BUTTON
    public void clickPrintButton() {
        waitForClickable(ticketsPage.print);
        jsClick(ticketsPage.print);
    }

    // GET SELECTED STATUS TEXT
    public String getSelectedStatus() {
        waitForVisibility(ticketsPage.statusBtn);
        return getText(ticketsPage.statusBtn);
    }
}