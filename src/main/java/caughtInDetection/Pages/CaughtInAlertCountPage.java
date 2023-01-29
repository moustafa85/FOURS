package caughtInDetection.Pages;

import java.io.IOException;

import fours.utils.AllMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import fours.base.BasePage;

public class CaughtInAlertCountPage extends BasePage{
	AllMethods allMethods;

	public CaughtInAlertCountPage() throws IOException {
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
	
	@FindBy(xpath = "(//div[contains(@class,'value___ln_Tc')])[4]")
	WebElement caughtInCount;
	
	public String CaughtInCount() {
		allMethods.VerifyElementDisplay(caughtInCount);
		String count = caughtInCount.getText();
		System.out.println("Caught-In alert in caught-In Detection Page -- "+count);
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
		driver.findElement(By.xpath("//div[@class='ant-select-item-option-content'][contains(.,'Caught In Detection')]")).click();
	}

}
