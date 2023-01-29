package caughtInDetection.TestCases;

import java.io.IOException;
import java.util.Map;

import fours.Testrail.testrail;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import caughtInDetection.Pages.Search;
import fours.base.BasePage;
import fours.utils.TestUtils;
import fours.utils.Utilities;
import login.Pages.LoginPage;

public class TC_65_PaginationTest extends BasePage{
	
	LoginPage loginPage;
	Search search;
	Utilities utilize;

	public TC_65_PaginationTest() throws IOException {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {

		loginPage = new LoginPage();
		search = new Search();
		utilize = new Utilities();
	}
	
	@DataProvider
	public Object[][] getExcelData() throws IOException, InvalidFormatException{
		Object data[][] = TestUtils.dataSupplier("Pagination",System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+ prop.getProperty("CaughtInDetection"));
		return data;
	}

	@testrail(id = "16719")
	@Test(dataProvider ="getExcelData")
	public void PaginationTest(Map<String,String> map) throws InterruptedException, IOException {
		
		test = extent.createTest("Caught-In Detection -- Pagination");
		test.assignCategory("Caught in Detection");
		loginPage.dashboardLink();
		search.CaughtIn();
		test.pass("Navigate to Caught in detection");
		search.Manage();
		test.pass("Click manage tab");
		search.StatusBoth();
		test.pass("Filter Both");
		if(utilize.Pagination(map.get("PageType"),map.get("PageNo"),map.get("LastPageNo")))
			test.pass("Verify Pagination functionality ");
		else
			test.fail("Pagination Functionality failed");
	}

}
