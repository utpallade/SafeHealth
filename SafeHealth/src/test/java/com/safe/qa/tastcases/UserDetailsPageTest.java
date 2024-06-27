package com.safe.qa.tastcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.safe.qa.base.TestBase;
import com.safe.qa.pages.ActiveUserPage;
import com.safe.qa.pages.HomePage;
import com.safe.qa.pages.LoginPage;
import com.safe.qa.pages.UserDetailsPage;

public class UserDetailsPageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	ActiveUserPage peoplePage;
	UserDetailsPage userPage;
	@BeforeMethod
	public void setUp() throws InterruptedException
	{
		initialization();
		loginPage = new LoginPage();
		peoplePage= new ActiveUserPage();
		
		homePage =loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
		peoplePage = homePage.verifyPeopleButton();
		userPage =peoplePage.validateSearchField();
	}
	
	@Test(priority =1)
	public void validateheaderEmailTest()
	{
		boolean  flg= userPage.validateheaderEmail();
		Assert.assertTrue(flg);
		System.out.println("Email is displayed :"+flg);
	}
	

	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
