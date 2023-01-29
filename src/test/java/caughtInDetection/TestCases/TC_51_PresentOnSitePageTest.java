package caughtInDetection.TestCases;

import java.io.IOException;

import fours.Testrail.testrail;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import caughtInDetection.Pages.PresentOnSitePage;
import fours.base.BasePage;
import fours.utils.TestUtils;
import login.Pages.LoginPage;

public class TC_51_PresentOnSitePageTest extends BasePage{

	LoginPage loginPage;
	PresentOnSitePage sitePage;
	TestUtils utils;
	
	public TC_51_PresentOnSitePageTest() throws IOException {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {
		loginPage = new LoginPage();
		sitePage = new PresentOnSitePage();
		utils = new TestUtils();
	}

	/**
	 *
	 * @throws InterruptedException
	 * @throws IOException
	 */
	@Test
	@testrail(id = "17302")
	public void PresentOnSite() throws InterruptedException, IOException {
		
		test = extent.createTest("Caught-In Detection -- Present On Site");
		test.assignCategory("Caught in Detection");
		loginPage.dashboardLink();
		sitePage.CaughtIn();
		test.pass("Navigate to Caught In detection page");
		String PresentOnSiteNO =sitePage.PresentOnSite();
		test.pass("Validate the Number of worker present on site");
		//todo Validate the present on site number (DB or from side bar)
		utils.ExcelWrite("No of workers are present -- "+PresentOnSiteNO,0,1,"PresentOnSite",System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+ prop.getProperty("CaughtInDetection"));
		test.pass("Present On Site test passed");
		
		
	}

}
