package com.Pages;

import org.openqa.selenium.By;

public class PaymentToUserPage {
	
    public By nextBtn = By.xpath("//button[@class='btn d-flex justify-content-center align-items-center w-100 h-100 btn-primary']");
    public By payuser = By.xpath("//a[@href='/banking/self/payment']//div[@class='quick-access-icon']");
    public By userfield = By.cssSelector("input[placeholder='Type to search']");
    public By errormsg = By.xpath("//user-field[@class='form-field ng-pristine ng-invalid ng-touched']//div[@class='invalid-feedback'][normalize-space()='This field is required']");
    public By amountField = By.xpath("//input[@type='tel']");
    public By paymentConfirmationTitle =By.xpath("//div[@class='title-text flex-grow-1 d-flex align-items-center']"); 
    public By limitExceededMsg = By.xpath("//div[@class=\"invalid-feedback\"]");
    public By schedulingType = By.xpath("//div[@class='w-100 mw-100 text-truncate pr-3']");
    public By futureDate = By.xpath("//input[@type='date']");
    public By descriptionField =  By.xpath("//textarea");
    public By dropdown = By.xpath("//button[contains(@class,'form-control')]");

    public By scheduledOption =By.xpath("//a[normalize-space()='Scheduled']");

    public By payNowOption =By.xpath("//a[normalize-space()='Pay now']");

    public By monthlyInstallmentOption =By.xpath("//a[normalize-space()='Monthly installments']");

    public By recurringPaymentOption =By.xpath("//a[normalize-space()='Recurring payments']");
    public By numberOfInstallments =By.xpath("//input[ @type=\"number\"]");
    }