package Dashboard.Pages;

import java.io.IOException;

import fours.utils.AllMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import fours.base.BasePage;

public class FreeFallAlertPage extends BasePage{
	AllMethods allMethods;

	public FreeFallAlertPage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
		allMethods = new AllMethods(driver);
	}
	
	@FindBy(xpath = "(//div[contains(@class,'value___ln_Tc')])[5]")
	WebElement freeFall;
	
	public void FreeFall() {
		allMethods.VerifyElementDisplay(freeFall);
		freeFall.click();
	}
	
	public String FreeFallAlertCount() {
		allMethods.VerifyElementDisplay(freeFall);
		String count = freeFall.getText();
		//System.out.println("Free Fall alert in Dashboard Page -- "+count);
		return count;
	}
	
	@FindBy(xpath = "(//div[contains(@class,'value___ln_Tc')])[6]")
	WebElement freeFallCount;
	
	public String FreeFallCount() {
		allMethods.VerifyElementDisplay(freeFallCount);
		String count = freeFallCount.getText();
		//System.out.println("Free Fall alert in Fall Alerts page -- "+count);
		return count;
	}

}
