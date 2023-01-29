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
import workerTraking.Pages.AssignedOpenPage;

public class TC_35_AssignedOpenPageTest extends BasePage{
	
	LoginPage loginPage;
	AssignedOpenPage assignOpenAlert;
	TestUtils utils;
	Utilities utilize;

	public TC_35_AssignedOpenPageTest() throws IOException {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {
		
		loginPage = new LoginPage();
		assignOpenAlert = new AssignedOpenPage();
		utils = new TestUtils();
		utilize = new Utilities();
	}
	
	@Test
	@testrail(id = "16686")
	public void AlertTest() throws InterruptedException, IOException {
		
		test = extent.createTest("Worker Tracking -- Assigned open alerts");
		test.assignCategory("Worker Tracking");

		loginPage.dashboardLink();
		assignOpenAlert.WT();
		String ele =  assignOpenAlert.AssOpenCount();
		assignOpenAlert.AssOpen();
		if(ele.equalsIgnoreCase("0"))
		{
			if(utilize.NoData().equals("No Data")) {
				String text = "Alert Management has No Data and there is no Assigned Open Alert in Worker Traking Page";
				utils.ExcelWrite(text,1,1,"Alerts",System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+ prop.getProperty("workerTracking"));
				test.pass("Alert Management has No Data and there is no Assigned Open Alert in Worker Traking Page");
			}
		}
		
		else if (ele.equalsIgnoreCase(utilize.TotalCount()))
		{
			String text = "Alerts are matching. Assigned Open Alerts in Worker Traking Page and Alert Management Page -- ";
			utils.ExcelWrite(text+utilize.TotalCount(),1,1,"Alerts",System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+prop.getProperty("workerTracking"));
			test.pass("Alerts are matching");
		}
		else 
		{
			String text1 = "Alerts are not matching. Assigned Open Alert in Worker Traking Page -- ";
			String text2 = ", Assigned Open Alert in Alert Management Page -- ";
			String ele2 =  utilize.TotalCount();
			String tx = text1 +""+ ele +""+ text2 +""+ ele2 ;
			utils.ExcelWrite(tx,1,1,"Alerts",System.getProperty("user.dir") +"\\"+prop.getProperty("Environment")+ prop.getProperty("workerTracking"));
			test.pass("Alerts are not matching");
		}
		
	}

}
