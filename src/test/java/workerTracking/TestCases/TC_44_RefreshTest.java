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
import workerTraking.Pages.Refresh;

public class TC_44_RefreshTest extends BasePage{
	
	LoginPage loginPage;
	Refresh refresh;
	Utilities utilize;

	public TC_44_RefreshTest() throws IOException {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {
		
		loginPage = new LoginPage();
		refresh = new Refresh();
		utilize = new Utilities();
	}
	
	@Test
	@testrail(id = "16684")
	public void RefreshTest() throws InterruptedException, IOException {
		
		test = extent.createTest("Worker Tracking -- Refresh test");
		test.assignCategory("Worker Tracking");

		loginPage.dashboardLink();
		
		refresh.WT();
		Thread.sleep(2000);
		refresh.Refresh();
	}

}
