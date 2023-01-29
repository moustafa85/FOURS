package dashboard.TestCases;

import java.io.IOException;

import fours.Testrail.testrail;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Dashboard.Pages.AssignedOpenAlertPage;
import fours.base.BasePage;
import fours.utils.TestUtils;
import fours.utils.Utilities;
import login.Pages.LoginPage;

public class TC_02_AssignedOpenAlertPageTest extends BasePage {
	
	LoginPage loginPage;
	AssignedOpenAlertPage assignOpenAlert;
	TestUtils utils;
	Utilities utilize;

	public TC_02_AssignedOpenAlertPageTest() throws IOException {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {
		
		loginPage = new LoginPage();
		assignOpenAlert = new AssignedOpenAlertPage();
		utils = new TestUtils();
		utilize = new Utilities();
	}	

	@Test
	@testrail(id = "16673,16987")
	public void AlertTest() throws InterruptedException, IOException {
		
		test = extent.createTest("Dashboard -- Assigned Open alerts");
		test.assignCategory("Dashboard");
		loginPage.dashboardLink();

		String ele =  assignOpenAlert.AssOpenCount();
		Thread.sleep(2000);
		assignOpenAlert.AssOpen();
		Thread.sleep(2000);
		if(ele.equalsIgnoreCase("0"))
		{
			if(utilize.NoData().equals("No Data")) {
				String text = "Alert Management has No Data and there is no Assigned Open Alert in Dashboard";
				utils.ExcelWrite(text,1,1,"AllAlerts",System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+ prop.getProperty("Dashboard"));
				test.pass("Alert Management has No Data and there is no Assigned Open Alert in Dashboard");
			}
		}
		
		else if (ele.equalsIgnoreCase(utilize.TotalCount()))
		{
			String text = "Alerts are matching. Assigned Open Alerts in Dashboard and Alert Management Page -- ";
			//System.out.println("Assign Open Alert in Alert Management Page -- "+utilize.TotalCount());
			utils.ExcelWrite(text+utilize.TotalCount(),1,1,"AllAlerts",System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+ prop.getProperty("Dashboard"));
			test.pass("Alerts are matching");
		}
		else 
		{
			String text1 = "Alerts are not matching. Open Alert in Dashboard--";
			String text2 = ", Open Alert in Alert Management Page--";
			String ele2 =  utilize.TotalCount();
			String tx = text1 +""+ ele +""+ text2 +""+ ele2 ;
			utils.ExcelWrite(tx,1,1,"AllAlerts", System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+ prop.getProperty("Dashboard"));
			test.pass("Alerts are not matching");
		}
		
	}

}
