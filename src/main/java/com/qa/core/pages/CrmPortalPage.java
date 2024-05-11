package com.qa.core.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.core.base.Base;

public class CrmPortalPage{
	WebDriver driver;
	public CrmPortalPage(WebDriver driver) {
		this.driver =driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//a[@href='https://ui.freecrm.com']")
	WebElement loginIcon;
	
	@FindBy(xpath = "//span[contains(text(),\"sign up\")]")
	WebElement signupIcon;
	
	public String validateTitle() {
		return driver.getTitle();
	}
	
	public LoginPage clickLoginIcon() {
		loginIcon.click();
		return new LoginPage(driver);
	}
	
	public LoginPage clickSignUpIcon() {
		signupIcon.click();
		return new LoginPage(driver);
	}

}
