package com.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.core.base.Base;
import com.qa.core.pages.ContactsPage;
import com.qa.core.pages.HomePage;
import com.qa.core.pages.LoginPage;

public class ContactsPageTest extends Base {

	ContactsPage contactPage;
	LoginPage loginPage;
	HomePage homePage;

	@BeforeMethod
	public void setUp() {
		loginPage = new LoginPage(driver);
		homePage = loginPage.login(confProp.getProperty("userEmail"), confProp.getProperty("userPassword"));
		contactPage = homePage.navigateToContactsPage(driver);
	}

	@Test(priority = 1)
	public void validateContactLabel() {
		Assert.assertTrue(contactPage.isContactLableDisplayed(), "Contact Lable not displayed");
		homePage.logout();
	}

	@Test(priority = 2)
	public void createContacts() {
		contactPage.createContact();
		Assert.assertTrue(contactPage.isNewContactLabelDisplayed(), "New Contact Label not dispalyed");
		homePage.logout();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
