package com.Actions;

import org.testng.Assert;

import com.Pages.DashBoardPage;

public class DashBoardAction extends BaseAction {
	
	DashBoardPage dashBoardPage = new DashBoardPage();
	
	public void successfullLogin() {
		
		
		String actual = getText(dashBoardPage.dashBoard);
		
		String expected = "Dashboard";
		
		Assert.assertEquals(actual, expected);
		
	}
	
	public void clickLogoutLink() {
		
		jsClick(dashBoardPage.logout);
		
	}

    }