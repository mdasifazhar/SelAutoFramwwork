package com.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.core.base.Base;
import com.qa.core.pages.CrmPortalPage;
import com.qa.core.pages.LoginPage;

public class CrmPortalPageTest extends Base {
	CrmPortalPage crmPortalPage;
	LoginPage loginPage;

	@BeforeMethod
	public void setUp() {
		crmPortalPage = new CrmPortalPage(driver);
	}

	@Test(priority = 1)
	public void validateCrmPotalMainPage() {
		String title = crmPortalPage.validateTitle();
		Assert.assertTrue(title.equalsIgnoreCase("#1 Free CRM Power Up your Entire Business Free Forever"),
				"Page Title does not dispayed");
	}

	@Test(priority = 2)
	public void navigateToLoginPage() {
		loginPage = crmPortalPage.clickLoginIcon();

		String title = loginPage.validateTitle();
		Assert.assertTrue(title.equalsIgnoreCase("Cogmento CRM"), "Login page title not displayed");
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
