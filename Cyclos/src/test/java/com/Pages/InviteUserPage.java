package com.Pages;
import org.openqa.selenium.By;

<<<<<<< HEAD
import com.Actions.BaseAction;



public class InviteUserPage extends BaseAction {

    By loginButton = By.xpath("//*[@id=\"login-link\"]/div");

    By usernameTextBox = By.xpath("//input[@placeholder='User']");

    By passwordTextBox = By.xpath("//input[@placeholder='Password']");

    By submitButton = By.xpath("//span[text()='Submit']");
    
    By MarketPlace =By.xpath("//div[@class='menu-text'][normalize-space()='Marketplace']");
    
    By inviteusers = By.xpath("//div[text()='Invite users']");

    By emailTextBox = By.xpath("//input[@type='text' or @type='email']");

    By sendInvitationButton = By.xpath("//span[normalize-space()='Send']");

    By successMessage = By.xpath("//*[contains(text(),'Invitation sent')]");

    By validationMessage = By.xpath("//*[contains(text(),'invalid') or contains(text(),'email')]");

    public void loginApplication(String username, String password) {

        click(loginButton);

        sendKeys(usernameTextBox, username);

        sendKeys(passwordTextBox, password);

        click(submitButton);
    }

    public void navigateToInvitePage() {

        click(MarketPlace);
        click(inviteusers);
		
    }

    public void enterEmail(String email) {

    	sendKeys(emailTextBox, email);
    }

    public void clickSendInvitation() {

        click(sendInvitationButton);
    }

    public boolean verifySuccessMessage() {

        return isDisplayed(successMessage);
    }

    public boolean verifyValidationMessage() {

        return isDisplayed(validationMessage);
    }
public class InviteUserPage {

    public By marketPlace = By.xpath("//div[@class='menu-text'][normalize-space()='Marketplace']");
    public By inviteUsers = By.xpath("//div[text()='Invite users']");
    public By emailTextBox = By.xpath("//div[contains(@class,'input-fields')]//input[@type='text']");
    public By sendInvitationButton = By.xpath("//span[normalize-space()='Send']");
    public By successMessage = By.xpath("//snack-bar[contains(text(),'invitation') or contains(text(),'sent')]");
    public By validationMessage = By.xpath("//*[contains(text(),'invalid') or contains(text(),'email')]");
}