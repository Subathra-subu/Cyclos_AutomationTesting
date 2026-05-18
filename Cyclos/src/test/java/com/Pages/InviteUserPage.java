package com.Pages;
//
import org.openqa.selenium.By;

public class InviteUserPage {

    public By marketPlace = By.xpath("//div[@class='menu-text'][normalize-space()='Marketplace']");
    public By inviteUsers = By.xpath("//div[text()='Invite users']");
    public By emailTextBox = By.xpath("//div[contains(@class,'input-fields')]//input[@type='text']");
    public By sendInvitationButton = By.xpath("//span[normalize-space()='Send']");
    public By successMessage = By.xpath("//snack-bar[contains(text(),'invitation') or contains(text(),'sent')]");
    public By validationMessage = By.xpath("//*[contains(text(),'invalid') or contains(text(),'email')]");
}