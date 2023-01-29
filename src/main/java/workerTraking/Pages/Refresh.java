package workerTraking.Pages;

import java.io.IOException;

import fours.utils.AllMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import fours.base.BasePage;

public class Refresh extends BasePage{
	AllMethods allMethods;

	public Refresh() throws IOException {
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
	
	@FindBy(xpath = "(//button[contains(@type,'button')])[2]")
	WebElement refresh;
	
	public void Refresh() {
		allMethods.VerifyElementDisplay(refresh);
		refresh.click();
	}

}
