package caughtInDetection.TestCases;

import java.io.IOException;
import java.util.Map;

import fours.Testrail.testrail;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import caughtInDetection.Pages.AllowedWorker;
import caughtInDetection.Pages.Search;
import fours.base.BasePage;
import fours.utils.TestUtils;
import login.Pages.LoginPage;

public class TC_60_AllowedWorkerTest extends BasePage{

	public TC_60_AllowedWorkerTest() throws IOException {
		super();
	}
	
	LoginPage loginPage;
	Search search;
	AllowedWorker allowedWorker;
	TestUtils utils;
	
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {

		loginPage = new LoginPage();
		search = new Search();
		allowedWorker = new AllowedWorker();
		utils = new TestUtils();
	}
	
	@DataProvider
	public Object[][] getExcelData() throws IOException, InvalidFormatException{
		Object data[][] = TestUtils.dataSupplier("AllowedWorker",System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+ prop.getProperty("CaughtInDetection"));
		return data;
	}

	/**
	 *
	 * @throws InterruptedException
	 * @throws IOException
	 */
	@testrail(id = "")
	@Test(dataProvider ="getExcelData")
	public void AllowedWorker(Map<String,String> map) throws InterruptedException, IOException {
		test = extent.createTest("Caught-In Detection -- Allowed Worker Test");
		test.assignCategory("Caught in Detection");
		loginPage.dashboardLink();
		search.CaughtIn();
		test.pass("Navigate to Caught in detection page");
		search.Manage();
		test.pass("Click Manage tab");
		search.StatusBoth();
		test.pass("Filter Status both");
		search.Search(map.get("Search"));
		test.pass("search for : "+map.get("Search"));
		allowedWorker.ViewWorker();
		test.pass("Click View Worker");
		allowedWorker.closeButton();
		test.pass("Click Close button");
		
	}

}
