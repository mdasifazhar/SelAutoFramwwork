package com.qa.core.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.core.base.Base;
import com.qa.core.utils.Utilities;

public class Registration extends Base {
	public Registration() {
		super();
	}

	WebDriver driver;

	@BeforeMethod
	public void setUp() {
		//initializeAndOpenBrowser();
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Register")).click();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	//@Test(priority = 2)
	public void verifyAccountwithExsitingEmail() {
	driver.findElement(By.id("input-firstname")).sendKeys("Bob");
	driver.findElement(By.id("input-lastname")).sendKeys("Beilly");
	driver.findElement(By.id("input-email")).sendKeys("mdasifazhar125123115137@gmail.com");
	driver.findElement(By.id("input-telephone")).sendKeys("9125671230");
	driver.findElement(By.id("input-password")).sendKeys("12345@6");
	driver.findElement(By.id("input-confirm")).sendKeys("12345@6");
	driver.findElement(By.xpath("//input[@name='agree']")).click();
	driver.findElement(By.xpath("//input[@type='submit']")).click();
	String actualMessage=driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText();
	Assert.assertTrue(actualMessage.contains("Warning: E-Mail Address is already registered!"),"Acoount is already Registed with given Email");
	}

	//@Test(priority = 1)
	public void verifyRegistrationWithMandatoryField() {

		driver.findElement(By.xpath("//input[@name='agree']")).click();
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		String actualMessageFirstName=driver.findElement(By.xpath("//input[@id='input-firstname']/following-sibling::div")).getText();
		Assert.assertTrue(actualMessageFirstName.equals("First Name must be between 1 and 32 characters!"));
	
		String actualMessageLastName=driver.findElement(By.xpath("//input[@id='input-lastname']/following-sibling::div")).getText();
		Assert.assertTrue(actualMessageLastName.equals("Last Name must be between 1 and 32 characters!"));
		
		
		String actualMessageEmail=driver.findElement(By.xpath("//input[@id='input-email']/following-sibling::div")).getText();
		Assert.assertTrue(actualMessageEmail.equals("E-Mail Address does not appear to be valid!"));
		
		String actualMessageTelphone=driver.findElement(By.xpath("//input[@id='input-telephone']/following-sibling::div")).getText();
		Assert.assertTrue(actualMessageTelphone.equals("Telephone must be between 3 and 32 characters!"));
		
		String actualMessagePassword=driver.findElement(By.xpath("//input[@id='input-password']/following-sibling::div")).getText();
		Assert.assertTrue(actualMessagePassword.equals("Password must be between 4 and 20 characters!"));
		
	}
	
	//@Test(priority = 3)
	public void registerUser() {
		driver.findElement(By.id("input-firstname")).sendKeys("Bob");
		driver.findElement(By.id("input-lastname")).sendKeys("Minizela");
		driver.findElement(By.id("input-email")).sendKeys(Utilities.getEmailwithDate());
		driver.findElement(By.id("input-telephone")).sendKeys("9123874560");
		driver.findElement(By.id("input-password")).sendKeys("1234@5");
		driver.findElement(By.id("input-confirm")).sendKeys("1234@5");
		driver.findElement(By.xpath("//input[@name='agree']")).click();
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		String actualMessage=driver.findElement(By.id("content")).getText();
		Assert.assertTrue(actualMessage.contains("Your Account Has Been Created!"),"Registration message not displayed");
	}

}
