package dashboard.TestCases;

import java.io.IOException;
import java.util.Map;

import fours.Testrail.testrail;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Dashboard.Pages.EnlargePage;
import Dashboard.Pages.ZoomPage;
import fours.base.BasePage;
import fours.utils.TestUtils;
import fours.utils.Utilities;
import login.Pages.LoginPage;

public class TC_09_ZoomTest extends BasePage{
	
	LoginPage loginPage;
	ZoomPage zoom;
	TestUtils utils;
	Utilities utilize;

	public TC_09_ZoomTest() throws IOException {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {
		
		loginPage = new LoginPage();
		zoom = new ZoomPage();
		utils = new TestUtils();
		utilize = new Utilities();
	}
	
	@DataProvider
	public Object[][] getExcelData() throws IOException, InvalidFormatException{
		Object data[][] = TestUtils.dataSupplier("zoom",System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+ prop.getProperty("Dashboard"));
		return data;
	}
	@testrail(id = "16675")
	@Test(dataProvider="getExcelData")
	public void ZoomTesting(Map<String,String> map) throws InterruptedException, IOException {
		
		test = extent.createTest("Dashboard -- Map Zoom ");
		test.assignCategory("Dashboard");
		loginPage.dashboardLink();


		utilize.PageScroller(0, 300);
		
		String strTest = map.get("Zoom");
	    int iTest = Integer.parseInt(strTest);
		
		for(int i = 1;i<=iTest;i++)
		{
			zoom.ZoomOut();
			//System.out.println("Zoom Out - " +i);
			//Thread.sleep(1000);
			utils.ExcelWrite("Zoom Out - "+iTest+" times",1,1,"zoom",System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+ prop.getProperty("Dashboard"));
		}
		//Thread.sleep(2000);
		test.pass("Map Zoom Out test passed");
		Thread.sleep(4000);

		for(int i=1;i<=iTest;i++)
		{

			zoom.ZoomIn();
			//System.out.println("Zoom In - " +i);
			//Thread.sleep(1000);
			utils.ExcelWrite("Zoom In - "+iTest+" times",1,2,"zoom",System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+  prop.getProperty("Dashboard"));
		}
		//Thread.sleep(2000);
		test.pass("Map Zoom In test passed");

}

}
