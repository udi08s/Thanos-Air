package com.testingfoo.commonutils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverManager {
	
	public static WebDriver driver;
	public static Properties config = new Properties();
	public static FileInputStream fis;
	public String testurl;
	
	public static WebDriver getDriver() {
		
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
		
		if (config.getProperty("os").equals("windows")) {
			if (config.getProperty("browser").equals("firefox")) {

				System.setProperty("webdriver.gecko.driver",
						System.getProperty("user.dir") + "//resources//executables//geckodriver-win64.exe");
				driver = new FirefoxDriver();
				driver.manage().window().maximize();

			}

			else if (config.getProperty("browser").equals("chrome")) {

				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") + "//resources//executables//chromedriver.exe");
				driver = new ChromeDriver();
				driver.manage().window().maximize();
			}
		}

		if (config.getProperty("os").equals("mac")) {
			if (config.getProperty("browser").equals("firefox")) {

				System.setProperty("webdriver.gecko.driver",
						System.getProperty("user.dir") + "//resources//executables//geckodriver");
				driver = new FirefoxDriver();
				driver.manage().window().maximize();

			}

			else if (config.getProperty("browser").equals("chrome")) {

				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") + "//resources//executables//chromedriver");
				driver = new ChromeDriver();
				driver.manage().window().maximize();
			}
		}
		
		return driver;
	}

}
