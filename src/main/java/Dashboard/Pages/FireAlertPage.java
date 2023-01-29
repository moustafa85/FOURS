package Dashboard.Pages;

import java.io.IOException;

import fours.utils.AllMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import fours.base.BasePage;

public class FireAlertPage extends BasePage{
	AllMethods allMethods;

	public FireAlertPage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
		allMethods = new AllMethods(driver);
	}
	
	@FindBy(xpath = "(//div[contains(@class,'value___ln_Tc')])[8]")
	WebElement fire;
	
	public void Fire() {
		allMethods.VerifyElementDisplay(fire);
		fire.click();
	}
	
	public String FireAlertCount() {
		allMethods.VerifyElementDisplay(fire);
		String count = fire.getText();
		//System.out.println("Fire alert in Dashboard Page -- "+count);
		return count;
	}
	
	@FindBy(xpath = "(//div[contains(@class,'value___ln_Tc')])[4]")
	WebElement fireCount;
	
	public String FireCount() {
		allMethods.VerifyElementDisplay(fireCount);

		String count = fireCount.getText();
		//System.out.println("Fire alert in Fall Alerts page -- "+count);
		return count;
	}

}
