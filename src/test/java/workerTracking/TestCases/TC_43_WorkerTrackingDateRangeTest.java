package workerTracking.TestCases;

import java.io.IOException;
import java.util.Map;

import fours.Testrail.testrail;
import fours.utils.Utilities;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import fours.base.BasePage;
import fours.utils.TestUtils;
import login.Pages.LoginPage;
import workerTraking.Pages.WorkerTrackingDateRange;

public class TC_43_WorkerTrackingDateRangeTest extends BasePage{
	
	LoginPage loginPage;
	WorkerTrackingDateRange dateRange;
	

	public TC_43_WorkerTrackingDateRangeTest() throws IOException {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {

		loginPage = new LoginPage();
		dateRange = new WorkerTrackingDateRange();
	}
	
	@DataProvider
	public Object[][] getExcelData() throws IOException, InvalidFormatException{
		Object data[][] = TestUtils.dataSupplier("TimeRange",System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+ prop.getProperty("workerTracking"));
		return data;
	}
	
	@Test(dataProvider ="getExcelData")
	@testrail(id = "16683")
	public void DateRange(Map<String,String> map) throws InterruptedException, IOException {
		test = extent.createTest("Date Range Test");
		test.assignCategory("Worker Tracking");
		loginPage.dashboardLink();
		String startDate = Utilities.FormatDate(map.get("StartDate"));
		String sdd =  Utilities.FormatDay(map.get("StartDate"));
		String endDate = Utilities.FormatDate(map.get("EndDate"));
		String edd = Utilities.FormatDay(map.get("EndDate"));
		dateRange.WT();
		dateRange.dateRangeClick();
		dateRange.today();
		dateRange.Day7();
		dateRange.Day30();
		dateRange.DateRange(startDate,endDate,sdd,edd);

}

}
