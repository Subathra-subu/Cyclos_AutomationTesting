package com.Pages;

import org.openqa.selenium.By;

public class PayExternalUserPage {

	public By payUser = By.xpath("//div[@class='menu-text'][normalize-space()='Banking']");

	public By externalPayments = By.xpath("//div[@class='root-container']//a[8]");

	public By payExternalUser = By.xpath("//div[normalize-space()='Pay external user']");

	public By emailField = By.xpath("//label[contains(.,'E-mail')]/following-sibling::div//input");

	public By amountField = By.xpath("//label[contains(.,'Amount')]/following-sibling::div//input");

	public By descriptionField = By.xpath("//label[contains(.,'Description')]/following-sibling::div//textarea");

	public By nextBtn = By.xpath("//button[.//span[contains(text(),'Next')] or contains(.,'Next')]");

	public By confirmBtn = By.xpath("//button[.//span[contains(text(),'Confirm')] or contains(.,'Confirm')]");

	public By paymentConfirmationTitle = By.xpath("//div[contains(text(),'Payment confirmation')]");

	public By successMessage = By.xpath("//div[contains(text(),'The external payment was successfully performed')]");

	public By pendingStatus = By.xpath("//div[contains(text(),'Pending')]");

	public By emailErrorMessage = By.xpath("//div[contains(@class,'invalid-feedback') and contains(text(),'This field is required')]");
	
	public By paymentRow = By.xpath("//div[contains(text(),'Cancel Test')]");

	public By cancelPaymentBtn = By.xpath("//button[contains(.,'Cancel this external payment')]");

	public By cancellationComment = By.xpath("//textarea");

	public By confirmCancelBtn =By.xpath("//button[.//span[contains(text(),'Confirm')] or contains(.,'Confirm')]");

	public By cancelledMessage =By.xpath("//*[contains(text(),'cancelled') or contains(text(),'canceled')]");
	
	public By payment(String description) {
	    return By.xpath("//div[contains(text(),'" + description + "')]");
	}
	public By invalidEmailErrorMessage = By.xpath("//div[contains(@class,'invalid-feedback') and contains(text(),'Destination user identifier is invalid.')]");
	
	public By amountErrorMessage = By.xpath("//label[contains(.,'Amount')]/following-sibling::div//div[contains(@class,'invalid-feedback')]");
}