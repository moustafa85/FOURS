package workerTracking.TestCases;

import java.io.IOException;

import fours.Testrail.testrail;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import fours.base.BasePage;
import fours.utils.TestUtils;
import fours.utils.Utilities;
import login.Pages.LoginPage;
import workerTraking.Pages.ResolvedAlertPage;

public class TC_36_ResolvedAlertPageTest extends BasePage{
	
	LoginPage loginPage;
	ResolvedAlertPage ResolvedAlert;
	TestUtils utils;
	Utilities utilize;

	public TC_36_ResolvedAlertPageTest() throws IOException {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {
		
		loginPage = new LoginPage();
		ResolvedAlert = new ResolvedAlertPage();
		utils = new TestUtils();
		utilize = new Utilities();
	}
	
	@Test
	@testrail(id = "16686")
	public void AlertTest() throws InterruptedException, IOException {
		
		test = extent.createTest("Worker Tracking -- Resolved alerts");
		test.assignCategory("Worker Tracking");

		loginPage.dashboardLink();
		
		ResolvedAlert.WT();
		String ele =  ResolvedAlert.ResolvedCount();
		ResolvedAlert.Resolved();
		if(ele.equalsIgnoreCase("0"))
		{
			if(utilize.NoData().equals("No Data")) {
				String text ="Alert Management has No Data and there is no Resolved Alert in Worker Tracking Page";
				utils.ExcelWrite(text,2,1,"Alerts",System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+prop.getProperty("workerTracking"));
				test.pass("Alert Management has No Data and there is no Resolved Alert in Worker Tracking Page");
			}
		}
		
		else if (ele.equalsIgnoreCase(utilize.TotalCount()))
		{	
			String text = "Alerts are matching. Resolved Alerts in Worker Tracking and Alert Management Page -- ";
			utilize.TotalCount();
			utils.ExcelWrite(text+utilize.TotalCount(),2,1,"Alerts",System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+prop.getProperty("workerTracking"));
			test.pass("Alerts are matching");
		}
		else
		{
			String text1 = "Alerts are not matching. Resolved Alert in Worker Tracking Page -- ";
			String text2 = ", Resolved Alert in Alert Management Page -- ";
			String ele2 =  utilize.TotalCount();
			String tx = text1 +""+ ele +""+ text2 +""+ ele2;
			utils.ExcelWrite(tx,2,1,"Alerts",System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+prop.getProperty("workerTracking"));
			test.pass("Alerts are not matching");
		}
		
	}
}
