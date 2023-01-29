package siteMonitoring.TestCases;

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
import siteMonitoring.Pages.AssignedOpenPage;
import workerTraking.Pages.WorkerTrackingDateRange;

public class TC_74_SiteMonitoringDateRangeTest extends BasePage{
	
	LoginPage loginPage;
	WorkerTrackingDateRange dateRange;
	AssignedOpenPage assignOpen;
	
	public int DataSet = -1;

	public TC_74_SiteMonitoringDateRangeTest() throws IOException {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {
		
		loginPage = new LoginPage();
		dateRange = new WorkerTrackingDateRange();
		assignOpen = new AssignedOpenPage();
	}
	
	@DataProvider
	public Object[][] getExcelData() throws IOException, InvalidFormatException{
		Object data[][] = TestUtils.dataSupplier("TimeRange",System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+ prop.getProperty("SiteMonitoring"));
		return data;
	}
	
	@Test(dataProvider ="getExcelData")
	@testrail(id ="16691")
	public void DateRange(Map<String,String> map) throws InterruptedException, IOException {
		
		DataSet++;
		
		test = extent.createTest("Site Monitoring -- Date Range Test");
		test.assignCategory("Site Monitoring");

		loginPage.dashboardLink();

		String startDate = Utilities.FormatDate(map.get("StartDate"));
		String sdd = Utilities.FormatDay(map.get("StartDate"));
		String endDate = Utilities.FormatDate(map.get("EndDate"));
		String edd = Utilities.FormatDay(map.get("EndDate"));

		assignOpen.SM();
		dateRange.dateRangeClick();
		dateRange.today();
		dateRange.Day7();
		dateRange.Day30();
		dateRange.DateRange(startDate,endDate,sdd,edd);


}

}
