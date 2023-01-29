package siteMonitoring.Pages;

import java.io.IOException;

import fours.utils.AllMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import fours.base.BasePage;

public class PresentOnSiteCard extends BasePage{
	AllMethods allMethods;

	public PresentOnSiteCard() throws IOException {
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
	
	@FindBy(xpath = "(//div[contains(@class,'value___ln_Tc')])[4]")
	WebElement presentOnSite;
	
	public String PresentOnSite() {
		allMethods.VerifyElementDisplay(presentOnSite);
		String count = presentOnSite.getText();
		//System.out.println("Present on site -- "+count);
		return count;
	}

}
