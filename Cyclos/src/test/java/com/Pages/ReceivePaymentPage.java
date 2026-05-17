package com.Pages;

import org.openqa.selenium.By;

public class ReceivePaymentPage {

    public By bankingLink =
            By.xpath("//div[contains(@class,'menu-text') and contains(normalize-space(),'Banking')]");

    public By receivePaymentLink =
            By.xpath("//*[contains(normalize-space(),'Receive payment')]");

    public By user =
            By.xpath("//input[contains(@placeholder,'search') or contains(@class,'autocomplete')]");
    
    public By userClick =
            By.xpath("//*[contains(@class,'autocomplete-option')]");

    public By amount =
            By.xpath("//input[@type='tel' or @type='number']");

    public By description =
            By.xpath("//textarea");

    public By next =
            By.xpath("//button[contains(.,'Next') or contains(.,'Submit')]");

    public By confirmationpass =
            By.xpath("//input[contains(@placeholder,'Password') or @type='password']");

    public By confirm =
            By.xpath("//span[contains(normalize-space(),'Confirm')]");

    public By paymentconfirmation =
            By.xpath("//*[contains(text(),'successfully processed')]");

    public By success =
            By.xpath("//*[contains(text(),'successfully processed')]");

    public By positiveNumberError =
            By.xpath("//*[contains(text(),'positive')]");

    public By requiredFieldError =
            By.xpath("//*[contains(text(),'required')]");
}