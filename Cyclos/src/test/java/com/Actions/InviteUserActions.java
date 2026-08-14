package com.Actions;

import java.util.List;
import java.util.Map;
//
import org.openqa.selenium.By;
import com.Pages.InviteUserPage;
import com.Utilities.CSVUtility;
import com.Utilities.HelperClass;

import io.cucumber.datatable.DataTable;

public class InviteUserActions extends BaseAction {

    InviteUserPage page;

    public InviteUserActions(InviteUserPage page) {
        this.page = page;
    }

    public void navigateToInvitePage() {
        try {
        	jsClick(page.marketPlace);
        	jsClick(page.inviteUsers);
        } catch (Exception e) {
            HelperClass.log.error("Failed to navigate Invite Page", e);
        }
    }

    public void enterEmail(String email) {
        try {
            sendKeys(page.emailtextbox, email);
        } catch (Exception e) {
            HelperClass.log.error("Failed entering email", e);
        }
    }
  
    
    
    public void clickSendInvitation() {
        try {
            jsClick(page.sendInvitationButton);
        } catch (Exception e) {
            HelperClass.log.error("Failed clicking send invitation", e);
        }
    }

    public boolean isSuccessMessageDisplayed() {
        try {
            return isDisplayed(page.successMessage);
        } catch (Exception e) {
            HelperClass.log.error("Success message not found", e);
            return false;
        }
    }

    public boolean isValidationMessageDisplayed() {
        try {
            return isDisplayed(page.validationMessage);
        } catch (Exception e) {
            HelperClass.log.error("Validation message not found", e);
            return false;
        }
    }
    
    public void clickAddEmailButton() {
    	    for (int i=1;i<=3;i++) {
    	    	 jsClick(By.xpath("//div[@class='input-fields']/descendant::button["+i+"]"));
    	    }
    }
    
    public void enterEmailInMultipleFields() {

        List<String> emails =
                CSVUtility.getVoucherCodes("src/test/resources/testData/email_InputData.csv");

        for (int i = 1; i <= emails.size(); i++) {

            sendKeys(
                By.xpath("(//div[@class='input-fields']//input)[" + i + "]"), emails.get(i - 1));
        }
    }
}