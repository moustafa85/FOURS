package device.TestCases;

import java.io.IOException;
import java.util.Map;

import fours.Testrail.testrail;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import device.pages.AddDevicePage;
import device.pages.DeviceBasePage;
import fours.base.BasePage;
import fours.utils.TestUtils;
import fours.utils.Utilities;
import login.Pages.LoginPage;

public class TC_104_DevicePaginationTest extends BasePage{

	LoginPage loginPage;
	DeviceBasePage deviceBasePage;
	Utilities utilize;
	
	public int DataSet = -1;
	
	public TC_104_DevicePaginationTest() throws IOException {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {

		loginPage = new LoginPage();
		deviceBasePage = new DeviceBasePage();
		utilize = new Utilities();
	}
	
	
	@DataProvider
	public Object[][] getExcelData() throws IOException, InvalidFormatException{
		Object data[][] = TestUtils.dataSupplier("Pagination", System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+prop.getProperty("DeviceFilePath"));
		return data;
	}

	@testrail(id = "16643,16826,16817,16865,16883,16874")
	@Test(dataProvider ="getExcelData")
	public void Pagination(Map<String,String> map) throws InterruptedException, IOException {
		
		DataSet++;
		
		test = extent.createTest("Device Pagination");
		test.assignCategory("Devices");

		loginPage.dashboardLink();
		deviceBasePage.DeviceModule();
		if(utilize.Pagination(map.get("PageType"), map.get("PageNo"),map.get("LastPageNo")))
			test.pass("Verify Pagination functionality ");
		else
			test.fail("Pagination Functionality failed");
		
	}

}
