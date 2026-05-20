package com.Pages;

import org.openqa.selenium.By;

import com.Actions.QR_Actions;

public class QRcode_page  {

	public By Banking = By.cssSelector("a[id='menu_banking'] ");
	public By QRcode = By.xpath("//div[text()='Receive QR-code']");
	public By Amount = By.xpath("//input[contains(@placeholder,'0')]");
	public By Generate = By.xpath("//span[normalize-space()='Generate QR code']");
	public By Qrcode = By.xpath("//receive-qr-payment-step-pending/descendant::img[1]");
	public By errormsg = By.xpath("//field-errors/descendant::div");
	public By new_generate = By.xpath("//span[text()='Generate new QR code']");


}
