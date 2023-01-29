package caughtInDetection.TestCases;

import java.awt.AWTException;
import java.io.IOException;
import java.util.Map;

import fours.Testrail.testrail;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.xmlbeans.impl.xb.xsdschema.All;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import caughtInDetection.Pages.EditCollisionZone;
import caughtInDetection.Pages.Search;
import fours.base.BasePage;
import fours.utils.TestUtils;
import fours.utils.Utilities;
import login.Pages.LoginPage;

public class TC_63_EditCollisionZoneTest extends BasePage{

	public TC_63_EditCollisionZoneTest() throws IOException {
		super();
	}

	LoginPage loginPage;
	EditCollisionZone collZone;
	Search search;
	TestUtils utils;
	Utilities utilize;
	
	public int DataSet = -1;
	
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {
		
		loginPage = new LoginPage();
		collZone = new EditCollisionZone();
		search = new Search();
		utils = new TestUtils();
		utilize = new Utilities();
	}
	
	
	@DataProvider
	public Object[][] getExcelData() throws IOException, InvalidFormatException{
		Object data[][] = TestUtils.dataSupplier("EditCollisionZone",System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+ prop.getProperty("CaughtInDetection"));
		return data;
	}

	/**
	 *
	 * @throws InterruptedException
	 * @throws IOException
	 * @throws AWTException
	 */
	@testrail(id = "16720")
	@Test(dataProvider ="getExcelData")
	public void EditCollisionZobe(Map<String,String> map) throws InterruptedException, IOException, AWTException {
		DataSet++;
		test = extent.createTest("Edit collision zone");
		test.assignCategory("Caught in Detection");
		loginPage.dashboardLink();
		collZone.CaughtIn();
		test.pass("Navigate to Caught in detection page");
		collZone.Manage();
		test.pass("Click Manage tab");
		search.StatusBoth();
		test.pass("Filter Both status");
		search.Search(map.get("Search"));
		test.pass("Search for :" +map.get("Search"));
		collZone.EditButton();
		test.pass("Click Edit Button");
		collZone.Name(map.get("Name"));
		test.pass("Update the name: "+map.get("Name"));
		collZone.allowedWorker(map.get("AllowedWorker"));
		test.pass("Entre allowed worker :"+ map.get("AllowedWorker"));
		collZone.mapArea(map.get("MapArea"));
		test.pass("Update the map area");
		collZone.UpdateButton();
		test.pass("Click Update button");
		
		if(utilize.getConfirmMsg().equals("Successfully updated Collision Zone"))
		{
			utils.WriteInExcel(utilize.getConfirmMsg(), DataSet+1, "EditCollisionZone","Status",System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+ prop.getProperty("CaughtInDetection"));
			test.pass("Collision zone is updated");
		}
		else
		{
			utils.WriteInExcel("Collision zone is not updated", DataSet+1, "EditCollisionZone","Status",System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+ prop.getProperty("CaughtInDetection"));
			test.fail("Collision zone is not updated");
		}
	}
}
