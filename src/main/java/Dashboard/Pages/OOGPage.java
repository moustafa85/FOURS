package Dashboard.Pages;

import java.io.IOException;

import fours.utils.AllMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import fours.base.BasePage;

public class OOGPage extends BasePage{
	AllMethods allMethods;

	public OOGPage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
		allMethods = new AllMethods(driver);
	}
	
	@FindBy(xpath = "(//div[contains(@class,'value___ln_Tc')])[6]")
	WebElement oog;
	
	public void OOG() {
		allMethods.VerifyElementDisplay(oog);
		oog.click();
	}
	
	public String OOGAlertCount() {
		allMethods.VerifyElementDisplay(oog);
		String count = oog.getText();
		//System.out.println("OOG alert in Dashboard Page -- "+count);
		return count;
	}
	
	@FindBy(xpath = "(//div[contains(@class,'value___ln_Tc')])[4]")
	WebElement oogCount;
	
	public String OOGCount() {
		allMethods.VerifyElementDisplay(oogCount);
		String count = oogCount.getText();
		//System.out.println("OOG alert in Worker Tracking page -- "+count);
		return count;
	}

}
