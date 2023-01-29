package siteMonitoring.TestCases;

import java.awt.AWTException;
import java.io.IOException;
import java.util.Map;

import fours.Testrail.testrail;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import fours.base.BasePage;
import fours.utils.TestUtils;
import fours.utils.Utilities;
import login.Pages.LoginPage;
import siteMonitoring.Pages.AddNewChildSite;
import siteMonitoring.Pages.AssignReassign;

public class TC_85_AssignReassignBeaconTest extends BasePage{

	public TC_85_AssignReassignBeaconTest() throws IOException {
		super();
	}
	
	LoginPage loginPage;
	AssignReassign assign;
	TestUtils utils;
	Utilities utilize;
	
	public int DataSet = -1;
	
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {
		
		loginPage = new LoginPage();
		assign = new AssignReassign();
		utils = new TestUtils();
		utilize = new Utilities();
	}
	
	@DataProvider
	public Object[][] getExcelData() throws IOException, InvalidFormatException{
		Object data[][] = TestUtils.dataSupplier("AssignBeacon",System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+ prop.getProperty("SiteMonitoring"));
		return data;
	}
	@testrail(id = "16707")
	@Test(dataProvider ="getExcelData")
	public void BeaconTest(Map<String,String> map) throws InterruptedException, IOException, AWTException {
		
		DataSet++;
		
		test = extent.createTest("Site Monitoring -- Assign and Reassign Beacon Test");
		test.assignCategory("Site Monitoring");
		loginPage.dashboardLink();
		assign.SM();
		assign.SelectSite(map.get("Site"));
		assign.Manage();
		assign.AssignBeaconButton();
		assign.SelectBeaconDevice(map.get("DeviceId"));
		assign.Beacon();
		if(utilize.getConfirmMsg().equals("Successfully assigned device"))
		{
			
				utils.WriteInExcel(utilize.getConfirmMsg(), DataSet+1, "AssignBeacon","Status",System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+prop.getProperty("SiteMonitoring"));
				test.pass("Successfully assigned device");
			
		}
		else
		{
			utils.WriteInExcel(utilize.getConfirmMsg(), DataSet+1, "AssignBeacon","Status",System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+prop.getProperty("SiteMonitoring"));
			test.pass("Device is not assigned successfully");
		}
		
	}

}
