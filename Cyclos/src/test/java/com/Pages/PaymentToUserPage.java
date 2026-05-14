package com.Pages;

import org.openqa.selenium.By;

public class PaymentToUserPage {
	public By login = By.xpath("//a[@id='login-link']");
	public By name=By.xpath("//input[@placeholder='User']");
    public By pswd=By.xpath("//input[@placeholder='Password']");
    public By submit = By.xpath("//span[text()=\"Submit\"]");
    public By nextBtn = By.xpath("//button[@class='btn d-flex justify-content-center align-items-center w-100 h-100 btn-primary']");
    public By payuser = By.xpath("//a[@href='/banking/self/payment']//div[@class='quick-access-icon']");
    public By userfield = By.xpath("//input[@placeholder='Type to search']");
    public By amountfield = By.xpath("//input[@placeholder='Amount']");
    public By errormsg = By.xpath("//user-field[@class='form-field ng-pristine ng-invalid ng-touched']//div[@class='invalid-feedback'][normalize-space()='This field is required']");
    }


