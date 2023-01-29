package Dashboard.Pages;

import java.io.IOException;

import fours.utils.AllMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import fours.base.BasePage;

public class CaughtInAlertPage extends BasePage{
	AllMethods allMethods;
	public CaughtInAlertPage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
		allMethods = new AllMethods(driver);
	}
	
	@FindBy(xpath = "(//div[contains(@class,'value___ln_Tc')])[7]")
	WebElement caughtIn;
	
	public void CaughtIn() {
		allMethods.VerifyElementDisplay(caughtIn);
		caughtIn.click();
	}
	
	public String CaughtInAlertCount() {
		allMethods.VerifyElementDisplay(caughtIn);
		String count = caughtIn.getText();
		//System.out.println("caught-In alert in Dashboard Page -- "+count);
		return count;
	}
	
	@FindBy(xpath = "(//div[contains(@class,'value___ln_Tc')])[4]")
	WebElement caughtInCount;
	
	public String CaughtInCount() {
		allMethods.VerifyElementDisplay(caughtInCount);
		String count = caughtInCount.getText();
		//System.out.println("Caught-In alert in Caught-In Detection page -- "+count);
		return count;
	}

}
