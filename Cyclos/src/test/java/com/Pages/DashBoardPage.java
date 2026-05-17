package com.Pages;

import org.openqa.selenium.By;

public class DashBoardPage {
	
	public By dashBoard = By.xpath("//div[text()='Dashboard']");
	
	public By logout = By.xpath("//a[@id='logout-trigger']//icon//*[name()='svg']"); // Selector Hub


}
