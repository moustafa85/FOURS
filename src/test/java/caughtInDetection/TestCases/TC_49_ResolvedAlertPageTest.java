package caughtInDetection.TestCases;

import java.io.IOException;

import fours.Testrail.testrail;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import caughtInDetection.Pages.ResolvedAlertCountPage;
import fours.base.BasePage;
import fours.utils.TestUtils;
import fours.utils.Utilities;
import login.Pages.LoginPage;
import workerTraking.Pages.ResolvedAlertPage;

public class TC_49_ResolvedAlertPageTest extends BasePage{
	
	LoginPage loginPage;
	ResolvedAlertCountPage ResolvedAlert;
	TestUtils utils;
	Utilities utilize;

	public TC_49_ResolvedAlertPageTest() throws IOException {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {
		loginPage = new LoginPage();
		ResolvedAlert = new ResolvedAlertCountPage();
		utils = new TestUtils();
		utilize = new Utilities();
	}

	@Test
	@testrail(id = "16712")
	public void ResolvedAlertTest() throws InterruptedException, IOException {
		
		test = extent.createTest("Caught-In Detection -- Resolved alerts");
		test.assignCategory("Caught in Detection");
		loginPage.dashboardLink();
		ResolvedAlert.CaughtIn();
		test.pass("Navigate to Caught In detection page");
		String ele =  ResolvedAlert.ResolvedCount();
		ResolvedAlert.Resolved();
		test.pass("Click Resolved alerts");

		if(ele.equalsIgnoreCase("0"))
		{
			if(utilize.NoData().equals("No Data")) {
				String text ="Alert Management has No Data and there is no Resolved Alert in Caught-In Detection Page";
				utils.ExcelWrite(text,2,1,"Alerts",System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+prop.getProperty("CaughtInDetection"));
				test.pass("Alert Management has No Data and there is no Resolved Alert in Caught-In Detection Page");
			}
		}
		
		else if (ele.equalsIgnoreCase(utilize.TotalCount()))
		{	
			String text = "Alerts. are matching. Resolved Alerts in Caught-In Detection and Alert Management Page -- ";
			utilize.TotalCount();
			utils.ExcelWrite(text+utilize.TotalCount(),2,1,"Alerts",System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+ prop.getProperty("CaughtInDetection"));
			test.pass("Alerts are matching");
		}
		else
		{
			String text1 = "Alerts are not matching. Resolved Alert in Caught-In Detection Page -- ";
			String text2 = ", Resolved Alert in Alert Management Page -- ";
			String ele2 =  utilize.TotalCount();
			String tx = text1 +""+ ele +""+ text2 +""+ ele2;
			utils.ExcelWrite(tx,2,1,"Alerts",System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+prop.getProperty("CaughtInDetection"));
			test.fail("Alerts are not matching");
		}
		
	}
}
