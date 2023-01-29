package fallAlert.TestCases;

import java.io.IOException;

import fours.Testrail.testrail;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import fallAlert.Pages.AssignedOpenAlertCountPage;
import fours.base.BasePage;
import fours.utils.TestUtils;
import fours.utils.Utilities;
import login.Pages.LoginPage;
import workerTraking.Pages.AssignedOpenPage;

public class TC_19_AssignedOpenPageTest extends BasePage {
	
	LoginPage loginPage;
	AssignedOpenAlertCountPage assignedOpen;
	TestUtils utils;
	Utilities utilize;

	public TC_19_AssignedOpenPageTest() throws IOException {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {
		
		loginPage = new LoginPage();
		assignedOpen = new AssignedOpenAlertCountPage();
		utils = new TestUtils();
		utilize = new Utilities();
	}

	@testrail(id = "16673")
	@Test
	public void AlertTest() throws InterruptedException, IOException {
		
		test = extent.createTest("Fall Alerts -- Assigned open alerts");
		test.assignCategory("Fall Alerts");

		loginPage.dashboardLink();
		assignedOpen.FAlert();
		String ele =  assignedOpen.AssOpenCount();
		assignedOpen.AssOpen();
		if(ele.equalsIgnoreCase("0"))
		{
			if(utilize.NoData().equals("No Data")) {
				String text = "Alert Management has No Data and there is no Assigned Open Alert in Fall Alerts Page";
				utils.ExcelWrite(text,1,1,"FallAlerts",System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+prop.getProperty("FallAlert"));
				test.pass("Alert Management has No Data and there is no Assigned Open Alert in Fall Alerts Page");
			}
		}
		
		else if (ele.equalsIgnoreCase(utilize.TotalCount()))
		{
			String text = "Alerts are matching.Assigned Open Alerts in Fall Alerts Page and Alert Management Page -- ";
			utils.ExcelWrite(text+utilize.TotalCount(),1,1,"FallAlerts",System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+prop.getProperty("FallAlert"));
			test.pass("Alerts are matching");
		}
		else 
		{
			String text1 = "Alerts are not matching. Assigned Open Alert in Fall Alerts Page -- ";
			String text2 = ", Assigned Open Alert in Alert Management Page -- ";
			String ele2 =  utilize.TotalCount();
			String tx = text1 +""+ ele +""+ text2 +""+ ele2 ;
			utils.ExcelWrite(tx,1,1,"FallAlerts",System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+prop.getProperty("FallAlert"));
			test.pass("Alerts are not matching");
		}
		
	}

}
