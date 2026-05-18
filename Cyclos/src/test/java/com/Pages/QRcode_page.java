package com.Pages;

import org.openqa.selenium.By;

import com.Actions.QR_Actions;

public class QRcode_page extends QR_Actions {

	By Banking = By.xpath("//div[@class='menu-text'][normalize-space()='Banking']");
	By QRcode = By.xpath("//div[text()='Receive QR-code']");
	By Amount = By.xpath("//input[contains(@placeholder,'0')]");
	By Generate = By.xpath("//span[normalize-space()='Generate QR code']");
	By Qrcode = By.xpath("//img[contains(@src,'blob:')]");
	By errormsg = By.xpath("//div[@class='invalid-feedback']");
	By new_generate = By.xpath("//span[text()='Generate new QR code']");

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
