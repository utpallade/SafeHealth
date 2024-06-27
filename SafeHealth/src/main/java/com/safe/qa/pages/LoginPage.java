package com.safe.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.safe.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	//Page Factory 
	@FindBy(name ="email")
	WebElement usremail;
	
	@FindBy(id="password")	
	WebElement pswd;
	
	@FindBy(xpath = "//span[text()='Sign In']")
	WebElement Signbtn;
	
	@FindBy(xpath ="//img[contains(@class,'jss')]")
	WebElement safeLogo;
	
	//Initializing the page Object
	public LoginPage()
	{
		PageFactory.initElements(driver,this);
	
	}
	
	//Action
	public String validateLoginPageTitle()
	{
		return driver.getTitle();
	}
	
	public boolean validateSAFELogo()
	{
		return safeLogo.isDisplayed();
	}
	public HomePage login(String usrEmail, String password) 
	{
		usremail.clear();
		usremail.sendKeys(usrEmail);
		pswd.clear();
		pswd.sendKeys(password);
		
		Signbtn.click();
		return new HomePage();
	}
	
	

}
