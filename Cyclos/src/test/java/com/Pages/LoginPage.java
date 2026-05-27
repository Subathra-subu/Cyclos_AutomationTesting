package com.Pages;
//login page
import org.openqa.selenium.By;


public class LoginPage {
	
	public By loginLink = By.xpath("//div[text()=' Login ']/parent::a");
	
	public By userName = By.xpath("//input[@placeholder='User']");
	public By password = By.xpath("//input[@placeholder='Password']");
	
	public By loginButton = By.xpath("//span[text()='Submit']");
	
	public By alertMessage = By.xpath("//div[text()='The given name / password are incorrect. Please, try again.']");
	
	public By userRequiredMessage = By.xpath("//div[contains(text(),'This field is required')]");
	
	public By passwordRequiredMessage = By.xpath("//div[contains(text(),'This field is required')]");
	
	

}