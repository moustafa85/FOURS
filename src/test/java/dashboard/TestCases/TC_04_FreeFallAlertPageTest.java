package dashboard.TestCases;

import java.io.IOException;

import fours.Testrail.testrail;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Dashboard.Pages.FreeFallAlertPage;
import Dashboard.Pages.TimeRange;
import fours.base.BasePage;
import fours.utils.TestUtils;
import login.Pages.LoginPage;

public class TC_04_FreeFallAlertPageTest extends BasePage{
	
	LoginPage loginPage;
	FreeFallAlertPage freeFallAlert;
	TestUtils utils;
	TimeRange timeRange;

	public TC_04_FreeFallAlertPageTest() throws IOException {
		super();
		
	}
	
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {

		loginPage = new LoginPage();
		freeFallAlert = new FreeFallAlertPage();
		utils = new TestUtils();
		timeRange = new TimeRange();
	}

	@testrail(id = "16674")
	@Test
	public void AlertTest() throws InterruptedException, IOException {

		test = extent.createTest("Dashboard -- Free Fall alerts");
		test.assignCategory("Dashboard");
		loginPage.dashboardLink();


		String ele =  freeFallAlert.FreeFallAlertCount();
		freeFallAlert.FreeFall();
		timeRange.TimeRange();
		if(ele.equalsIgnoreCase(freeFallAlert.FreeFallCount()))
		{
				String text = "No of Free Fall alert is equal. Free Fall Alert in Dashboard and Fall Alert Page -- ";
				utils.ExcelWrite(text+freeFallAlert.FreeFallCount(),4,1,"AllAlerts",System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+  prop.getProperty("Dashboard"));
				test.pass("No of Free Fall alert is equal.");
		}
		else
		{
			String text1 = "No of Free Fall alert is NOT equal.Free Fall Alert in Dashboard Page -- ";
			String text2 = ", Free Fall Alert in Fall Alert Page -- ";
			String ele2 =  freeFallAlert.FreeFallCount();
			String tx = text1 +""+ ele +""+ text2 +""+ ele2 ;
			utils.ExcelWrite(tx,4,1,"AllAlerts",System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+prop.getProperty("Dashboard"));
			test.pass("No of Free Fall alert is NOT equal.");
		}
		
	}

}
