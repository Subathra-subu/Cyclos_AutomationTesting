package com.Actions;

import org.openqa.selenium.By;

import com.Pages.PaymentToUserPage;
import com.Utilities.ConfigureClass;

public class PaymentToUserActions extends BaseAction {
	PaymentToUserPage paymentpage = new PaymentToUserPage();
	public void loginbtn() {
		
		click(paymentpage.login);
		
		waitForVisibility(paymentpage.name);
	}
	public void username() {
		
		sendKeys(paymentpage.name, ConfigureClass.getUsername());
	}
	public void password() {
		
		sendKeys(paymentpage.pswd, ConfigureClass.getPassword());
	}
	public void submit() {
		
		click(paymentpage.submit);
	}
	public void clickNext() {
		
		click(paymentpage.nextBtn);
	}
	public void clickPayUser() {
		
		waitForVisibility(paymentpage.payuser);
		
		click(paymentpage.payuser);
	}
	public void enterUser(String value) {
		if(value != null && !value.trim().isEmpty()) {
			waitForVisibility(paymentpage.userfield);
			sendKeys(paymentpage.userfield, value);
		}
	}


	public String validateErrorMessage() {
		
		waitForVisibility(paymentpage.errormsg);
		return  getText(paymentpage.errormsg);
	}
}








