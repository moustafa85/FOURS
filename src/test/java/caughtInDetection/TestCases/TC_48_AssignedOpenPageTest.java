package caughtInDetection.TestCases;

import java.io.IOException;

import fours.Testrail.testrail;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import caughtInDetection.Pages.AssignedOpenCountPage;
import fours.base.BasePage;
import fours.utils.TestUtils;
import fours.utils.Utilities;
import login.Pages.LoginPage;
import workerTraking.Pages.AssignedOpenPage;

public class TC_48_AssignedOpenPageTest extends BasePage{
	
	LoginPage loginPage;
	AssignedOpenCountPage assignOpen;
	TestUtils utils;
	Utilities utilize;

	public TC_48_AssignedOpenPageTest() throws IOException {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {
		loginPage = new LoginPage();
		assignOpen = new AssignedOpenCountPage();
		utils = new TestUtils();
		utilize = new Utilities();
	}

	/**
	 *
	 * @throws InterruptedException
	 * @throws IOException
	 */
	@Test
	@testrail(id = "16712")
	public void AssignedOpenAlertTest() throws InterruptedException, IOException {
		
		test = extent.createTest("Caught-In Detection -- Assigned open alerts");
		test.assignCategory("Caught in Detection");
		loginPage.dashboardLink();
		assignOpen.CaughtIn();
		test.pass("Navigate to Caught In detection page");
		String ele =  assignOpen.AssOpenCount();
		assignOpen.AssOpen();
		test.pass("Click assigned open");
		if(ele.equalsIgnoreCase("0"))
		{
			if(utilize.NoData().equals("No Data")) {
				String text = "Alert Management has No Data and there is no Assigned Open Alert in Caught-In Detection Page";
				utils.ExcelWrite(text,1,1,"Alerts",System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+ prop.getProperty("CaughtInDetection"));
				test.pass("Alert Management has No Data and there is no Assigned Open Alert in Caught-In Detection Page");
			}
		}
		
		else if (ele.equalsIgnoreCase(utilize.TotalCount()))
		{
			String text = "Alerts are matching. Assigned Open Alerts in Caught-In Detection Page and Alert Management Page -- ";
			utils.ExcelWrite(text+utilize.TotalCount(),1,1,"Alerts",System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+prop.getProperty("CaughtInDetection"));
			test.pass("Alerts are matching");
		}
		else 
		{
			String text1 = "Alerts are not matching. Open Alert in Caught-In Detection Page -- ";
			String text2 = ", Open Alert in Alert Management Page -- ";
			String ele2 =  utilize.TotalCount();
			String tx = text1 +""+ ele +""+ text2 +""+ ele2 ;
			utils.ExcelWrite(tx,1,1,"Alerts",System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+ prop.getProperty("CaughtInDetection"));
			test.fail("Alerts are not matching");
		}
		
	}

}
