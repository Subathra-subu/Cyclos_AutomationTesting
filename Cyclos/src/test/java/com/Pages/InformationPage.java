package com.Pages;

import org.openqa.selenium.By;

public class InformationPage {

	public By informationMenu = By.xpath("//div[text()='Information']/parent::a");

	public By contactForm = By.xpath("//div[text()='Contact form']");

	// Iframe containing the WordPress Contact Form 7
	public By contactFormIframe = By.id("iframe_0");

	// Form fields (inside iframe)
	public By questionTypeDropdown = By.name("your-recipient");
	public By fromField = By.name("your-name");
	public By emailField = By.name("your-email");
	public By subjectField = By.name("your-subject");
	public By messageField = By.name("your-message");

	// CAPTCHA
	public By captchaChallenge = By.name("_wpcf7_captcha_challenge_captcha-contact");
	public By captchaField = By.name("captcha-contact");

	// Submit button
	public By submitButton = By.xpath("//input[@type='submit' and @value='Send']");

	// Response messages
	public By successMessage = By.cssSelector(".wpcf7-response-output.wpcf7-mail-sent-ok");
	public By validationError = By.cssSelector(".wpcf7-response-output.wpcf7-validation-errors");
	public By spamBlocked = By.cssSelector(".wpcf7-response-output.wpcf7-spam-blocked");

}
