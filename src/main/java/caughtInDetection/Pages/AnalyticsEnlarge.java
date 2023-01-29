package caughtInDetection.Pages;

import java.io.IOException;

import fours.utils.AllMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import fours.base.BasePage;

public class AnalyticsEnlarge extends BasePage{
	AllMethods allMethods;

	public AnalyticsEnlarge() throws IOException {
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
	
	@FindBy(xpath = "(//button[contains(@type,'button')])[12]")
	WebElement caughtInEnlargeButton;
	
	public void CaughtInEnlargeButton() {
		allMethods.VerifyElementDisplay(caughtInEnlargeButton);
		caughtInEnlargeButton.click();
	}
	
	@FindBy(xpath = "(//span[contains(@class,'ant-modal-close-x')])")
	WebElement CloseButton;
	
	public void CloseButton() {
		allMethods.VerifyElementDisplay(CloseButton);
		CloseButton.click();
	}
	
	@FindBy(xpath = "(//button[contains(@type,'button')])[11]")
	WebElement workerTypeEnlargeButton;
	
	public void WorkerTypeEnlargeButton() {
		allMethods.VerifyElementDisplay(workerTypeEnlargeButton);
		workerTypeEnlargeButton.click();
	}
	
	@FindBy(xpath = "(//span[contains(@class,'ant-modal-close-x')])[2]")
	WebElement workerTypeCloseButton;
	
	public void workerTypeCloseButton() {
		allMethods.VerifyElementDisplay(workerTypeCloseButton);
		workerTypeCloseButton.click();
	}
	
	@FindBy(xpath = "(//button[contains(@type,'button')])[13]")
	WebElement workerAlertEnlargeButton;
	
	public void workerAlertEnlargeButton() {
		allMethods.VerifyElementDisplay(workerAlertEnlargeButton);
		workerAlertEnlargeButton.click();
	}
	
	@FindBy(xpath = "(//span[contains(@class,'ant-modal-close-x')])[3]")
	WebElement workerAlertCloseButton;
	
	public void workerAlertCloseButton() {
		allMethods.VerifyElementDisplay(workerAlertCloseButton);
		workerAlertCloseButton.click();
	}
	
	@FindBy(xpath = "(//button[contains(@type,'button')])[14]")
	WebElement siteEnlargeButton;
	
	public void SiteEnlargeButton() {
		allMethods.VerifyElementDisplay(siteEnlargeButton);
		siteEnlargeButton.click();
	}
	
	@FindBy(xpath = "(//span[contains(@class,'ant-modal-close-x')])[4]")
	WebElement siteCloseButton;
	
	public void siteCloseButton() {
		allMethods.VerifyElementDisplay(siteCloseButton);
		siteCloseButton.click();
	}

}
