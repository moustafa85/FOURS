package siteMonitoring.Pages;

import java.io.IOException;

import fours.utils.AllMethods;
import org.openqa.selenium.By;
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
	
	@FindBy(xpath = "//a[contains(.,'Site Monitoring')]")
	WebElement sm;
	
	public void SM() {
		allMethods.VerifyElementDisplay(sm);
		sm.click();
	}
	
	@FindBy(xpath = "(//button[contains(@type,'button')])[13]")
	WebElement tAOTEnlargeButton;
	
	public void TotalAlertsOverTimeEnlargeButton() {
		allMethods.VerifyElementDisplay(tAOTEnlargeButton);
		tAOTEnlargeButton.click();
	}
	
	//@FindBy(xpath = "//span[@class='anticon anticon-close ant-modal-close-icon']")
	@FindBy(xpath = "(//span[@class='ant-modal-close-x'])")
	WebElement CloseButton;
	
	public void CloseButton() {
		allMethods.VerifyElementClickable(CloseButton);
		CloseButton.click();
	}



	public void clickClosebtn(int i){
		allMethods.VerifyElementClickable(driver.findElement(By.xpath("(//span[@class='ant-modal-close-x'])["+i+"]")));
		driver.findElement(By.xpath("(//span[@class='ant-modal-close-x'])["+i+"]")).click();
	}
	
	@FindBy(xpath = "(//button[contains(@type,'button')])[14]")
	WebElement tWPSEnlargeButton;
	
	public void WorkerPresentOnSiteEnlargeButton() {
		allMethods.VerifyElementDisplay(tWPSEnlargeButton);
		tWPSEnlargeButton.click();
	}
	
	@FindBy(xpath = "(//span[contains(@class,'ant-modal-close-x')])[1]")
	WebElement workerTypeCloseButton;
	
	public void workerTypeCloseButton() {
		allMethods.VerifyElementDisplay(workerTypeCloseButton);
		workerTypeCloseButton.click();
	}
	
	@FindBy(xpath = "(//button[contains(@type,'button')])[16]")
	WebElement wTWACEnlargeButton;
	
	public void WorkerTypeWiseAlertEnlargeButton() {
		allMethods.VerifyElementDisplay(wTWACEnlargeButton);
		wTWACEnlargeButton.click();
	}
	
	@FindBy(xpath = "//body/div[3]/div[1]/div[2]/div[1]/div[2]/button[1]/span[1]")
	WebElement workerAlertCloseButton;
	
	public void workerAlertCloseButton() {
		allMethods.VerifyElementDisplay(workerAlertCloseButton);
		workerAlertCloseButton.click();
	}
	
	@FindBy(xpath = "(//button[contains(@type,'button')])[17]")
	WebElement wWAEnlargeButton;
	
	public void WorkerWithAlertEnlargeButton() {
		allMethods.VerifyElementDisplay(wWAEnlargeButton);
		wWAEnlargeButton.click();
	}
	
	@FindBy(xpath = "//body/div[4]/div[1]/div[2]/div[1]/div[2]/button[1]/span[1]")
	WebElement siteCloseButton;
	
	public void siteCloseButton() {
		allMethods.VerifyElementDisplay(siteCloseButton);
		siteCloseButton.click();
	}
	
	@FindBy(xpath = "(//button[contains(@type,'button')])[18]")
	WebElement sWAAEnlargeButton;
	
	public void SiteWithAllAlertsEnlargeButton() {
		allMethods.VerifyElementDisplay(sWAAEnlargeButton);
		sWAAEnlargeButton.click();
	}
	
	@FindBy(xpath = "(//button[contains(@type,'button')])[15]")
	WebElement tACSBCEnlargeButton;
	
	public void AlertSiteByCategoryEnlargeButton() {
		allMethods.VerifyElementDisplay(tACSBCEnlargeButton);
		tACSBCEnlargeButton.click();
	}

}
