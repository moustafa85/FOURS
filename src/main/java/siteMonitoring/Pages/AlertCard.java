package siteMonitoring.Pages;

import java.io.IOException;

import fours.utils.AllMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import fours.base.BasePage;

public class AlertCard extends BasePage{
	AllMethods allMethods;
	public AlertCard() throws IOException {
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
	
	@FindBy(xpath = "(//div[contains(@class,'value___ln_Tc')])[5]")
	WebElement alert;
	
	public String Alert() {
		allMethods.VerifyElementDisplay(alert);

		String count = alert.getText();
		//System.out.println("Alert in Site Monitoring Page -- "+count);
		return count;
	}

}
