package device.TestCases;

import java.awt.AWTException;
import java.io.IOException;
import java.util.Map;

import fours.Testrail.testrail;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import device.pages.AddDevicePage;
import device.pages.DeviceBasePage;
import device.pages.EditDevicePage;
import fours.base.BasePage;
import fours.utils.TestUtils;
import fours.utils.Utilities;
import login.Pages.LoginPage;

public class TC_99_EditDevicePageTest extends BasePage{
	
	LoginPage loginPage;
	EditDevicePage editDevice;
	TestUtils utils;
	DeviceBasePage deviceBasePage;
	Utilities utilize;
	
	public int DataSet = -1;

	public TC_99_EditDevicePageTest() throws IOException {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {

		loginPage = new LoginPage();
		editDevice = new EditDevicePage();
		utils = new TestUtils();
		utilize = new Utilities();
		deviceBasePage = new DeviceBasePage();
	}
	
	@DataProvider
	public Object[][] getExcelData() throws IOException, InvalidFormatException{
		Object data[][] = TestUtils.dataSupplier("EditDevice",System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+ prop.getProperty("DeviceFilePath"));
		return data;
	}

	@testrail(id = "16884,16875,16644,16809,16866,16818")
	@Test(dataProvider ="getExcelData")
	public void EditDevice(Map<String,String> map) throws InterruptedException, IOException, AWTException {

		DataSet++;
		
		test = extent.createTest("Edit Device");
		test.assignCategory("Devices");

		loginPage.dashboardLink();
		deviceBasePage.DeviceModule();
		deviceBasePage.Search(map.get("DeviceID"));
		Thread.sleep(2000);
		if(editDevice.DeviceType().equals("Smart Guard"))
		{
			editDevice.EditDevice();
			editDevice.Longitude(map.get("Longitude"));
			editDevice.Latitude(map.get("Latitude"));
			editDevice.LoRaWanVersion(map.get("LoRaWan"));
			editDevice.DevClass(map.get("Devclass"));
			editDevice.AppEUI(map.get("ApplicationEUI"));
			editDevice.AppSessionKey(map.get("ApplicationSessionKey"));
		}
		else 
		{
			editDevice.EditDevice();
			editDevice.Longitude(map.get("Longitude"));
			editDevice.Latitude(map.get("Latitude"));
		}
		
		editDevice.Update();
		utils.WriteInExcel(utilize.getConfirmMsg(), DataSet+1, "EditDevice","Status", System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+prop.getProperty("DeviceFilePath"));
		test.pass("Device is updated");

	}

}
