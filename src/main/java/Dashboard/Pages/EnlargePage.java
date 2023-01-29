package Dashboard.Pages;

import java.io.IOException;

import fours.utils.AllMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import fours.base.BasePage;

public class EnlargePage extends BasePage{
	AllMethods allMethods;

	public EnlargePage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
		allMethods = new AllMethods(driver);
	}
	
	@FindBy(xpath = "(//button[contains(@type,'button')])[4]")
	WebElement enlarge;
	
	public void Enlarge() {
		allMethods.VerifyElementDisplay(enlarge);
		enlarge.click();
	}
	
	@FindBy(xpath = "//span[@class='ant-modal-close-x']")
	WebElement closeButton;
	
	public void closeButton() {
		allMethods.VerifyElementDisplay(closeButton);
		closeButton.click();
	}

}
