package com.safe.qa.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.safe.qa.base.TestBase;
import com.safe.qa.util.TestUtil;

public class ContentPage extends TestBase {
	
	//Page Factory 
		@FindBy(xpath="//h6[text()='Welcome to Safe!']")
		WebElement welcomeMessage;
	
	    @FindBy(xpath ="//div[text()='Content']")
	    WebElement ContentLink;
	    
	    @FindBy(xpath="//button//span[normalize-space()='Add New Questions']")
	    WebElement addQuesbet;
	    
	    @FindBy(xpath="//textarea[@name='content']")
	    WebElement questionField;
	    
	    @FindBy(xpath="//div[@class='ProseMirror']")
	    WebElement answerField;
	    
	    @FindBy(xpath="//button//span[text()='Save Changes']")
	    WebElement saveBtn;
	    
	    	    
	    @FindBy(xpath="//div[@class='MuiAccordionSummary-content']//h6")
	    List<WebElement> listQues;
	    
	    @FindBy(xpath="//span[text()='OK']")
	    WebElement okBtn;
	    
	    TestUtil testUtil;
	
	       //Initializing the page Object
			public ContentPage()
			{
				PageFactory.initElements(driver,this);
				testUtil= new TestUtil();
			
			}
			
			public boolean validateLoginPageTitleOFchild()
			{
				testUtil.switchToChildWildow();
				return ContentLink.isDisplayed();
			}
			
			public boolean validateWelcomeMessageOnParent()
			{
				testUtil.switchToparentWildow();;
				return welcomeMessage.isDisplayed();
			}
			
			public void validateAddNewQuestion() throws InterruptedException
			{
				testUtil.switchToChildWildow();
				addQuesbet.click();
				questionField.clear();
				Thread.sleep(3500);
				questionField.sendKeys("Welcome to test");
				answerField.clear();
				Thread.sleep(3500);
				answerField.sendKeys("Welcome to test");
				
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); 
				WebElement element = wait.until(ExpectedConditions.elementToBeClickable(saveBtn));
				testUtil.scrolltoElement(element);
				element.click();
				Thread.sleep(3500);
			}
			
			
			//div[contains(@id,'content')]//span[@class='MuiButton-label'][normalize-space()='Edit']
			public void validateEditAddNewQuestion() throws InterruptedException
			{
				testUtil.switchToChildWildow();
				int siz=listQues.size();
				listQues.get(siz-1).click();
				
				driver.findElement(By.xpath("(//div[contains(@id,'content')]//span[@class='MuiButton-label']"+
				"[normalize-space()='Edit'])["+siz+"]")).click();
				questionField.sendKeys("Welcome to test");
				
				answerField.clear();
				Thread.sleep(3500);
				answerField.sendKeys("Welcome to test");
				Thread.sleep(3500);
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); 
				WebElement element = wait.until(ExpectedConditions.elementToBeClickable(saveBtn));
				testUtil.scrolltoElement(element);
				element.click();
				Thread.sleep(3500);
				
			
			}
			
			public void validateDeleteAddNewQuestion() throws InterruptedException
			{
				testUtil.switchToChildWildow();
				int siz=listQues.size();
				listQues.get(siz-1).click();
				driver.findElement(By.xpath("(//button[@data-testid='expansionPanelDeleteBtn'])["+siz+"]")).click();
				Thread.sleep(3500);
				okBtn.click();
				Thread.sleep(3500);
				
			}

}
