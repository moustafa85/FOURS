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
import fours.base.BasePage;
import fours.utils.TestUtils;
import fours.utils.Utilities;
import login.Pages.LoginPage;

public class TC_105_SearchTest extends BasePage{

	public TC_105_SearchTest() throws IOException {
		super();
	}
	
	LoginPage loginPage;
	DeviceBasePage deviceBasePage;
	
	public int DataSet = -1;
	
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {
		
		loginPage = new LoginPage();
		deviceBasePage = new DeviceBasePage();
	}
	
	@DataProvider
	public Object[][] getExcelData() throws IOException, InvalidFormatException{
		Object data[][] = TestUtils.dataSupplier("Search", System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+prop.getProperty("DeviceFilePath"));
		return data;
	}

	@testrail(id = "16881,16872,16641,16863,16815,16806,16824")
	@Test(dataProvider ="getExcelData")
	public void searchDevice(Map<String,String> map) throws InterruptedException, IOException, AWTException {

		DataSet++;
		
		test = extent.createTest("Search Device");
		test.assignCategory("Devices");
		loginPage.dashboardLink();
		deviceBasePage.DeviceModule();
		deviceBasePage.StatusBoth();
		deviceBasePage.Search(map.get("Search"));
		
		

	}

}
