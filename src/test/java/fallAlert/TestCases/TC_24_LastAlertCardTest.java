package fallAlert.TestCases;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import AlertMng.Pages.actions.AlertMngBasePage;
import Database.Testcases.LastAlertQueryTest;
import fours.Testrail.testrail;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import fallAlert.Pages.LastAlertPage;
import fours.base.BasePage;
import fours.utils.TestUtils;
import fours.utils.Utilities;
import login.Pages.LoginPage;

public class TC_24_LastAlertCardTest extends BasePage{
	
	LoginPage loginPage;
	LastAlertPage lastAlert;
	TestUtils utils;
	Utilities utilize;
	public int DataSet = -1;
	LastAlertQueryTest lastAlertQueryTest;
	AlertMngBasePage alertMngBasePage;


	public TC_24_LastAlertCardTest() throws IOException {
		super();
	}

	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {

		loginPage = new LoginPage();
		lastAlert = new LastAlertPage();
		utils = new TestUtils();
		utilize = new Utilities();
		lastAlertQueryTest = new LastAlertQueryTest();
		alertMngBasePage = new AlertMngBasePage();
	}
	@DataProvider
	public Object[][] getExcelData() throws IOException, InvalidFormatException {
		Object data[][] = TestUtils.dataSupplier("LastAlert",System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+prop.getProperty("FallAlert"));
		return data;
	}

	@Test(dataProvider="getExcelData")
	@testrail(id = "16674")
	public void LastAlertTest(Map<String,String> map) throws InterruptedException, IOException, SQLException, ClassNotFoundException {
		DataSet++;
		test = extent.createTest("Fall Alert -- Last Alert");
		test.assignCategory("Fall Alerts");
		if(!loginPage.dashboardLink())
			test.fail("Failed Navigate to Dashboard");
		test.pass("User Navigated to Dashboard");
		if (!lastAlert.FAlert())
			test.fail("Failed Navigate to Fall Alerts page");
		test.pass("Navigate to Fall Alerts page");
		if(!lastAlert.SelectSite(map.get("Site")))
			test.fail("Failed Select the site "+map.get("Site"));
		test.pass("Select the site : "+map.get("Site"));
		Thread.sleep(2000);
		String ele =  lastAlert.LastAlert();
		test.pass("Check the last alert");
		if(ele.equalsIgnoreCase("-"))
		{
			utils.WriteInExcel("There is no Last Alert",DataSet+1,"LastAlert","LastAlert",System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+prop.getProperty("FallAlert"));
			test.pass("There is no Last Alert");
		}
		else
		{
			String Alert_ID = LastAlertQueryTest.CheckLastIncident(map.get("TypeID"),map.get("Site"));
			if (Alert_ID!=null){
				utils.WriteInExcel(lastAlert.LastAlert(),DataSet+1,"LastAlert","LastAlert",System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+prop.getProperty("FallAlert"));
				test.pass("Last Alert Test : "+ele);
				if (!lastAlert.LastAlertClick())
					test.fail("Last Alert is not displayed");
				test.pass("Navigate to last alert");
				if(alertMngBasePage.getAlertDetailsPageTitle().contains(Alert_ID)){
					test.pass("last alert displayed and Verified from DB");
				}else {
					test.fail("last alert displayed in Fall Alerts Page is not matching Last Alert from DB");
				}
			}else {
				test.fail("Empty last alert extracted from DB");

			}
		}
	}

	}

