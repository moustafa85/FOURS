package worker.TestCases;

import java.awt.AWTException;
import java.io.IOException;
import java.util.Map;

import fours.Testrail.testrail;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import fours.base.BasePage;
import fours.utils.TestUtils;
import fours.utils.Utilities;
import login.Pages.LoginPage;
import workers.pages.AssignDevicePage;
import workers.pages.WorkerBasePage;

public class TC_88_AssignDevicePageTest extends BasePage{
	
	LoginPage loginPage;
	AssignDevicePage assignDevice;
	TestUtils utils;
	WorkerBasePage workerBasePage;
	Utilities utilize;
	
	public int DataSet = -1;

	public TC_88_AssignDevicePageTest() throws IOException {
		super();
	}

	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {
		
		loginPage = new LoginPage();
		assignDevice = new AssignDevicePage();
		utils = new TestUtils();
		workerBasePage = new WorkerBasePage();
		utilize = new Utilities();
	}
	
	@DataProvider
	public Object[][] getExcelData() throws IOException, InvalidFormatException{
		Object data[][] = TestUtils.dataSupplier("AssignDevice", System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+prop.getProperty("WorkerFilePath"));
		return data;
	}
	
	@Test(dataProvider ="getExcelData")
	@testrail(id = "16656,16931")
	public void AssignDeviceTesting(Map<String,String> map) throws InterruptedException, IOException, AWTException {

		DataSet++;
		
		test = extent.createTest("Assign Device for worker");
		test.assignCategory("Workers");

		loginPage.dashboardLink();


		workerBasePage.WorkersModule();
		workerBasePage.Search(map.get("WorkerId"));
		assignDevice.AssignDevice();
		assignDevice.SelectDevice(map.get("DeviceID"));
		assignDevice.Submit();
		if(utilize.getConfirmMsg().contains("Successfully assigned device"))
		{
			utils.WriteInExcel(utilize.getConfirmMsg(), DataSet+1, "AssignDevice","Status",System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+ prop.getProperty("WorkerFilePath"));
			test.pass("Device is assigned");
		}
		else
		{
			utils.WriteInExcel("Device is not assigned --"+utilize.getConfirmMsg(), DataSet+1, "AssignDevice","Status",System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+ prop.getProperty("WorkerFilePath"));
			test.pass("Device is not assigned");
		}

	}
}
