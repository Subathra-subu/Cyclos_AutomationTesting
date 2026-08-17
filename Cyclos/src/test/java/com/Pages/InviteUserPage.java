package com.Pages;
//iviteuser
import org.openqa.selenium.By;

public class InviteUserPage {

    public By marketPlace = By.xpath("//div[contains(text(),'Marketplace')][@class='menu-text']");
    public By inviteUsers = By.xpath("//div[text()='Invite users']");
    public By sendInvitationButton = By.xpath("//action-button[@class='d-inline-block button']/child::button");
    public By successMessage = By.xpath("//ui-root[@class='flex-grow-1 d-flex root']/child::snack-bar");
    public By validationMessage = By.xpath("//div[@class='notification-message']");
    

    public By emailtextbox = By.xpath("(//div[@class='input-fields']//input)[1]");



}