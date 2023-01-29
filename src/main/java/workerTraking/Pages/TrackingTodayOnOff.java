package workerTraking.Pages;

import java.io.IOException;

import fours.utils.AllMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import fours.base.BasePage;

public class TrackingTodayOnOff extends BasePage{
	AllMethods allMethods;

	public TrackingTodayOnOff() throws IOException {
		super();
		PageFactory.initElements(driver, this);
		allMethods = new AllMethods(driver);
	}
	
	@FindBy(xpath = "//a[@href='/workerTracking']")
	WebElement wt;
	
	public void WT() {
			allMethods.VerifyElementDisplay(wt);		
			wt.click();
			}
	
	@FindBy(xpath = "//div[@role='tab'][contains(.,'Tracking')]")
	WebElement tracking;
	
	public void Tracking() {
		allMethods.VerifyElementDisplay(tracking);
		tracking.click();
	}
	
	@FindBy(xpath = "//span[@class='ant-switch-inner'][contains(.,'Today')]")
	WebElement todayOff;
	
	public void todayOff() {
		allMethods.VerifyElementDisplay(todayOff);
		todayOff.click();
	}
	
	@FindBy(xpath = "//span[@class='ant-switch-inner'][contains(.,'All Time')]")
	WebElement todayOn;
	
	public void TodayOn() {
		allMethods.VerifyElementDisplay(todayOn);
		todayOn.click();
	}
	
	

}
