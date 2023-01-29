package siteMonitoring.Pages;

import java.io.IOException;

import fours.utils.AllMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import fours.base.BasePage;

public class MapEnlarge extends BasePage{
	AllMethods allMethods;

	public MapEnlarge() throws IOException {
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
	
	@FindBy(xpath = "(//button[contains(@type,'button')])[12]")
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
