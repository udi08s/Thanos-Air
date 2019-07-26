package com.testingfoo.thanosair.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.testingfoo.driver.TestBase;
import com.testingfoo.thanosair.pages.FlightBookingPage;
import com.testingfoo.thanosair.pages.FlightOptionsPage;
import com.testingfoo.thanosair.pages.FlightPointsPage;
import com.testingfoo.thanosair.pages.FlightSelectionPage;
import com.testingfoo.thanosair.pages.HomePage;

public class FlightBooking{

	private WebDriver driver;
	private int bagsize = 1;

	@BeforeMethod
	public void setup() {
		
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "//resources//executables//chromedriver");

		this.driver = new ChromeDriver();

		this.driver.manage().window().maximize();
		
	} 
	

	@Test(dataProvider = "bagsCount")
	public void launchTest(String count) throws InterruptedException {

		HomePage homePage = new HomePage(driver);

		homePage.goToUrl();
		
		bagsize = Integer.parseInt(count);

		FlightBookingPage flightBookingPage = new FlightBookingPage(driver);

		Thread.sleep(5000);

		flightBookingPage.enterDestination("Brisbane");

		Thread.sleep(5000);

		flightBookingPage.clickOneWayButton();

		Thread.sleep(5000);

		flightBookingPage.selectDepartDateAfter15Days();

		Thread.sleep(5000);

		flightBookingPage.clickOnSearch();

		FlightSelectionPage flightSelectionPage = new FlightSelectionPage(driver);

		Assert.assertTrue(flightSelectionPage.getSubTotalValue().equals("$0"), "SubTotal is $0");

		String redValueSelected = flightSelectionPage.selectRed_eDeal();

		flightSelectionPage.clickAddToTrip();

		Assert.assertTrue(flightSelectionPage.getSubTotalValue().contains(redValueSelected),
				"Correct red eValue is selected");

		flightSelectionPage.clickContinueBtn();

		FlightPointsPage flightPointsPage = new FlightPointsPage(driver);

		flightPointsPage.clickContinueBtn();

		flightPointsPage.acceptFareCondition();

		FlightOptionsPage flightOptionsPage = new FlightOptionsPage(driver);

		flightOptionsPage.selectAddBags(bagsize);

	}

	@DataProvider(name = "bagsCount")
	public static Object[][] dataProviderMethod() {
		return new Object[][] { { "1" }, { "2" }, { "3" }, { "4" }, { "5" } };
	}

	@AfterMethod
	public void tearDown() {
	
		driver.close();
		
	}

}
