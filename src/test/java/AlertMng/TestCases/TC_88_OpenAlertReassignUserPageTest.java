package AlertMng.TestCases;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Map;

import fours.Testrail.testrail;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import AlertMng.Pages.actions.AlertMngBasePage;
import AlertMng.Pages.actions.OpenAlertReassignUserPage;
import fours.base.BasePage;
import fours.utils.TestUtils;
import fours.utils.Utilities;
import login.Pages.LoginPage;

public class TC_88_OpenAlertReassignUserPageTest extends BasePage {

	public TC_88_OpenAlertReassignUserPageTest() throws IOException {
		super();
	}
	
	LoginPage loginPage;
	TestUtils utilswrite;
	OpenAlertReassignUserPage assignUser;
	AlertMngBasePage AlertBasePage;
	Utilities utilize;
	
	public int DataSet = -1;
	
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {
		//
		loginPage = new LoginPage();
		utilswrite = new TestUtils();
		assignUser = new OpenAlertReassignUserPage();
		AlertBasePage = new AlertMngBasePage();
		utilize = new Utilities();
	}
	
	@DataProvider
	public Object[][] getExcelData() throws IOException, InvalidFormatException{
		Object data[][] = TestUtils.dataSupplier("OpenReassignUser",System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+ prop.getProperty("AlertMngFile"));
		return data;
	}

	/**
	 *
	 * @throws InterruptedException
	 * @throws IOException
	 * @throws AWTException
	 */
	@testrail(id = "16730,28776")
	@Test(dataProvider="getExcelData",dependsOnGroups={"generateAlerts"})
	public void ReassignAlertMngTesting(Map<String, String> map) throws InterruptedException, IOException, AWTException {
		DataSet++;
		test = extent.createTest("Alert Management -- Reassign user for assigned open alert");
		test.assignCategory("Alert Management");
		loginPage.dashboardLink();
		AlertBasePage.AlertMng();
		test.pass("Navigate to Alert Management Page");
		AlertBasePage.Search(map.get("AlertId"));
		test.pass("Search For Alert: "+map.get("AlertId"));
		AlertBasePage.openAlertDetailsPage();
		test.pass("Click Alert Detail button");
		assignUser.Reassignbtn();
		test.pass("Click Reassign button");
		AlertBasePage.AssignUser(map.get("UserId"));
		test.pass("Entre Assigned User ID :"+map.get("UserId"));
		Robot rb = new Robot();
		rb.keyPress(KeyEvent.VK_ENTER);
		AlertBasePage.Assign();
		test.pass("Click Assign Button");
		if(utilize.getConfirmMsg().equalsIgnoreCase("Successfully Reassigned Alert"))
		{
			utilswrite.WriteInExcel(utilize.getConfirmMsg(), DataSet+1, "OpenReassignUser","Status",System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+ prop.getProperty("AlertMngFile"));
			test.pass("User is reassigned");
		}
		else
		{
			utilswrite.WriteInExcel("User is not reassigned", DataSet+1, "OpenReassignUser", "Status",System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+prop.getProperty("AlertMngFile"));
			test.pass("User is not reassigned");
		}
	}

}
