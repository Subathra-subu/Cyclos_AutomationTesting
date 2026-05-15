package com.Actions;

import org.openqa.selenium.By;

public class QR_Actions extends BaseAction {
	public void l_click(By locator) {
		click(locator);
	}
	public void u_sendKeys(By locator,String username) {
		sendKeys(locator,username);
	}
	public void p_sendKeys(By locator,String password) {
		sendKeys(locator,password);
	}
	public void s_click(By locator) {
		click(locator);
	}
       public void bank_click(By locator) {
    	   click(locator);
       }
       public void  qr_click(By locator)  {
    	  
    	   click(locator);
    	    try { Thread.sleep(1500); } catch (Exception e) {}
       
       }
       
       public void send_amount(By locator, String value) {
    	   waitForVisibility(locator);
    	   sendKeys(locator,value);
       }
       public void button_click(By locator) {
    	   
    	   click(locator);
    	  
       }
       public Boolean qr_check(By locator) {
    	   waitForVisibility(locator);
    	  return  isDisplayed(locator);
    	   
       }
       public String error_check(By locator) {
    	   waitForVisibility(locator);
    	   return  getText(locator);
       }
       
}
