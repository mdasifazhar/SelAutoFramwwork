package com.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.core.base.Base;
import com.qa.core.pages.HomePage;
import com.qa.core.pages.LoginPage;

public class LoginPageTest extends Base{
	LoginPage loginPage;
	HomePage homePage;
	
	@BeforeMethod
	public void setup() {
		loginPage = new LoginPage(driver);
	}
	
	@Test(priority = 1)
	public void login() {
		homePage= loginPage.login(confProp.getProperty("userEmail"), confProp.getProperty("userPassword"));
		String title=homePage.validateTitle();
		Assert.assertTrue(title.equalsIgnoreCase("Cogmento CRM"),"Home Page Title do not displayed");
		homePage.logout();
	}

	@AfterMethod
	public void tearDown() {
		closeFiles();
		closeBrowser();
	}
}
