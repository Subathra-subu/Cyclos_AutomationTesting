package com.Pages;

import org.openqa.selenium.By;

public class PaymentRequestPage {

    // Navigation
    public By Banking = By.xpath("//div[@class='menu-text'][normalize-space()='Banking']");
    public By paymentrequest = By.xpath("//div[text()='Payment requests']");
    public By sendrequest = By.xpath("//div[normalize-space()='Send a new request']");

    // Receiver Selection
    public By user = By.cssSelector("input[placeholder='Type to search']");
    public By option = By.cssSelector("a[class='select-option autocomplete-option-0']");

    // Contact Selection
    public By contact = By.xpath("//div[@class='d-flex']//button[@type='button']");
    public By contactname = By.xpath("//div[@class='mb-2']/a[text()=' Active Walking ']");

    // Form Inputs
    public By amount = By.xpath("//input[@type='tel']");
    public By date = By.cssSelector("input[type='date']");
    public By description = By.xpath("//textarea | //input[contains(@class,'description')]");

    // Scheduling
    public By scheduling = By.xpath("//button[contains(@aria-controls,'dropdown-menu')]");

    // Monthly Installments
    public By monthlyInstallment = By.xpath("//div[@role='listbox']/a[text()=' Monthly installments ']");

    // Installment Count
    public By installmentCount = By.xpath("//input[@type='number']");

    // Buttons
    public By confirm = By.xpath("//span[normalize-space()='Confirm']");
    public By modalConfirm =
            By.xpath("//modal-container[contains(@class,'show')]//button[contains(@class,'btn-primary')]");
    // Popup
    public By modalText = By.xpath("//div[contains(text(),'Are you sure')]");

    // Success Message
    public By successBanner = By.xpath("//*[contains(text(),'was successfully sent')]");

    // Validation
    public By requiredMessage = By.xpath("//div[contains(text(),'This field is required')]");
    public By dateValidationError = By.xpath("//div[@class='invalid-feedback']");

    // Existing Request
    public By existingUser = By.xpath("//tbody//tr[1]");
    public By paypageAssert = By.xpath("//div[text()=' Payment request details ']");

    // Print / Cancel
    public By print = By.xpath("//div[contains(text(),'Print')]");
    public By cancel = By.xpath("//div[contains(text(),'Cancel this payment request')]");

}