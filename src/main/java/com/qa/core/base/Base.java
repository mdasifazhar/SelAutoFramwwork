package com.qa.core.base;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.qa.core.utils.Browser;
import com.qa.core.utils.Utilities;

public class Base {

	public static ThreadLocal<WebDriver> threadLocal = new ThreadLocal<>();
	public static WebDriver driver;
	protected Properties confProp;
	protected Properties dataProp;
	private File confFile;
	private File dataFile ;
	private FileInputStream confFis ;
	private FileInputStream dataFis;
	public Base() {
		loadPropertyfiles();
		initializeAndOpenBrowser();
	}

	private void loadPropertyfiles() {
		confProp = new Properties();
		dataProp = new Properties();
		try {
			String path = System.getProperty("user.dir")
					+ "\\src\\main\\java\\com\\qa\\core\\config\\config.properties";
			confFile = new File(path);
			dataFile = new File(
					System.getProperty("user.dir") + "\\src\\main\\java\\com\\qa\\core\\testdata\\testdata.properties");
			confFis = new FileInputStream(confFile);
			dataFis = new FileInputStream(dataFile);
			confProp.load(confFis);
			dataProp.load(dataFis);
			initializeAndOpenBrowser();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void initializeAndOpenBrowser() {
		String browserName = confProp.getProperty("browser");
		driver = getDriver(browserName);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utilities.IMPLICIT_WAIT_TIME));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Utilities.PAGE_LOAD_TIME_WAIT_TIME));
		driver.get(confProp.getProperty("url"));

	}

	private static WebDriver getDriver(String browserName) {
		if (threadLocal.get() == null) {
			if (browserName.equalsIgnoreCase(Browser.CHROME.name())) {
				driver = new ChromeDriver();
				threadLocal.set(driver);

			} else if (browserName.equalsIgnoreCase(Browser.EDGE.name())) {
				driver = new EdgeDriver();
				threadLocal.set(driver);
			} else if (browserName.equalsIgnoreCase(Browser.FIREFOX.name())) {
				driver = new FirefoxDriver();
				threadLocal.set(driver);
			} else if (browserName.equalsIgnoreCase(Browser.SAFARI.name())) {
				driver = new SafariDriver();
				threadLocal.set(driver);
			}
		}
		return threadLocal.get();
	}

	public void tearDown() {
		driver = null;
	}
	
	public void closeBrowser() {
		Base.threadLocal.get().close();
		driver.quit();
	}
	public void closeFiles() {
		try {
			confFis.close();
			dataFis.close();
			dataProp.clear();
			confProp.clear();
		}catch(Exception e) {
			System.out.println("Error closing file");
		}
	}
}
