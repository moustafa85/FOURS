package device.TestCases;

import java.io.IOException;
import java.util.Map;

import fours.Testrail.testrail;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import device.pages.ActivateDevicePage;
import device.pages.DeviceBasePage;
import fours.base.BasePage;
import fours.utils.TestUtils;
import fours.utils.Utilities;
import login.Pages.LoginPage;

public class TC_101_ActivateDevicePageTest extends BasePage{
	
	LoginPage loginPage;
	ActivateDevicePage activateDevice;
	TestUtils utils;
	DeviceBasePage deviceBasePage;
	Utilities utilize;
	
	public int DataSet = -1;

	public TC_101_ActivateDevicePageTest() throws IOException {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {
		
		loginPage = new LoginPage();
		activateDevice = new ActivateDevicePage();
		utils = new TestUtils();
		utilize = new Utilities();
		deviceBasePage = new DeviceBasePage();
	}
	
	@DataProvider
	public Object[][] getExcelData() throws IOException, InvalidFormatException{
		Object data[][] = TestUtils.dataSupplier("ActivateDevice", System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+prop.getProperty("DeviceFilePath"));
		return data;
	}
	@testrail(id = "16645,16810,16867,16828,16819,16885,16876")
	@Test(dataProvider="getExcelData")
	public void ActivateDevice(Map<String,String> map) throws InterruptedException, IOException {

		DataSet++;
		
		test = extent.createTest("Activate Device");
		test.assignCategory("Devices");

		loginPage.dashboardLink();
		deviceBasePage.DeviceModule();
		activateDevice.InactiveStatus();
		deviceBasePage.Search(map.get("DeviceID"));
		activateDevice.Activate();
		if(utilize.getConfirmMsg().equalsIgnoreCase("Successfully activated device"))
		{
			utils.WriteInExcel(utilize.getConfirmMsg(), DataSet+1, "ActivateDevice","Status", System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+prop.getProperty("DeviceFilePath"));
			test.pass("Device is activated");
		}
		else
		{
			utils.WriteInExcel("Device is not activated", DataSet+1, "ActivateDevice", "Status", System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+prop.getProperty("DeviceFilePath"));
			test.pass("Device is not activated");
		}
	}

}
