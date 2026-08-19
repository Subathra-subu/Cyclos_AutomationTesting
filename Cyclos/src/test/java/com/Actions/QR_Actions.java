package com.Actions;

import com.Pages.QRcode_page;

public class QR_Actions extends BaseAction {

    QRcode_page page = new QRcode_page();


    // Navigate to QR Code page
    public void navigateToQRPage() {
        click(page.Banking);
        click(page.QRcode);
    }

    // Enter amount (used for Scenario Outline)
    public void enterAmount(String amount) {
        try {
            waitForVisibility(page.Amount);
            sendKeys(page.Amount, amount);
        } catch (Exception e) {
            System.out.println("Failed to enter amount: " + e.getMessage());
        }
    }

    // Click Generate QR code button
    public void clickGenerate() {
        try {
            click(page.Generate);
        } catch (Exception e) {
            System.out.println("Failed to click Generate button: " + e.getMessage());
        }
    }

    // Click Generate New QR code button
    public void clickNewGenerate() {
        try {
            jsClick(page.new_generate);
        } catch (Exception e) {
            System.out.println("Failed to click New Generate button: " + e.getMessage());
        }
    }

    // Verify QR code is displayed
    public boolean isQRGenerated() {
        try {
            waitForVisibility(page.Qrcode);
            return isDisplayed(page.Qrcode);
        } catch (Exception e) {
            System.out.println("QR code not found: " + e.getMessage());
            return false;
        }
    }

    // Get validation error message
    public String getErrorMessage() {
        try {
            waitForVisibility(page.errormsg);
            return getText(page.errormsg);
        } catch (Exception e) {
            System.out.println("Error message not found: " + e.getMessage());
            return "";
        }
    }

    // Get button text for verification
    public String getGenerateText() {
        try {
            waitForVisibility(page.Generate);
            return getText(page.Generate);
        } catch (Exception e) {
            System.out.println("Generate text not found: " + e.getMessage());
            return "";
        }
    }
}