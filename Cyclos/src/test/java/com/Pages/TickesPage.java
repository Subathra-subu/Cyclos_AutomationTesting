package com.Pages;

import org.openqa.selenium.By;

public class TickesPage extends BasePage {

    // Main navigation
    public By bankingMenu =
            By.xpath("//a[@id='menu_banking']");

    // Tickets submenu inside banking
    public By ticketsMenu =
            By.xpath("//div[text()=\"Tickets\"]/parent::a");

    // Status filter dropdown button
    public By statusBtn =
            By.xpath("//button[contains(@class,'form-control')]");

    // Print button inside transaction detail
    public By print =
            By.xpath("//div[text()=\"Print\"]/parent::button");

    // Transaction status label in detail view
    public By transactionStatus =
            By.xpath("(//div[contains(@class,'label-value-value')])[1]");

    // Shown when no records match the filter
    public By noResultsMessage =
            By.xpath("//div[text()='No results match the search criteria']");

    // First data row in the tickets table
    public By firstRow =
            By.xpath("//table[contains(@class,'table-hover')]/tbody/tr[1]");

    // Spinner / loading indicator — wait for this to disappear after actions
    public By loadingSpinner =
            By.xpath("//*[contains(@class,'loading') or contains(@class,'spinner')]");
}