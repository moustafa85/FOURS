package fallAlert.Pages;

import java.io.IOException;

import fours.utils.AllMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import fours.base.BasePage;

public class FallPreventionAlertPage extends BasePage{
	AllMethods allMethods;

	public FallPreventionAlertPage() throws IOException {
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
	
	@FindBy(xpath = "(//div[contains(@class,'value___ln_Tc')])[5]")
	WebElement fallPrevAlert;
	
	public String FallPrevAlertCount() {
		allMethods.VerifyElementDisplay(fallPrevAlert);
		String count = fallPrevAlert.getText();
		//System.out.println("Fall Prevention Alert in Fall Alert Page -- "+count);
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
		driver.findElement(By.xpath("//div[@class='ant-select-item-option-content'][contains(.,'Fall Prevention')]")).click();
	}

}
