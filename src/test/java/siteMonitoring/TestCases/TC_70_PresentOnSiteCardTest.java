package siteMonitoring.TestCases;

import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import fours.base.BasePage;
import fours.utils.TestUtils;
import login.Pages.LoginPage;
import siteMonitoring.Pages.AlertCard;
import siteMonitoring.Pages.PresentOnSiteCard;

public class TC_70_PresentOnSiteCardTest extends BasePage{

	public TC_70_PresentOnSiteCardTest() throws IOException {
		super();
	}
	
	LoginPage loginPage;
	PresentOnSiteCard presentOnSite;
	TestUtils utils;
	
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {
		
		loginPage = new LoginPage();
		presentOnSite = new PresentOnSiteCard();
		utils = new TestUtils();
	}
	
	@Test
	public void PresentOnSite() throws InterruptedException, IOException {
		
		test = extent.createTest("Site Monitoring -- Present On Site Test");
		test.assignCategory("Site Monitoring");

		loginPage.dashboardLink();
		
		////loginPage.login(prop.getProperty("username"), prop.getProperty("password"));;		//Thread.sleep(2000);
		presentOnSite.SM();
		//Thread.sleep(2000);
		presentOnSite.PresentOnSite();
	
		utils.ExcelWrite(presentOnSite.PresentOnSite(),0,1,"PresentOnSite",System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+ prop.getProperty("SiteMonitoring"));
		test.pass("Alert Card"+presentOnSite.PresentOnSite());
		
	}

}
