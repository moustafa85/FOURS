package AlertMng.TestCases;

import java.io.IOException;

import fours.Testrail.testrail;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import AlertMng.Pages.actions.ColumnSorting;
import fours.base.BasePage;
import login.Pages.LoginPage;

public class TC_91_ColumnSortingTest extends BasePage{

	public TC_91_ColumnSortingTest() throws IOException {
		super();
	}
	
	LoginPage loginPage;
	ColumnSorting sorting;
	
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {
		//
		loginPage = new LoginPage();
		sorting = new ColumnSorting();
	}

	/**
	 *
	 * @throws InterruptedException
	 */
	@Test
	@testrail(id="16725,16942")
	public void ColumnSorting() throws InterruptedException {

		test = extent.createTest("Alert Management -- Column Sorting");
		test.assignCategory("Alert Management");
		loginPage.dashboardLink();
		sorting.AlertMng();
		test.pass("Navigate to Alert Management page");
		sorting.AlertIdSorting();
		test.pass("Alert ID sort Ascending");
		sorting.AlertIdSorting();
		test.pass("Alert ID sort Descending");
		sorting.AlertTypeSorting();
		test.pass("Alert Type sort Ascending");
		sorting.AlertTypeSorting();
		test.pass("Alert Type sort Descending");
		sorting.StatusSorting();
		test.pass("Alert Status sort Ascending");
		sorting.StatusSorting();
		test.pass("Alert Status sort Descending");
		sorting.WorkerNameSorting();
		test.pass("Worker sort Ascending");
		sorting.WorkerNameSorting();
		test.pass("Worker sort Descending");
		sorting.LocationSorting();
		test.pass("Location sort Ascending");
		sorting.LocationSorting();
		test.pass("Location sort Descending");
		sorting.AssignedToSorting();
		test.pass("Assigned to sort Ascending");
		sorting.AssignedToSorting();
		test.pass("Assigned to sort Descending");
		sorting.DeviceIdSorting();
		test.pass("Device ID to sort Ascending");
		sorting.DeviceIdSorting();
		test.pass("Device ID to sort Dscending");
		sorting.WorkerIdSorting();
		test.pass("Worker ID to sort Ascending");
		sorting.WorkerIdSorting();
		test.pass("Worker ID to sort Descending");
		sorting.WorkerTypeSorting();
		test.pass("Worker Type to sort Ascending");
		sorting.WorkerTypeSorting();
		test.pass("Worker Type to sort Descending");
		sorting.AssignedBySorting();
		test.pass("Assigned By to sort Ascending");
		sorting.AssignedBySorting();
		test.pass("Assigned By to sort Descending");
		sorting.DurationSorting();
		test.pass("Duration to sort Ascending");
		sorting.DurationSorting();
		test.pass("Duration to sort Descending");
		sorting.FinishTimeSorting();
		test.pass("Finish Time sort Ascending");
		sorting.FinishTimeSorting();
		test.pass("Finish Time sort Descending");
		sorting.UpdatedAtSorting();
		test.pass("Updated At sort Ascending");
		sorting.UpdatedAtSorting();
		test.pass("Updated At sort Descending");
		sorting.CreatedAtSorting();
		test.pass("Created At sort Ascending");
		sorting.CreatedAtSorting();
		test.pass("Created At sort Descending");
	    	
	}


}
