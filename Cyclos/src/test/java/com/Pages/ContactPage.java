package com.Pages;

import org.openqa.selenium.By;

public class ContactPage 

{
  
	public By DemoUser = By.xpath("//div[text()=\"  Demo user \"]/parent::a");
	
	public By contact = By.xpath("//div[text()=\"Contacts\"]");

	public By AddNew = By.xpath("//div[text()=\"Add new\"]/parent::button");
	
	public By ContactName = By.xpath("//input[contains(@placeholder , \"Type\")]");
	
	public By submit = By.xpath("//span[text()=\"Submit\"]");
	
	public By successMessage = By.xpath("//h1/following::div[contains(text(),\"required\")]");
	
	public By contactListViewButton = By.xpath("//div/following::label[2]");
	
	public By userAssert = By.xpath("//th[text()=\"User\"]");
	
}
