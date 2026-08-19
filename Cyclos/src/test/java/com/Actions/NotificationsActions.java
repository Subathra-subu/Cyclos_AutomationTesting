package com.Actions;

import org.testng.Assert;

import com.Pages.NotificationsPage;
import com.Utilities.HelperClass;

public class NotificationsActions extends BaseAction {

    NotificationsPage notificationsPage = new NotificationsPage();

    public void clickNotificationsIcon() {

        click(notificationsPage.notificationsIcon);
        HelperClass.log.info("Clicked Notifications icon");
    }

    public void verifyNotificationsPage() {

        boolean urlCheck =
                HelperClass.getDriver().getCurrentUrl().contains("notifications");

        boolean checkboxCheck =
                isDisplayed(notificationsPage.unreadOnlyCheckbox);

        Assert.assertTrue(
                urlCheck || checkboxCheck,
                "Notifications page was not opened");

        HelperClass.log.info("Notifications page opened successfully");
    }

    public void openNotifications() {

        HelperClass.log.info("Opening Notifications");

        click(notificationsPage.notificationsIcon);

        waitForVisibility(notificationsPage.unreadOnlyCheckbox);
    }

    public void uncheckUnreadOnly() {

        HelperClass.log.info("Unchecking Unread Only checkbox");

        click(notificationsPage.unreadOnlyCheckbox);
    }

    public void verifyNotificationsDisplayed() {

        HelperClass.log.info("Verifying Notifications");

        waitForVisibility(notificationsPage.notificationRows);

        Assert.assertTrue(
                isDisplayed(notificationsPage.notificationRows),
                "Notifications are not displayed");
    }
    
    public void openNotification() {

        HelperClass.log.info("Opening Notification");

        waitForVisibility(notificationsPage.notificationRows);

        click(notificationsPage.notificationRows);

        HelperClass.log.info("Notification clicked successfully");
    }

    public void verifyNotificationOpened() {

        HelperClass.log.info("Verifying Notification Details");

        waitForVisibility(notificationsPage.printnotfns);

        Assert.assertTrue(
                isDisplayed(notificationsPage.printnotfns),
                "Notification details are not displayed");

        HelperClass.log.info("Notification details displayed successfully");
    }
}