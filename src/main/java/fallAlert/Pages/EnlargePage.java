package fallAlert.Pages;

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
	
	@FindBy(xpath = "//a[@href='/fallPrevention']")
	WebElement fAlert;
	
	public void FAlert() {
		allMethods.VerifyElementDisplay(fAlert);
		fAlert.click();
	}
	
	//@FindBy(xpath = "//span[@class='anticon anticon-fullscreen']")
	@FindBy(xpath = "(//button[contains(@type,'button')])[12]")
	WebElement mapEnlarge;
	
	public void MapEnlarge() {
		allMethods.VerifyElementDisplay(mapEnlarge);
		mapEnlarge.click();
	}
	
	@FindBy(xpath = "//span[contains(@class,'ant-modal-close-x')]")
	WebElement mapEnlargeClose;
	
	public void MapEnlargeClose() {
		allMethods.VerifyElementDisplay(mapEnlargeClose);
		mapEnlargeClose.click();
	}
	
	@FindBy(xpath = "(//button[contains(@type,'button')])[10]")
	WebElement fallAlertMapEnlarge;
	
	public void FallAlertMapEnlarge() {
		allMethods.VerifyElementDisplay(fallAlertMapEnlarge);
		fallAlertMapEnlarge.click();
	}
	
	@FindBy(xpath = "//body/div[3]/div[1]/div[2]/div[1]/div[2]/button[1]/span[1]/span[1]/*[1]")
	//@FindBy(xpath = "//span[contains(@class,'ant-modal-close-x')]")
	WebElement fallAlertMapEnlargeClose;
	
	public void FallAlertMapEnlargeClose() {
		allMethods.VerifyElementDisplay(fallAlertMapEnlargeClose);
		fallAlertMapEnlargeClose.click();
	}
	
	@FindBy(xpath = "(//button[contains(@type,'button')])[11]")
	WebElement workerTypeMapEnlarge;
	
	public void WorkerTypeMapEnlarge() {
		allMethods.VerifyElementDisplay(workerTypeMapEnlarge);
		workerTypeMapEnlarge.click();
	}
	
	@FindBy(xpath = "//body/div[4]/div[1]/div[2]/div[1]/div[2]/button[1]/span[1]/span[1]/*[1]")
	WebElement workerTypeMapEnlargeClose;
	
	public void WorkerTypeMapEnlargeClose() {
		allMethods.VerifyElementDisplay(workerTypeMapEnlargeClose);
		workerTypeMapEnlargeClose.click();
	}
	
	@FindBy(xpath = "(//button[contains(@type,'button')])[13]")
	WebElement workerMapEnlarge;
	
	public void WorkerMapEnlarge() {
		allMethods.VerifyElementDisplay(workerMapEnlarge);
		workerMapEnlarge.click();
	}
	
	@FindBy(xpath = "//body/div[5]/div[1]/div[2]/div[1]/div[2]/button[1]/span[1]")
	WebElement workerMapEnlargeClose;
	
	public void WorkerMapEnlargeClose() {
		allMethods.VerifyElementDisplay(workerMapEnlargeClose);
		workerMapEnlargeClose.click();
	}
	
	@FindBy(xpath = "(//button[contains(@type,'button')])[14]")
	WebElement siteMapEnlarge;
	
	public void SiteMapEnlarge() {
		allMethods.VerifyElementDisplay(siteMapEnlarge);
		siteMapEnlarge.click();
	}
	
	@FindBy(xpath = "//body/div[6]/div[1]/div[2]/div[1]/div[2]/button[1]/span[1]/span[1]/*[1]")
	WebElement siteMapEnlargeClose;
	
	public void SiteMapEnlargeClose() {
		allMethods.VerifyElementDisplay(siteMapEnlargeClose);
		siteMapEnlargeClose.click();
	}

}
