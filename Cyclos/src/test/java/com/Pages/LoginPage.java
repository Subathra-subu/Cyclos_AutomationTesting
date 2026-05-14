package com.Pages;

import org.openqa.selenium.By;

import com.Actions.BaseAction;

public class LoginPage extends BaseAction {

      By loginbtn = By.xpath("//a[@id='login-link']");
      By username = By.xpath("//input[@placeholder='User']");
      By password = By.xpath("//input[@placeholder='Password']");
      By submit = By.xpath("//button[@class='btn d-flex justify-content-center align-items-center w-100 h-100 btn-primary btn-action-primary']");
      
      public void loginToTheWebsite(String user, String pass) {
    	  click(loginbtn);
    	  type(username, user);
    	  type(password, pass);
    	  click(submit);
//    	  acceptAlert();
      }
}