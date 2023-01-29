package device.TestCases;

import java.awt.AWTException;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

import fours.Testrail.testrail;
import org.apache.commons.text.CharacterPredicates;
import org.apache.commons.text.RandomStringGenerator;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import device.pages.AddDevicePage;
import device.pages.DeviceBasePage;
import fours.base.BasePage;
import fours.utils.TestUtils;
import fours.utils.Utilities;
import login.Pages.LoginPage;

public class TC_106_AddDevicePageTest extends BasePage{
	
	LoginPage loginPage;
	AddDevicePage addDevice;
	TestUtils utils;
	DeviceBasePage deviceBasePage;
	Utilities utilize;
	
	public int DataSet = -1;

	public TC_106_AddDevicePageTest() throws IOException {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {
		
		loginPage = new LoginPage();
		addDevice = new AddDevicePage();
		utils = new TestUtils();
		utilize = new Utilities();
		deviceBasePage = new DeviceBasePage();
	}
	
	@DataProvider
	public Object[][] getExcelData() throws IOException, InvalidFormatException{
		Object data[][] = TestUtils.dataSupplier("AddDevice",System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+ prop.getProperty("DeviceFilePath"));
		return data;
	}
	@testrail(id = "16637")
	@Test(dataProvider ="getExcelData")
	public void addDevice(Map<String,String> map) throws InterruptedException, IOException, AWTException {

		DataSet++;
		
		test = extent.createTest("Add Device");
		test.assignCategory("Devices");

		loginPage.dashboardLink();
		deviceBasePage.DeviceModule();
		addDevice.AddDevice();
		RandomStringGenerator generator = new RandomStringGenerator
				.Builder()
				.withinRange('0', 'z')
				.filteredBy(CharacterPredicates.LETTERS, CharacterPredicates.DIGITS)
				.build();
		String deviceUID = generator.generate(18);
		addDevice.DeviceUID(deviceUID);
		addDevice.deviceType(map.get("DeviceType"));
		addDevice.longitude(map.get("Longitude"));
		addDevice.Latitude(map.get("Latitude"));


		if(map.get("DeviceType").equals("Smart Guardian"))
		{
			addDevice.videoFeedId(map.get("VideoFeedId"));
		}
		else if(map.get("DeviceType").equals("Smart Guard"))
		{
			addDevice.LoRaWanVersion(map.get("LoRaWan"));
			addDevice.DevClass(map.get("DevClass"));
			addDevice.AppEUI(map.get("ApplicationEUI"));
			addDevice.AppSessionKey(map.get("ApplicationSessionKey"));
		}
		
		if(!addDevice.Submit()){
			test.fail("Failed to click Submit");
			Assert.fail("Failed to click Submit");
		}
		test.pass("Click Submit New Device");
		if(utilize.getConfirmMsg().contains("Device UID already exists."))
		{
			utils.WriteInExcel(deviceUID, DataSet+1, "AddDevice","DeviceUID", System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+prop.getProperty("DeviceFilePath"));
			utils.WriteInExcel("Device is not added--"+utilize.getConfirmMsg(), DataSet+1, "AddDevice","Status", System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+prop.getProperty("DeviceFilePath"));
			test.pass("Device is not added");
		}else if(utilize.getConfirmMsg().contains("Successfully added device"))
		{
			utils.WriteInExcel(utilize.getConfirmMsg(), DataSet+1, "AddDevice","Status", System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+prop.getProperty("DeviceFilePath"));
			utils.WriteInExcel(deviceUID, DataSet+1, "EditDevice","DeviceID", System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+prop.getProperty("DeviceFilePath"));
			utils.WriteInExcel(deviceUID, DataSet+1, "ActivateDevice","DeviceID", System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+prop.getProperty("DeviceFilePath"));
			utils.WriteInExcel(deviceUID, DataSet+1, "DeactivateDevice","DeviceID", System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+prop.getProperty("DeviceFilePath"));
			utils.WriteInExcel(deviceUID, DataSet+1, "Search","Search", System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+prop.getProperty("DeviceFilePath"));
			utils.WriteInExcel(deviceUID, DataSet+1, "DeleteDevice","Search", System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+prop.getProperty("DeviceFilePath"));
			test.pass("Device is added");
		}
		else
		{
			utils.WriteInExcel("Device is not added--"+utilize.getConfirmMsg(), DataSet+1, "AddDevice","Status", System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+prop.getProperty("DeviceFilePath"));
			test.pass("Device is not added");
		}

	}


}
