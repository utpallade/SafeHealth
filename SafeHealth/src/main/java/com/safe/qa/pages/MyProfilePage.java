package com.safe.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.safe.qa.base.TestBase;

public class MyProfilePage  extends TestBase{
	
	@FindBy(xpath="//div[@class='MuiGrid-root MuiGrid-item']//p[text()='kmr@yopmail.com' ]")
	WebElement headerEmail;
	
	@FindBy(xpath="//button[@class='MuiButtonBase-root MuiCardActionArea-root']")
	WebElement uploadImage;
	
	        //Initializing the page Object
			public MyProfilePage()
			{
				PageFactory.initElements(driver,this);
							
			}
			
			//Action
			
			public boolean validateheaderEmail()
			{
				return headerEmail.isDisplayed();
			}
			
			public void validateuploadImage() throws InterruptedException
			{
				uploadImage.sendKeys("C:\\Users\\adity\\OneDrive\\Desktop\\1.jpg");
				Thread.sleep(3200);
			}


}
