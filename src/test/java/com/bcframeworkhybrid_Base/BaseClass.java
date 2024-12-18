package com.bcframeworkhybrid_Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.bcframeworkhybrid.utilities.PropertiesReader;

public class BaseClass {

	protected WebDriver driver;
	private PropertiesReader propertiesReader;

	@BeforeMethod
	public void setup() {
		// WebDriverManager.chromedriver().setup();
		System.setProperty("webdriver.chrome.driver", "C:\\Automation\\chromedriver-win32\\chromedriver.exe");
		propertiesReader = new PropertiesReader("C:\\Users\\HP-laptop\\eclipse-workspace\\BootCampFramworkHybrid-Mamdouh-mmosman74\\src\\test\\java\\bctestdata.properties");

		// Initialize WebDriver with increased timeout settings
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get(propertiesReader.getProperty("url"));
	}

	@AfterMethod
	public void teardown() {
		if (driver != null) {
			driver.quit();
		}
	}
}
