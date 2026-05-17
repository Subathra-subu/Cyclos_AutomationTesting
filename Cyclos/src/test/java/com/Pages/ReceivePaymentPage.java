package com.Pages;

import org.openqa.selenium.By;

public class ReceivePaymentPage {

    public By bankingLink = By.xpath("//div[contains(@class,'menu-text') and contains(.,'Banking')]");
    public By receivePaymentLink = By.xpath("//div[contains(@class,'menu-text') and normalize-space()='Receive payment']");
    public By user = By.xpath("//input[@placeholder='Type to search']");
    public By userClick = By.xpath("//a[contains(@class,'select-option')]");
    public By amount = By.xpath("//input[@type='tel']");
    public By description = By.xpath("//textarea");
    public By next = By.xpath("//button[contains(@class,'btn-primary')]");
    public By confirmationpass = By.xpath("//input[@placeholder='Type here: Password']");
    public By confirm = By.xpath("//span[normalize-space()='Confirm']");
    public By paymentconfirmation = By.xpath("//*[contains(text(),'Payment')]");
    public By success = By.linkText("The payment was successfully processed");
    public By positiveNumberError = By.xpath("//*[contains(text(),'positive')]");
    public By requiredFieldError = By.xpath("//*[normalize-space()='This field is required']");
}