package com.testingfoo.thanosair.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlightPointsPage {
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	@FindBy(xpath="//button[@id='btn-continue']")
	private WebElement continueBtn;
	
	@FindBy(xpath="//li[@class='done ng-star-inserted']//span[@class='c-indicator']")
	private WebElement flightSuccess;
	
	@FindBy(xpath="//button[@id='btn-accept']")
	private WebElement fareConditionAcceptBtn;
	
	private By whyBookQantasText=By.xpath("/*[contains(text(),'Why book on qantas.com?)]");
	
	public FlightPointsPage(WebDriver driver) {
		this.driver=driver;
		this.wait= new WebDriverWait(driver, 20);
		PageFactory.initElements(driver, this);
	}
	
	public void clickContinueBtn() throws InterruptedException {
		
		Thread.sleep(14000);
		//this.wait.until(ExpectedConditions.invisibilityOfElementLocated(whyBookQantasText));
		//this.wait.until(ExpectedConditions.invisibilityOf(element));
		this.wait.until(
		          webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
		this.wait.until(ExpectedConditions.visibilityOf(continueBtn));
		this.wait.until(ExpectedConditions.elementToBeClickable(continueBtn));
		this.continueBtn.click();
		
	}

	public void acceptFareCondition() {
		// TODO Auto-generated method stub
		
		this.wait.until(ExpectedConditions.elementToBeClickable(fareConditionAcceptBtn));
		this.fareConditionAcceptBtn.click();
		
	}
}
