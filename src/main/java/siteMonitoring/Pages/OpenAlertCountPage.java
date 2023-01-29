package siteMonitoring.Pages;

import java.io.IOException;

import fours.utils.AllMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import fours.base.BasePage;

public class OpenAlertCountPage extends BasePage{
	AllMethods allMethods;
	public OpenAlertCountPage() throws IOException {
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
	
	@FindBy(xpath = "(//div[contains(@class,'value___ln_Tc')])[1]")
	WebElement open;
	
	public void Open() {
		allMethods.VerifyElementDisplay(open);
		open.click();
	}
	
	public String OpenCount() {
		allMethods.VerifyElementDisplay(open);
		String count = open.getText();
		//System.out.println("Open alert in Site Monitoring Page -- "+count);
		return count;
	}

}
