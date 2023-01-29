package AlertMng.Pages.locators;

import fours.base.BasePage;
import fours.utils.AllMethods;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class ColumnSortingLocators{
	@FindBy(xpath = "(//td[contains(@class,'ant-table-cell')])")
	public WebElement tableArea;

	@FindBy(linkText = "Alert Management")
	public WebElement alertMng;

	@FindBy(xpath = "//span[contains(text(),'Alert Id')]")
	public WebElement alertId;
	
	@FindBy(xpath = "(//div[contains(@class,'ant-table-column-sorters')])[4]")
	public WebElement alertType;

	@FindBy(xpath = "//span[contains(.,'Status')]")
	public WebElement status;

	@FindBy(xpath = "//span[contains(.,'Worker Name')]")
	public WebElement workerName;
	
	@FindBy(xpath = "//span[contains(.,'Location')]")
	public WebElement location;

	@FindBy(xpath = "//span[contains(.,'Assigned To')]")
	public WebElement assignedTo;

	@FindBy(xpath = "//span[contains(.,'Device Id')]")
	public WebElement deviceId;

	@FindBy(xpath = "//span[contains(.,'Worker Id')]")
	public WebElement workerId;

	@FindBy(xpath = "//span[contains(.,'Worker Type')]")
	public WebElement workerType;

	@FindBy(xpath = "//span[contains(.,'Assigned By')]")
	public WebElement assignedBy;

	@FindBy(xpath = "//span[contains(.,'Duration')]")
	public WebElement duration;

	@FindBy(xpath = "//span[contains(.,'Finish Time')]")
	public WebElement finishTime;

	@FindBy(xpath = "//span[contains(.,'Updated At')]")
	public WebElement updatedAt;

	@FindBy(xpath = "//span[contains(.,'Created At')]")
	public WebElement createdAt;

}
