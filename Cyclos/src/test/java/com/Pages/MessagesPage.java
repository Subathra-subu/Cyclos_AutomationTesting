package com.Pages;

import org.openqa.selenium.By;

public class MessagesPage {

    public By messageIcon =
            By.xpath("//a[contains(@href,'messages') or contains(@class,'message')]");

    public By newMessageLink =
            By.xpath("//*[contains(text(),'New message')]");

    public By recipientField =
            By.xpath("//input[@placeholder='Type a name']");
    
    

    public By subjectField =
            By.xpath("//input[@type='text']");


    public By sendButton =
            By.xpath("//span[text()='Send']/parent::button");

    public By successPopup =
            By.xpath("//*[contains(text(),'The email was sent')]");
}