package siteMonitoring.TestCases;

import java.io.IOException;

import fours.Testrail.testrail;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import fours.base.BasePage;
import fours.utils.TestUtils;
import fours.utils.Utilities;
import login.Pages.LoginPage;
import siteMonitoring.Pages.AssignedOpenPage;
import siteMonitoring.Pages.OpenAlertCountPage;

public class TC_67_AssignedOpenPageTest extends BasePage {
	
	LoginPage loginPage;
	AssignedOpenPage assignOpen;
	TestUtils utils;
	Utilities utilize;

	public TC_67_AssignedOpenPageTest() throws IOException {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {
		
		loginPage = new LoginPage();
		assignOpen = new AssignedOpenPage();
		utils = new TestUtils();
		utilize = new Utilities();
	}
	
	@Test
	@testrail(id = "16697")
	public void AlertTest() throws InterruptedException, IOException {
		
		test = extent.createTest("Site Monitoring -- Assigned open alerts");
		test.assignCategory("Site Monitoring");

		loginPage.dashboardLink();
		
		////loginPage.login(prop.getProperty("username"), prop.getProperty("password"));;		//Thread.sleep(2000);
		assignOpen.SM();
		//Thread.sleep(2000);
		String ele =  assignOpen.AssOpenCount();
		System.out.println("Ale -- "+ele);
		//Thread.sleep(1000);
		assignOpen.AssOpen();
		////Thread.sleep(1000);
		//utilize.SelectSite();
		//Thread.sleep(2000);
		if(ele.equalsIgnoreCase("0"))
		{
			if(utilize.NoData().equals("No Data")) {
				System.out.println("Alert Management has No Data and there is no Assigned Open Alert in Site Monitoring Page");
				String text = "Alert Management has No Data and there is no Assigned Open Alert in Site Monitoring Page";
				utils.ExcelWrite(text,1,1,"AllAlerts",System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+prop.getProperty("SiteMonitoring"));
				test.pass("Alert Management has No Data and there is no Assigned Open Alert in Site Monitoring Page");
			}
		}
		
		else if (ele.equalsIgnoreCase(utilize.TotalCount()))
		{
			System.out.println("Alerts are matching");
			System.out.println("Assigned Open Alert in Site Monitoring Page -- "+ele);
			String text = "Alerts are matching. Assigned Open Alerts in Site Monitoring Page and Alert Management Page -- ";
			System.out.println("Assigned Open Alert in Alert Management Page -- "+utilize.TotalCount());
			utils.ExcelWrite(text+utilize.TotalCount(),1,1,"AllAlerts",System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+prop.getProperty("SiteMonitoring"));
			test.pass("Alerts are matching");
		}
		else 
		{
			System.out.println("Alerts are not matching");
			System.out.println("Assigned Open Alert in Site Monitoring Page -- "+ele);
			System.out.println("Assigned Open Alert in Alert Management Page -- "+utilize.TotalCount());
			String text1 = "Alerts are not matching. Assigned Open Alert in Site Monitoring Page -- ";
			String text2 = ", Assigned Open Alert in Alert Management Page -- ";
			String ele2 =  utilize.TotalCount();
			String tx = text1 +""+ ele +""+ text2 +""+ ele2 ;
			utils.ExcelWrite(tx,1,1,"AllAlerts",System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+prop.getProperty("SiteMonitoring"));
			test.pass("Alerts are not matching");
		}
		
	}

}
