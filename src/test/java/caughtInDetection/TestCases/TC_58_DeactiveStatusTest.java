package caughtInDetection.TestCases;

import java.io.IOException;

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

public class TC_58_DeactiveStatusTest extends BasePage{
	
	LoginPage loginPage;
	Search search;

	public TC_58_DeactiveStatusTest() throws IOException {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {

		loginPage = new LoginPage();
		search = new Search();
	}
	
	@Test
	@testrail(id = "16721")
	public void DeactiveStatus() throws InterruptedException, IOException {
		
		test = extent.createTest("Caught-In Detection -- Deactive Status");
		test.assignCategory("Caught in Detection");
		loginPage.dashboardLink();
		search.CaughtIn();
		test.pass("Navigate to Caught in detection page");
		search.Manage();
		test.pass("Click Manage Tab");
		search.InactiveStatus();
		test.pass("Filter Inactive data");
	}

}
