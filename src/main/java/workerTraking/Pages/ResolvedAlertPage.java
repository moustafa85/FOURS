package workerTraking.Pages;

import java.io.IOException;

import fours.utils.AllMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import fours.base.BasePage;

public class ResolvedAlertPage extends BasePage{
	AllMethods allMethods;

	public ResolvedAlertPage() throws IOException {
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
	
	@FindBy(xpath = "(//div[contains(@class,'value___ln_Tc')])[3]")
	WebElement resolved;
	
	public void Resolved() {
		allMethods.VerifyElementDisplay(resolved);
		resolved.click();
	}
	
	public String ResolvedCount() {
		allMethods.VerifyElementDisplay(resolved);
		String count = resolved.getText();
		//System.out.println("Resolved alert in Worker Tracking Page -- "+count);
		return count;
	}

}
