package workerTraking.Pages;

import java.io.IOException;

import fours.utils.AllMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import fours.base.BasePage;

public class TrackingMapEnlarge extends BasePage{
	AllMethods allMethods;

	public TrackingMapEnlarge() throws IOException {
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

	
	@FindBy(xpath = "//div[@role='tab'][contains(.,'Tracking')]")
	WebElement tracking;
	
	public void Tracking() {
		allMethods.VerifyElementDisplay(tracking);
		tracking.click();
	}
	
	@FindBy(xpath = "(//button[contains(@type,'button')])[4]")
	WebElement mapEnlargeButton;
	
	public void MapEnlargeButton() {
		allMethods.VerifyElementDisplay(mapEnlargeButton);
		mapEnlargeButton.click();
	}
	
	@FindBy(xpath = "//span[contains(@class,'ant-modal-close-x')]")
	WebElement mapCloseButton;
	
	public void MapCloseButton() {
		allMethods.VerifyElementDisplay(mapCloseButton);
		mapCloseButton.click();
	}

}
