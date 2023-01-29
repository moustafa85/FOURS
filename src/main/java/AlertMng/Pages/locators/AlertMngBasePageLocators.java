package AlertMng.Pages.locators;

import fours.base.BasePage;
import fours.utils.AllMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;

public class AlertMngBasePageLocators {

	
	@FindBy(linkText = "Alert Management")
	public WebElement alertMng;

	@FindBy(xpath = "//input[contains(@type,'text')]")
	public WebElement search;

	@FindBy(xpath = "//span[@class='anticon anticon-read']")
	public WebElement detail;

	@FindBy(xpath = "(//input[contains(@type,'search')])[2]")
	public WebElement assignuser;

	@FindBy(xpath = "//button[contains(@type,'submit')]")
	public WebElement assign;

	@FindBy(xpath = "//span[contains(text(),'All')]")
	public WebElement status;
	
	@FindBy(xpath = "(//div[@class='ant-select-item-option-content'][contains(.,'Open')])[1]")
	public WebElement open;

	@FindBy(xpath = "//span[@class = \"ant-page-header-heading-title\"]")
	public WebElement alertDetailsPageTitle;

}
