package com.Actions;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.Pages.LoginPage;
import com.StepDefinitions.Hooks;
import com.Utilities.ConfigureClass;


public class LoginAction extends BaseAction{
	
	LoginPage loginPage = new LoginPage();
	
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
		
		try {
			sendUserName(name);
			sendPassword(password);
		} 
		catch (Exception e) {
			Hooks.logger.error("Unable to enter username and password", e);
		}
	}
	
	public void assertAlertMessage(String expected) {
		
		
		try {
			String actual = getText(loginPage.alertMessage);

			Assert.assertEquals(actual, expected);
		}
		catch(Exception e) {
			Hooks.logger.error("Unable to assert alert message", e);
		}
		
	}
	
	public void assertRequiredMessage(By locator,String expected) {
		
		try {
			String actual = getText(locator);
		
			Assert.assertEquals(actual, expected);
		}
		catch(Exception e) {
			Hooks.logger.error("Unable to assert required message", e);
		}
		
	}
	
	public void assertUsernameRequired(String expected) {
		
		try {
		
			assertRequiredMessage(loginPage.userRequiredMessage,expected);
		}
		catch(Exception e) {
			Hooks.logger.error("Unable to assert username required message");
		}
		
		
	}
	
	public void assertPasswordRequired(String expected) {
		
		try {
		
			assertRequiredMessage(loginPage.passwordRequiredMessage,expected);
		}
		catch(Exception e) {
			Hooks.logger.error("Unable to assert password required message");
		}
		
	}
	
	public void enterBlankUserName(String username, String password) {
		
		sendUserName(username);
		sendPassword(password);
		
		
	}
	
	public void enterBlankPassword(String username, String password) {
		
		sendUserName(username);
		sendPassword(password);
		
	}
	
	public void assertBothRequiredMessage(String expected) {
		
		assertUsernameRequired(expected);
		assertPasswordRequired(expected);
		
	}
	
	public void enterBlankInputs(String username, String password) {
		
		sendUserName(username);
		sendPassword(password);
		
	}
	
	public void checkLogout() {
		
		boolean actual = isDisplayed(loginPage.loginLink);
		
		Assert.assertEquals(actual, true);
		
	}
	

}