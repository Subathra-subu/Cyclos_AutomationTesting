package com.Pages;

import org.openqa.selenium.By;

public class NotificationsPage {

	public By notificationsIcon = By.id("notifications-link");
    public By notificationsActiveMenu = By.xpath("//a[@id='notifications-link' and contains(@class,'active')]/parent::div");
    public By unreadOnlyCheckbox = By.xpath("//label[normalize-space()='Unread only']");
    public By unreadCheckbox = By.xpath("//input[@type='checkbox']");
    public By notificationRows = By.xpath("//table/tbody/tr");
    public By notification = By.xpath( "//div[contains(@class,'notification')][1]");
    public By printnotfns = By.xpath("//button[@class='btn']//icon//*[name()='svg']");
}