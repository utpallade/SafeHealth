package com.safe.qa.tastcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.safe.qa.base.TestBase;
import com.safe.qa.pages.ActiveUserPage;
import com.safe.qa.pages.HomePage;
import com.safe.qa.pages.LoginPage;
import com.safe.qa.util.TestUtil;

public class PeoplePageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	ActiveUserPage peoplePage;
	
	
	PeoplePageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException
	{
		initialization();
		loginPage = new LoginPage();
		peoplePage= new ActiveUserPage();
		
		homePage =loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
		peoplePage = homePage.verifyPeopleButton();
		
	}
	
	@Test(priority =1)
	public void validatePeopleNavigationTest()
	{
		boolean  flg= peoplePage.validatePeopleNavigationLink();
		Assert.assertTrue(flg);
		System.out.println("Navigation Link is displayed :"+flg);
	}
	
	@Test(priority=2)
	public void validateSearchFieldTest() throws InterruptedException {
		
		peoplePage.validateSearchField();
		System.out.println("searching successful");
	}
	
	@Test (priority=3)
	public void creatNewMemberUserTest() throws InterruptedException
	{
		peoplePage.creatNewMemberUser();
	}
	
	@DataProvider(name ="CreateContent")
	public Object[][] setData()
	{
		Object data[][]=TestUtil.getTestData("Sheet1");
	
		return data;
	}
	
	@Test (priority=4, dataProvider = "CreateContent")
	public void creatNewMemberUserDDTest(String userRole,String fstName,String lstName,String eMail) throws InterruptedException
	{
		peoplePage.creatNewMemberUserDD(userRole, eMail, fstName, lstName);;
	}
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
