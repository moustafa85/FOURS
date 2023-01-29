package siteMonitoring.TestCases;

import java.io.IOException;

import fours.Testrail.testrail;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import fours.base.BasePage;
import fours.utils.TestUtils;
import fours.utils.Utilities;
import login.Pages.LoginPage;
import siteMonitoring.Pages.OpenAlertCountPage;

public class TC_66_OpenAlertPageTest extends BasePage {
	
	LoginPage loginPage;
	OpenAlertCountPage openAlert;
	TestUtils utils;
	Utilities utilize;

	public TC_66_OpenAlertPageTest() throws IOException {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {
		
		loginPage = new LoginPage();
		openAlert = new OpenAlertCountPage();
		utils = new TestUtils();
		utilize = new Utilities();
	}
	
	@Test
	@testrail(id = "16690")
	public void AlertTest() throws InterruptedException, IOException {
		
		test = extent.createTest("Site Monitoring -- Open alerts");
		test.assignCategory("Site Monitoring");

		loginPage.dashboardLink();
		
		////loginPage.login(prop.getProperty("username"), prop.getProperty("password"));;		//Thread.sleep(2000);
		openAlert.SM();
		//Thread.sleep(2000);
		String ele =  openAlert.OpenCount();
		//System.out.println("Ale -- "+ele);
		//Thread.sleep(1000);
		openAlert.Open();
		////Thread.sleep(1000);
		//utilize.SelectSite();
		//Thread.sleep(2000);
		if(ele.equalsIgnoreCase("0"))
		{
			if(utilize.NoData().equals("No Data")) {
				System.out.println("Alert Management has No Data and there is no Open Alert in Site Monitoring Page ");
				String text ="Alert Management has No Data and there is no Open Alert in Site Monitoring Page ";
				utils.ExcelWrite(text,0,1,"AllAlerts",System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+prop.getProperty("SiteMonitoring"));
				test.pass("Alert Management has No Data and there is no Open Alert in Site Monitoring Page");
			}
		}
		
		else if (ele.equalsIgnoreCase(utilize.TotalCount()))
		{	
			System.out.println("Alerts are matching. Open Alerts in Site Monitoring and Alert Management Page");
			String text = "Alerts are matching. Open Alerts in Site Monitoring and Alert Management Page -- ";
			utilize.TotalCount();
			utils.ExcelWrite(text+utilize.TotalCount(),0,1,"AllAlerts",System.getProperty("user.dir") +"\\"+prop.getProperty("Environment")+prop.getProperty("SiteMonitoring"));
			test.pass("Alerts are matching");
		}
		else
		{
			System.out.println("Alerts are not matching");
			System.out.println("Open Alert in Site Monitoring Page -- "+ele);
			String text1 = "Alerts are not matching. Open Alert in Site Monitoring Page -- ";
			System.out.println("Open Alert in Alert Management Page -- "+utilize.TotalCount());
			String text2 = "Open Alert in Alert Management Page-- ";
			String ele2 =  utilize.TotalCount();
			String tx = text1 +""+ ele +""+ text2 +""+ ele2;
			utils.ExcelWrite(tx,0,1,"AllAlerts",System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+prop.getProperty("SiteMonitoring"));
			test.pass("Alerts are not matching");
		}
		
	}

}
