package com.safe.qa.tastcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.safe.qa.base.TestBase;
import com.safe.qa.pages.ContentPage;
import com.safe.qa.pages.HomePage;
import com.safe.qa.pages.LoginPage;

public class ContentPageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	ContentPage contentPage;
	
	
	ContentPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException
	{
		initialization();
		loginPage = new LoginPage();
		homePage =loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
		contentPage = homePage.verifyContentButton();
	}
	
	@Test(priority =1)
	public void validateheaderEmailTest()
	{
		boolean  flg= contentPage.validateLoginPageTitleOFchild();
		Assert.assertTrue(flg);
		System.out.println("contentPage is displayed :"+flg);
	}
	
	@Test(priority =2)
	public void validateWelcomeMessageTest() {
		boolean  flg= contentPage.validateWelcomeMessageOnParent();
			Assert.assertTrue(flg);
			System.out.println("Welcome Message is displayed :"+flg);
	}
	
	@Test(priority=3)
	public void validateAddNewQuestionTest() throws InterruptedException
	{
		contentPage.validateAddNewQuestion();
	}
	@Test(priority=4)
	public void validateEditAddNewQuestionTest() throws InterruptedException
	{
		contentPage.validateEditAddNewQuestion();
	}
	@Test(priority=5)
	public void validateDeleteAddNewQuestiontest() throws InterruptedException
	{
		contentPage.validateDeleteAddNewQuestion();
	}
	

	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}


}
