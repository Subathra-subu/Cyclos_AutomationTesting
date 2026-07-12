package com.Pages;

import org.openqa.selenium.By;

public class NotificationsPage {

	public By notificationsIcon = By.id("notifications-link");
    public By notificationsActiveMenu = By.xpath("//a[@id='notifications-link' and contains(@class,'active')]/parent::div");
    public By unreadOnlyCheckbox = By.xpath("//label[normalize-space()='Unread only']");
}