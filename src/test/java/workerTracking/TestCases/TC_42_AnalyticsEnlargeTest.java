package workerTracking.TestCases;

import java.io.IOException;

import fours.Testrail.testrail;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import fours.base.BasePage;
import fours.utils.Utilities;
import login.Pages.LoginPage;
import workerTraking.Pages.AnalyticsEnlarge;

public class TC_42_AnalyticsEnlargeTest extends BasePage{
	
	LoginPage loginPage;
	AnalyticsEnlarge enlarge;
	Utilities utilize;

	public TC_42_AnalyticsEnlargeTest() throws IOException {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {
		
		loginPage = new LoginPage();
		enlarge = new AnalyticsEnlarge();
		utilize = new Utilities();
	}
	
	@Test
	@testrail(id = "16688")
	public void EnlargeTest() throws InterruptedException, IOException {
		
		test = extent.createTest("Worker Tracking -- Analytics Enlarge");
		test.assignCategory("Worker Tracking");

		loginPage.dashboardLink();
		
		enlarge.WT();
		Thread.sleep(2000);
		WebElement Element = driver.findElement(By.xpath("//div[@class='separator'][contains(.,'Analytics')]"));
		utilize.ScrollToLocation(Element);
		enlarge.TotalOOGEnlargeButton();
		enlarge.TotalOOGCloseButton();
		enlarge.WorkerPresentEnlargeButton();
		enlarge.WorkerPresentCloseButton();
		enlarge.WorkerTypeEnlargeButton();
		enlarge.WorkerTypeCloseButton();
		enlarge.workerAlertEnlargeButton();
		enlarge.workerAlertCloseButton();
		enlarge.SiteEnlargeButton();
		enlarge.siteCloseButton();
	}

}
