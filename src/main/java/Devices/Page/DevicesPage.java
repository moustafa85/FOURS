/**
 * 
 */
package Devices.Page;

import java.io.IOException;

import fours.utils.AllMethods;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import fours.base.BasePage;


public class DevicesPage extends BasePage{
AllMethods allMethods;

	public DevicesPage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
		allMethods = new AllMethods(driver);
	}
	
	@FindBy(xpath = "//a[contains(.,'Devices')]") private WebElement DevicesBtn;
	@FindBy(xpath = "//body/div[@id='root']/div[1]/section[1]/div[1]/main[1]/div[1]/div[1]/div[1]/div[1]/span[1]/div[1]/div[3]/button[1]/span[1]/*[1]")private WebElement AddIcon;
	@FindBy(xpath = "//input[contains(@id,'uid')]") private WebElement MACAddress;
	@FindBy(xpath = "(//div[contains(@class,'ant-select-selector')])[5]") private WebElement DeviceType;
	@FindBy(xpath = "//div[@class='ant-select-item-option-content'][contains(.,'Smart Guard')]") private WebElement SmartGuard;
	@FindBy(xpath = "//div[@class='ant-select-item-option-content'][contains(.,'Beacon')]") private WebElement Beacon;
	@FindBy(xpath = "//div[@class='ant-select-item-option-content'][contains(.,'Smart Guardian')]") private WebElement SmartGuardian;
	@FindBy(xpath = "(//input[contains(@type,'number')])[1]") private WebElement Geo1;
	@FindBy(xpath = "(//input[contains(@type,'number')])[2]") private WebElement Geo2;
	@FindBy(xpath = "//button[@type='submit'][contains(.,'Submit')]") private WebElement Submit;
	@FindBy(xpath = "//input[contains(@id,'videoFeedId')]") private WebElement vfid;
	
	@FindBy(xpath = "//input[contains(@class,'ant-input')]") private WebElement SearchTxtFld;
	@FindBy(xpath = "//tbody/tr[2]/td[11]/div[1]/button[1]/span[1]/*[1]") private WebElement EditIcon;
	
	@FindBy(xpath = "(//input[contains(@type,'number')])[1]") private WebElement EditGeo1;
	@FindBy(xpath = "(//input[contains(@type,'number')])[2]") private WebElement EditGeo2;
	@FindBy(xpath = "//button[@type='submit'][contains(.,'Update')]") private WebElement UpdateBtn;
	
	@FindBy(xpath = "//tbody/tr[2]/td[11]/div[1]/span[1]/*[1]") private WebElement DeleteIcon;
	@FindBy(xpath = "//span[contains(text(),'Yes')]") private WebElement YesDelete;
	
	
	
	
	public void clickOnDeviceModule() {
		allMethods.VerifyElementDisplay(DevicesBtn);
		DevicesBtn.click();
	}
	
	public void clickOnAddIcon() {
		allMethods.VerifyElementDisplay(AddIcon);
		AddIcon.click();
	}
	
	public void addMACAddress(String macAddress) {
		allMethods.VerifyElementDisplay(MACAddress);
		MACAddress.click();
		MACAddress.sendKeys(macAddress);
	}
	
	public void selectDevice(String device) throws InterruptedException {
		allMethods.VerifyElementDisplay(DeviceType);
		DeviceType.click();
		if(device.equals("Smart Guard")) {
			allMethods.VerifyElementDisplay(SmartGuard);
			SmartGuard.click();
			////Thread.sleep(2000);
		}else if (device.equals("Beacon")) {
			allMethods.VerifyElementDisplay(Beacon);
			Beacon.click();
			//Thread.sleep(2000);
		}else {
			allMethods.VerifyElementDisplay(SmartGuardian);
			SmartGuardian.click();
			//Thread.sleep(2000);
		}
	}
	
	public void geo1(String geo1) {
		allMethods.VerifyElementDisplay(Geo1);
		Geo1.click();
		Geo1.sendKeys(geo1);
	}
	
	public void geo2(String geo2) {
		allMethods.VerifyElementDisplay(Geo2);
		Geo2.click();
		Geo2.sendKeys(geo2);
	}
	
	public void vfid(String vffid) {
		allMethods.VerifyElementDisplay(vfid);
		vfid.click();
		vfid.sendKeys(vffid);
	}
	
	public void clickOnSearchTxtFld(String data) {
		allMethods.VerifyElementDisplay(SearchTxtFld);
		SearchTxtFld.click();
		SearchTxtFld.sendKeys(data);
		
	}
	public void clickOnEditIcon() {
		allMethods.VerifyElementDisplay(EditIcon);
		EditIcon.click();
	}
	
	public void clickOnSubmit() {
		allMethods.VerifyElementDisplay(Submit);

		Submit.click();
	}	
	
	public void editGeo1(String geo1) {
		allMethods.VerifyElementDisplay(EditGeo1);

		EditGeo1.click();
		EditGeo1.sendKeys(Keys.BACK_SPACE);
		EditGeo1.sendKeys(geo1);
	}
	
	public void editGeo2(String geo2) {
		allMethods.VerifyElementDisplay(EditGeo2);

		EditGeo2.click();
		EditGeo2.sendKeys(Keys.BACK_SPACE);
		EditGeo2.sendKeys(geo2);
	}
	
	public void clickOnUpdate() {
		allMethods.VerifyElementDisplay(UpdateBtn);

		UpdateBtn.click();
	}
	
	public void clickOnDelete() throws InterruptedException {
		allMethods.VerifyElementDisplay(DeleteIcon);

		DeleteIcon.click();
		//Thread.sleep(2000);
		allMethods.VerifyElementDisplay(YesDelete);

		YesDelete.click();
	}	
	
	public boolean DelelteIcon() {
		allMethods.VerifyElementDisplay(DeleteIcon);
		return DeleteIcon.isDisplayed();
	}
	
	
}
