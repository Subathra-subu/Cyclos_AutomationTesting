package com.Pages;

import org.openqa.selenium.By;

public class RegisterPage {
	
	public By registerLink = By.xpath("//div[text()=' Register ']");
	public By upload = By.xpath("//span[text()='Upload a new image']");
	public By name = By.xpath("(//input[@type='text'])[1]");
	public By loginName = By.xpath("(//input[@type='text'])[2]");
	public By email = By.xpath("(//input[@type='text'])[3]");
	public By website = By.xpath("//input[@id='website']");
	public By gender = By.xpath("//label[text()=' Female ']");
	public By businessTypeButton = By.xpath("//button[@id='business_type']");
	public By businessType = By.xpath("//a[@id='business_type_restaurants']");
	public By mobile = By.xpath("(//input[@placeholder=\"(201) 555-0123\"])[1]");
	public By landLine = By.xpath("(//input[@placeholder=\"(201) 555-0123\"])[2]");
	public By define_Address = By.xpath("(//label[@class='custom-control-label'])[3]");
	public By address = By.xpath("//input[@id='addressLine1']");
	public By zipCode = By.xpath("//input[@id='zip']");
	public By city = By.xpath("//input[@id='city']");
	public By region = By.xpath("//input[@id='region']");
	public By next = By.xpath("//span[text()='Next']");
	
	public By new_password = By.xpath("(//input[@type='password'])[1]");
	public By confirm_password = By.xpath("(//input[@type='password'])[2]");
	
	public By agreement = By.cssSelector(".custom-control-label");
	
	public By recaptcha = By.xpath("//div[@class='recaptcha-checkbox-border']");
	
	public By submit = By.xpath("//span[text()='Submit']");
	
	public By registration = By.xpath("//div[text()=' Registration successful ']");
	
	public By existMessage = By.xpath("//div[contains(text(),'Login name must be unique.')]");
	
	public By requiredMessage_name = By.xpath("(//div[@class='d-flex label-value-value']/descendant::div)[1]");
	
	public By requiredMessage_login = By.xpath("(//div[@class='d-flex label-value-value']/descendant::div)[2]");
	
	public By requiredMessage_email = By.xpath("(//div[@class='d-flex label-value-value']/descendant::div)[3]");

}
