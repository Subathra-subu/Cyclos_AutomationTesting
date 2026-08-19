package com.Pages;

import org.openqa.selenium.By;

public class referencePage 

{
	
	public By personalMenu = By.xpath("//div[text()=\"  Demo user \"]");
	public By referenceMenu = By.xpath("//div[text()='Notifications']/following::div[text()='References']");
	public By receivedReference = By.xpath("//label[normalize-space()='Received']");
	public By deleteButton = By.xpath("//table//*[local-name()='svg' and contains(@class,'bi-trash')]/ancestor::button[1]");
	public By confirmDelete = By.xpath("//*[self::button or self::a or self::span][contains(translate(.,'DELETE','delete'),'delete') or contains(translate(.,'REMOVE','remove'),'remove') or contains(translate(.,'YES','yes'),'yes') or contains(translate(.,'CONFIRM','confirm'),'confirm')]");
	public By successMessage = By.xpath("//snack-bar");

}
