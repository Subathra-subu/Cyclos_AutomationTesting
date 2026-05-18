package com.Pages;

import org.openqa.selenium.By;

public class TickesPage  {

	public By bankingMenu = By.xpath("//a[@id='menu_banking']");

	public By ticketsMenu = By.xpath("//div[text()=\"Tickets\"]/parent::a");

	public By statusBtn = By.xpath("//button[contains(@class,'form-control')]");

	public By print = By.xpath("//div[text()=\"Print\"]/parent::button");

	public By transactionStatus = By.xpath("(//div[contains(@class,'label-value-value')])[1]");

	public By noResultsMessage = By.xpath("//div[contains(text(),'No results match the search criteria')]");

	public By firstRow = By.xpath("//table[contains(@class,'table-hover')]/tbody/tr[1]");

	public By loadingSpinner = By.xpath("//*[contains(@class,'loading') or contains(@class,'spinner')]");

	public By filter = By.xpath("//div[text()='Show more filters']/parent::button");

	public By filterStatusBtn = By.xpath("//button[@title='Open']");

	public By clickOpen = By.xpath("//a[text()=\" Open \"]");

	public By asserOpen = By.xpath("//tbody/tr[1]/td[3]");

}