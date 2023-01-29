package workerTraking.Pages;

import java.io.IOException;

import fours.utils.AllMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import fours.base.BasePage;

public class PresentOnSitePage extends BasePage{
	AllMethods allMethods;

	public PresentOnSitePage() throws IOException {
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
	
	@FindBy(xpath = "(//div[contains(@class,'Tc')])[5]")
	WebElement presentOnSite;
	
	public String PresentOnSite() {
		allMethods.VerifyElementDisplay(presentOnSite);
		String count = presentOnSite.getText();
		//System.out.println("No of worker is present on site  -- "+count);
		return count;
	}

}
