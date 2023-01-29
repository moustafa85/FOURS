package device.TestCases;

import java.awt.AWTException;
import java.io.IOException;
import java.util.Map;

import fours.Testrail.testrail;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import device.pages.DeviceBasePage;
import device.pages.Filters;
import fours.base.BasePage;
import fours.utils.TestUtils;
import fours.utils.Utilities;
import login.Pages.LoginPage;

public class TC_98_FilterTest extends BasePage{

	public TC_98_FilterTest() throws IOException {
		super();
	}
	
	LoginPage loginPage;
	DeviceBasePage deviceBasePage;
	Filters filter;
	Utilities utilize;
	
	public int DataSet = -1;
	
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {
		
		loginPage = new LoginPage();
		deviceBasePage = new DeviceBasePage();
		filter = new Filters();
		utilize = new Utilities();
	}
	
	@DataProvider
	public Object[][] getExcelData() throws IOException, InvalidFormatException{
		Object data[][] = TestUtils.dataSupplier("Filters",System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+ prop.getProperty("DeviceFilePath"));
		return data;
	}
	@Test(dataProvider="getExcelData")
	@testrail(id = "16640,16862,16805,16823,16814,16880,16871")
	public void FilterTesting(Map<String,String> map) throws InterruptedException, AWTException {

		DataSet++;
		
		test = extent.createTest("Devices -- Filters");
		test.assignCategory("Devices");

		loginPage.dashboardLink();
		
		deviceBasePage.DeviceModule();
		filter.DeviceType(map.get("DeviceType"));
		filter.Status(map.get("Status"));
		filter.Site(map.get("Site"));
		filter.BatteryLevel(map.get("BatteryLevel"));
		filter.Download();
		filter.close();


	}

}
