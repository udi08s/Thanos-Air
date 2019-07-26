package com.testingfoo.thanosair.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	@FindBy(xpath="//a[@id='panel-book-a-trip']")
	private WebElement bookATripLabel ;
	
	@FindBy(xpath="//a[@id='panel-flights']")
	private WebElement flightLink ;
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		this.wait= new WebDriverWait(driver, 360);
		PageFactory.initElements(driver, this);
	}
	
	public void goToUrl() {
		this.driver.get("https://www.qantas.com/au/en.html");
		this.wait.until(ExpectedConditions.visibilityOf(bookATripLabel));
	}
	
	public void clickFlightBooking() {
		
		this.wait.until(ExpectedConditions.visibilityOf(flightLink));
		this.flightLink.click();
		
	}
	

}
