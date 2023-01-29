package fallAlert.TestCases;

import java.io.IOException;
import java.util.Map;

import fours.Testrail.testrail;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import fallAlert.Pages.ManagePage;
import fours.base.BasePage;
import fours.utils.TestUtils;
import fours.utils.Utilities;
import login.Pages.LoginPage;

public class TC_29_FallPrevActivate extends BasePage{
	
	LoginPage loginPage;
	ManagePage mnPage;
	Utilities utilize;
	TestUtils utils;
	
	public int DataSet = -1;

	public TC_29_FallPrevActivate() throws IOException {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {
		
		loginPage = new LoginPage();
		mnPage = new ManagePage();
		utilize = new Utilities();
		utils = new TestUtils();
	}
	
	@DataProvider
	public Object[][] getExcelData() throws IOException, InvalidFormatException{
		Object data[][] = TestUtils.dataSupplier("FallPrevActivate",System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+ prop.getProperty("FallAlert"));
		return data;
	}
	
	@Test(dataProvider ="getExcelData")
	@testrail(id = "16680")

	public void ActivateTest(Map<String,String> map) throws InterruptedException, IOException {
		
		DataSet++;
		
		test = extent.createTest("Fall Prevention -- Activate Test");
		test.assignCategory("Fall Alerts");

		loginPage.dashboardLink();
		
		mnPage.FAlert();
		mnPage.Manage();
		mnPage.FallPrev(map.get("FallPrev"));
		mnPage.FreeFall(map.get("FreeFall"));
		mnPage.search(map.get("Search"));
		Thread.sleep(2000);
		mnPage.FallPrevToggle();
	    if(utilize.getConfirmMsg().equals("Successfully updated worker"))
		{
			utils.WriteInExcel("Activated--"+utilize.getConfirmMsg(), DataSet+1, "FallPrevActivate","Status",System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+ prop.getProperty("FallAlert"));
			test.pass("Fall Prevention is activated");
		}
		else
		{
			utils.WriteInExcel("Not Activated--"+utilize.getConfirmMsg(), DataSet+1, "FallPrevActivate","Status",System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+prop.getProperty("FallAlert"));
			test.pass("Fall Prevention is not activated");
		}
		
}

}
