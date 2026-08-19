package com.Pages;

import org.openqa.selenium.By;

public class DocumentPage {

	public By documentsMenu = By.xpath("//div[text()='Documents']");
	public By innovativeDocRow = By.xpath("//td[contains(text(),'Innovative Approaches to Development')]");
	public By downloadBtn = By.xpath("//td[contains(text(),'Innovative Approaches to Development')]/following-sibling::td//button");

}
