package device.pages;

import java.io.IOException;

import fours.utils.AllMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import fours.base.BasePage;

public class DeactivateDevicePage extends BasePage{
	AllMethods allMethods;
	public DeactivateDevicePage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
		allMethods = new AllMethods(driver);
	}
	
	@FindBy(xpath = "//button[contains(@role,'switch')]")
	WebElement deactivate;
	
	public void Deactivate() {
		allMethods.VerifyElementDisplay(deactivate);
		deactivate.click();
	}
}
