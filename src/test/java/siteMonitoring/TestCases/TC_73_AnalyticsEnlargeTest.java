package siteMonitoring.TestCases;

import java.io.IOException;

import fours.Testrail.testrail;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import fours.base.BasePage;
import fours.utils.Utilities;
import login.Pages.LoginPage;
import siteMonitoring.Pages.AnalyticsEnlarge;

public class TC_73_AnalyticsEnlargeTest extends BasePage{
	
	LoginPage loginPage;
	AnalyticsEnlarge enlarge;
	Utilities utilize;

	public TC_73_AnalyticsEnlargeTest() throws IOException {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {
		
		loginPage = new LoginPage();
		enlarge = new AnalyticsEnlarge();
		utilize = new Utilities();
	}
	
	@Test
	@testrail(id = "16699")
	public void AnalyticsEnlarge() throws InterruptedException, IOException {
		
		test = extent.createTest("Site Monitoring -- Analytics Enlarge");
		test.assignCategory("Site Monitoring");

		loginPage.dashboardLink();
		
		////loginPage.login(prop.getProperty("username"), prop.getProperty("password"));;		//Thread.sleep(2000);
		enlarge.SM();
		Thread.sleep(2000);
		WebElement Element = driver.findElement(By.xpath("//div[@class='separator'][contains(.,'Analytics')]"));
		//Thread.sleep(2000);
		utilize.ScrollToLocation(Element);
		//Thread.sleep(2000);
		enlarge.TotalAlertsOverTimeEnlargeButton();
		//Thread.sleep(2000);
		enlarge.CloseButton();
		//Thread.sleep(2000);
		enlarge.WorkerPresentOnSiteEnlargeButton();
		//Thread.sleep(2000);
		enlarge.clickClosebtn(2);
		//Thread.sleep(2000);
		enlarge.WorkerTypeWiseAlertEnlargeButton();
		//Thread.sleep(2000);
		enlarge.clickClosebtn(3);
		//Thread.sleep(2000);
		enlarge.WorkerWithAlertEnlargeButton();
		//Thread.sleep(2000);
		enlarge.clickClosebtn(4);
		enlarge.SiteWithAllAlertsEnlargeButton();
		//Thread.sleep(2000);
		enlarge.clickClosebtn(5);
		enlarge.AlertSiteByCategoryEnlargeButton();
		//Thread.sleep(2000);
		enlarge.clickClosebtn(6);
		//Thread.sleep(2000);
		
	}

}
