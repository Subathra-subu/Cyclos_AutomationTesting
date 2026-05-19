package com.Pages;

import org.openqa.selenium.By;

import com.Actions.QR_Actions;

public class QRcode_page  {

	public By Banking = By.xpath("//div[@class='menu-text'][normalize-space()='Banking']");
	public By QRcode = By.xpath("//div[text()='Receive QR-code']");
	public By Amount = By.xpath("//input[contains(@placeholder,'0')]");
	public By Generate = By.xpath("//span[normalize-space()='Generate QR code']");
	public By Qrcode = By.xpath("//img[contains(@src,'blob:')]");
	public By errormsg = By.xpath("//div[@class='invalid-feedback']");
	public By new_generate = By.xpath("//span[text()='Generate new QR code']");


}
