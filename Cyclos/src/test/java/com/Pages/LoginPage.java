package com.Pages;
//login page
import org.openqa.selenium.By;


public class LoginPage {
	
	public By loginLink = By.xpath("//div[text()=' Login ']");
	
	public By userName = By.xpath("//input[@placeholder='User']");
	public By password = By.xpath("//input[@placeholder='Password']");
	
	public By loginButton = By.xpath("//span[text()='Submit']");
	
	public By alertMessage = By.xpath("//div[text()='The given name / password are incorrect. Please, try again.']");
	
	public By userRequiredMessage = By.xpath("//div[@class='input-group login-margin-bottom']/following-sibling::*");
	
	public By passwordRequiredMessage = By.xpath("//div[@class='input-group']/following-sibling::*");

}