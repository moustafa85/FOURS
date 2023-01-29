package fallAlert.Pages;

import java.io.IOException;

import fours.utils.AllMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import fours.base.BasePage;

public class RefreshPage extends BasePage{
	AllMethods allMethods;

	public RefreshPage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
		allMethods = new AllMethods(driver);
	}
	
	@FindBy(xpath = "//a[contains(.,'Fall Alerts')]")
	WebElement fAlert;
	
	public void FAlert() {
		allMethods.VerifyElementDisplay(fAlert);
		fAlert.click();
	}
	
	@FindBy(xpath = "//span[@class='anticon anticon-redo']")
	WebElement refresh;
	
	public void RefreshButton() {
		allMethods.VerifyElementDisplay(refresh);
		refresh.click();
	}
	
	

}
