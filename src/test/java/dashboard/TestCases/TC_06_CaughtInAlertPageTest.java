package dashboard.TestCases;

import java.io.IOException;

import fours.Testrail.testrail;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Dashboard.Pages.CaughtInAlertPage;
import Dashboard.Pages.TimeRange;
import fours.base.BasePage;
import fours.utils.TestUtils;
import login.Pages.LoginPage;

public class TC_06_CaughtInAlertPageTest extends BasePage{
	
	LoginPage loginPage;
	CaughtInAlertPage caughtInAlert;
	TestUtils utils;
	TimeRange timeRange;

	public TC_06_CaughtInAlertPageTest() throws IOException {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {
		
		loginPage = new LoginPage();
		caughtInAlert = new CaughtInAlertPage();
		utils = new TestUtils();
		timeRange = new TimeRange();
	}

	@testrail(id = "16674")
	@Test
	public void AlertTest() throws InterruptedException, IOException {
		
		test = extent.createTest("Dashboard -- Caught-In alerts");
		test.assignCategory("Dashboard");
		loginPage.dashboardLink();
		String ele =  caughtInAlert.CaughtInAlertCount();

		caughtInAlert.CaughtIn();
		timeRange.TimeRange();
		if(ele.equalsIgnoreCase(caughtInAlert.CaughtInCount()))
		{
				String text = "No of Caught-In alert is equal. Caught-In Alert in Dashboard and Caught-In Detection Page -- ";
				utils.ExcelWrite(text+caughtInAlert.CaughtInCount(),6,1,"AllAlerts",System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+ prop.getProperty("Dashboard"));
				test.pass("No of Caught-In alert is equal.");
		}
		else
		{
			String text1 = "No of Caught-In alert is NOT equal. Caught-In alert in Dashboard Page -- ";
			String text2 = ", Caught-In alert in Caught-In Detection Page -- ";
			String ele2 =  caughtInAlert.CaughtInCount();
			String tx = text1 +""+ ele +""+ text2 +""+ ele2 ;
			utils.ExcelWrite(tx,6,1,"AllAlerts",System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+prop.getProperty("Dashboard"));
			test.pass("No of Caught-In alert is NOT equal");
		}
		
	}
	
}
