package com.safe.qa.tastcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.safe.qa.base.TestBase;
import com.safe.qa.pages.ActiveUserPage;
import com.safe.qa.pages.ContentPage;
import com.safe.qa.pages.HomePage;
import com.safe.qa.pages.LoginPage;
import com.safe.qa.pages.MyProfilePage;

public class HomePageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	ActiveUserPage peoplePage;
	ContentPage contentPage;
	MyProfilePage profilePage;
	
	HomePageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp() 
	{
		initialization();
		loginPage = new LoginPage();
		peoplePage= new ActiveUserPage();
		profilePage =new MyProfilePage();
		homePage =loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
		
	}
	

	@Test(priority =1)
	public void verifyHomePageTitle()
	{
		String title = homePage.validateLoginPageTitle();
		Assert.assertEquals(title, "Administration Console");
		System.out.println(loginPage.validateLoginPageTitle());
		
	}
	
	@Test(priority =2)
	public void validateWelcomeMessageTest() {
		boolean  flg= homePage.validateWelcomeMessage();
			Assert.assertTrue(flg);
			System.out.println("Welcome Message is displayed :"+flg);
	}
	
	@Test(priority =3)
	public void validateHeadderTextTest() {
		boolean  flg= homePage.validateHeadderText();
			Assert.assertTrue(flg);
			System.out.println("Headder Text is displayed :"+flg);
	}
	
	@Test(priority =3)
	public void verifyPeopleButtonTest() throws InterruptedException
	{
		
		peoplePage =homePage.verifyPeopleButton();
		System.out.println("Mevigated to People page ");
		
	}
	
	@Test(priority =4)
	public void verifyMyprofilelinkTest() throws InterruptedException 
	{
		
		profilePage =homePage.verifyMyprofilelink();
		System.out.println("Mevigated to My profile page ");
		
	}
	
	@Test(priority =5)
	public void verifyContentButtontest() throws InterruptedException
	{
		
		contentPage =homePage.verifyContentButton();
		System.out.println("Mevigated to People page ");
		
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
