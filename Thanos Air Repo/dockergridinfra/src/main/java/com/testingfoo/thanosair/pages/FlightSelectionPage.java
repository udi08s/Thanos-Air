package com.testingfoo.thanosair.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlightSelectionPage {
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	@FindBy(xpath="//cart-subtotal-row[@class='price-row e2e-cash-amount ng-star-inserted']//span[@class='text-right amount']")
	private WebElement subTotalValue;
	
	@FindAll({@FindBy(xpath="//div[starts-with(@class,'fare-cell fare_AUAURED1JQ idx_0')]//label[@class='fare-head']")})
	private List<WebElement> allRedDeals;
	
	@FindBy(xpath="//span[contains(text(),'Add to Trip')]")
	private WebElement addToTripBtn;
	
	@FindBy(xpath="//div[starts-with(@class,'ng-tns-c64')]//div")
	private WebElement dealAmount;
	
	
	@FindBy(xpath="//button[@id='btn-continue']")
	private WebElement continueBtn;
	
	
	public FlightSelectionPage(WebDriver driver) {
		this.driver=driver;
		this.wait= new WebDriverWait(driver, 360);
		PageFactory.initElements(driver, this);
	}
	
	public String getSubTotalValue() {
		
		this.wait.until(ExpectedConditions.visibilityOf(subTotalValue));
		return this.subTotalValue.getText();
	}

	public String selectRed_eDeal() throws InterruptedException {
		// TODO Auto-generated method stub
		
		this.wait.until(ExpectedConditions.visibilityOfAllElements(allRedDeals));
		
		this.allRedDeals.get(0).click();
		
		this.wait.until(ExpectedConditions.visibilityOf(dealAmount));
		
		//Thread.sleep(5000);
		
		return this.dealAmount.getText();
				
		
	}
	
	public void clickAddToTrip() {
		
		this.wait.until(ExpectedConditions.elementToBeClickable(subTotalValue));
		
		this.addToTripBtn.click();
	}
	
	public void clickContinueBtn() {
		
		this.wait.until(ExpectedConditions.elementToBeClickable(continueBtn));
		
		this.continueBtn.click();
	}
	

}
