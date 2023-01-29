package siteMonitoring.TestCases;

import java.io.IOException;

import fours.Testrail.testrail;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import fours.base.BasePage;
import fours.utils.TestUtils;
import login.Pages.LoginPage;
import siteMonitoring.Pages.AlertCard;

public class TC_69_AlertCardTest extends BasePage{

	public TC_69_AlertCardTest() throws IOException {
		super();
	}
	
	LoginPage loginPage;
	AlertCard alert;
	TestUtils utils;
	
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {
		
		loginPage = new LoginPage();
		alert = new AlertCard();
		utils = new TestUtils();
	}
	
	@Test
	@testrail(id = "16696")
	public void AlertCardTest() throws InterruptedException, IOException {
		
		test = extent.createTest("Site Monitoring -- Alert Card");
		test.assignCategory("Site Monitoring");

		loginPage.dashboardLink();
		
		////loginPage.login(prop.getProperty("username"), prop.getProperty("password"));;		//Thread.sleep(2000);
		alert.SM();
		//Thread.sleep(2000);
		alert.Alert();
	
		utils.ExcelWrite(alert.Alert(),0,1,"Alerts",System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+ prop.getProperty("SiteMonitoring"));
		test.pass("Alert Card"+alert.Alert());
		
	}

}
