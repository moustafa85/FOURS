package workerTracking.TestCases;

import java.io.IOException;

import fours.Testrail.testrail;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import fours.base.BasePage;
import fours.utils.TestUtils;
import fours.utils.Utilities;
import login.Pages.LoginPage;
import workerTraking.Pages.AssignedOpenPage;
import workerTraking.Pages.PresentOnSitePage;

public class TC_38_PresentOnSiteTest extends BasePage{
	
	LoginPage loginPage;
	PresentOnSitePage sitePage;
	TestUtils utils;

	public TC_38_PresentOnSiteTest() throws IOException {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {
		
		loginPage = new LoginPage();
		sitePage = new PresentOnSitePage();
		utils = new TestUtils();
	}
	
	@Test
	@testrail(id = "16688")
	public void PresentOnSite() throws InterruptedException, IOException {
		
		test = extent.createTest("Worker Tracking -- Present On Site Test");
		test.assignCategory("Worker Tracking");

		loginPage.dashboardLink();
		
		sitePage.WT();
		sitePage.PresentOnSite();
		
		utils.ExcelWrite("No of workers are present -- "+sitePage.PresentOnSite(),0,1,"PresentOnSite",System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+ prop.getProperty("workerTracking"));
		test.pass("Present On Site test passed");
		
		
	}

}
