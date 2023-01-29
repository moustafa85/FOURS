package caughtInDetection.Pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;

import fours.utils.AllMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import fours.base.BasePage;

public class AddCollisionZone extends BasePage{
AllMethods allMethods;
	public AddCollisionZone() throws IOException {
		super();
		PageFactory.initElements(driver, this);
		allMethods = new AllMethods(driver);
	}
	
	@FindBy(xpath = "//a[@href='/caughtInDetection']")
	WebElement caughtIn;
	
	public void CaughtIn() {

		allMethods.VerifyElementDisplay(caughtIn);
		caughtIn.click();
	}
	
	@FindBy(xpath = "//div[@role='tab'][contains(.,'Manage')]")
	WebElement manage;
	
	public void Manage() {

		allMethods.VerifyElementDisplay(manage);
		manage.click();
	}
	
	@FindBy(xpath = "//button[@type='button'][contains(.,'Add Collision Zone')]")
	WebElement addButton;
	
	public void AddButton() {
		allMethods.VerifyElementDisplay(addButton);
		addButton.click();
	}
	
	@FindBy(xpath = "//input[@placeholder='Please enter Name'][contains(@id,'name')]")
	WebElement name;
	
	public void Name(String CollisionName) throws InterruptedException {
		allMethods.VerifyElementDisplay(name);
		name.sendKeys(CollisionName);

	}
	
	@FindBy(xpath = "//input[@id='basic_allowedWorkers']")
	WebElement allowedWorker;
	
	public void allowedWorker(String worker) throws InterruptedException, AWTException {
		allMethods.VerifyElementDisplay(allowedWorker);
		allowedWorker.sendKeys(worker);
		Thread.sleep(1000);
		Robot rb = new Robot();
		rb.keyPress(KeyEvent.VK_ENTER);
		
	}
	
	@FindBy(xpath = "//textarea[contains(@class,'ant-input')]")
	WebElement mapArea;
	
	public void mapArea(String areaPoints) throws InterruptedException {
		allMethods.VerifyElementDisplay(mapArea);
		mapArea.sendKeys(areaPoints);
		Thread.sleep(1000);
		
	}
	
	@FindBy(xpath = "(//span[contains(.,'Add Collision Zone')])[2]")
	WebElement addCollisionZone;
	
	public void AddCollisionZone() {
		allMethods.VerifyElementDisplay(addCollisionZone);
		addCollisionZone.click();
	}
	
	

}
