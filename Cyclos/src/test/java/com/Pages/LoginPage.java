package com.Pages;

import org.openqa.selenium.By;

public class LoginPage extends BasePage {

    // LOGIN LINK

    public By loginButton =

            By.xpath("//*[@id='login-link']/div");

    // USERNAME

    public By usernameTextBox =

            By.xpath("//input[@placeholder='User']");

    // PASSWORD

    public By passwordTextBox =

            By.xpath("//input[@placeholder='Password']");

    // SUBMIT BUTTON

    public By submitButton =

            By.xpath("//span[text()=\"Submit\"]");
}