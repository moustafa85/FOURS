package AlertMng.Pages.actions;

import java.io.IOException;

import AlertMng.Pages.locators.ColumnSortingLocators;
import fours.utils.AllMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import fours.base.BasePage;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class ColumnSorting extends BasePage{
	AllMethods allMethods;
	ColumnSortingLocators columnSorting;
	public ColumnSorting() throws IOException {

		super();
		this.columnSorting = new ColumnSortingLocators();
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver,10);
		PageFactory.initElements(factory, this.columnSorting);
		allMethods = new AllMethods(driver);
	}


	public void scrollHorizontal(WebElement webElement){
		allMethods.VerifyElementDisplay(webElement);
		JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
		javascriptExecutor.executeScript("document.getElementsByClassName(\"ant-table-body\")[0].scrollLeft += 100;");
		javascriptExecutor.executeScript("arguments[0].scrollLeft = arguments[0].offsetWidth", webElement);

	}

	
	public void AlertMng() {
		allMethods.VerifyElementDisplay(columnSorting.alertMng);
		columnSorting.alertMng.click();
	}
	

	
	public void AlertIdSorting() {
		allMethods.VerifyElementDisplay(columnSorting.alertId);

		columnSorting.alertId.click();
	}

	
	public void AlertTypeSorting() {
		allMethods.VerifyElementDisplay(columnSorting.alertType);
		columnSorting.alertType.click();
	}

	
	public void StatusSorting() {
		allMethods.VerifyElementDisplay(columnSorting.status);
		columnSorting.status.click();
	}

	
	public void WorkerNameSorting() {
		allMethods.VerifyElementDisplay(columnSorting.workerName);
		columnSorting.workerName.click();
	}

	
	public void LocationSorting() {
		scrollHorizontal(columnSorting.location);
		columnSorting.location.click();
	}

	
	public void AssignedToSorting() {
		scrollHorizontal(columnSorting.assignedTo);
		columnSorting.assignedTo.click();
	}

	
	public void DeviceIdSorting() {
		scrollHorizontal(columnSorting.deviceId);
		columnSorting.deviceId.click();
	}

	public void WorkerIdSorting() {
		scrollHorizontal(columnSorting.workerId);
		columnSorting.workerId.click();
	}

	
	public void WorkerTypeSorting() {
		scrollHorizontal(columnSorting.workerType);
		columnSorting.workerType.click();
	}

	
	public void AssignedBySorting() {
		scrollHorizontal(columnSorting.assignedBy);
		columnSorting.assignedBy.click();
	}

	
	public void DurationSorting() {
		scrollHorizontal(columnSorting.duration);
		columnSorting.duration.click();
	}

	
	public void FinishTimeSorting() {
		scrollHorizontal(columnSorting.finishTime);

		columnSorting.finishTime.click();
	}

	
	public void UpdatedAtSorting() {
		scrollHorizontal(columnSorting.updatedAt);
		columnSorting.updatedAt.click();
	}
	
	public void CreatedAtSorting() {
		scrollHorizontal(columnSorting.createdAt);
		columnSorting.createdAt.click();
	}

}
