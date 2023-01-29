package caughtInDetection.Pages;

import java.io.IOException;

import fours.utils.AllMethods;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import fours.base.BasePage;

public class ColumnSorting extends BasePage{

	AllMethods allMethods;

	public ColumnSorting() throws IOException {
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
	
	@FindBy(xpath = "//a[@href='/caughtInDetection']")
	WebElement caughtIn;
	
	public void CaughtIn() {
		allMethods.VerifyElementDisplay(caughtIn);
		caughtIn.click();
	}
	
	@FindBy(xpath = "//div[@role='tab'][contains(.,'Manage')]")
	WebElement manage;
	
	public void Manage() {
		allMethods.VerifyElementDisplay(manage);
		manage.click();
	}
	
	@FindBy(xpath = "(//span[contains(.,'Id')])[1]")
	WebElement IdClick;
	
	public void IdSorting() {
		allMethods.VerifyElementDisplay(IdClick);
		IdClick.click();
	}
	
	@FindBy(xpath = "//span[contains(.,'Name')]")
	WebElement nameClick;
	
	public void NameSorting() {
		allMethods.VerifyElementDisplay(nameClick);
		nameClick.click();
	}
	
	@FindBy(xpath = "//span[contains(.,'Allowed Workers')]")
	WebElement allowedWorker;
	
	public void AllowedWorkerSorting() {
		allMethods.VerifyElementDisplay(allowedWorker);
		allowedWorker.click();
	}
	
	
	@FindBy(xpath = "//span[contains(.,'Geo Area Id')]")
	WebElement geoAreaId;
	
	public void geoAreaIdSorting() {
		scrollHorizontal(geoAreaId);
		geoAreaId.click();
	}
	
	@FindBy(xpath = "//span[contains(.,'Created At')]")
	WebElement createdAt;
	
	public void createdAtSorting() {
		scrollHorizontal(createdAt);
		createdAt.click();
	}
	
	@FindBy(xpath = "//span[contains(.,'Updated At')]")
	WebElement updatedAt;
	
	public void updatedAtSorting() {
		scrollHorizontal(updatedAt);
		updatedAt.click();
	}
	
	@FindBy(xpath = "//span[contains(.,'Status')]")
	WebElement status;
	
	public void statusSorting() {
		scrollHorizontal(status);
		status.click();
	}

}
