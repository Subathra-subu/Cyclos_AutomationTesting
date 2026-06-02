package com.Actions;

import org.testng.Assert;

import com.Pages.ContactPage;
import com.Utilities.HelperClass;

public class ContactActions extends BaseAction {

    ContactPage contactPage = new ContactPage();

    public void clickPersonMenu() {

        try {

            waitForVisibility(contactPage.DemoUser);

            waitForClickable(contactPage.DemoUser);

            jsClick(contactPage.DemoUser);

            HelperClass.log.info("Clicked Person Menu Successfully");

        } catch (Exception e) {

            HelperClass.log.error("Failed to click Person Menu : " + e.getMessage());

            throw e;
        }
    }

    public void clickContactButton() {

        try {

            waitForVisibility(contactPage.contact);

            waitForClickable(contactPage.contact);

            jsClick(contactPage.contact);

            HelperClass.log.info("Clicked Contact Button Successfully");

        } catch (Exception e) {

            HelperClass.log.error("Failed to click Contact Button : " + e.getMessage());

            throw e;
        }
    }

    public void clickAddNewButton() {

        try {

            waitForVisibility(contactPage.AddNew);

            waitForClickable(contactPage.AddNew);

            jsClick(contactPage.AddNew);

            HelperClass.log.info("Clicked Add New Button Successfully");

        } catch (Exception e) {

            HelperClass.log.error("Failed to click Add New Button : " + e.getMessage());

            throw e;
        }
    }

    public void enterContactName(String contactName) {

        try {

            sendKeys(contactPage.ContactName, contactName);

            HelperClass.log.info("Entered Contact Name : " + contactName);

        } catch (Exception e) {

            HelperClass.log.error("Failed to enter Contact Name : " + e.getMessage());

            throw e;
        }
    }

    public void clickSubmitButton() {

        try {

            waitForVisibility(contactPage.submit);

            waitForClickable(contactPage.submit);

            jsClick(contactPage.submit);

            HelperClass.log.info("Clicked Submit Button Successfully");

        } catch (Exception e) {

            HelperClass.log.error("Failed to click Submit Button : " + e.getMessage());

            throw e;
        }
    }

    public void verifyContactCreated(String expectedMessage) {

        try {

            String actualMessage = getText(contactPage.successMessage);

            Assert.assertEquals(actualMessage, expectedMessage);

            HelperClass.log.info("Contact Created Successfully");

        } catch (Exception e) {

            HelperClass.log.error("Contact Verification Failed : " + e.getMessage());

            throw e;
        }
    }
    
    public void clickContactListViewButton() {

        try {

            waitForVisibility(contactPage.contactListViewButton);

            waitForClickable(contactPage.contactListViewButton);

            jsClick(contactPage.contactListViewButton);

            HelperClass.log.info("Clicked Contact List View Button Successfully");

        } catch (Exception e) {

            HelperClass.log.error("Failed to click Contact List View Button : " + e.getMessage());

            throw e;
        }
    }
    
    public void verifyUserColumnDisplayed() {

        String actualText = getText(contactPage.userAssert);

        Assert.assertEquals(actualText, "User",
                "User column text mismatch");
    }
}