package com.Pages;

import org.openqa.selenium.By;

public class TickesPage extends BasePage {

   
    public By bankingMenu =
            By.xpath("//a[@id='menu_banking']");

    
    public By ticketsMenu =
            By.xpath("//div[text()=\"Tickets\"]/parent::a");

    
    public By statusBtn =
            By.xpath("//button[contains(@class,'form-control')]");
    
    public By print =
            By.xpath("//div[text()=\"Print\"]/parent::button");
    
    public By transactionStatus =
            By.xpath("(//div[contains(@class,'label-value-value')])[1]");
    
    public By noResultsMessage =
            By.xpath("//div[text()='No results match the search criteria']");
    
    public By firstRow = By.xpath("//table[@class=\"table table-hover cursor-pointer\"]/tbody/tr[1]");
}