package com.Actions;

import com.Utilities.ConfigureClass;

public class LoginAction extends BaseAction{
	
	public void clickLoginLink() {
		
		click(loginPage.loginLink);
	
	}
	
	public void enterUserNameAndPassword() {
		
		sendKeys(loginPage.userName,ConfigureClass.getUsername());
		sendKeys(loginPage.password,ConfigureClass.getPassword());
		
	}
	
	public void clickSubmitButton() {
		
		click(loginPage.loginButton);
	}

}
