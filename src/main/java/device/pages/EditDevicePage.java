package device.pages;

import java.io.IOException;

import fours.utils.AllMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import fours.base.BasePage;

public class EditDevicePage extends BasePage{
AllMethods allMethods;
	public EditDevicePage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
		allMethods = new AllMethods(driver);
	}
	
	@FindBy(xpath = "(//td[@class='ant-table-cell'])[3]")
	WebElement deviceType;
	
	public  String DeviceType(){
		allMethods.VerifyElementDisplay(deviceType);
		String type = deviceType.getText();
		return type;
   }
	
	@FindBy(xpath = "//span[@class='anticon anticon-edit']")
	WebElement editDevice;
	
	public  void EditDevice(){
		allMethods.VerifyElementDisplay(editDevice);
		editDevice.click();
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
	
	//------- additional details for smart guard ------------
	
	
	@FindBy(xpath = "(//span[contains(@class,'ant-select-selection-item')])[6]")
	WebElement loRaWanVersion;
	
	public  void LoRaWanVersion(String LoRaWan) throws InterruptedException{
		allMethods.VerifyElementDisplay(loRaWanVersion);
		loRaWanVersion.click();
		//Thread.sleep(1000);
		allMethods.VerifyElementDisplay(driver.findElement(By.xpath("//div[@class='ant-select-item-option-content'][contains(.,'"+LoRaWan+"')]")));
		driver.findElement(By.xpath("//div[@class='ant-select-item-option-content'][contains(.,'"+LoRaWan+"')]")).click();
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
	
	@FindBy(xpath = "(//span[contains(@class,'ant-select-selection-item')])[7]")
	WebElement devClass;
	
	public  void DevClass(String devclass) throws InterruptedException{
		allMethods.VerifyElementDisplay(devClass);
		devClass.click();
		//Thread.sleep(1000);
		allMethods.VerifyElementDisplay(driver.findElement(By.xpath("//div[@class='ant-select-item-option-content'][contains(.,'"+devclass+"')]")));

		driver.findElement(By.xpath("//div[@class='ant-select-item-option-content'][contains(.,'"+devclass+"')]")).click();
	}
	
	@FindBy(xpath = "//button[@type='submit'][contains(.,'Update')]")
	WebElement update;

	public  void Update( ){
		allMethods.VerifyElementDisplay(update);
		update.click();
	}
	
}
