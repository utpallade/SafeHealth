package com.safe.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.github.javafaker.Faker;
import com.safe.qa.base.TestBase;

public class TestUtil extends TestBase{

	Faker faker;
	Actions act;
	List<String> ids;
	public static String fName;
	public static  String lName;
	public static String eMail;

	public static String TESTDATA_SHEET_PATH = "C:\\Users\\adity\\Desktop\\NewUser.xlsx";

	static Workbook book;
	static Sheet sheet;
	static JavascriptExecutor js;

	public  TestUtil() {
		act= new Actions(driver);
		faker =new Faker();
		fName= faker.name().firstName();
		lName=faker.name().lastName();
		eMail= faker.internet().emailAddress();

	}
	public void mouseHover(WebElement test)
	{

		act.moveToElement(test).build().perform();
	}

	public void openNewTab(WebElement element)
	{
		act.keyDown(Keys.CONTROL).click(element).keyUp(Keys.CONTROL).build().perform();
	}

	public void switchToChildWildow()
	{
		ids = new ArrayList(driver.getWindowHandles());
		driver.switchTo().window(ids.get(1));
	}
	public void switchToparentWildow()
	{
		ids = new ArrayList(driver.getWindowHandles());
		driver.switchTo().window(ids.get(0));
	}

	public void scrolltoElement(WebElement element)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
	}

	public static Object[][] getTestData(String sheetName) {
		FileInputStream file = null;
		try {
			file = new FileInputStream(TESTDATA_SHEET_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		} catch (InvalidFormatException e) 
		{
			e.printStackTrace();
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for (int i = 0; i < sheet.getLastRowNum(); i++) 
		{
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) 
			{
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();

			}
		}
		return data;
	}


}
