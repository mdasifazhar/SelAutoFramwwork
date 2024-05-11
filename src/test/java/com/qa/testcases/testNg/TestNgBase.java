package com.qa.testcases.testNg;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.qa.core.utils.Browser;
import com.qa.core.utils.Utilities;

public class TestNgBase {

	public static WebDriver driver;
	public Properties confProp;
	public Properties dataProp;

	// Pre-Conditions
	@BeforeSuite
	public void beforeTestSuite() {
		System.out.println("@BeforeSuite********");

		confProp = new Properties();
		dataProp = new Properties();
		try {
			String path = System.getProperty("user.dir")
					+ "\\src\\main\\java\\com\\qa\\core\\config\\config.properties";
			File confFile = new File(path);
			File dataFile = new File(
					System.getProperty("user.dir") + "\\src\\main\\java\\com\\qa\\core\\testdata\\testdata.properties");
			FileInputStream confFis = new FileInputStream(confFile);
			FileInputStream dataFis = new FileInputStream(dataFile);
			confProp.load(confFis);
			dataProp.load(dataFis);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("   @BeforeTest********");

	}

	@BeforeGroups
	public void beforeGroup() {
		System.out.println("     @BeforeGroups********");
	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("       @BeforeClass********");

		String browserName = "chrome";// confProp.getProperty("browser");
		System.out.println("BrowserName: " + browserName);
		if (browserName.equalsIgnoreCase(Browser.CHROME.name())) {
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase(Browser.EDGE.name())) {
			driver = new EdgeDriver();
		} else if (browserName.equalsIgnoreCase(Browser.FIREFOX.name())) {
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase(Browser.SAFARI.name())) {
			driver = new SafariDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utilities.IMPLICIT_WAIT_TIME));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Utilities.PAGE_LOAD_TIME_WAIT_TIME));
		// driver.get(confProp.getProperty("url"));
	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("         @BeforeMethod.........");
	}

	// Post-Conditions
	@AfterMethod
	public void afterMethod() {
		System.out.println("         @AfterMethod.........");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("       @AfterClass********");
		// driver.quit();
	}

	@AfterGroups
	public void afterGroups() {
		System.out.println("     @AfterGroups********");
	}

	@AfterTest
	public void afterTest() {
		System.out.println("   @AfterTest********");
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("@AfterSuite********");
	}

	public void takeScreenshot() {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrFile, new File("C:\\Users\\mdasi\\eclipse-workspace\\SelCoreFramework\\test-output\\"));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
