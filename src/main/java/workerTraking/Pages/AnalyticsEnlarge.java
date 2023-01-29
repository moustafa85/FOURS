package workerTraking.Pages;

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
	
	@FindBy(xpath = "//a[@href='/workerTracking']")
	WebElement wt;
	
	public void WT() {
			allMethods.VerifyElementDisplay(wt);		
			wt.click();
}
	
	@FindBy(xpath = "(//button[contains(@type,'button')])[12]")
	WebElement TotalOOGEnlargeButton;
	
	public void TotalOOGEnlargeButton() {
		allMethods.VerifyElementDisplay(TotalOOGEnlargeButton);
		TotalOOGEnlargeButton.click();
	}
	
	@FindBy(xpath = "//span[contains(@class,'ant-modal-close-x')]")
	WebElement TotalOOGCloseButton;
	
	public void TotalOOGCloseButton() {
		allMethods.VerifyElementDisplay(TotalOOGCloseButton);
		TotalOOGCloseButton.click();
	}
	
	@FindBy(xpath = "(//button[contains(@type,'button')])[11]")
	WebElement workerPresentEnlargeButton;
	
	public void WorkerPresentEnlargeButton() {
		allMethods.VerifyElementDisplay(workerPresentEnlargeButton);
		workerPresentEnlargeButton.click();
	}
	
	@FindBy(xpath = "(//span[contains(@class,'ant-modal-close-x')])[2]")
	WebElement workerPresentCloseButton;
	
	public void WorkerPresentCloseButton() {
		allMethods.VerifyElementDisplay(workerPresentCloseButton);
		workerPresentCloseButton.click();
	}
	
	@FindBy(xpath = "(//button[contains(@type,'button')])[14]")
	WebElement workerTypeEnlargeButton;
	
	public void WorkerTypeEnlargeButton() {
		allMethods.VerifyElementDisplay(workerTypeEnlargeButton);
		workerTypeEnlargeButton.click();
	}
	
	@FindBy(xpath = "(//span[contains(@class,'ant-modal-close-x')])[3]")
	WebElement workerTypeCloseButton;
	
	public void WorkerTypeCloseButton() {
		allMethods.VerifyElementDisplay(workerTypeCloseButton);
		workerTypeCloseButton.click();
	}
	
	@FindBy(xpath = "(//button[contains(@type,'button')])[13]")
	WebElement workerAlertEnlargeButton;
	
	public void workerAlertEnlargeButton() {
		allMethods.VerifyElementDisplay(workerAlertEnlargeButton);
		workerAlertEnlargeButton.click();
	}
	
	@FindBy(xpath = "(//span[contains(@class,'ant-modal-close-x')])[4]")
	WebElement workerAlertCloseButton;
	
	public void workerAlertCloseButton() {
		allMethods.VerifyElementDisplay(workerAlertCloseButton);
		workerAlertCloseButton.click();
	}
	
	@FindBy(xpath = "(//button[contains(@type,'button')])[15]")
	WebElement siteEnlargeButton;
	
	public void SiteEnlargeButton() {
		allMethods.VerifyElementDisplay(siteEnlargeButton);
		siteEnlargeButton.click();
	}
	
	@FindBy(xpath = "(//span[contains(@class,'ant-modal-close-x')])[5]")
	WebElement siteCloseButton;
	
	public void siteCloseButton() {
		allMethods.VerifyElementDisplay(siteCloseButton);
		siteCloseButton.click();
	}

}
