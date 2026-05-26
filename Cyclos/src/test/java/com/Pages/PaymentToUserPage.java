package com.Pages;

import org.openqa.selenium.By;

public class PaymentToUserPage {


	
	public By nextBtn = By.xpath("//button[.//span[contains(text(),'Next')] or contains(.,'Next')]");

	public By payuser = By.xpath("//div[contains(@class,'quick-access-icon')]/parent::a[contains(@href,'payment')]");

	public By userfield = By.xpath("//label[contains(.,'To user')]/following-sibling::div//input");

	public By errormsg = By.xpath("//div[contains(@class,'invalid-feedback') and contains(text(),'This field is required')]");

	public By amountField = By.xpath("//label[contains(.,'Amount')]/following-sibling::div//input");

	public By paymentConfirmationTitle = By.xpath("//div[contains(@class,'title-text')]/ancestor::div[contains(@class,'card')]");

	public By validateMessage = By.xpath("//div[contains(@class,'invalid-feedback')]");

	

	public By futureDate = By.xpath("//input[@type='date']");

	public By descriptionField = By.xpath("//label[contains(.,'Description')]/following-sibling::div//textarea");

	public By dropdown = By.xpath("//button[contains(@class,'form-control')]");

	public By scheduledOption = By.xpath("//button[contains(@class,'form-control')]/following-sibling::div//a[contains(.,'Scheduled')]");

	public By payNowOption = By.xpath("//button[contains(@class,'form-control')]/following-sibling::div//a[contains(.,'Pay now')]");

	public By monthlyInstallmentOption = By.xpath("//button[contains(@class,'form-control')]/following-sibling::div//a[contains(.,'Monthly installments')]");

	public By recurringPaymentOption = By.xpath("//button[contains(@class,'form-control')]/following-sibling::div//a[contains(.,'Recurring payments')]");


	public By numberOfInstallments = By.xpath("//label[contains(.,'installments')]/following-sibling::div//input");
}

