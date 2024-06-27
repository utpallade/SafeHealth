package com.safe.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.safe.qa.base.TestBase;


public class LogOut extends TestBase {
	
	
	@FindBy(xpath="//button[@class='MuiButtonBase-root MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-disableElevation']")
	WebElement userName;
	
	@FindBy(xpath="//li[text()='Logout']")
	WebElement logoutlink;
	//Initializing the page Object
	public LogOut()
	{
		PageFactory.initElements(driver,this);
	}
	
	public void verifylogout() throws InterruptedException
	{
		userName.click();
		Thread.sleep(3900);
		logoutlink.click();
	}

}
