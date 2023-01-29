package Dashboard.Pages;

import java.io.IOException;

import fours.utils.AllMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import fours.base.BasePage;

public class AlertFilterPage extends BasePage{
	AllMethods allMethods;

	public AlertFilterPage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
		allMethods = new AllMethods(driver);
	}
	
	@FindBy(xpath = "(//span[contains(@class,'ant-select-selection-item')])[2]")
	WebElement siteDropdown;
	
	public void SelectSite(String site) throws InterruptedException {
		allMethods.VerifyElementDisplay(siteDropdown);
		siteDropdown.click();
		Thread.sleep(1000);
		//siteDropdown.sendKeys(site);
		//Thread.sleep(1000);
		driver.findElement(By.xpath("(//span[contains(.,'"+site+"')])[2]")).click();
	}
	
	@FindBy(xpath = "(//span[contains(@class,'ant-select-selection-item')])[3]")
	WebElement statusDropdown;
	
	public void Status(String status) throws InterruptedException {
		allMethods.VerifyElementDisplay(statusDropdown);
		statusDropdown.click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@class='ant-select-item-option-content'][contains(.,'"+status+"')]")).click();
	}
	
	@FindBy(xpath = "(//span[contains(@class,'ant-select-selection-item')])[4]")
	WebElement type;
	
	public void AlertType(String status) throws InterruptedException {
		allMethods.VerifyElementDisplay(type);
		type.click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@class='ant-select-item-option-content'][contains(.,'"+status+"')]")).click();
	}
	
	@FindBy(xpath = "//span[@class='anticon anticon-close-circle']")
	WebElement clear;
	
	public void ClearFilter() {
		allMethods.VerifyElementDisplay(clear);
		clear.click();
	}
	
	@FindBy(xpath = "//li[contains(@class,'ant-pagination-total-text')]")
	WebElement totalAlert;
	
	public String TotalAlert() {
		allMethods.VerifyElementDisplay(totalAlert);
		String text = totalAlert.getText();
		String[] elementSplit = text.split("\\s");
		String count = elementSplit[1];
		System.out.println("Alerts in Dashboard page -- "+count);
		return count;
	}

}
