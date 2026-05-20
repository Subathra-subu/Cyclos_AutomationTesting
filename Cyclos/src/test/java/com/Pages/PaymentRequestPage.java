package com.Pages;

import org.openqa.selenium.By;

public class PaymentRequestPage {
    public By Banking = By.xpath("//div[@class='menu-text'][normalize-space()='Banking']");
    public By paymentrequest = By.xpath("//div[text()='Payment requests']");
    public By sendrequest = By.xpath("//div[normalize-space()='Send a new request']");
    
    // Form Inputs
    public By user = By.cssSelector("input[placeholder='Type to search']");
    public By option = By.cssSelector("a[class='select-option autocomplete-option-0']");
    public By amount = By.xpath("//input[@type='tel']");
    public By date = By.cssSelector("input[type='date']");
    public By scheduling = By.xpath("//button[contains(@aria-controls,'dropdown-menu')]"); // Adjusted based on dropdown patterns
    public By description = By.xpath("//textarea | //input[contains(@class, 'description')]"); // Based on standard UI textareas

    // Buttons & Popups
    public By confirm = By.xpath("//span[normalize-space()='Confirm']");
    public By modalConfirm = By.xpath("//div[contains(@class, 'modal')]//span[normalize-space()='Confirm'] | //button[contains(.,'Confirm')]");
    public By modalText = By.xpath("//div[contains(text(), 'Are you sure')]");
    public By successBanner = By.xpath("//*[contains(text(),'was successfully sent')]");
    public By requiredMessage = By.xpath("//div[contains(text(),'This field is required')]");
    
    // View Details elements
    public By print = By.xpath("//div[contains(text(),'Print')]");
    public By cancel = By.xpath("//div[contains(text(),'Cancel this payment request')]");
    public By existingUser = By.xpath("//tbody//tr[1]");
    public By paypageAssert = By.xpath("//div[text()=' Payment request details ']");
    public By dateValidationError = By.xpath("//div[@class='invalid-feedback']");
}
