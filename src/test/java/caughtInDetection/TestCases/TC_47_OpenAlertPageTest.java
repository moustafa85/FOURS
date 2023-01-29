package caughtInDetection.TestCases;

import java.io.IOException;

import fours.Testrail.testrail;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import caughtInDetection.Pages.OpenAlertCountPage;
import fours.base.BasePage;
import fours.utils.TestUtils;
import fours.utils.Utilities;
import login.Pages.LoginPage;

public class TC_47_OpenAlertPageTest extends BasePage {
	
	LoginPage loginPage;
	OpenAlertCountPage openAlert;
	TestUtils utils;
	Utilities utilize;

	public TC_47_OpenAlertPageTest() throws IOException {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {
		loginPage = new LoginPage();
		openAlert = new OpenAlertCountPage();
		utils = new TestUtils();
		utilize = new Utilities();
	}
	
	@Test
	@testrail(id = "16712")
	public void OpenAlertTest() throws InterruptedException, IOException {
		
		test = extent.createTest("Caught-In Detection -- Open alert");
		test.assignCategory("Caught in Detection");
		loginPage.dashboardLink();
		openAlert.CaughtIn();
		test.pass("Navigate to Caught In Detection page");
		String ele =  openAlert.OpenCount();
		openAlert.Open();
		test.pass("Click Open Alert");
		if(ele.equalsIgnoreCase("0"))
		{
			if(utilize.NoData().equals("No Data")) {
				String text ="Alert Management has No Data and there is no Open Alert in Caught-In Detection Page ";
				utils.ExcelWrite(text,0,1,"Alerts",System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+ prop.getProperty("CaughtInDetection"));
				test.pass("Alert Management has No Data and there is no Open Alert in Caught-In Detection Page");
			}
		}
		
		else if (ele.equalsIgnoreCase(utilize.TotalCount()))
		{	
			String text = "Alerts are matching. Open Alerts in Caught-In Detection and Alert Management Page -- ";
			utilize.TotalCount();
			utils.ExcelWrite(text+utilize.TotalCount(),0,1,"Alerts",System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+prop.getProperty("CaughtInDetection"));
			test.pass("Alerts are matching");
		}
		else
		{
			String text1 = "Alerts are not matching. Open Alert in Caught-In Detection Page -- ";
			String text2 = "Open Alert in Alert Management Page-- ";
			String ele2 =  utilize.TotalCount();
			String tx = text1 +""+ ele +""+ text2 +""+ ele2;
			utils.ExcelWrite(tx,0,1,"Alerts",System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+prop.getProperty("CaughtInDetection"));
			test.fail("Alerts are not matching");
		}
		
	}

}
