package device.pages;

import java.awt.AWTException;
import java.io.IOException;

import fours.utils.AllMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import fours.base.BasePage;
import org.testng.annotations.AfterSuite;

public class Filters extends BasePage{
AllMethods allMethods;
	public Filters() throws IOException {
		super();
		PageFactory.initElements(driver, this);
		allMethods= new AllMethods(driver);
	}
	
	@FindBy(xpath = "//span[contains(@title,'All')]")
	WebElement deviceType;
	
	public void DeviceType(String device) throws InterruptedException {
		allMethods.VerifyElementDisplay(deviceType);
		deviceType.click();
		Thread.sleep(1000);
		allMethods.VerifyElementDisplay(driver.findElement(By.xpath("//div[@class='ant-select-item-option-content'][contains(.,'"+device+"')]")));
		driver.findElement(By.xpath("//div[@class='ant-select-item-option-content'][contains(.,'"+device+"')]")).click();
	}
	
	@FindBy(xpath = "//span[@class='ant-select-selection-item'][contains(.,'Active')]")
	WebElement statusClick;
	
	public void Status(String status) throws InterruptedException {
		allMethods.VerifyElementDisplay(statusClick);

		statusClick.click();
		////Thread.sleep(1000);
		allMethods.VerifyElementDisplay(driver.findElement(By.xpath("//div[@class='ant-select-item-option-content'][contains(.,'"+status+"')]")));
		driver.findElement(By.xpath("//div[@class='ant-select-item-option-content'][contains(.,'"+status+"')]")).click();
	}
	
	@FindBy(xpath = "//input[contains(@id,'sites')]")
	WebElement siteClick;
	
	public void Site(String site) throws InterruptedException, AWTException {
		allMethods.VerifyElementDisplay(siteClick);
		siteClick.sendKeys(site);
		//Thread.sleep(1000);
		allMethods.VerifyElementDisplay(driver.findElement(By.xpath("//span[@class='ant-select-tree-title'][contains(.,'"+site+"')]")));
		driver.findElement(By.xpath("//span[@class='ant-select-tree-title'][contains(.,'"+site+"')]")).click();
		//Thread.sleep(1000);
	}
	
	@FindBy(xpath = "//body/div[@id='root']/div[1]/section[1]/div[2]/main[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[4]/div[2]/div[1]/div[1]/div[1]/div[1]/span[2]")
	WebElement batteryLevel;
	
	public void BatteryLevel(String battery) throws InterruptedException, AWTException {
		allMethods.VerifyElementDisplay(batteryLevel);

		batteryLevel.click();
		//Thread.sleep(2000);
		allMethods.VerifyElementDisplay(driver.findElement(By.xpath("//div[@class='ant-select-item-option-content'][contains(.,'"+battery+"')]")));
		driver.findElement(By.xpath("//div[@class='ant-select-item-option-content'][contains(.,'"+battery+"')]")).click();
	}
	
	@FindBy(xpath = "(//button[contains(@type,'button')])[1]")
	WebElement download;
	
	public void Download() throws InterruptedException, AWTException {
		allMethods.VerifyElementDisplay(download);
		download.click();
	}

	@FindBy(xpath = "//span[@class=\"anticon anticon-close ant-modal-close-icon\"]")
	WebElement close;

	public void close() {
		allMethods.VerifyElementDisplay(close);
		close.click();
	}
}
