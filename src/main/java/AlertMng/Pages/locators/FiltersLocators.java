package AlertMng.Pages.locators;

import fours.base.BasePage;
import fours.utils.AllMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class FiltersLocators{

	@FindBy(xpath = "//span[@class='ant-select-selection-item'][contains(.,'All')]")
	public WebElement statusClick;

	@FindBy(xpath = "(//div[contains(@class,'ant-select-selection-overflow')])[1]")
	public WebElement alertTypeClick;
	
	@FindBy(xpath = "//input[@id='workers']")
	public WebElement workerClick;
	
	@FindBy(xpath = "//input[@id='device']")
	public WebElement deviceClick;
	
	@FindBy(xpath = "//input[@id='pId']")
	public WebElement siteClick;

	@FindBy(xpath = "//input[@id='assignedTo']")
	public WebElement assignedTo;

	@FindBy(xpath = "//input[@id='assignedBy']")
	public WebElement assignedBy;

	@FindBy(xpath = "(//button[contains(@type,'button')])[1]")
	public WebElement download;

	@FindBy(xpath = "//span[@class=\"anticon anticon-close ant-modal-close-icon\"]")
	public WebElement CloseDownload;

	@FindBy(xpath = "//input[@placeholder='Start date']")
	public WebElement startDate;
	
	@FindBy(xpath = "//input[@placeholder='End date']")
	public WebElement endDate;


}
