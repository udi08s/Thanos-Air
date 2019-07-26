package com.testingfoo.thanosair.pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.openqa.selenium.JavascriptExecutor;


public class FlightBookingPage {
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	@FindBy(xpath="//span[@class='qfa1-radiobutton__label-text'][contains(text(),'One way')]")
	private WebElement oneWayRadioButton ;
	
	@FindBy(xpath="//input[@id='typeahead-input-to']")
	private WebElement toField ;
	
	@FindBy(xpath="//input[@id='datepicker-input-departureDate']")
	private WebElement departDate ;
	
	@FindAll({@FindBy(xpath="//td[@class='date-picker__calendar-weekdays-items date-picker__calendar-weekdays-items--enabled']")})
	public List<WebElement> allValidDates;
	
	@FindBy(xpath="//button[@class='qfa1-submit-button__button'][contains(text(),'SEARCH FLIGHTS')]")
	public WebElement searchBtn;
	
	public FlightBookingPage(WebDriver driver) {
		this.driver=driver;
		this.wait= new WebDriverWait(driver, 360);
		PageFactory.initElements(driver, this);
	}
	
	public void clickOneWayButton() throws InterruptedException {
		
		Thread.sleep(5000);
		//this.wait.until(ExpectedConditions.elementToBeClickable(oneWayRadioButton));
		//this.oneWayRadioButton.click();
		
		JavascriptExecutor js= (JavascriptExecutor)driver;
		WebElement el=(WebElement) js.executeScript("return document.getElementById('oneway');"); //Click on Element
		js.executeScript("arguments[0].click();", el);
		
	}
	
	public void enterDestination(String location) {
		
		this.wait.until(ExpectedConditions.visibilityOf(toField));
		this.toField.sendKeys(location);
		
		WebElement element=driver.findElement(By.id("typeahead-list-item-to-list"));
		
		List<WebElement> listOfEntries=element.findElements(By.tagName("li"));
		
		System.out.println(listOfEntries.size());
		
		for(WebElement i:listOfEntries) {
			if(i.getText().contains(location)) {
				i.click();
			}
		}
		
	}
	
	public void selectDepartDateAfter15Days() throws InterruptedException {
		
		JavascriptExecutor js= (JavascriptExecutor)driver;
		WebElement el=(WebElement) js.executeScript("return document.getElementById('datepicker-input-departureDate');"); //Click on Element
		js.executeScript("arguments[0].click();", el);
		
		List<WebElement> allValidDates=this.allValidDates;
		
		//System.out.println(allValidDates.size());
		
		for (WebElement date : allValidDates) {
			if (date.getText().equals("15")) {
				date.click();
				break;
			}
		}
		
	}

	public void clickOnSearch() {
		// TODO Auto-generated method stub
		
		this.wait.until(ExpectedConditions.elementToBeClickable(searchBtn));
		this.searchBtn.click();
		
	}
	
	
		
	

}
