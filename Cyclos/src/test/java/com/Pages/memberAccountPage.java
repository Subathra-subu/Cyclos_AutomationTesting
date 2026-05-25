package com.Pages;

import org.openqa.selenium.By;

public class memberAccountPage

{

	public By memberAccountLink = By.xpath("//div[text()=\"Member account\"]");

	public By downloadBtn = By.xpath("//div[text()=\"Download\"]/parent::button");

	public By bankingMenu = By.xpath("//a[@id='menu_banking']");
	
	public By pdfOption = By.xpath("//div[text()=\"PDF\"]/parent::button");

}
