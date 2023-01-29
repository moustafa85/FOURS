package device.TestCases;

import java.io.IOException;

import fours.Testrail.testrail;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import device.pages.ActivateDevicePage;
import device.pages.DeviceBasePage;
import device.pages.columnSorting;
import fours.base.BasePage;
import fours.utils.TestUtils;
import fours.utils.Utilities;
import login.Pages.LoginPage;

public class TC_103_ColumnSortingTesting extends BasePage{

	public TC_103_ColumnSortingTesting() throws IOException {
		super();
	}
	
	LoginPage loginPage;
	columnSorting sorting;
	
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {
		
		loginPage = new LoginPage();
		sorting = new columnSorting();
	}
	@testrail(id = "16642,16825,16816,16864,16882,16873")
	@Test
	public void ColumnSorting() throws InterruptedException, IOException {

		
		test = extent.createTest("Column Sorting");
		test.assignCategory("Devices");

		loginPage.dashboardLink();
		sorting.DeviceModule();
		sorting.DeviceIDSorting();
		sorting.DeviceIDSorting();
		sorting.DeviceUIDSorting();
		sorting.DeviceUIDSorting();
		sorting.DeviceTypeSorting();
		sorting.DeviceTypeSorting();
		sorting.siteSorting();
		sorting.siteSorting();
		sorting.statusSorting();
		sorting.statusSorting();
		sorting.LocationSorting();
		sorting.LocationSorting();
		sorting.BatterySorting();
		sorting.BatterySorting();
		sorting.LastSeenAtSorting();
		sorting.LastSeenAtSorting();
		sorting.AssignedBySorting();
		sorting.AssignedBySorting();
		sorting.CreatedAtSorting();
		sorting.CreatedAtSorting();
		sorting.UpdatedAtSorting();
		sorting.UpdatedAtSorting();
	}
}
