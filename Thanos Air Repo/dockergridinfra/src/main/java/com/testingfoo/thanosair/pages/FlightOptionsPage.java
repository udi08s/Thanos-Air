package com.testingfoo.thanosair.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlightOptionsPage {
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	@FindBy(xpath="//button[@class='button-add-bag trigger-modal']")
	private WebElement addBagsOption;
	
	@FindBy(xpath="//button[@class='btn right']")
	private WebElement BtnRight;
	
	@FindBy(xpath="//button[@id='bags-btn-continue']")
	private WebElement continueBtn;
	
	@FindBy(xpath="//navigation-ribbon-view-tac[@class='ng-tns-c108-78 ng-star-inserted']//button[@class='btn btn-primary btn-navigation e2e-btn-continue-tac']")
	private WebElement acceptBtn;
	
	public FlightOptionsPage(WebDriver driver) {
		this.driver=driver;
		this.wait= new WebDriverWait(driver, 20);
		PageFactory.initElements(driver, this);
	}

	public void selectAddBags(int number) throws InterruptedException {
		// TODO Auto-generated method stub
		
		Thread.sleep(7000);
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;

		jse.executeScript("scroll(0, 2500)");
		
		Thread.sleep(3000);
		
		this.wait.until(ExpectedConditions.elementToBeClickable(addBagsOption));
		
		//this.addBagsOption.click();
		
		Actions actionsTwo = new Actions(driver);
		JavascriptExecutor jseTwo = (JavascriptExecutor) driver;
		actionsTwo.moveToElement(addBagsOption).click();
		jseTwo.executeScript("arguments[0].click()", addBagsOption);
		
		int count=1;
		while(count<number) {
			
			this.wait.until(ExpectedConditions.elementToBeClickable(this.BtnRight));
			this.BtnRight.click();
			count++;
			
		}
		
		this.continueBtn.click();
		
		this.wait.until(ExpectedConditions.elementToBeClickable(acceptBtn));
		this.acceptBtn.click();
		
		System.out.println(" Selected "+ count+ " of bags");
	}
	

}
