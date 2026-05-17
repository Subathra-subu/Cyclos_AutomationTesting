package com.Pages;

import org.openqa.selenium.By;

public class ReceivePaymentPage {

    public By bankingLink = By.xpath("//div[@class='menu-text'][normalize-space()='Banking']");
    public By receivePaymentLink = By.xpath("//div[normalize-space()='Receive payment']");
    public By user = By.xpath("//input[@placeholder='Type to search']");
    public By userClick = By.xpath("//a[@class='select-option autocomplete-option-0']");
    public By amount = By.xpath("//input[contains(@id,'id_')]");
    public By description = By.xpath("//textarea");
    public By next = By.xpath("//button[@class='btn d-flex justify-content-center align-items-center w-100 h-100 btn-primary']");
    public By confirmationpass = By.xpath("//input[@placeholder='Type here: Password']");
    public By confirm = By.xpath("//span[normalize-space()='Confirm']");
    public By paymentconfirmation = By.xpath("//div[@class='title-text flex-grow-1 d-flex align-items-center']");
    public By success = By.linkText("The payment was successfully processed");    
    public By positiveNumberError = By.xpath("//div[@class='invalid-feedback']");    
    public By requiredFieldError = By.xpath("//user-field[@class='form-field ng-pristine ng-invalid ng-touched']//div[@class='invalid-feedback'][normalize-space()='This field is required']");
    public By exceededLimit =
            By.xpath("//*[contains(text(),'You have exceeded the maximum of payments per day')]");

    
}