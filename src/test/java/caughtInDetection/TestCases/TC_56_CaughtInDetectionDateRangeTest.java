package caughtInDetection.TestCases;

import java.io.IOException;
import java.util.Map;

import fours.Testrail.testrail;
import fours.utils.Utilities;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import caughtInDetection.Pages.AssignedOpenCountPage;
import fours.base.BasePage;
import fours.utils.TestUtils;
import login.Pages.LoginPage;
import workerTraking.Pages.WorkerTrackingDateRange;

public class TC_56_CaughtInDetectionDateRangeTest extends BasePage{
	
	LoginPage loginPage;
	WorkerTrackingDateRange dateRange;
	AssignedOpenCountPage assignOpen;
	
	public int DataSet = -1;

	public TC_56_CaughtInDetectionDateRangeTest() throws IOException {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {
		
		loginPage = new LoginPage();
		dateRange = new WorkerTrackingDateRange();
		assignOpen = new AssignedOpenCountPage();
	}
	
	@DataProvider
	public Object[][] getExcelData() throws IOException, InvalidFormatException{
		Object data[][] = TestUtils.dataSupplier("TimeRange",System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+ prop.getProperty("CaughtInDetection"));
		return data;
	}

	/**
	 *
	 * @throws InterruptedException
	 * @throws IOException
	 */
	@testrail(id = "16710")
	@Test(dataProvider ="getExcelData")
	public void DateRange(Map<String, String> map) throws InterruptedException, IOException {
		DataSet++;
		test = extent.createTest("Caught-In Detection Date Range");
		test.assignCategory("Caught in Detection");
		loginPage.dashboardLink();
		String startDate = Utilities.FormatDate(map.get("StartDate"));
		String sdd = Utilities.FormatDay(map.get("StartDate"));
		String endDate = Utilities.FormatDate(map.get("EndDate"));
		String edd = Utilities.FormatDay(map.get("EndDate"));
		assignOpen.CaughtIn();
		test.pass("Navigate to Caught in detection page");
		dateRange.dateRangeClick();
		test.pass("Click data range list");
		dateRange.today();
		test.pass("Filter Today alerts");
		dateRange.Day7();
		test.pass("Filter thr last 7 days alerts");
		dateRange.Day30();
		test.pass("Filter the last month alerts");
		dateRange.DateRange(startDate,endDate,sdd,edd);
		test.pass("Filter the alerts for the period : "+startDate +" - "+endDate);
	    

}

}
