package siteMonitoring.Pages;

import java.io.IOException;

import fours.utils.AllMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import fours.base.BasePage;

public class AssignedOpenPage extends BasePage{
	AllMethods allMethods;
	public AssignedOpenPage() throws IOException {
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
	
	@FindBy(xpath = "(//div[@class='value___ln_Tc'])[2]")
	WebElement assOpen;
	
	public void AssOpen() {
		allMethods.VerifyElementDisplay(assOpen);
		assOpen.click();
	}
	
	public String AssOpenCount() {
		allMethods.VerifyElementDisplay(assOpen);
		String count = assOpen.getText();
		//System.out.println("Assigned open alert in Site Monitoring Page -- "+count);
		return count;
	}

}
