package com.qa.core.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.qa.core.base.Base;
import com.qa.core.utils.Utilities;

public class LoginPage {
	WebDriver driver;
/*	
	public Login() {
		super();
	}
	WebDriver driver;

	@BeforeMethod
	public void setUp() {
		driver = initializeAndOpenBrower(confProp.getProperty("browser"));
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Login")).click();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	//@Test(priority = 2)
	public void loginWithValidCredentails() {

		driver.findElement(By.id("input-email")).sendKeys(confProp.getProperty("validEmail"));
		driver.findElement(By.id("input-password")).sendKeys(confProp.getProperty("validEmailPassword"));
		driver.findElement(By.xpath("//input[@type='submit']")).click();

		Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed(),
				"Account information not displayed");
		driver.quit();
	}

	//@Test(priority = 1)
	public void verifyLoginWithInValidCredentails() {
		WebDriverWait wait= new WebDriverWait(driver, null);
		driver.findElement(By.id("input-email")).sendKeys(Utilities.getEmailwithDate());
		driver.findElement(By.id("input-password")).sendKeys(dataProp.getProperty("invalidPassword"));
		driver.findElement(By.xpath("//input[@type='submit']")).click();

		String actualWarningMsg = driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']"))
				.getText();
		Assert.assertTrue(actualWarningMsg.contains("Warning: No match for E-Mail Address and/or Password."),
				"Warning message not displayed");
		driver.quit();
	}
*/
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="email")
	WebElement email;
	
	@FindBy(name = "password")
	WebElement password;
	
	@FindBy(xpath = "//div[contains(text(),'Login')]")
	WebElement loginBtn;
	
	@FindBy(xpath = "//a[contains(text(),\"Sign Up\")]")
	WebElement signUp;
	
	@FindBy(xpath = "//a[contains(text(),\"Forgot your password?\")]")
	WebElement forgotPassword;
	
	@FindBy(xpath = "//*[@id=\"container\"]/div/div[2]/span[1]")
	WebElement googleSignup;
	
	@FindBy(xpath = "//a[@href='https://ui.freecrm.com']")
	WebElement loginIcon;
	
	public String validateTitle() {
		return driver.getTitle();
	}
	
	public boolean validateGoogleSignUpLink() {
		return googleSignup.isDisplayed();
	}
	
	public HomePage login(String userName,String userPassword) {
		loginIcon.click();
		email.sendKeys(userName,Keys.ENTER);
		password.sendKeys(userPassword,Keys.ENTER);
		loginBtn.click();
		return new HomePage(driver);
	}
}
