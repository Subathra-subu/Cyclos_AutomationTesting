package com.Actions;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.Pages.systempaymentpage;
import com.Utilities.HelperClass;

public class systempaymentAction extends BaseAction{
	 systempaymentpage syspage = new systempaymentpage();
	public void navigateToPaymentToSystemPage() {
		jsClick(syspage.Banking);
		click(syspage.paymenttosystem);
	}
	
	public void clicknextButton() {
		jsClick(syspage.nextbutton);
		
	}
	public void enterAmount(String amount) {
		sendKeys(syspage.amountfield, amount);
	}
	public void clickConfirmButton() {
		jsClick(syspage.confirmbutton);
	}
	public String getConfirmationMessage() {
		return getText(syspage.msg);
	}
	
	public String getValidationErrorMessage() {
	    return getText(syspage.validationErrorMsg);
	}
	public void selectPaymentMethodAndDate() {
	    jsClick(syspage.listbox);
	    jsClick(syspage.scheduled);

	    WebElement dateField = waitForVisibility(syspage.datepicker);

	    JavascriptExecutor js =
	            (JavascriptExecutor) HelperClass.getDriver();

	    js.executeScript(
	        "arguments[0].value='2026-06-03';" +
	        "arguments[0].dispatchEvent(new Event('input',{bubbles:true}));" +
	        "arguments[0].dispatchEvent(new Event('change',{bubbles:true}));",
	        dateField
	    );

	    dateField.sendKeys(Keys.TAB);
	}
}
