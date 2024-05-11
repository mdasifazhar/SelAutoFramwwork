package com.qa.testcases.testNg.parameter;

import org.openqa.selenium.By;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qa.testcases.testNg.TestNgBase;

public class YahooLoginTest extends TestNgBase {

	@Parameters({"baseurl","email"})
	@Test
	public void loginToYahoo(String baseurl,String email) {
		driver.get(baseurl);
		driver.findElement(By.xpath("//div/a[contains(text(),'Sign in')]")).click();
		driver.findElement(By.id("login-username")).sendKeys(email);
		driver.findElement(By.id("login-signin")).click();

	}

	@Test(enabled = false)
	public void testOne() {
		System.out.println("             One");
	}

	@Test(enabled = false)
	public void testTwo() {
		System.out.println("             Two");
	}

	@Test(enabled = false)
	public void testThree() {
		System.out.println("             Three");
	}

}
