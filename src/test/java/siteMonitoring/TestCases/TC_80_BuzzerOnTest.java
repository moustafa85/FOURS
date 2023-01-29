package siteMonitoring.TestCases;

import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import fours.base.BasePage;
import login.Pages.LoginPage;
import siteMonitoring.Pages.GuardianPage;

public class TC_80_BuzzerOnTest extends BasePage{
	
	public TC_80_BuzzerOnTest() throws IOException {
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
	public void BuzzerOn() throws InterruptedException, IOException {
		
		test = extent.createTest("Site Monitoring -- Buzzer On Test");
		test.assignCategory("Site Monitoring");

		loginPage.dashboardLink();
		
		////loginPage.login(prop.getProperty("username"), prop.getProperty("password"));;		//Thread.sleep(4000);
		guardian.SM();
//		//Thread.sleep(2000);
		guardian.Guardian();
		//Thread.sleep(2000);
		guardian.BuzzerOff();
		//Thread.sleep(2000);
		
	}

}
