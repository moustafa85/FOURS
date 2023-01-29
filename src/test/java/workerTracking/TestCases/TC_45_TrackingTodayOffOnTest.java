package workerTracking.TestCases;

import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import fours.base.BasePage;
import login.Pages.LoginPage;
import workerTraking.Pages.TrackingMapEnlarge;
import workerTraking.Pages.TrackingTodayOnOff;

public class TC_45_TrackingTodayOffOnTest extends BasePage{
	
	LoginPage loginPage;
	TrackingTodayOnOff onOff;

	public TC_45_TrackingTodayOffOnTest() throws IOException {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {

		loginPage = new LoginPage();
		onOff = new TrackingTodayOnOff();
	}
	
	@Test
	public void TodayOnOffTest() throws InterruptedException, IOException {
		
		test = extent.createTest("Worker Tracking -- Today On/Off");
		test.assignCategory("Worker Tracking");

		loginPage.dashboardLink();
		
		onOff.WT();
		onOff.Tracking();
		onOff.todayOff();
		onOff.TodayOn();
	}

}
