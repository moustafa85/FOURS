package device.TestCases;

import java.awt.AWTException;
import java.io.IOException;
import java.util.Map;

import fours.Testrail.testrail;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import device.pages.DeviceBasePage;
import device.pages.EditDevicePage;
import fours.base.BasePage;
import fours.utils.TestUtils;
import fours.utils.Utilities;
import login.Pages.LoginPage;

public class TC_100_DeleteDevice extends BasePage{

	public TC_100_DeleteDevice() throws IOException {
		super();
	}
	
	LoginPage loginPage;
	TestUtils utils;
	DeviceBasePage deviceBasePage;
	Utilities utilize;
	
	public int DataSet = -1;
	
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {
		
		loginPage = new LoginPage();
		utils = new TestUtils();
		utilize = new Utilities();
		deviceBasePage = new DeviceBasePage();
	}
	
	@DataProvider
	public Object[][] getExcelData() throws IOException, InvalidFormatException{
		Object data[][] = TestUtils.dataSupplier("DeleteDevice",System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+ prop.getProperty("DeviceFilePath"));
		return data;
	}
	@testrail(id = "19262")
	@Test(dataProvider ="getExcelData")
	public void DeleteDeviceTesting(Map<String,String> map) throws InterruptedException, IOException, AWTException {

		DataSet++;
		
		test = extent.createTest("Delete Device");
		test.assignCategory("Devices");
		loginPage.dashboardLink();
		deviceBasePage.DeviceModule();
		deviceBasePage.StatusBoth();
		deviceBasePage.Search(map.get("Search"));
		Thread.sleep(2000);
		deviceBasePage.deleteDevice();
		deviceBasePage.deleteDeviceConfirm();

	}
	
	

}
