package com.safe.qa.tastcases;



import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.safe.qa.base.TestBase;
import com.safe.qa.pages.HomePage;
import com.safe.qa.pages.LogOut;
import com.safe.qa.pages.LoginPage;

public class LogOutTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	LogOut logOut;
		
	LogOutTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp() 
	{
		initialization();
		loginPage = new LoginPage();
		logOut= new LogOut();
		homePage =loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
	}
	
	@Test
	public void verifylogoutButton() throws InterruptedException
	{
		logOut.verifylogout();
	}	

}
