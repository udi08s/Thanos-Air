package com.testingfoo.stepfiles;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import com.testingfoo.commonutils.ConfigLoader;
import com.testingfoo.commonutils.DriverManager;
import com.testingfoo.thanosair.pages.FlightBookingPage;
import com.testingfoo.thanosair.pages.FlightOptionsPage;
import com.testingfoo.thanosair.pages.FlightPointsPage;
import com.testingfoo.thanosair.pages.FlightSelectionPage;
import com.testingfoo.thanosair.pages.HomePage;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class FlightBookingBDD {
	
	public WebDriver driver;
	public static Properties config = new Properties();
	public static FileInputStream fis;
	public String testurl;
	public int bagsize = 1;
	
	public HomePage homePage;
	public FlightBookingPage flightBookingPage;
	public FlightSelectionPage flightSelectionPage;
	public FlightPointsPage flightPointsPage;
	public FlightOptionsPage flightOptionsPage;
	String rededealValue="";
	
	
@Before()
public void setup() {
	
	config=ConfigLoader.getConfigDetails();
	driver=DriverManager.getDriver();
	testurl = config.getProperty("testsiteurl");
	
	homePage = new HomePage(driver);
	flightBookingPage = new FlightBookingPage(driver);
	flightSelectionPage = new FlightSelectionPage(driver);
	flightPointsPage = new FlightPointsPage(driver);
	flightOptionsPage = new FlightOptionsPage(driver);
	
	
}
	

@Given("^User navigates to qantas website$")
public void user_navigates_to_qantas_website()  {
    // Write code here that turns the phrase above into concrete actions
    
	HomePage homePage = new HomePage(driver);
	
	homePage.goToUrl(testurl);
	
	System.out.println(" Launched the Site");
	
}

@Given("^User selects the destination$")
public void user_selects_the_destination() throws Throwable {
    // Write code here that turns the phrase above into concrete actions

	
	flightBookingPage.enterDestination("BNE");
}

@Given("^User selects dates$")
public void user_selects_dates() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	flightBookingPage.selectDepartDateAfter15Days();
	
}
@Given("^User selects One way Option$")
public void user_selects_One_way_Option() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	flightBookingPage.clickOneWayRadioButton();
}

@When("^User clicks on Search$")
public void user_clicks_on_Search() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	flightBookingPage.clickOnSearch();
}

@Then("^User should be taken to the search page$")
public void user_should_be_taken_to_the_search_page() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	System.out.println("Flight Search Successful");
	
	Assert.assertTrue(flightSelectionPage.getSubTotalValue().equals("$0"), "SubTotal is $0");
	
	System.out.println("Subtotal value is $0 before selecting the deal");
	
}

@Given("^User selects Red e-deal$")
public void user_selects_Red_e_deal() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    
	rededealValue = flightSelectionPage.selectRed_eDeal();
	
}

@When("^user selects add trip$")
public void user_selects_add_trip() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    
	flightSelectionPage.clickAddToTrip();
}

@Then("^SubTotal Value should be Zero$")
public void subtotal_Value_should_be_Zero() throws Throwable {

	

	
    // Write code here that turns the phrase above into concrete actions
    
	Assert.assertTrue(flightSelectionPage.getSubTotalValue().contains(rededealValue),
			"Correct red eValue is selected");
	
	System.out.println("Subtotal value has changed after selecting the red deal");
}

@Given("^User clicks on continue button in flight selection page$")
public void user_clicks_on_continue_button_in_flight_selection_page() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	flightSelectionPage.clickContinueBtn();
}

@Given("^User clicks on continue button in flight points page$")
public void user_clicks_on_continue_button_in_flight_points_page() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	flightPointsPage.clickContinueBtn();

	
}

@Given("^User clicks on Accept Fare button in the fare condition page$")
public void user_clicks_on_Accept_Fare_button_in_the_fare_condition_page() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	flightPointsPage.acceptFareCondition();
}

@When("^User selects Add Bags option in the Flight Options page$")
public void user_selects_Add_Bags_option_in_the_Flight_Options_page() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	flightOptionsPage.clickAddBags();
}

@Then("^User should be able to additional baggage to the journey$")
public void user_should_be_able_to_additional_baggage_to_the_journey() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	flightOptionsPage.selectAddBags(1);
}

@Then("^User should be able to add \"([^\"]*)\" additional baggage to the journey$")
public void user_should_be_able_to_add_additional_baggage_to_the_journey(String numberOf) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    int size=Integer.parseInt(numberOf);
	flightOptionsPage.selectAddBags(size);
	
}


@After()
public void tearDown() throws IOException {
	
	driver.close();
	
	
}



}
