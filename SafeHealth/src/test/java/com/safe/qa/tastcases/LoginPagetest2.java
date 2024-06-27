package com.safe.qa.tastcases;

import java.util.Arrays;
import java.util.Collection;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.safe.qa.base.TestBase2;
import com.safe.qa.pages.HomePage;
import com.safe.qa.pages.LoginPage;

public class LoginPagetest2 extends TestBase2{

	LoginPage loginPage;
	HomePage homePage;
	private String browser;
	
	LoginPagetest2(String browser){
		super();
		 this.browser = browser;
	}
	
	  @Parameters
	    public static Collection<Object[]> data() {
	        return Arrays.asList(new Object[][] {
	            { "chrome" }, { "firefox" }, { "edge" }
	        });
	    }
	
	@BeforeMethod
	public void setUp()
	{
		initializeDriver(browser);
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
