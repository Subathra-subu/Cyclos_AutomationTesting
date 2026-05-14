package com.Pages;

import org.openqa.selenium.By;

import com.Actions.QR_Actions;

public class QRcode_page extends QR_Actions{
   
	By Banking = By.xpath("//div[@class='menu-text'][normalize-space()='Banking']");
	By QRcode = By.xpath("//div[text()='Receive QR-code']");
	By Amount = By.xpath("//input[@placeholder='0,00']");
	By Generate = By.xpath("//span[normalize-space()='Generate QR code']");
	By Qrcode = By.xpath("//img[@class='mb-3']");
	 By loginButton = By.xpath("//*[@id=\"login-link\"]/div");

	    By usernameTextBox = By.xpath("//input[@placeholder='User']");

	    By passwordTextBox = By.xpath("//input[@placeholder='Password']");

	    By submitButton = By.xpath("//span[text()='Submit']");
	    By errormsg = By.xpath("//div[@class='invalid-feedback']");
	    By new_generate = By.xpath("//span[text()='Generate new QR code']");
	    
	    public void loginApplication(String username, String password) {

	        l_click(loginButton);

	        u_sendKeys(usernameTextBox, username);

	        p_sendKeys(passwordTextBox, password);

	        s_click(submitButton);
	    }
	
	public void navigatetoBankingPage() {
		bank_click(Banking);
		  qr_click(QRcode);
	}
	public void enter_amount(String amount) {
		send_amount(Amount, amount);
	}
	 public void clickqrButton() {
		 button_click(Generate);
	 }
	 public Boolean QrVerification() {
		 return qr_check(Qrcode);
	 }
	 public String errormessage() {
       
		 return error_check(errormsg);
}
	 public void clickqrButtonnew() {
		 button_click(new_generate);
	 }
	 
	 public String newgen() {
		 return error_check(Generate);
	 }
}
	 
	 