package workerTraking.Pages;

import java.io.IOException;

import fours.utils.AllMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import fours.base.BasePage;

public class OOGAlertPage extends BasePage{
	AllMethods allMethods;

	public OOGAlertPage() throws IOException {
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
	
	@FindBy(xpath = "(//div[contains(@class,'value___ln_Tc')])[4]")
	WebElement oog;
	
	public String OOGCount() {
		allMethods.VerifyElementDisplay(oog);
		String count = oog.getText();
		System.out.println("Out of Geofence alert in Worker Tracking Page -- "+count);
		return count;
	}
	
	@FindBy(linkText = "Alert Management")
	WebElement alertMng;
	
	public void AlertMng() {
		allMethods.VerifyElementDisplay(alertMng);
		alertMng.click();
	}
	
	@FindBy(xpath = "(//div[contains(@class,'ant-select-selection-overflow')])[1]")
	WebElement alertType;
	
	public void AlertType() throws InterruptedException {
		allMethods.VerifyElementDisplay(alertType);
		alertType.click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@class='ant-select-item-option-content'][contains(.,'Out of Geofence')]")).click();
	}

}
