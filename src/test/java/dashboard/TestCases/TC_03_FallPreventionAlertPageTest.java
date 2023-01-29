package dashboard.TestCases;

import java.io.IOException;

import fours.Testrail.testrail;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Dashboard.Pages.FallPreventionAlertPage;
import Dashboard.Pages.TimeRange;
import fours.base.BasePage;
import fours.utils.TestUtils;
import login.Pages.LoginPage;

public class TC_03_FallPreventionAlertPageTest extends BasePage {
	
	LoginPage loginPage;
	FallPreventionAlertPage fallPreventionAlert;
	TestUtils utils;
	TimeRange timeRange;

	public TC_03_FallPreventionAlertPageTest() throws IOException {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {

		loginPage = new LoginPage();
		fallPreventionAlert = new FallPreventionAlertPage();
		utils = new TestUtils();
		timeRange = new TimeRange();
	}

	@testrail(id = "16674")
	@Test
	public void AlertTest() throws InterruptedException, IOException {
		
		test = extent.createTest("Dashboard -- Fall Prevention alerts");
		test.assignCategory("Dashboard");
		loginPage.dashboardLink();
		String ele =  fallPreventionAlert.FallPrevAlertCount();

		fallPreventionAlert.FallPrev();
		timeRange.TimeRange();
		if(ele.equalsIgnoreCase(fallPreventionAlert.FallPrevCount()))
		{
				String text = "No of Fall Prevention alert is equal. Fall Prevention Alert in Dashboard and Fall Alert Page -- ";
				utils.ExcelWrite(text+fallPreventionAlert.FallPrevCount(),3,1,"AllAlerts",System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+  prop.getProperty("Dashboard"));
				test.pass("No of Fall Prevention alert is equal");
		}
		else
		{
			String text1 = "No of Fall Prevention alert is NOT equal. Fall Prevention alert in Dashboard Page -- ";
			String text2 = ", Fall Prevention alert in Fall Alert Page -- ";
			String ele2 =  fallPreventionAlert.FallPrevCount();
			String tx = text1 +""+ ele +""+ text2 +""+ ele2 ;
			utils.ExcelWrite(tx,3,1,"AllAlerts",System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+prop.getProperty("Dashboard"));
			test.pass("No of Fall Prevention alert is NOT equal.");
		}
		
	}

}
