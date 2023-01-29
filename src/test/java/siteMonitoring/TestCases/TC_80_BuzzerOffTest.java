package siteMonitoring.TestCases;

import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import fours.base.BasePage;
import fours.utils.TestUtils;
import login.Pages.LoginPage;
import siteMonitoring.Pages.GuardianPage;

public class TC_80_BuzzerOffTest extends BasePage{
	
	public TC_80_BuzzerOffTest() throws IOException {
		super();
	}

	LoginPage loginPage;
	GuardianPage lastAlert;
	
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {
		
		loginPage = new LoginPage();
		lastAlert = new GuardianPage();
	}
	
	@Test
	public void BuzzerOff() throws InterruptedException, IOException {
		
		test = extent.createTest("Site Monitoring -- Buzzer Off Test");
		test.assignCategory("Site Monitoring");

		loginPage.dashboardLink();
		
		////loginPage.login(prop.getProperty("username"), prop.getProperty("password"));;		//Thread.sleep(4000);
		lastAlert.SM();
//		//Thread.sleep(2000);
		lastAlert.Guardian();
		//Thread.sleep(4000);
		lastAlert.BuzzerOff();
		//Thread.sleep(2000);
		
	}

}
