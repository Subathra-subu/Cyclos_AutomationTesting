package com.Pages;

import org.openqa.selenium.By;

import com.Actions.BaseAction;

public class ReceivePaymentPage extends BaseAction {

    By bankingLink = By.xpath("//div[@class='menu-text'][normalize-space()='Banking']");
    By receivePaymentLink = By.xpath("//div[normalize-space()='Receive payment']");
    By user = By.xpath("//input[@placeholder='Type to search']");
    By userClick = By.xpath("//a[@class='select-option autocomplete-option-0']");
    By amount = By.xpath("//input[contains(@id,'id_')]");
    By description = By.xpath("//textarea");
    By next = By.xpath("//button[@class='btn d-flex justify-content-center align-items-center w-100 h-100 btn-primary']");
    By confirmationpass = By.xpath("//input[@placeholder='Type here: Password']");
    By confirm = By.xpath("//span[normalize-space()='Confirm']");
    By success = By.linkText("The payment was successfully processed");
    
    public void clickingLinks() {
    	click(bankingLink);
    	click(receivePaymentLink);
    }
    public void enterDetails(String userName, String amountToUser, String descriptiontothefield) {
    	type(user, userName);
    	click(userClick);
    	type(amount, amountToUser);
    	type(description, descriptiontothefield);
    	click(next);
    }
    public void submit(String confirmpass) {
//    	type(confirmationpass, confirmpass);
    	click(confirm);
    }
//    public boolean isPaymentSuccessful() {
//        return isDisplayed(success);
//    }
}