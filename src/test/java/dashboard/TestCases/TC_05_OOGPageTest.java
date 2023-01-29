package dashboard.TestCases;

import java.io.IOException;

import fours.Testrail.testrail;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Dashboard.Pages.OOGPage;
import Dashboard.Pages.TimeRange;
import fours.base.BasePage;
import fours.utils.TestUtils;
import login.Pages.LoginPage;

public class TC_05_OOGPageTest extends BasePage{
	
	LoginPage loginPage;
	OOGPage oogAlert;
	TestUtils utils;
	TimeRange timeRange;

	public TC_05_OOGPageTest() throws IOException {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {
		
		loginPage = new LoginPage();
		oogAlert = new OOGPage();
		utils = new TestUtils();
		timeRange = new TimeRange();
	}

	@testrail(id = "16674")
	@Test
	public void AlertTest() throws InterruptedException, IOException {
		
		test = extent.createTest("Dashboard -- OOG alerts");
		test.assignCategory("Dashboard");
		loginPage.dashboardLink();

		String ele =  oogAlert.OOGAlertCount();
		oogAlert.OOG();
		timeRange.TimeRange();
		if(ele.equalsIgnoreCase(oogAlert.OOGCount()))
		{

				String text = "No of OOG alert is equal. OOG Alert in Dashboard and Worker Tracking Page -- ";
				utils.ExcelWrite(text+oogAlert.OOGCount(),5,1,"AllAlerts",System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+ prop.getProperty("Dashboard"));
				test.pass("No of OOG alert is equal");
		}
		else
		{

			String text1 = "No of OOG alert is NOT equal. OOG alert in Dashboard Page -- ";
			String text2 = ", OOG alert in Worker Tracking Page -- ";
			String ele2 =  oogAlert.OOGCount();
			String tx = text1 +""+ ele +""+ text2 +""+ ele2 ;
			utils.ExcelWrite(tx,5,1,"AllAlerts",System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+prop.getProperty("Dashboard"));
			test.pass("No of OOG alert is NOT equal");
		}
		
	}
}
