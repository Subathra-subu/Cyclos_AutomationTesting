package com.Pages;

import org.openqa.selenium.By;

public class systempaymentpage {

	public By paymenttosystem =  By.xpath("//div[normalize-space()='Payment to system']");
	public	By amountfield = By.xpath("//div[@class='input-group']/descendant::input");
	public By nextbutton = By.xpath("//action-button[@class='d-inline-block button']/child::button");
	public By confirmbutton = By.xpath("//span[text()='Confirm']/parent::button");
	public By msg = By.xpath("//div[@class='notification-message']/child::div");
	public By Banking = By.cssSelector("a[id='menu_banking'] ");
	public By validationErrorMsg= By.xpath("//field-errors/child::div");
	public By listbox = By.xpath("//div[@class='w-100']/child::button");
	public By scheduled = By.xpath("//a[text()=' Scheduled ']");
	public By datepicker = By.xpath("//input[@type='date']");
	
}
