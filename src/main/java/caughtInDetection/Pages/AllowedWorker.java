package caughtInDetection.Pages;

import java.io.IOException;

import fours.utils.AllMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import fours.base.BasePage;

public class AllowedWorker extends BasePage{
AllMethods allMethods;
	public AllowedWorker() throws IOException {
		super();
		PageFactory.initElements(driver, this);
		allMethods = new AllMethods(driver);
	}
	
	@FindBy(xpath = "//*[contains(@class,'3MFDs')]")
	WebElement viewWorker;
	
	public void ViewWorker() {

		allMethods.VerifyElementDisplay(viewWorker);
		viewWorker.click();
	}
	
	@FindBy(xpath = "//span[@class='ant-modal-close-x']")
	WebElement closeButton;
	
	public void closeButton() {

		allMethods.VerifyElementDisplay(closeButton);
		closeButton.click();
	}

}
