package com.Actions;

import org.openqa.selenium.By;

import com.Pages.PaymentToUserPage;
import com.Utilities.ConfigureClass;

public class PaymentToUserActions extends BaseAction {
	PaymentToUserPage paymentpage = new PaymentToUserPage();
	
	public void clickNext() {
		waitForVisibility(paymentpage.nextBtn);
		click(paymentpage.nextBtn);
	}
	public void clickPayUser() {

	    waitForClickable(paymentpage.payuser);

	    scrollIntoView(paymentpage.payuser);

	    jsClick(paymentpage.payuser);
	}

	public void enterUser(String value) {

	    waitForVisibility(paymentpage.userfield);

	    sendKeys(paymentpage.userfield, value);
	    By suggestion = By.xpath("//a[contains(text(),\"" + value + "\")]");
	    
	    waitForVisibility(suggestion);
	    
	    click(suggestion);
	}

	  


	public String validateErrorMessage() {
		
		waitForVisibility(paymentpage.errormsg);
		
		return  getText(paymentpage.errormsg);
		
	}
	public void enterAmount(String amount) {

	    waitForVisibility(paymentpage.amountField);

	   

	    sendKeys(paymentpage.amountField, amount);

	    click(paymentpage.descriptionField);
	}
	public String validatePaymentConfirmationTitle() {

	    waitForVisibility(paymentpage.paymentConfirmationTitle);
	    return getText(paymentpage.paymentConfirmationTitle);
	}

	public String validateLimitExceededMessage() {

	    waitForVisibility(paymentpage.limitExceededMsg);

	    scrollIntoView(paymentpage.limitExceededMsg);

	    return getText(paymentpage.limitExceededMsg);
	}
	public void selectSchedulingType(String type) {

	    scrollIntoView(paymentpage.dropdown);

	    waitForVisibility(paymentpage.dropdown);

	    click(paymentpage.dropdown);

	    if(type.equalsIgnoreCase("Scheduled")) {

	        waitForVisibility(paymentpage.scheduledOption);

	        click(paymentpage.scheduledOption);
	    }

	    else if(type.equalsIgnoreCase("Pay now")) {

	        waitForVisibility(paymentpage.payNowOption);

	        click(paymentpage.payNowOption);
	    }

	    else if(type.equalsIgnoreCase("Monthly installments")) {

	        waitForVisibility(paymentpage.monthlyInstallmentOption);

	        click(paymentpage.monthlyInstallmentOption);
	    }

	    else if(type.equalsIgnoreCase("Recurring payments")) {

	        waitForVisibility(paymentpage.recurringPaymentOption);

	        click(paymentpage.recurringPaymentOption);
	    }
	}

	public void selectFutureDate(String date) {

	    waitForVisibility(paymentpage.futureDate);

	    click(paymentpage.futureDate);


	    sendKeys(paymentpage.futureDate, date);
	}

	public void enterDescription(String description) {

	    waitForVisibility(paymentpage.descriptionField);

	    sendKeys(paymentpage.descriptionField, description);
	}
	public void enterNumberOfInstallments(String value) {

	    waitForVisibility(paymentpage.numberOfInstallments);

	    sendKeys(paymentpage.numberOfInstallments, value);
	}
}








