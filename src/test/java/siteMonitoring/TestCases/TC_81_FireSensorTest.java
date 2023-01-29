package siteMonitoring.TestCases;

import java.io.IOException;

import fours.Testrail.testrail;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import fours.base.BasePage;
import login.Pages.LoginPage;
import siteMonitoring.Pages.GuardianPage;

public class TC_81_FireSensorTest extends BasePage{

	public TC_81_FireSensorTest() throws IOException {
		super();
	}
	
	LoginPage loginPage;
	GuardianPage guardian;
	
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {
		
		loginPage = new LoginPage();
		guardian = new GuardianPage();
	}
	
	@Test
	@testrail(id = "16701,16703")
	public void FireSensor() throws InterruptedException, IOException {
		
		test = extent.createTest("Site Monitoring -- Fire Sensor Test");
		test.assignCategory("Site Monitoring");

		loginPage.dashboardLink();
		
		////loginPage.login(prop.getProperty("username"), prop.getProperty("password"));;		//Thread.sleep(4000);
		guardian.SM();
		guardian.Guardian();
		guardian.FireSensor();

	}

}
