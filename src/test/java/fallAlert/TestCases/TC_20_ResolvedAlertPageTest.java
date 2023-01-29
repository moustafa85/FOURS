package fallAlert.TestCases;

import java.io.IOException;

import fours.Testrail.testrail;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import fallAlert.Pages.AssignedOpenAlertCountPage;
import fallAlert.Pages.ResolvedAlertCountPage;
import fours.base.BasePage;
import fours.utils.TestUtils;
import fours.utils.Utilities;
import login.Pages.LoginPage;

public class TC_20_ResolvedAlertPageTest extends BasePage {
	
	LoginPage loginPage;
	ResolvedAlertCountPage resolvedAlert;
	TestUtils utils;
	Utilities utilize;

	public TC_20_ResolvedAlertPageTest() throws IOException {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {
		
		loginPage = new LoginPage();
		resolvedAlert = new ResolvedAlertCountPage();
		utils = new TestUtils();
		utilize = new Utilities();
	}

	@testrail(id = "16673")
	@Test
	public void AlertTest() throws InterruptedException, IOException {
		
		test = extent.createTest("Fall Alerts -- Resolved alerts");
		test.assignCategory("Fall Alerts");

		loginPage.dashboardLink();
		
		resolvedAlert.FAlert();
		String ele =  resolvedAlert.ResolvedCount();
		resolvedAlert.Resolved();
		if(ele.equalsIgnoreCase("0"))
		{
			if(utilize.NoData().equals("No Data")) {
				String text ="Alert Management has No Data and there is no Resolved Alert in Fall Alerts Page";
				utils.ExcelWrite(text,2,1,"FallAlerts",System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+ prop.getProperty("FallAlert"));
				test.pass("Alert Management has No Data and there is no Resolved Alert in Fall Alerts Page");
			}
		}
		
		else if (ele.equalsIgnoreCase(utilize.TotalCount()))
		{	
			String text = "Alerts are matching.Resolved Alerts in Fall Alerts and Alert Management Page -- ";
			utilize.TotalCount();
			utils.ExcelWrite(text+utilize.TotalCount(),2,1,"FallAlerts",System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+ prop.getProperty("FallAlert"));
			test.pass("Alerts are matching");
		}
		else
		{
			String text1 = "Alerts are not matching. Resolved Alert in Fall Alerts Page -- ";
			String text2 = ", Resolved Alert in Alert Management Page -- ";
			String ele2 =  utilize.TotalCount();
			String tx = text1 +""+ ele +""+ text2 +""+ ele2;
			utils.ExcelWrite(tx,2,1,"FallAlerts",System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+prop.getProperty("FallAlert"));
			test.pass("Alerts are not matching");
		}
		
	}

}
