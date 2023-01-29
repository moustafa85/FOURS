package device.pages;

import java.io.IOException;

import fours.utils.AllMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import fours.base.BasePage;

public class DeviceBasePage extends BasePage {
AllMethods allMethods;
	public DeviceBasePage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
		allMethods = new AllMethods(driver);
	}
	
	@FindBy(xpath = "//a[contains(.,'Devices')]")
	WebElement deviceModule;
	
	public void DeviceModule() {
		allMethods.VerifyElementDisplay(deviceModule);

		deviceModule.click();
	}
	
	@FindBy(xpath = "(//input[contains(@type,'number')])[1]")
	WebElement longitude;
	
	public  void Longitude(String longi){
		allMethods.VerifyElementDisplay(longitude);
		longitude.sendKeys(Keys.CONTROL + "a");
		longitude.sendKeys(Keys.DELETE);
		longitude.sendKeys(longi);
   }
	
	@FindBy(xpath = "(//input[contains(@type,'number')])[2]")
	WebElement latitude;
	
	public  void Latitude(String lat){
		allMethods.VerifyElementDisplay(latitude);

		latitude.sendKeys(Keys.CONTROL + "a");
		latitude.sendKeys(Keys.DELETE);
		latitude.sendKeys(lat);
   }
	
	//--------- Additional Details for Smart Guard -----------
	
	@FindBy(xpath = "(//span[contains(@class,'ant-select-selection-item')])[6]")
	WebElement loRaWanVersion;
	
	public  void LoRaWanVersion(String LoRaWan) throws InterruptedException{
		allMethods.VerifyElementDisplay(loRaWanVersion);
		loRaWanVersion.click();
		//Thread.sleep(1000);
		allMethods.VerifyElementDisplay(driver.findElement(By.xpath("//div[@class='ant-select-item-option-content'][contains(.,'"+LoRaWan+"')]")));
		driver.findElement(By.xpath("//div[@class='ant-select-item-option-content'][contains(.,'"+LoRaWan+"')]")).click();
	}
		
	@FindBy(xpath = "//input[contains(@aria-owns,'devClass_list')]")
	WebElement devClass;
	
	public  void DevClass(String devclass) throws InterruptedException{
		allMethods.VerifyElementDisplay(devClass);

		devClass.click();
//		Thread.sleep(1000);
		allMethods.VerifyElementDisplay(driver.findElement(By.xpath("//div[@class='ant-select-item-option-content'][contains(.,'"+devclass+"')]")));
		driver.findElement(By.xpath("//div[@class='ant-select-item-option-content'][contains(.,'"+devclass+"')]")).click();
	}
		
	@FindBy(xpath = "//input[contains(@id,'applicationEUI')]")
	WebElement appEUI;

	public  void AppEUI(String EUI){
		allMethods.VerifyElementDisplay(appEUI);

		appEUI.sendKeys(Keys.CONTROL + "a");
		appEUI.sendKeys(Keys.DELETE);
		appEUI.sendKeys(EUI);
	}
		
	@FindBy(xpath = "//input[contains(@id,'appSessionKey')]")
	WebElement appSessionKey;

	public  void AppSessionKey(String SessionKey){
		allMethods.VerifyElementDisplay(appSessionKey);

		appSessionKey.sendKeys(Keys.CONTROL + "a");
		appSessionKey.sendKeys(Keys.DELETE);
		appSessionKey.sendKeys(SessionKey);
	}
	
	@FindBy(xpath = "//input[contains(@placeholder,'Search for ID and Device UID...')]")
	WebElement search;
	
	public  void Search(String deviceId){
		allMethods.VerifyElementDisplay(search);
		search.sendKeys(deviceId);
   }
	
	@FindBy(xpath = "//span[@class='ant-select-selection-item'][contains(.,'Active')]")
	WebElement status;
	
	public  void StatusBoth() throws InterruptedException{
		allMethods.VerifyElementDisplay(status);
		status.click();
//		Thread.sleep(1000);
		allMethods.VerifyElementDisplay(driver.findElement(By.xpath("//div[@class='ant-select-item-option-content'][contains(.,'Both')]")));

		driver.findElement(By.xpath("//div[@class='ant-select-item-option-content'][contains(.,'Both')]")).click();
   }
	
	@FindBy(xpath = "//span[@class='anticon anticon-delete']")
	WebElement deleteDevice;
	
	public void deleteDevice() throws InterruptedException {
		allMethods.VerifyElementDisplay(deleteDevice);

		deleteDevice.click();
	}
	
	@FindBy(xpath = "//button[@type='button'][contains(.,'Yes')]")
	WebElement deleteUserConfirm;
	
	public void deleteDeviceConfirm() throws InterruptedException {
		allMethods.VerifyElementDisplay(deleteUserConfirm);

		deleteUserConfirm.click();
	}

}
