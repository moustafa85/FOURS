package workerTracking.TestCases;

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
import workerTraking.Pages.MapZoom;

public class TC_41_MapZoomTest extends BasePage{
	
	LoginPage loginPage;
	MapZoom zoom;
	TestUtils utils;
	Utilities utilize;

	public TC_41_MapZoomTest() throws IOException {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {

		loginPage = new LoginPage();
		zoom = new MapZoom();
		utils = new TestUtils();
		utilize = new Utilities();
	}
	
	@DataProvider
	public Object[][] getExcelData() throws IOException, InvalidFormatException{
		Object data[][] = TestUtils.dataSupplier("zoom", System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+prop.getProperty("workerTracking"));
		return data;
	}
	@testrail(id = "16687")
	@Test(dataProvider="getExcelData")
	public void MapZoom(Map<String,String> map) throws InterruptedException, IOException {
		
		test = extent.createTest("Worker Tracking -- Map Zoom Test");
		test.assignCategory("Worker Tracking");
		loginPage.dashboardLink();
		zoom.WT();
		utilize.PageScroller(0, 300);
		
		String strTest = map.get("Zoom");
	    int iTest = Integer.parseInt(strTest);
		
		for(int i = 1;i<=iTest;i++)
		{
			zoom.ZoomOut();
			utils.ExcelWrite("Zoom Out - "+iTest+" times",1,1,"Zoom",System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+  prop.getProperty("workerTracking"));
		}
		test.pass("Map Zoom Out test passed");
		
		for(int i=1;i<=iTest;i++)
		{
			zoom.ZoomIn();
			utils.ExcelWrite("Zoom In - "+iTest+" times",1,2,"Zoom",System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+prop.getProperty("workerTracking"));
		}
		test.pass("Map Zoom In test passed");

}

}
