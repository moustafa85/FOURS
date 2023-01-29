package device.pages;

import java.io.IOException;

import fours.utils.AllMethods;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import fours.base.BasePage;

public class columnSorting extends BasePage{
AllMethods allMethods;
	public columnSorting() throws IOException {
		super();
		PageFactory.initElements(driver, this);
		allMethods = new AllMethods(driver);
	}
	public void scrollHorizontal(WebElement webElement){
		allMethods.VerifyElementDisplay(webElement);
		JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
		javascriptExecutor.executeScript("document.getElementsByClassName(\"ant-table-body\")[0].scrollLeft += 100;");
		javascriptExecutor.executeScript("arguments[0].scrollLeft = arguments[0].offsetWidth", webElement);

	}
	
	@FindBy(xpath = "//a[contains(.,'Devices')]")
	WebElement deviceModule;
	
	public void DeviceModule() {
		allMethods.VerifyElementDisplay(deviceModule);
		deviceModule.click();
	}
	
	@FindBy(xpath = "//span[contains(.,'Device Id')]")
	WebElement deviceID;
	
	public void DeviceIDSorting() {
		allMethods.VerifyElementDisplay(deviceID);
		deviceID.click();
	}
	
	@FindBy(xpath = "//span[contains(.,'Device UID')]")
	WebElement deviceUID;
	
	public void DeviceUIDSorting() {
		allMethods.VerifyElementDisplay(deviceUID);
		deviceUID.click();
	}
	
	@FindBy(xpath = "//span[contains(.,'Device Type')]")
	WebElement deviceType;
	
	public void DeviceTypeSorting() {
		allMethods.VerifyElementDisplay(deviceType);
		deviceType.click();
	}
	
	@FindBy(xpath = "(//span[contains(.,'Sites')])[3]")
	WebElement site;
	
	public void siteSorting() {
		allMethods.VerifyElementDisplay(site);
		site.click();
	}
	
	@FindBy(xpath = "//span[contains(.,'Status')]")
	WebElement status;
	
	public void statusSorting() {
		allMethods.VerifyElementDisplay(status);
		status.click();
	}
	
	@FindBy(xpath = "//th[@class='ant-table-cell'][contains(.,'Location')]")
	WebElement location;
	
	public void LocationSorting() {
		scrollHorizontal(location);
		allMethods.VerifyElementDisplay(location);
		location.click();
	}
	
	@FindBy(xpath = "//span[contains(.,'Battery')]")
	WebElement battery;

	public void BatterySorting() {
		scrollHorizontal(battery);
		allMethods.VerifyElementDisplay(battery);
		battery.click();
	}
	
	@FindBy(xpath = "//span[contains(.,'Last Seen At')]")
	WebElement lastSeenAt;
	
	public void LastSeenAtSorting() {
		scrollHorizontal(lastSeenAt);
		allMethods.VerifyElementDisplay(lastSeenAt);
		lastSeenAt.click();
	}
	
	@FindBy(xpath = "//th[contains(.,'Assigned By')]")
	WebElement assignedBy;
	
	public void AssignedBySorting() {
		scrollHorizontal(assignedBy);
		allMethods.VerifyElementDisplay(assignedBy);
		assignedBy.click();
	}
	
	@FindBy(xpath = "//span[contains(.,'Created At')]")
	WebElement createdAt;
	
	public void CreatedAtSorting() {
		scrollHorizontal(createdAt);
		allMethods.VerifyElementDisplay(createdAt);
		createdAt.click();
	}
	
	@FindBy(xpath = "//span[contains(.,'Updated At')]")
	WebElement updatedAt;
	
	public void UpdatedAtSorting() {
		scrollHorizontal(updatedAt);
		allMethods.VerifyElementDisplay(updatedAt);
		updatedAt.click();
	}

}
