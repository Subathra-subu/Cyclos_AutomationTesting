package com.Pages;

import org.openqa.selenium.By;

public class TickesPage extends BasePage {

    // BANKING MENU
    public By bankingMenu =
            By.xpath("//a[@id='menu_banking']");

    // TICKETS MENU — inside the Banking sidebar sub-menu
    public By ticketsMenu =
            By.xpath("//span[text()='Tickets']");

    // STATUS BUTTON
    public By statusBtn =
            By.xpath("//label[contains(text(),'Status')]/following::button[1]");

    // PRINT BUTTON
    public By print =
            By.xpath("//button[contains(.,'Print')]");
}