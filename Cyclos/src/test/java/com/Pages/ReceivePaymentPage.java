package com.Pages;

import org.openqa.selenium.By;

public class ReceivePaymentPage {

    public By bankingLink = By.xpath("//div[contains(@class,'menu-text') and contains(normalize-space(),'Banking')]");
    public By receivePaymentLink = By.xpath("//*[contains(normalize-space(),'Receive payment')]");
    public By user = By.xpath("(//input[contains(@class,'form-control')])[1]");
    public By userClick = By.xpath("(//a[contains(@class,'select-option')])[1]");
    public By amount = By.xpath("(//input[@type='tel' or @type='text'])[last()]");
    public By description = By.xpath("//textarea");
    public By next = By.xpath("//button[contains(@class,'btn-primary')]");
    public By confirmationpass = By.xpath("//input[contains(@placeholder,'Password')]");
    public By confirm = By.xpath("//*[normalize-space()='Confirm']");
    public By paymentconfirmation = By.xpath("//div[contains(@class,'title-text')]");
    public By success = By.xpath("//*[contains(text(),'successfully processed')]");
    public By positiveNumberError = By.xpath("//div[contains(@class,'invalid-feedback')]");
    public By requiredFieldError = By.xpath("//*[contains(text(),'This field is required')]");

}