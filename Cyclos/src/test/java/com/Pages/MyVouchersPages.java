package com.Pages;

import org.openqa.selenium.By;

public class MyVouchersPages

{

	public By markPlace = By.xpath("//a/div[text()=\"Marketplace\"]");
	public By voucher = By.xpath("//div[text()='My vouchers']/ancestor::a");
	public By buyVocher = By.xpath("//*[contains(text(),'Buy vouchers')]");
	public By cinema = By.xpath("//a[contains(text(),\" Cinema\")]");

	public By number = By.xpath("//input[@autocomplete=\"off\" and @type=\"number\"]");

	public By amount = By.xpath("//input[@autocomplete=\"off\" and @type=\"tel\"]");

	public By next = By.xpath("//button/span[contains(text(),\"Next\")]");

	public By confirm = By.xpath("//button/span[contains(text(),\"Con\")]");

	public By assertAmount = By.xpath("//label-value[2]//div[1]//div[1]");

	public By assertAlert = By.xpath("//div[contains(text(),\"the maximum allowed open amount\")]");

	public By gift = By.xpath("//a[text()=\" Gift voucher \"]");

	public By giftNo = By.xpath("//input[@type=\"number\"]");

	public By restaurant = By.xpath("//a[text()=\" Restaurant voucher \"]");

	public By assertPopUp = By.xpath("//*[contains(text(),'The voucher(s) has been bought.')]");

	public By voucherCode =
	        By.xpath("//span[normalize-space()='Voucher code']"
	                + "/following::input[@type='text'][1]");

	public By result =
	        By.xpath("//tbody/tr[1]/td[3]/a");

	
}