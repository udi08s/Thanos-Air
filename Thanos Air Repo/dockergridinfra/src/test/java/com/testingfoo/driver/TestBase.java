package com.testingfoo.driver;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {

	public WebDriver driver;
	public static Properties config = new Properties();
	public static FileInputStream fis;
	public String testurl;

	@BeforeSuite
	public void setup() {

		if (driver == null) {

			try {

				fis = new FileInputStream(
						System.getProperty("user.dir") + "//resources//properties//config.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				config.load(fis);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
			
	@BeforeMethod
	public void driversetup() {
		
			if (config.getProperty("os").equals("windows")) {
				if (config.getProperty("browser").equals("firefox")) {

					System.setProperty("webdriver.gecko.driver",
							System.getProperty("user.dir") + "//resources//executables//geckodriver-win64.exe");
					driver = new FirefoxDriver();
					driver.manage().window().maximize();

				}

				else if (config.getProperty("browser").equals("chrome")) {

					System.setProperty("webdriver.chrome.driver",
							System.getProperty("user.dir") + "//resources//executables//chromedriver-win.exe");
					driver = new ChromeDriver();
					driver.manage().window().maximize();
				}
			}

			if (config.getProperty("os").equals("mac")) {
				if (config.getProperty("browser").equals("firefox")) {

					System.setProperty("webdriver.gecko.driver",
							System.getProperty("user.dir") + "//resources//executables//geckodriver-mac");
					driver = new FirefoxDriver();
					driver.manage().window().maximize();
					driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

				}

				else if (config.getProperty("browser").equals("chrome")) {

					System.setProperty("webdriver.chrome.driver",
							System.getProperty("user.dir") + "//resources//executables//chromedriver-mac");
					driver = new ChromeDriver();
					driver.manage().window().maximize();
				}
			}

			testurl = config.getProperty("testsiteurl");

		}
	
	

	@AfterSuite
	public void tearDown() {

		try {
			
			driver.close();
			
			fis.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@AfterTest
	public void tearDownMethod() {

		try {
			
			driver.quit();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
