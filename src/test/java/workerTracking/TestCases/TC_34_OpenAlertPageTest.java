package workerTracking.TestCases;

import java.io.IOException;

import fours.Testrail.testrail;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import fours.base.BasePage;
import fours.utils.TestUtils;
import fours.utils.Utilities;
import login.Pages.LoginPage;
import workerTraking.Pages.OpenAlertCountPage;

public class TC_34_OpenAlertPageTest extends BasePage {
	
	LoginPage loginPage;
	OpenAlertCountPage OpenAlert;
	TestUtils utils;
	Utilities utilize;

	public TC_34_OpenAlertPageTest() throws IOException {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {

		loginPage = new LoginPage();
		OpenAlert = new OpenAlertCountPage();
		utils = new TestUtils();
		utilize = new Utilities();
	}
	
	@Test
	@testrail(id = "16686")
	public void AlertTest() throws InterruptedException, IOException {
		
		test = extent.createTest("Worker Tracking -- Open alert");
		test.assignCategory("Worker Tracking");

		loginPage.dashboardLink();
		
		OpenAlert.WT();
		String ele =  OpenAlert.OpenCount();
		OpenAlert.Open();
		if(ele.equalsIgnoreCase("0"))
		{
			if(utilize.NoData().equals("No Data")) {
				String text ="Alert Management has No Data and there is no Open Alert in Worker Tracking Page ";
				utils.ExcelWrite(text,0,1,"Alerts",System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+prop.getProperty("workerTracking"));
				test.pass("Alert Management has No Data and there is no Open Alert in Worker Tracking Page");
			}
		}
		
		else if (ele.equalsIgnoreCase(utilize.TotalCount()))
		{	
			//System.out.println("Alerts are matching. Open Alerts in Worker Tracking and Alert Management Page");
			String text = "Alerts are matching. Open Alerts in Worker Tracking and Alert Management Page -- ";
			utilize.TotalCount();
			utils.ExcelWrite(text+utilize.TotalCount(),0,1,"Alerts",System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+prop.getProperty("workerTracking"));
			test.pass("Alerts are matching");
		}
		else
		{
			String text1 = "Alerts are not matching. Open Alert in Worker Tracking Page -- ";
			String text2 = "Open Alert in Alert Management Page-- ";
			String ele2 =  utilize.TotalCount();
			String tx = text1 +""+ ele +""+ text2 +""+ ele2;
			utils.ExcelWrite(tx,0,1,"Alerts",System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+prop.getProperty("workerTracking"));
			test.pass("Alerts are not matching");
		}
		
	}

}
