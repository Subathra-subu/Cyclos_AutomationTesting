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

	public By emailErrorMessage = By
			.xpath("//div[contains(@class,'invalid-feedback') and contains(text(),'This field is required')]");
}