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
import workerTraking.Pages.TrackingMapEnlarge;

public class TC_46_TrackingMapEnlargeTest extends BasePage{
	
	LoginPage loginPage;
	TrackingMapEnlarge enlarge;

	public TC_46_TrackingMapEnlargeTest() throws IOException {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {
		
		loginPage = new LoginPage();
		enlarge = new TrackingMapEnlarge();
	}
	
	@Test
	@testrail(id = "16687")
	public void MapEnlarge() throws InterruptedException, IOException {
		
		test = extent.createTest("Worker Tracking -- Tracking Map Enlarge");
		test.assignCategory("Worker Tracking");
		loginPage.dashboardLink();
		enlarge.WT();
		enlarge.Tracking();
		enlarge.MapEnlargeButton();
		enlarge.MapCloseButton();
	}

}
