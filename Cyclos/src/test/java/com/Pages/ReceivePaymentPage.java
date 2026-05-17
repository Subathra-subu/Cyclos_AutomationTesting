package com.Pages;

import org.openqa.selenium.By;

public class ReceivePaymentPage {

    public By bankingLink =
            By.xpath("//div[contains(@class,'menu-text') and contains(.,'Banking')]");

    public By receivePaymentLink =
            By.xpath("//a[contains(@href,'receive')]");

    public By user =
            By.xpath("//input[@type='text']");

    public By userClick =
            By.xpath("(//*[contains(@class,'autocomplete-option')])[1]");

    public By amount =
            By.xpath("//input[contains(@type,'tel') or contains(@class,'amount')]");

    public By description =
            By.xpath("//textarea");

    public By next =
            By.xpath("//button[contains(.,'Next') or contains(.,'Submit')]");

    public By confirmationpass =
            By.xpath("//input[@type='password']");

    public By confirm =
            By.xpath("//*[contains(text(),'Confirm')]");

    public By paymentconfirmation =
            By.xpath("//*[contains(text(),'successfully processed')]");

    public By success =
            By.xpath("//*[contains(text(),'successfully processed')]");

    public By positiveNumberError =
            By.xpath("//*[contains(text(),'positive')]");

    public By requiredFieldError =
            By.xpath("//*[contains(text(),'required')]");
}