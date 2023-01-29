package caughtInDetection.TestCases;

import java.io.IOException;
import java.util.Map;

import fours.Testrail.testrail;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import caughtInDetection.Pages.Search;
import fours.base.BasePage;
import fours.utils.TestUtils;
import fours.utils.Utilities;
import login.Pages.LoginPage;

public class TC_61_ActivateCollisionTest extends BasePage{
	
	LoginPage loginPage;
	Search search;
	Utilities utilize;
	TestUtils utilswrite;
	
	public int DataSet = -1;

	public TC_61_ActivateCollisionTest() throws IOException {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {
		
		loginPage = new LoginPage();
		search = new Search();
		utilize = new Utilities();
		utilswrite = new TestUtils();
	}
	
	@DataProvider
	public Object[][] getExcelData() throws IOException, InvalidFormatException{
		Object data[][] = TestUtils.dataSupplier("Activate",System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+ prop.getProperty("CaughtInDetection"));
		return data;
	}
	
	@testrail(id = "16721")
	@Test(dataProvider ="getExcelData")
	public void ActivateCollision(Map<String,String> map) throws InterruptedException, IOException {
		
		DataSet++;
		
		test = extent.createTest("Caught-In Detection -- Activate Collision Zone");
		test.assignCategory("Caught in Detection");
		loginPage.dashboardLink();
		search.CaughtIn();
		test.pass("Navigate to Caught in detection");
		search.Manage();
		test.pass("Click Manage tab");
		search.InactiveStatus();
		test.pass("Filter Inactive data");
		search.Search(map.get("Search"));
		test.pass("Search for : "+map.get("Search"));
		search.Activate();
		test.pass("Activate :" +map.get("Search"));
		if(utilize.getConfirmMsg().equalsIgnoreCase("Successfully Activated collision zone"))
		{
			utilswrite.WriteInExcel(utilize.getConfirmMsg(), DataSet+1, "Activate","Status",System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+ prop.getProperty("CaughtInDetection"));
			test.pass("Collision is activated");
		}
		else
		{
			utilswrite.WriteInExcel("Collision is not deactivated", DataSet+1, "Activate", "Status",System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+ prop.getProperty("CaughtInDetection"));
			test.fail("Collision is not activated");
		}
	}

}
