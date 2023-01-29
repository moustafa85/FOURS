package siteMonitoring.TestCases;

import java.io.IOException;

import fours.Testrail.testrail;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import fours.base.BasePage;
import fours.utils.TestUtils;
import fours.utils.Utilities;
import login.Pages.LoginPage;
import siteMonitoring.Pages.AddNewChildSite;

public class TC_78_RefreshTest extends BasePage{

	public TC_78_RefreshTest() throws IOException {
		super();
	}
	
	LoginPage loginPage;
	AddNewChildSite childSite;
	
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {
		
		loginPage = new LoginPage();
		childSite = new AddNewChildSite();
	}
	
	@Test
	@testrail(id = "16692")
	public void RefreshTest() throws InterruptedException, IOException {
		
		
		
		test = extent.createTest("Site Monitoring -- Refresh");
		test.assignCategory("Site Monitoring");

		loginPage.dashboardLink();
		
		////loginPage.login(prop.getProperty("username"), prop.getProperty("password"));;		//Thread.sleep(2000);
		childSite.SM();
		Thread.sleep(2000);
		childSite.Refresh();
		//Thread.sleep(4000);
	}

}
