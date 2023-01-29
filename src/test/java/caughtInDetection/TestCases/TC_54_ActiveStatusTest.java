package caughtInDetection.TestCases;

import java.io.IOException;

import fours.Testrail.testrail;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import caughtInDetection.Pages.Search;
import fours.base.BasePage;
import login.Pages.LoginPage;

public class TC_54_ActiveStatusTest extends BasePage{
	
	LoginPage loginPage;
	Search search;

	public TC_54_ActiveStatusTest() throws IOException {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {
		
		loginPage = new LoginPage();
		search = new Search();
	}

	/**
	 *
	 * @throws InterruptedException
	 * @throws IOException
	 */
	@Test
	@testrail(id = "16721")
	public void ActiveStatus() throws InterruptedException, IOException {
		test = extent.createTest("Caught-In Detection -- Active Status");
		test.assignCategory("Caught in Detection");
		loginPage.dashboardLink();
		search.CaughtIn();
		test.pass("Navigate to Caught in detection page");
		search.Manage();
		test.pass("Click Manage tab");
		search.ActiveStatus();
		test.pass("Filter Active Status");
	}

}
