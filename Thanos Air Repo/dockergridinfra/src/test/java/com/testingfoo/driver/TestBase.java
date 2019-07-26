package com.testingfoo.driver;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;


public class TestBase {
	

	public WebDriver driver;

	
	@BeforeSuite
	public void setup() {

		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "//resources//executables//chromedriver");

		this.driver = new ChromeDriver();

		this.driver.manage().window().maximize();

	}

	
	
	@AfterSuite
	public void tearDown() {
		
		if(driver!=null) {
			driver.quit();
		}

	}
}
