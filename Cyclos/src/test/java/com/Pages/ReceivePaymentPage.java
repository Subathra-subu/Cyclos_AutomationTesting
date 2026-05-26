package com.Pages;

import org.openqa.selenium.By;

public class ReceivePaymentPage {

    public By bankingLink =
            By.xpath("//div[normalize-space()='Banking']/ancestor::a");

    public By receivePaymentLink =
            By.xpath("//div[normalize-space()='Receive payment']/ancestor::a");

    public By user =
            By.xpath("//input[@placeholder='Type to search']");

    public By userClick =
            By.xpath("(//a[contains(@class,'autocomplete-option')])[1]");

    public By amount =
            By.xpath("//input[contains(@id,'id_') and @type='tel']");

    public By description =
            By.xpath("//textarea[@placeholder or @formcontrolname='description']");

    public By next =
            By.xpath("//button[.//span[normalize-space()='Next'] or normalize-space()='Next']");

    public By confirmationpass =
            By.xpath("//input[contains(@placeholder,'Password')]");

    public By confirm =
            By.xpath("//button[.//span[normalize-space()='Confirm']]");

    public By paymentconfirmation =
            By.xpath("//div[contains(@class,'title-text') and contains(.,'Payment')]");

    public By success =
            By.xpath("//*[contains(text(),'successfully processed')]");

    public By positiveNumberError =
            By.xpath("//*[contains(@class,'invalid-feedback') and contains(text(),'positive')]");

    public By requiredFieldError =
            By.xpath("//*[contains(@class,'invalid-feedback') and normalize-space()='This field is required']");

    public By exceededLimit =
            By.xpath("//*[contains(text(),'maximum of payments per day')]");
}