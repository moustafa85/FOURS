package workerTraking.Pages;

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
	
	@FindBy(xpath = "//a[@href='/workerTracking']")
	WebElement wt;
	
	public void WT() {
			allMethods.VerifyElementDisplay(wt);		
			wt.click();
			}
	
	@FindBy(xpath = "(//button[contains(@type,'button')])[9]")
	WebElement mapEnlargeButton;
	
	public void MapEnlargeButton() {
		allMethods.VerifyElementDisplay(mapEnlargeButton);
		mapEnlargeButton.click();
	}
	
	@FindBy(xpath = "//span[@class='anticon anticon-close ant-modal-close-icon']")
	WebElement mapCloseButton;
	
	public void MapCloseButton() {
		allMethods.VerifyElementDisplay(mapCloseButton);
		mapCloseButton.click();
	}
	
	

}
