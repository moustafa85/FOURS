package siteMonitoring.Pages;

import java.io.IOException;

import fours.utils.AllMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import fours.base.BasePage;

public class LastAlertCard extends BasePage{
	AllMethods allMethods;

	public LastAlertCard() throws IOException {
		super();
		PageFactory.initElements(driver, this);
		allMethods = new AllMethods(driver);
	}
	
	@FindBy(xpath = "//a[@href='/siteMonitoring']")
	WebElement sm;
	
	public Boolean SM() {
		if(!allMethods.VerifyElementDisplay(sm))
			return false;
		sm.click();
		return true;
	}
	
	@FindBy(xpath = "//div[@role='tab'][contains(.,'Guardian')]")
	WebElement guardian;
	
	public Boolean Guardian() {
		if(!allMethods.VerifyElementDisplay(guardian))
			return false;
		guardian.click();
		return true;
	}
	
	@FindBy(xpath = "//div[contains(@class,'value___ln_Tc')]")
	WebElement lastAlert;
	
	public Boolean LastAlertClick() {
		if(!allMethods.VerifyElementDisplay(lastAlert))
			return false;
		lastAlert.click();
		return true;
	}
	
	public String LastAlert() {
		allMethods.VerifyElementDisplay(lastAlert);
		String count = lastAlert.getText();
		return count;
	}

	@FindBy(xpath = "(//div[@class='ant-select-selector'])[2]")
	WebElement siteDropdown;

	public Boolean SelectSite(String site) throws InterruptedException {
		if(allMethods.VerifyElementDisplay(siteDropdown)){
			siteDropdown.click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("(//span[contains(.,'"+site+"')])[2]")).click();
			return true;
		}
		return false;

	}

}
