package com.Actions;

import org.testng.Assert;

import com.Pages.NotificationsPage;
import com.Utilities.HelperClass;

public class NotificationsActions extends BaseAction {

    NotificationsPage notificationsPage = new NotificationsPage();

    public void clickNotificationsIcon() {
        click(notificationsPage.notificationsIcon);
        HelperClass.log.info("Clicked Notifications icon");
        System.out.println(HelperClass.getDriver().getCurrentUrl());
    }

    public void verifyNotificationsPage() {
        boolean urlCheck = HelperClass.getDriver().getCurrentUrl().contains("notifications");
        boolean checkboxCheck =isDisplayed(notificationsPage.unreadOnlyCheckbox);
        Assert.assertTrue(urlCheck || checkboxCheck,"Notifications page was not opened");
        HelperClass.log.info("Notifications page opened successfully");
    }
}