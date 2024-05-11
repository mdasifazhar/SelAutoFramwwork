package com.qa.testcases.testNg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNgClass extends TestNgBase {

	@Test(priority = 1,groups = {"A","B"})
	public void testa() {
		System.out.println("             Calling test-a");
		//WebElement elt=driver.findElement(By.xpath("//a/span]/following-sibling::span"));
		//System.out.println(elt.isDisplayed());
	}

	@Test(priority = 2,groups = {"B"})
	public void testb() {
		System.out.println("             Calling test-b");
	}

	@Test(priority = 3,groups = {"A","B"} )
	public void testc() {
		Assert.assertFalse(false);
		System.out.println("             Calling test-c");
	}
}
