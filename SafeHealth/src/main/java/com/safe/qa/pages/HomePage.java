package com.safe.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.safe.qa.base.TestBase;
import com.safe.qa.util.TestUtil;

public class HomePage extends TestBase{

	//Page Factory 
	@FindBy(xpath="//h6[text()='Welcome to Safe!']")
	WebElement welcomeMessage;
	
	@FindBy(xpath="//a[@href='/healthcheck/users/active']//div[@role='button']")
	WebElement  buttonPeople;
	
	@FindBy(xpath="//*[name()='path' and contains(@d,'M10.59 4.5')]")
	WebElement contentbt;
	
	@FindBy(xpath="//p[text()='HealthCheck-Consumer-Quality']")
	WebElement headderText;
	
	@FindBy(xpath="//button[@class='MuiButtonBase-root MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-disableElevation']")
	WebElement userName;
	
	@FindBy(xpath="//li[text()='My Profile']")
	WebElement MyProfilelink;
	
	TestUtil testUtil;
	
	
	//Initializing the page Object
		public HomePage()
		{
			PageFactory.initElements(driver,this);
			testUtil= new TestUtil();
		
		}
		
		//Action
		public String validateLoginPageTitle()
		{
			return driver.getTitle();
		}
		public boolean validateWelcomeMessage()
		{
			return welcomeMessage.isDisplayed();
		}
		
		public boolean validateHeadderText()
		{
			return headderText.isDisplayed();
		}
		
		public ActiveUserPage verifyPeopleButton() throws InterruptedException
		{
			testUtil.mouseHover(buttonPeople);
			buttonPeople.click();
			Thread.sleep(3500);
			return new ActiveUserPage();
		}
		
		public ContentPage verifyContentButton() throws InterruptedException
		{
			testUtil.mouseHover(contentbt);
			testUtil.openNewTab(contentbt);
			Thread.sleep(3500);
			return new ContentPage();
		}
		
		public MyProfilePage verifyMyprofilelink() throws InterruptedException
		{
			userName.click();
			MyProfilelink.click();
			Thread.sleep(3500);
			return new MyProfilePage();
		}
		

}
