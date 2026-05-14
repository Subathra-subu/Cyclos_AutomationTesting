package com.Pages;

import org.openqa.selenium.By;

public class LoginPage {
	
	public By loginLink = By.xpath("//div[text()=' Login ']");
	
	public By userName = By.xpath("//input[@placeholder='User']");
	public By password = By.xpath("//input[@placeholder='Password']");
	
	public By loginButton = By.xpath("//span[text()='Submit']");

}
