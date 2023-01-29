package dashboard.TestCases;

import java.io.IOException;

import fours.Testrail.testrail;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Dashboard.Pages.SosAlertPage;
import fours.base.BasePage;
import fours.utils.TestUtils;
import login.Pages.LoginPage;

public class SOSAlertPageTest extends BasePage{
	
	LoginPage loginPage;
	SosAlertPage sosAlert;
	TestUtils utils;

	public SOSAlertPageTest() throws IOException {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {
		
		loginPage = new LoginPage();
		sosAlert = new SosAlertPage();
		utils = new TestUtils();
	}
	
	@Test
	@testrail(id = "16674")
	public void AlertTest() throws InterruptedException, IOException {
		
		test = extent.createTest("Dashboard -- SOS alerts");
		test.assignCategory("Dashboard");
		loginPage.dashboardLink();
		String ele =  sosAlert.SOSAlertCount();
		sosAlert.SOS();
		sosAlert.TimeRange();
		if(ele.equalsIgnoreCase(sosAlert.SOSCount()))
		{

				String text = "No of SOS alert is equal. SOS Alert in Dashboard and Fall Alert Page -- ";
				utils.ExcelWrite(text+sosAlert.SOSCount(),2,1,"AllAlerts",System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+prop.getProperty("Dashboard"));
				test.pass("No of SOS alert is equal. ");
		}
		else
		{

			String text1 = "No of SOS alert is NOT equal. SOS alert in Dashboard Page --";
			String text2 = ", SOS alert in Fall Alert Page --";
			String ele2 =  sosAlert.SOSCount();
			String tx = text1 +""+ ele +""+ text2 +""+ ele2 ;
			utils.ExcelWrite(tx,2,1,"AllAlerts", System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+prop.getProperty("Dashboard"));
			test.pass("No of SOS alert is NOT equal");
		}
		
	}

}
