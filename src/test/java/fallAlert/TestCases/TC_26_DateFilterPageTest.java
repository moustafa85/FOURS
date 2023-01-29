package fallAlert.TestCases;

import java.io.IOException;
import java.util.Map;

import fours.Testrail.testrail;
import fours.utils.Utilities;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import fallAlert.Pages.DateFilterPage;
import fours.base.BasePage;
import fours.utils.TestUtils;
import login.Pages.LoginPage;

public class TC_26_DateFilterPageTest extends BasePage{
	
	LoginPage loginPage;
	DateFilterPage filter;

	public TC_26_DateFilterPageTest() throws IOException {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {

		loginPage = new LoginPage();
		filter = new DateFilterPage();
	}
	
	@DataProvider
	public Object[][] getExcelData() throws IOException, InvalidFormatException{
		Object data[][] = TestUtils.dataSupplier("TimeRangeFilter",System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+ prop.getProperty("FallAlert"));
		return data;
	}

	@Test(dataProvider ="getExcelData")
	@testrail(id = "16677")
	public void DateFilterTest(Map<String,String>map) throws InterruptedException, IOException {
		
		test = extent.createTest("Fall Alerts -- Date Range filter");
		test.assignCategory("Fall Alerts");

		loginPage.dashboardLink();
		filter.FAlert();
		filter.dateRangeClick();
		filter.today();
		filter.Day7();
		filter.Day30();
		String startDate = Utilities.FormatDate(map.get("StartDate"));
		String endDate = Utilities.FormatDate(map.get("EndDate"));
		filter.TimeRange(startDate,endDate);
	}
}
