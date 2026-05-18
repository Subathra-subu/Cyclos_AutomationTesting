package com.Actions;

import com.Pages.RegisterPage;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.testng.Assert;

public class RegisterAction extends BaseAction {
	
	RegisterPage registerPage = new RegisterPage();
	
	public void clickRegisterLink() {
		
		jsClick(registerPage.registerLink);
		
	}
	
	public void uploadImage(String imagePath) throws Exception { // Referred
		
			click(registerPage.upload);

		    StringSelection selection = new StringSelection(imagePath);

		    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);

		    Robot robot = new Robot();

		    robot.delay(2000);

		    // CTRL + V
		    robot.keyPress(KeyEvent.VK_CONTROL);
		    robot.keyPress(KeyEvent.VK_V);

		    robot.keyRelease(KeyEvent.VK_V);
		    robot.keyRelease(KeyEvent.VK_CONTROL);

		    robot.delay(1000);

		    // ENTER
		    robot.keyPress(KeyEvent.VK_ENTER);
		    robot.keyRelease(KeyEvent.VK_ENTER);
	}
	
	public void enterName(String name) {

		sendKeys(registerPage.name, name);
	}

	public void enterLoginName(String loginName) {

		sendKeys(registerPage.loginName, loginName);
	}

	public void enterEmail(String email) {

		sendKeys(registerPage.email, email);
	}

	public void enterWebsite(String website) {

		sendKeys(registerPage.website, website);
	}

	public void selectGender() {

		click(registerPage.gender);
	}

	public void selectBusinessType() {

		click(registerPage.businessTypeButton);

		click(registerPage.businessType);
	}

	public void enterMobile(String mobile) {

		sendKeys(registerPage.mobile, mobile);
	}

	public void enterLandline(String landline) {

		sendKeys(registerPage.landLine, landline);
	}

	public void clickDefineAddress() {

		click(registerPage.define_Address);
	}

	public void enterAddress(String address) {

		sendKeys(registerPage.address, address);
	}

	public void enterZipCode(String zip) {

		sendKeys(registerPage.zipCode, zip);
	}

	public void enterCity(String city) {

		sendKeys(registerPage.city, city);
	}

	public void enterRegion(String region) {

		sendKeys(registerPage.region, region);
	}

	public void clickNextButton() {

		click(registerPage.next);
	}

	public void enterNewPassword(String password) {

		sendKeys(registerPage.new_password, password);
	}

	public void enterConfirmPassword(String password) {

		sendKeys(registerPage.confirm_password, password);
	}

	public void clickAgreement() {

		click(registerPage.agreement);
	}

	public void clickRecaptcha() throws InterruptedException {

		Thread.sleep(20000);

		click(registerPage.recaptcha);
	}
	
	public void enterValidDetails(String name,String loginName,String email,String website,String mobile,String landline,String address,String zip,String city,String region,String password) throws InterruptedException {

		enterName(name);

		enterLoginName(loginName);

		enterEmail(email);

		enterWebsite(website);

		selectGender();

		selectBusinessType();

		enterMobile(mobile);

		enterLandline(landline);

		clickDefineAddress();

		enterAddress(address);

		enterZipCode(zip);

		enterCity(city);

		enterRegion(region);

		clickNextButton();

		enterNewPassword(password);

		enterConfirmPassword(password);

		clickAgreement();

		clickRecaptcha();
	}
	
	public void clickSubmitButton() {
		
		click(registerPage.submit);
		
	}
	
	public void assertSuccessfullLogin(String expected) {

			String actual = getText(registerPage.registration);

			Assert.assertEquals(actual,expected);
	}
	
	public void enterExistingDetails(String name,String loginName){
		
		enterName(name);

		enterLoginName(loginName);
		
	}
	
	public void assertAlreadyExistMessage(String expected) {
		
		String actual = getText(registerPage.existMessage);
		
		Assert.assertEquals(actual, expected);
	}

}
