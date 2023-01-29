package Dashboard.Pages;

import java.io.IOException;

import fours.utils.AllMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import fours.base.BasePage;

public class FallPreventionAlertPage extends BasePage {
	AllMethods allMethods;
	public FallPreventionAlertPage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
		allMethods = new AllMethods(driver);
	}
	
	@FindBy(xpath = "(//div[contains(@class,'value___ln_Tc')])[4]")
	WebElement fallPrev;
	
	public void FallPrev() {
		allMethods.VerifyElementDisplay(fallPrev);
		fallPrev.click();
	}
	
	public String FallPrevAlertCount() {
		allMethods.VerifyElementDisplay(fallPrev);
		String count = fallPrev.getText();
		//System.out.println("Fall Prevention alert in Dashboard Page -- "+count);
		return count;
	}
	
	@FindBy(xpath = "(//div[contains(@class,'value___ln_Tc')])[5]")
	WebElement fallPrevCount;
	
	public String FallPrevCount() {
		allMethods.VerifyElementDisplay(fallPrevCount);

		String count = fallPrevCount.getText();
		//System.out.println("Fall Prevention alert in Fall Alerts page -- "+count);
		return count;
	}

}
