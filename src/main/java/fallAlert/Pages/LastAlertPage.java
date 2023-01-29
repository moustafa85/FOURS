package fallAlert.Pages;

import java.io.IOException;

import fours.utils.AllMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import fours.base.BasePage;

public class LastAlertPage extends BasePage{
	AllMethods allMethods;
	public LastAlertPage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
		allMethods = new AllMethods(driver);
	}
	
	@FindBy(xpath = "//a[@href='/fallPrevention']")
	WebElement fAlert;
	
	public Boolean FAlert() {
		if(!allMethods.VerifyElementDisplay(fAlert))
			return false;
		fAlert.click();
		return true;
	}
	
	@FindBy(xpath = "(//div[contains(@class,'valueContainer___3mnbh')])[7]")
	WebElement lastAlert;
	
	public Boolean LastAlertClick() {
		if(!allMethods.VerifyElementDisplay(lastAlert))
			return false;
		lastAlert.click();
		return true;
	}
	
	public String LastAlert() {
		allMethods.VerifyElementDisplay(lastAlert);
		String element = lastAlert.getText();
		//System.out.println("Last Alert in Fall Alert Page -- "+element);
		return element;
	}
	@FindBy(xpath = "(//div[@class='ant-select-selector'])[2]")
	WebElement siteDropdown;

	public Boolean SelectSite(String site) throws InterruptedException {
		if(allMethods.VerifyElementDisplay(siteDropdown)){
			siteDropdown.click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("(//span[contains(.,'"+site+"')])[2]")).click();
			return true;
		}
		return false;

	}

}
