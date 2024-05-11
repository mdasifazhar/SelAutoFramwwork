package com.qa.core.pages;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	public HomePage(WebDriver driver) {
		this.driver =driver;
		PageFactory.initElements(driver, this);
	}

	List<String> leftNavList = Arrays.asList("Home", "Calendar", "Contacts", "Companies", "Deals", "Tasks", "Cases",
			"Calls", "Documents", "Email", "Campaigns", "Forms", "Reports");

	@FindAll({ @FindBy(xpath = "(//div[@id='ui']//following-sibling::span[@class='item-text'])[1]"),
			@FindBy(xpath = "(//div[@id='ui']//following-sibling::span[@class='item-text'])[2]"),
			@FindBy(xpath = "(//div[@id='ui']//following-sibling::span[@class='item-text'])[3]"),
			@FindBy(xpath = "(//div[@id='ui']//following-sibling::span[@class='item-text'])[4]"),
			@FindBy(xpath = "(//div[@id='ui']//following-sibling::span[@class='item-text'])[5]"),
			@FindBy(xpath = "(//div[@id='ui']//following-sibling::span[@class='item-text'])[6]"),
			@FindBy(xpath = "(//div[@id='ui']//following-sibling::span[@class='item-text'])[7]"),
			@FindBy(xpath = "(//div[@id='ui']//following-sibling::span[@class='item-text'])[8]"),
			@FindBy(xpath = "(//div[@id='ui']//following-sibling::span[@class='item-text'])[9]"),
			@FindBy(xpath = "(//div[@id='ui']//following-sibling::span[@class='item-text'])[10]"),
			@FindBy(xpath = "(//div[@id='ui']//following-sibling::span[@class='item-text'])[11]"),
			@FindBy(xpath = "(//div[@id='ui']//following-sibling::span[@class='item-text'])[12]"),
			@FindBy(xpath = "(//div[@id='ui']//following-sibling::span[@class='item-text'])[13]") })
	List<WebElement> leftNavigations;
	
	@FindBy(xpath = "//span[contains(text(),'Asif Azhar')]")
	WebElement userNameLabel;

	@FindBy(xpath = "//div[@role='listbox']")
	WebElement settingDropDown;

	@FindBy(xpath = "//*[@id='ui']//child::span[contains(text(),'Deals')]")
	WebElement dealsPageLink;

	@FindBy(xpath = "//*[@id='ui']//child::span[contains(text(),'Contacts')]")
	WebElement contactsPageLink;

	@FindBy(xpath = "//*[@id='ui']//child::span[contains(text(),'Tasks')]")
	WebElement tasksPageLink;

	@FindBy(xpath = "//span[contains(text(),'Log Out')]")
	WebElement logout;

	public String validateTitle() {
		return driver.getTitle();
	}

	public boolean validateLeftNavigation() {
		for (WebElement elt : leftNavigations)
			if (!leftNavList.contains(elt.getText()))
				return false;
		return true;
	}

	public ContactsPage navigateToContactsPage(WebDriver driver) {
		contactsPageLink.click();
		return new ContactsPage(driver);
	}

	public DealsPage navigateToDealsPage() {
		dealsPageLink.click();
		return new DealsPage();
	}

	public TasksPage navigateToTasksPage() {
		tasksPageLink.click();
		return new TasksPage();
	}
	
	public boolean verifyUserName() {
		return userNameLabel.isDisplayed();
	}

	public void logout() {
		settingDropDown.click();
		logout.click();
	}

}
