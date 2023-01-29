package caughtInDetection.TestCases;

import java.awt.AWTException;
import java.io.IOException;
import java.util.Map;

import fours.Testrail.testrail;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import caughtInDetection.Pages.AddCollisionZone;
import fours.base.BasePage;
import fours.utils.TestUtils;
import fours.utils.Utilities;
import login.Pages.LoginPage;

public class TC_59_AddCollisionZoneTest extends BasePage{

	public TC_59_AddCollisionZoneTest() throws IOException {
		super();
	}
	
	LoginPage loginPage;
	AddCollisionZone collZone;
	TestUtils utils;
	Utilities utilize;
	
	public int DataSet = -1;
	
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {

		loginPage = new LoginPage();
		collZone = new AddCollisionZone();
		utils = new TestUtils();
		utilize = new Utilities();
	}
	
	
	@DataProvider
	public Object[][] getExcelData() throws IOException, InvalidFormatException{
		Object data[][] = TestUtils.dataSupplier("AddCollisionZone",System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+ prop.getProperty("CaughtInDetection"));
		return data;
	}
	
	@testrail(id = "16718,16734")
	@Test(dataProvider ="getExcelData")
	public void AddCollisionZone(Map<String,String> map) throws InterruptedException, IOException, AWTException {
		
		DataSet++;
		
		test = extent.createTest("Add collision zone");
		test.assignCategory("Caught in Detection");
		loginPage.dashboardLink();
		collZone.CaughtIn();
		test.pass("Navigate to Caught in detection page");
		collZone.Manage();
		test.pass("Click Manage tab");
		collZone.AddButton();
		test.pass("Click add button");
		collZone.Name(map.get("Name"));
		test.pass("Entre Name for thr collision zone: "+map.get("Name"));
		collZone.allowedWorker(map.get("AllowedWorker"));
		test.pass("Entre Allowed Worker : "+map.get("AllowedWorker"));
		collZone.mapArea(map.get("MapArea"));
		test.pass("Entre Map area: "+map.get("MapArea"));
		collZone.AddCollisionZone();
		test.pass("Submit the collision zone");
		if(utilize.getConfirmMsg().equals("Successfully created collision zone"))
		{
			utils.WriteInExcel(utilize.getConfirmMsg(), DataSet+1, "AddCollisionZone","Status",System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+ prop.getProperty("CaughtInDetection"));
			test.pass("Collision zone is added");
		}
		else
		{
			utils.WriteInExcel("Collision zone is not added", DataSet+1, "AddCollisionZone","Status",System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+ prop.getProperty("CaughtInDetection"));
			test.fail("Collision zone is not added");
		}
	}

}
