package com.qa.core.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {

	WebDriver driver;
	public ContactsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[contains(text(),'Contacts')]")
	WebElement contactsLabel;

	@FindBy(xpath="//button[contains(text(),'Create')]")
	WebElement createContactsBtn;
	
	@FindBy(xpath="(//*[@id=\"dashboard-toolbar\"]//child::div[1]/span)[1]")
	WebElement createContactLabel;
	
	public boolean isContactLableDisplayed() {
		return contactsLabel.isDisplayed();
	}
	
	public void createContact() {
		createContactsBtn.click();		
	}
	
	public boolean isNewContactLabelDisplayed() {
		return createContactLabel.getText().equalsIgnoreCase("Create New Contact");
		
	}
}
