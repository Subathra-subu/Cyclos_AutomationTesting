package com.Pages;

import org.openqa.selenium.By;

public class LoginPage extends BasePage {

    

    public By loginButton =

            By.xpath("//*[@id='login-link']/div");

    

    public By usernameTextBox =

            By.xpath("//input[@placeholder='User']");

    

    public By passwordTextBox =

            By.xpath("//input[@placeholder='Password']");

    

    public By submitButton =

            By.xpath("//span[text()=\"Submit\"]");
}