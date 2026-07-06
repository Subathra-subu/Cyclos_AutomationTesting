package com.Pages;

import org.openqa.selenium.By;

public class MessagesPage {

	public By messageIcon = By.xpath("//a[@id='messages-link']");

	public By newMessageLink = By.xpath("//div[contains(text(),'New message')]");

	public By recipientField = By.xpath("//button[@class='form-control text-left custom-select w-100']");
	
	public By userField =By.xpath("//div[@class='dropdown-menu show']/child::a[1]");
	
//	public By user = By.xpath("//input[@placeholder='Type to search']");
	
	public By user = By.xpath("//button[@class='btn btn-icon ml-2']");
	
	public By user_name = By.xpath("//a[normalize-space()='Active Walking']");

	public By subjectField = By.xpath("//input[contains(@class,'form-control') and contains(@class,'w-100')]");
	
	public By textField = By.xpath("//div[@class='editor']");

	public By sendButton = By.xpath("//button[@class='btn d-flex justify-content-center align-items-center w-100 h-100 btn-primary']");

	public By successPopup = By.xpath("//snack-bar[normalize-space()='The message was successfully sent']");
	
	public By inboxTab = By.xpath("//label[text()=' Inbox ']");

	public By sentTab = By.xpath("//label[text()=' Sent ']");

	public By trashTab = By.xpath("//label[text()=' Trash ']");

//	//div[@class='page-content card d-flex flex-grow-1 layout-normal last mode-normal']
	
	public By activeInboxTab = By.xpath("//a[contains(@class,'active') and contains(.,'Inbox')]");

	public By activeSentTab = By.xpath("(//div[@class='page-content-body card-body d-flex flex-column'])[2]/descendant::th[2]");

	public By activeTrashTab = By.xpath("(//div[@class='page-content-body card-body d-flex flex-column'])[2]/descendant::th[2]");
}