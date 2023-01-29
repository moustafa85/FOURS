package fallAlert.TestCases;

import java.io.IOException;

import fours.Testrail.testrail;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import fallAlert.Pages.OpenAlertCountPage;
import fours.base.BasePage;
import fours.utils.TestUtils;
import fours.utils.Utilities;
import login.Pages.LoginPage;

public class TC_18_OpenAlertPageTest extends BasePage{
	
	LoginPage loginPage;
	OpenAlertCountPage openAlert;
	TestUtils utils;
	Utilities utilize;

	public TC_18_OpenAlertPageTest() throws IOException {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {
		
		loginPage = new LoginPage();
		openAlert = new OpenAlertCountPage();
		utils = new TestUtils();
		utilize = new Utilities();
	}
	
	@Test
	@testrail(id = "16670")
	public void AlertTest() throws InterruptedException, IOException {
		
		test = extent.createTest("Fall Alerts -- Open alerts");
		test.assignCategory("Fall Alerts");

		loginPage.dashboardLink();
		
		openAlert.FAlert();
		String ele =  openAlert.OpenCount();
		openAlert.Open();
		if(ele.equalsIgnoreCase("0"))
		{
			if(utilize.NoData().equals("No Data")) {
				String text ="Alert Management has No Data and there is no Open Alert in Fall Alerts Page ";
				utils.ExcelWrite(text,0,1,"FallAlerts",System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+prop.getProperty("FallAlert"));
				test.pass("Alert Management has No Data and there is no Open Alert in Fall Alerts Page");
			}
		}
		
		else if (ele.equalsIgnoreCase(utilize.TotalCount()))
		{	
			String text = "Alerts are matching.Open Alert in Fall Alerts and Alert Management Page -- ";
			utilize.TotalCount();
			utils.ExcelWrite(text+utilize.TotalCount(),0,1,"FallAlerts",System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+prop.getProperty("FallAlert"));
			test.pass("Alerts are matching");
		}
		else
		{
			String text1 = "Alerts are not matching. Open Alert in Fall Alerts Page -- ";
			String text2 = "Open Alert in Alert Management Page-- ";
			String ele2 =  utilize.TotalCount();
			String tx = text1 +""+ ele +""+ text2 +""+ ele2;
			utils.ExcelWrite(tx,0,1,"FallAlerts",System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+prop.getProperty("FallAlert"));
			test.pass("Alerts are not matching");
		}
		
	}

}
