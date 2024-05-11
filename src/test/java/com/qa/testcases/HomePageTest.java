package com.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.core.base.Base;
import com.qa.core.pages.HomePage;
import com.qa.core.pages.LoginPage;

public class HomePageTest extends Base {
	HomePage homePage;
	LoginPage loginPage;

	@BeforeMethod
	public void setup() {
		loginPage = new LoginPage(driver);
		homePage = loginPage.login(confProp.getProperty("userEmail"), confProp.getProperty("userPassword"));
	}

	@Test(priority = 1)
	public void validateLeftNavigationTest() {
		Assert.assertTrue(homePage.validateLeftNavigation(), "Left Navigation not displayed on Home page");
		homePage.logout();

	}

	@Test(priority = 2)
	public void userNameTest() {
		Assert.assertTrue(homePage.verifyUserName(), "User Name Label not dispalyed on Home Page");
		homePage.logout();
	}
	
	@Test(priority = 3)
	public void validateHomePageTitle() {
		Assert.assertTrue("Cogmento CRM".equalsIgnoreCase(homePage.validateTitle()), "Home Page title not displayed.");
		homePage.logout();
	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}

}