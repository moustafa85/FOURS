package caughtInDetection.Pages;

import java.io.IOException;

import fours.utils.AllMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import fours.base.BasePage;

public class AssignedOpenCountPage extends BasePage {
	AllMethods allMethods;

	public AssignedOpenCountPage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
		allMethods = new AllMethods(driver);
	}
	
	@FindBy(xpath = "//a[@href='/caughtInDetection']")
	WebElement caughtIn;
	
	public void CaughtIn() {
		allMethods.VerifyElementDisplay(caughtIn);
		caughtIn.click();
	}
	
	@FindBy(xpath = "(//div[@class='value___ln_Tc'])[2]")
	WebElement assOpen;
	
	public void AssOpen() {
		allMethods.VerifyElementDisplay(assOpen);
		assOpen.click();
	}
	
	public String AssOpenCount() {
		allMethods.VerifyElementDisplay(assOpen);
		String count = assOpen.getText();
		//System.out.println("Assigned open alert in Caught-In Detection Page -- "+count);
		return count;
	}

}
