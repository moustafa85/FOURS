package Dashboard.Pages;

import java.io.IOException;

import fours.utils.AllMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import fours.base.BasePage;

public class OpenAlertPage extends BasePage{
	AllMethods allMethods;

	public OpenAlertPage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
		allMethods = new AllMethods(driver);
	}
	
	@FindBy(xpath = "(//div[@class='value___ln_Tc'])[1]")
	WebElement open;
	
	public void Open() {
		allMethods.VerifyElementDisplay(open);
		open.click();
	}
	
	public String OpenCount() {
		allMethods.VerifyElementDisplay(open);
		String count = open.getText();
		//System.out.println("Open alert in Dashboard Page -- "+count);
		return count;
	}

}
