package com.qa.core.test;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestAutomation {
	WebDriver driver;
	
	@BeforeTest
	public void openBrwser() {
		ChromeOptions option = new ChromeOptions();
		option.setAcceptInsecureCerts(true);
		option.addArguments("--start-maximized");//--headless --user-data-dir
		driver = new ChromeDriver(option);	
		
	}
	@Test
	public void openWebrestaurantStoreWebsite() throws Exception{
		
		driver.get("https://www.selenium.dev/selenium/web/web-form.html");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		//driver.manage().window().fullscreen();
		Thread.sleep(5000);
		Assert.assertTrue(driver.getTitle().contains("Web form"));
		
	}
	@Test
	public void fillForm() throws Exception{
		driver.get("https://www.selenium.dev/selenium/web/web-form.html");
		driver.manage().window().fullscreen();
		driver.switchTo().alert();
		WebElement elt= driver.findElement(By.id("my-text-id"));
		elt.sendKeys("Hello");
		//Thread.sleep(5000);
		//WebElement submit=driver.findElement(By.cssSelector("Button"));
		//submit.click();
		//WebElement confirmationPage=driver.findElement(By.className("display-6"));
		//Assert.assertTrue(confirmationPage.getText().equals("Form submitted"));
		
	}
	
	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}

}
