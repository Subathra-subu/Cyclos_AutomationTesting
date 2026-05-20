package com.Pages;

import org.openqa.selenium.By;

public class AddIntrestPage {

    public By marketPlace =
            By.xpath("//div[text()='Marketplace']/parent::a");

    public By adIntrestLink =
            By.xpath("//div[contains(text(),'interests')]/parent::a");

    public By tableRows =
            By.cssSelector("tbody tr");

    public By delFirstRow =
            By.xpath("(//tbody/tr)[1]//button");

    public By confirmDelBtn =
            By.xpath("//button[contains(.,'Confirm')]");

    public By successToast =
            By.xpath("//*[contains(text(),'was removed')]");

    public By noResult =
            By.xpath("//div[contains(text(),'No results')]");

    public By addNew =
            By.xpath("//div[text()='Add new']/parent::button");

    public By name =
            By.xpath("//input[contains(@id,'id_')]");

    public By keyWord =
            By.xpath("//div[@class='d-flex flex-grow-1 mw-100']//input");

    public By doneBy =
            By.xpath("//input[contains(@placeholder,'search')]");

    public By AllFirst =
            By.xpath("(//button[contains(@aria-controls,'dropdown-menu')])[2]");

    public By categry =
            By.xpath("//a[contains(normalize-space(),'Artists')]");

    public By min =
            By.xpath("(//input[@type='tel'])[1]");

    public By max =
            By.xpath("(//input[@type='tel'])[2]");

    public By subMit =
            By.xpath("//button//span[text()='Submit']");
    
    public By popUp =
            By.xpath("//*[contains(text(),'was created')]");
    
    public By requiredMessage =
            By.xpath("//div[contains(text(),\" This field is required\")]");
    
    public By unique = By.xpath("//div[contains(text(),\"unique\")]");
}