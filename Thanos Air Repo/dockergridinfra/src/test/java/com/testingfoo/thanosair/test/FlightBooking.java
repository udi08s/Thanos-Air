package com.testingfoo.thanosair.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.testingfoo.driver.TestBase;
import com.testingfoo.thanosair.pages.FlightBookingPage;
import com.testingfoo.thanosair.pages.FlightOptionsPage;
import com.testingfoo.thanosair.pages.FlightPointsPage;
import com.testingfoo.thanosair.pages.FlightSelectionPage;
import com.testingfoo.thanosair.pages.HomePage;

public class FlightBooking extends TestBase{
	
	private int bagsize = 1;
	
	@BeforeMethod
	public void setupMethod() {
		
		HomePage homePage = new HomePage(driver);
		
		homePage.goToUrl(testurl);
		
		System.out.println(" Launched the Site");
		
	} 


	@Test(dataProvider = "bagsCount")
	public void launchTest(String count) throws InterruptedException {
		
		bagsize = Integer.parseInt(count);

		FlightBookingPage flightBookingPage = new FlightBookingPage(driver);
		
		flightBookingPage.enterDestination("BNE");
		
		flightBookingPage.clickOneWayRadioButton();
		
		flightBookingPage.selectDepartDateAfter15Days();
		
		flightBookingPage.clickOnSearch();
		
		System.out.println("Flight Search Successful");

		FlightSelectionPage flightSelectionPage = new FlightSelectionPage(driver);

		Assert.assertTrue(flightSelectionPage.getSubTotalValue().equals("$0"), "SubTotal is $0");
		
		System.out.println("Subtotal value is $0 before selecting the deal");

		String redValueSelected = flightSelectionPage.selectRed_eDeal();

		flightSelectionPage.clickAddToTrip();

		Assert.assertTrue(flightSelectionPage.getSubTotalValue().contains(redValueSelected),
				"Correct red eValue is selected");
		
		System.out.println("Subtotal value has changed after selecting the red deal");

		flightSelectionPage.clickContinueBtn();

		FlightPointsPage flightPointsPage = new FlightPointsPage(driver);

		flightPointsPage.clickContinueBtn();

		flightPointsPage.acceptFareCondition();

		FlightOptionsPage flightOptionsPage = new FlightOptionsPage(driver);

		flightOptionsPage.clickAddBags();
		
		flightOptionsPage.selectAddBags(bagsize);
		

	}
	
	@AfterMethod
	public void tearDownMethod() {
		
		driver.close();
		
	} 

	@DataProvider(name = "bagsCount")
	public static Object[][] dataProviderMethod() {
		return new Object[][] { { "1" }, { "2" }, { "3" }, { "4" }, { "5" } };
	}

	

}
