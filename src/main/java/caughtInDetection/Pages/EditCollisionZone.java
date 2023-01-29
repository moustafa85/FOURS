package caughtInDetection.Pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;

import fours.utils.AllMethods;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import fours.base.BasePage;

public class EditCollisionZone extends BasePage{
	AllMethods allMethods;

	public EditCollisionZone() throws IOException {
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
	
	@FindBy(xpath = "//span[@class='anticon anticon-edit']")
	WebElement editButton;
	
	public void EditButton() {
		allMethods.VerifyElementDisplay(editButton);
		editButton.click();
	}
	
	@FindBy(xpath = "//input[contains(@placeholder,'Please enter Name')]")
	WebElement name;
	
	public void Name(String CollisionName) throws InterruptedException {

		allMethods.VerifyElementDisplay(name);
		name.sendKeys(Keys.CONTROL + "a");
	    name.sendKeys(Keys.DELETE);
		name.sendKeys(CollisionName);
	}
	
	@FindBy(xpath = "//input[@id='basic_allowedWorkers']")
	WebElement allowedWorker;
	
	public void allowedWorker(String worker) throws InterruptedException, AWTException {
		allMethods.VerifyElementDisplay(mapArea);
		mapArea.sendKeys(Keys.CONTROL + "a");
		mapArea.sendKeys(Keys.DELETE);
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
		mapArea.sendKeys(Keys.CONTROL + "a");
		mapArea.sendKeys(Keys.DELETE);
		mapArea.sendKeys(areaPoints);
		Thread.sleep(1000);
	}
	
	@FindBy(xpath = "//button[@type='button'][contains(.,'Update Collision Zone')]")
	WebElement update;
	
	public void UpdateButton() {
		allMethods.VerifyElementDisplay(update);
		update.click();
	}

}
