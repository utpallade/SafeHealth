package com.safe.qa.tastcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.safe.qa.base.TestBase;
import com.safe.qa.pages.HomePage;
import com.safe.qa.pages.LoginPage;
import com.safe.qa.pages.MyProfilePage;

public class MyProfilePageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	
	MyProfilePage myProfilePage;
	@BeforeMethod
	public void setUp() throws InterruptedException
	{
		initialization();
		loginPage = new LoginPage();
				
		homePage =loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
		myProfilePage = homePage.verifyMyprofilelink();
		
	}
	
	@Test(priority =1)
	public void validateheaderEmailTest()
	{
		boolean  flg= myProfilePage.validateheaderEmail();
		Assert.assertTrue(flg);
		System.out.println("Email is displayed :"+flg);
	}
	
	@Test(priority =2)
	public void validateuploadImageTest() throws InterruptedException
	{
		myProfilePage.validateuploadImage();
	}

	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}


}
