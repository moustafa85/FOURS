package caughtInDetection.Pages;

import java.io.IOException;

import fours.utils.AllMethods;
import org.openqa.selenium.By;
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
	
	@FindBy(xpath = "//a[@href='/caughtInDetection']")
	WebElement caughtIn;
	
	public void CaughtIn() {
		allMethods.VerifyElementDisplay(caughtIn);
		caughtIn.click();
	}
	
	@FindBy(xpath = "(//button[contains(@type,'button')])[10]")
	WebElement mapEnlargeButton;
	
	public void MapEnlargeButton() {
		WebElement Element = driver.findElement(By.xpath("//div[@class='separator'][contains(.,'Mapped Alerts')]"));
		allMethods.VerifyElementDisplay(Element);
		allMethods.scrollToSpecificLocation(Element);
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
