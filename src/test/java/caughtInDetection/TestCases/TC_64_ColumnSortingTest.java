package caughtInDetection.TestCases;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import caughtInDetection.Pages.ColumnSorting;
import fours.base.BasePage;
import fours.utils.Utilities;
import login.Pages.LoginPage;

public class TC_64_ColumnSortingTest extends BasePage{

	public TC_64_ColumnSortingTest() throws IOException {
		super();
	}
	
	LoginPage loginPage;
	ColumnSorting sorting;
	Utilities utilize;
	
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {
		
		loginPage = new LoginPage();
		sorting = new ColumnSorting();
		utilize = new Utilities();
	}
	
	@Test
	public void AllowedWorker() throws InterruptedException, IOException {
		
		test = extent.createTest("Caught-In Detection -- Allowed Worker Test");
		test.assignCategory("Caught in Detection");

		
		loginPage.dashboardLink();
		sorting.CaughtIn();
		test.pass("Navigate to Caught in detection");
		sorting.Manage();
		test.pass("Click Manage tab");
		test.pass("Start column sorting");
		sorting.IdSorting();
		sorting.IdSorting();
		sorting.NameSorting();
		sorting.NameSorting();
		sorting.AllowedWorkerSorting();
		sorting.AllowedWorkerSorting();
		WebElement Element = driver.findElement(By.xpath("//span[contains(.,'Allowed Workers')]"));
		utilize.ScrollToLocation(Element);
		sorting.geoAreaIdSorting();
		sorting.geoAreaIdSorting();
		sorting.createdAtSorting();
		sorting.createdAtSorting();
		sorting.updatedAtSorting();
		sorting.updatedAtSorting();
		sorting.statusSorting();
		sorting.statusSorting();
		test.pass("Column sorting");
	}

}
