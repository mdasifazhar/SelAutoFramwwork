package com.qa.core.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.core.base.Base;
import com.qa.core.utils.Utilities;

public class Search extends Base {

	WebDriver driver;


	@AfterClass
	public void tearDown() {
		driver.quit();
	}

	@Test(dataProvider = "SearchData")
	public void searchProduct(String search) {
		//initializeAndOpenBrowser();
		driver.findElement(By.name("search")).sendKeys(search);
		// driver.findElement(By.name("search")).sendKeys("HP");
		driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']/i")).click();
		String text = driver.findElement(By.linkText("HP LP3065")).getText();
		Assert.assertTrue(text.contains("HP LP3065"));
	}
	/*
	 * @DataProvider(name = "SearchData") public Object[][] supplyTestData() {
	 * Object[][] data= {{"HP","HP LP3065"},{"Apple","Apple Cinema 30"}}; return
	 * data; }
	 */

	@DataProvider(name = "SearchData")
	public Object[][] supplyTestData() {
		Object[][] data = Utilities.getDataFromExcelSheet("Search");
		return data;
	}
}
