package caughtInDetection.TestCases;

import java.io.IOException;

import fours.Testrail.testrail;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import caughtInDetection.Pages.AnalyticsEnlarge;
import fours.base.BasePage;
import fours.utils.Utilities;
import login.Pages.LoginPage;

public class TC_55_AnalyticsEnlargeTest extends BasePage{
	
	LoginPage loginPage;
	AnalyticsEnlarge enlarge;
	Utilities utilize;

	public TC_55_AnalyticsEnlargeTest() throws IOException {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {
		loginPage = new LoginPage();
		enlarge = new AnalyticsEnlarge();
		utilize = new Utilities();
	}

	/**
	 *
	 * @throws InterruptedException
	 * @throws IOException
	 */
	@testrail(id = "16715")
	@Test
	public void AnalyticsEnlargeTest() throws InterruptedException, IOException {
		test = extent.createTest("Worker Tracking -- Analytics Enlarge");
		test.assignCategory("Caught in Detection");
		loginPage.dashboardLink();
		enlarge.CaughtIn();
		Thread.sleep(2000);
		WebElement ele = driver.findElement(By.xpath("//div[@class='separator'][contains(.,'Mapped Alerts')]"));
		utilize.ScrollToLocation(ele);
		WebElement Element = driver.findElement(By.xpath("//div[@class='separator'][contains(.,'Analytics')]"));
		utilize.ScrollToLocation(Element);
		enlarge.CaughtInEnlargeButton();
		test.pass("Enlarge Enlarge Button");
		enlarge.CloseButton();
		test.pass("Close Enlarge chart");
		enlarge.WorkerTypeEnlargeButton();
		test.pass("Enlarge Worker type chart");
		enlarge.workerTypeCloseButton();
		test.pass("Close Worker type chart");
		enlarge.workerAlertEnlargeButton();
		test.pass("Enlarge Worker alert chart");
		enlarge.workerAlertCloseButton();
		test.pass("Close Worker alert chart");
		enlarge.SiteEnlargeButton();
		test.pass("Enlarge Site alerts chart");
		enlarge.siteCloseButton();
		test.pass("Close Site alerts chart");
	}

}
