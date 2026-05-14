package com.Actions;

import org.testng.Assert;

import com.Pages.DashBoardPage;

public class DashBoardAction extends BaseAction {
	
	public void successfullLogin() {
		
		DashBoardPage dashBoardPage = new DashBoardPage();
		
		String actual = getText(dashBoardPage.dashBoard);
		
		String expected = "Dashboard";
		
		Assert.assertEquals(actual, expected);
		
	}
	

}
