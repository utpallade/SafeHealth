package com.safe.qa.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.safe.qa.base.TestBase;
import com.safe.qa.util.TestUtil;

public class ActiveUserPage extends TestBase{
	
	TestUtil testUtil;
	
	@FindBy(xpath="//input[@placeholder='Search']")
	WebElement SearchBox;
	
	@FindBy(xpath ="//span[text()='New User']")
	WebElement newUserButton;
	
	@FindBy(xpath ="//div[text()='People']")
	WebElement peopleLink;
	
	@FindBy(xpath = "//span[@aria-label='Select Role']")
	WebElement SelectRole;
	
		
	@FindBy(xpath ="//input[@name='email']")
	WebElement emailField;
	
	@FindBy(xpath ="//input[@name='firstName']")
	WebElement firstName;
	
	@FindBy(xpath ="//input[@name='lastName']")
	WebElement lastName;

	@FindBy(xpath="//span[text()='Add User']")
	WebElement addUserBt;
	
	@FindBy(xpath="//td//button")
	WebElement meatBallsMenue;
	
	@FindBy(xpath ="//li//span[text()='Edit']")
	WebElement editButton;
	
	   //Initializing the page Object
		public ActiveUserPage()
		{
			PageFactory.initElements(driver,this);
			testUtil= new TestUtil();
		}
		
		//Action
		
		public boolean validatePeopleNavigationLink()
		{
			return peopleLink.isDisplayed();
		}
		
		public UserDetailsPage validateSearchField() throws InterruptedException
		{
			SearchBox.clear();
			SearchBox.sendKeys(prop.getProperty("searchUser"));
			Thread.sleep(3500);
			SearchBox.click();
			meatBallsMenue.click();
			editButton.click();
			return new UserDetailsPage();
		}
		
		public void creatNewMemberUser() throws InterruptedException {
			
			newUserButton.click();
			SelectRole.click();
			driver.findElement(By.xpath("//span[text()='Member']")).click();
			emailField.clear();
			emailField.sendKeys(TestUtil.eMail);
			firstName.clear();
			firstName.sendKeys(TestUtil.fName);
			lastName.clear();
			lastName.sendKeys(TestUtil.lName);
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.visibilityOf(addUserBt)).click();
					
			Thread.sleep(3500);
			
		}
		

		public void creatNewMemberUserDD(String role,String eMail,String fName, String  lName) throws InterruptedException {
			
			newUserButton.click();
			SelectRole.click();
			driver.findElement(By.xpath("//span[text()='"+role+"']")).click();
			emailField.clear();
			emailField.sendKeys(eMail);
			firstName.clear();
			firstName.sendKeys(fName);
			lastName.clear();
			lastName.sendKeys(lName);
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.visibilityOf(addUserBt)).click();
					
			Thread.sleep(3500);
			
		}
	
	
	


}
