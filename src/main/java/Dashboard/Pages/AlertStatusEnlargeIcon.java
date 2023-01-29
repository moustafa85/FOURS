package Dashboard.Pages;

import java.io.IOException;

import fours.utils.AllMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import fours.base.BasePage;

public class AlertStatusEnlargeIcon extends BasePage{
	AllMethods allMethods;

	public AlertStatusEnlargeIcon() throws IOException {
		super();
		PageFactory.initElements(driver, this);
		allMethods = new AllMethods(driver);
	}
	
	@FindBy(xpath = "(//button[contains(@type,'button')])[1]")
	WebElement enlargeIcon;
	
	public void enlargeIcon() {
		allMethods.VerifyElementDisplay(enlargeIcon);
		enlargeIcon.click();
	}
	
	@FindBy(xpath = "//span[@class='anticon anticon-close ant-modal-close-icon']")
	WebElement clearIcon;
	
	public void ClearIcon() {
		allMethods.VerifyElementDisplay(clearIcon);
		clearIcon.click();
	}

}
