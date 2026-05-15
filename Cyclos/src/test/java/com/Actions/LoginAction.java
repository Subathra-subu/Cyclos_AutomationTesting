package com.Actions;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.StepDefinitions.Hooks;
import com.Utilities.ConfigureClass;

public class LoginAction extends BaseAction{
	
	public void sendUserName(String name) {
		
		try {
			sendKeys(loginPage.userName,name);
		}
		catch(Exception e){
			Hooks.logger.error("Unable to enter username", e);
		}
	}
	
	public void sendPassword(String password) {
		
		try {
			sendKeys(loginPage.password,password);
		}
		catch(Exception e){
			Hooks.logger.error("Unable to enter password", e);
		}
	}
		
	
	public void clickLoginLink() {
		
		try {
			click(loginPage.loginLink);
		}
		catch(Exception e) {
			Hooks.logger.error("Unable to click the link", e);
		}
	
	}
	
	public void entervaliduserNameAndPassword() {
		
		try {
			sendUserName(ConfigureClass.getUsername());
			sendPassword(ConfigureClass.getPassword());
		}
		catch(Exception e){
			Hooks.logger.error("Unable to enter username and password",e);
		}
		
	}
	
	public void clickSubmitButton() {
		
		try {
			click(loginPage.loginButton);
		}
		catch(Exception e) {
			Hooks.logger.error("Unable to click the link", e);
		}
	}
	
	public void enterinvalidUsernameandPassword(String name,String password) {
		
		sendUserName(name);
		sendPassword(password);
	}
	
	public void assertAlertMessage() {
		
		String actual = getText(loginPage.alertMessage);
		
		String expected = "The given name / password are incorrect. Please, try again.";

		Assert.assertEquals(actual,expected);
		
	}
	
	public boolean assertRequiredMessage(By locator) {
		
		String actual = getText(locator);
		
		String expected = "This field is required";
		
		return actual.equals(expected);
		
	}
	
	public void assertUsernameRequired() {
		
		boolean actual = assertRequiredMessage(loginPage.userRequiredMessage);
		
		Assert.assertEquals(actual,true);
		
	}
	
	public void assertPasswordRequired() {
		
		boolean actual = assertRequiredMessage(loginPage.passwordRequiredMessage);
		
		Assert.assertEquals(actual,true);
		
	}
	
	public void enterBlankUserName() {
		
	}
	
	public void enterBlankPassword() {
		
	}
	
	

}
