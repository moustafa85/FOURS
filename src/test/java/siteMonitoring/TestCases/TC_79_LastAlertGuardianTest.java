package siteMonitoring.TestCases;

import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import fours.base.BasePage;
import fours.utils.TestUtils;
import login.Pages.LoginPage;
import siteMonitoring.Pages.GuardianPage;

public class TC_79_LastAlertGuardianTest extends BasePage{

	public TC_79_LastAlertGuardianTest() throws IOException {
		super();
	}
	
	LoginPage loginPage;
	GuardianPage lastAlert;
	TestUtils utils;
	
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {
		
		loginPage = new LoginPage();
		lastAlert = new GuardianPage();
		utils = new TestUtils();
	}
	
	@Test
	public void LastAlertTest() throws InterruptedException, IOException {
		
		test = extent.createTest("Site Monitoring -- Guardian Last Alert");
		test.assignCategory("Site Monitoring");

		loginPage.dashboardLink();
		
		////loginPage.login(prop.getProperty("username"), prop.getProperty("password"));;		//Thread.sleep(4000);
		lastAlert.SM();
		//Thread.sleep(2000);
//		lastAlert.Guardian();
//		//Thread.sleep(2000);
		String ele =  lastAlert.LastAlert();
		System.out.println("Ale == "+ele);
		//Thread.sleep(1000);
		
		if(ele.equalsIgnoreCase("-"))
		{
			System.out.println("There is no Last Alert");
			utils.ExcelWrite("There is no Last Alert",0,1,"GuardianLastAlert",System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+prop.getProperty("SiteMonitoring"));
			test.pass("There is no Last Alert");
		}
		else
		{
			utils.ExcelWrite(lastAlert.LastAlert(),0,1,"GuardianLastAlert",System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+prop.getProperty("SiteMonitoring"));
			test.pass("Last Alert Test");
		}
		
		lastAlert.LastAlertClick();
		//Thread.sleep(2000);
		
	}

}
