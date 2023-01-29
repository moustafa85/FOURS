package Dashboard.Pages;

import java.io.IOException;

import fours.utils.AllMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import fours.base.BasePage;

public class ColumnSort extends BasePage{
	AllMethods allMethods;

	public ColumnSort() throws IOException {
		super();
		PageFactory.initElements(driver, this);
		allMethods = new AllMethods(driver);
	}
	
	@FindBy(xpath = "//span[contains(.,'Alert Id')]")
	WebElement alertSorting;
	
	public void AlertSorting() {
		allMethods.VerifyElementDisplay(alertSorting);
		alertSorting.click();
	}
	
	@FindBy(xpath = "//span[contains(.,'Created At')]")
	WebElement createdAtSorting;
	
	public void CreatedAtSorting() {
		allMethods.VerifyElementDisplay(createdAtSorting);
		createdAtSorting.click();
	}
	
	@FindBy(xpath = "//span[contains(.,'Type')]")
	WebElement typeSorting;
	
	public void TypeSorting() {
		allMethods.VerifyElementDisplay(typeSorting);
		typeSorting.click();
	}
	
	@FindBy(xpath = "//span[contains(.,'Status')]")
	WebElement statusSorting;
	
	public void StatusSorting() {
		allMethods.VerifyElementDisplay(statusSorting);
		statusSorting.click();
	}
	
	@FindBy(xpath = "(//span[contains(.,'Worker')])[5]")
	WebElement workerSorting;
	
	public void WorkerSorting() {
		allMethods.VerifyElementDisplay(workerSorting);
		workerSorting.click();
	}
	
	@FindBy(xpath = "//span[contains(.,'Location')]")
	WebElement locationSorting;
	
	public void LocationSorting() {
		allMethods.VerifyElementDisplay(locationSorting);
		locationSorting.click();
	}
	
	@FindBy(xpath = "//span[contains(.,'Assigned To')]")
	WebElement assignedToSorting;
	
	public void AssignedToSorting() {
		allMethods.VerifyElementDisplay(assignedToSorting);
		assignedToSorting.click();
	}

}
