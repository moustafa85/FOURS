package fallAlert.TestCases;

import java.io.IOException;

import fours.Testrail.testrail;
import org.apache.poi.ss.formula.functions.T;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import fallAlert.Pages.RefreshPage;
import fours.base.BasePage;
import login.Pages.LoginPage;

public class TC_27_RefreshTest extends BasePage{
	
	LoginPage loginPage;
	RefreshPage refresh;

	public TC_27_RefreshTest() throws IOException {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {
		
		loginPage = new LoginPage();
		refresh = new RefreshPage();
	}
	
	@Test
	@testrail(id = "16672")
	public void Refresh() throws InterruptedException, IOException {
		
		test = extent.createTest("Fall Alerts -- Refresh");
		test.assignCategory("Fall Alerts");

		loginPage.dashboardLink();
		
		refresh.FAlert();
		Thread.sleep(2000);
		refresh.RefreshButton();
	}
}


