package siteMonitoring.Pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;

import fours.utils.AllMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import fours.base.BasePage;

public class AssignReassign extends BasePage{
	AllMethods allMethods;

	public AssignReassign() throws IOException {
		super();
		PageFactory.initElements(driver, this);
		allMethods = new AllMethods(driver);
	}
	
	@FindBy(xpath = "//a[contains(.,'Site Monitoring')]")
	WebElement sm;
	
	public void SM() {
		allMethods.VerifyElementDisplay(sm);
		sm.click();
	}
	
	@FindBy(xpath = "(//span[contains(@class,'ant-select-selection-item')])[1]")
	WebElement site;
	
	public void SelectSite(String Site) throws InterruptedException {
		allMethods.VerifyElementDisplay(site);
		site.click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[@class='ant-select-tree-title'][contains(.,'"+Site+"')]")).click();
	}
	
	@FindBy(xpath = "//div[@role='tab'][contains(.,'Manage')]")
	WebElement manage;
	
	public void Manage() {
		allMethods.VerifyElementDisplay(manage);
		manage.click();
	}
	
	@FindBy(xpath = "(//button[contains(@type,'button')])[7]")
	WebElement assignSGButton;
	
	public void AssignSGButton() {
		allMethods.VerifyElementDisplay(assignSGButton);
		assignSGButton.click();
	}
	
	@FindBy(xpath = "//input[@id='basic_device']")
	WebElement selectSGDevice;
	
	public void SelectSGDevice(String Device) throws InterruptedException, AWTException {
		allMethods.VerifyElementDisplay(selectSGDevice);
		selectSGDevice.sendKeys(Device);
		//Thread.sleep(1000);
		Robot rb = new Robot();
		rb.keyPress(KeyEvent.VK_ENTER);
	}
	
	@FindBy(xpath = "//button[@type='submit'][contains(.,'Submit')]")
	WebElement submitSG;
	
	public void SG() {
		allMethods.VerifyElementDisplay(submitSG);
		submitSG.click();
	}
	
	@FindBy(xpath = "(//button[contains(@type,'button')])[6]")
	WebElement assignBeaconButton;
	
	public void AssignBeaconButton() {
		allMethods.VerifyElementDisplay(assignBeaconButton);
		assignBeaconButton.click();
	}
	
	@FindBy(xpath = "//input[@id='basic_device']")
	WebElement selectBeaconDevice;
	
	public void SelectBeaconDevice(String Device) throws InterruptedException, AWTException {
		allMethods.VerifyElementDisplay(selectBeaconDevice);
		selectBeaconDevice.sendKeys(Device);
		//Thread.sleep(1000);
		Robot rb = new Robot();
		rb.keyPress(KeyEvent.VK_ENTER);
	}
	
	@FindBy(xpath = "//button[@type='submit'][contains(.,'Submit')]")
	WebElement submit;
	
	public void Beacon() {
		allMethods.VerifyElementDisplay(submit);
		submit.click();
	}

}
