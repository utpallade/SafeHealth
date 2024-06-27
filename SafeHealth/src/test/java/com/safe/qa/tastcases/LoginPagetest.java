package com.safe.qa.tastcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.safe.qa.base.TestBase;
import com.safe.qa.pages.HomePage;
import com.safe.qa.pages.LoginPage;

public class LoginPagetest extends TestBase{

	LoginPage loginPage;
	HomePage homePage;
	
	LoginPagetest(){
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		initialization();
		loginPage = new LoginPage();	
		
	}
	
	@Test(priority =1)
	public void verifyPageTitle()
	{
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "Administration Console");
		System.out.println(loginPage.validateLoginPageTitle());
		
	}
	
	@Test(priority =2)
	public void safeLogoImageTest() {
		boolean  flg= loginPage.validateSAFELogo();
			Assert.assertTrue(flg);
			System.out.println("Safe Logo is displayed :"+flg);
	}
	
	@Test(priority =3)
	public void loginTest() throws InterruptedException
	{
		
		homePage =loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
		System.out.println("Login successful");
		
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

	
}
