package com.Pages;

import org.openqa.selenium.By;

public class MessagesPage {

	public By messageIcon = By.xpath("//a[@id='messages-link']//icon-with-counter//icon//*[name()='svg']//*[name()='path' and contains(@d,'M0 4a2 2 0')]");

	public By newMessageLink = By.xpath("//div[contains(text(),'New message')]");

	public By recipientField = By.xpath("//button[@class='form-control text-left custom-select w-100']");
	
	public By userField =By.xpath("//div[@class='dropdown-menu show']/child::a[1]");
	
	public By user = By.xpath("//input[@placeholder='Type to search']");

	public By subjectField = By.xpath("//input[@class='form-control w-100 ng-pristine ng-invalid ng-touched']");

	public By sendButton = By.xpath("//button[@class='btn d-flex justify-content-center align-items-center w-100 h-100 btn-primary']");

	public By successPopup = By.xpath("//snack-bar[normalize-space()='The message was successfully sent']");
}