package com.safe.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.safe.qa.base.TestBase;


public class UserDetailsPage extends TestBase{
	
	@FindBy(xpath="//div[@class='MuiGrid-root MuiGrid-item']//p[text()='utpal.lade@safehealth.me' ]")
	WebElement headerEmail;
	
	
	
	        //Initializing the page Object
			public UserDetailsPage()
			{
				PageFactory.initElements(driver,this);
							
			}
			
			//Action
			
			public boolean validateheaderEmail()
			{
				return headerEmail.isDisplayed();
			}
			
			

}
