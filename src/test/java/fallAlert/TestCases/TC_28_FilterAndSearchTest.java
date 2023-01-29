package fallAlert.TestCases;

import java.awt.AWTException;
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

public class TC_28_FilterAndSearchTest extends BasePage{
	
	LoginPage loginPage;
	ManagePage mnPage;
	Utilities utilize;
	
	public int DataSet = -1;

	public TC_28_FilterAndSearchTest() throws IOException {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {

		loginPage = new LoginPage();
		mnPage = new ManagePage();
		utilize = new Utilities();
	}
	
	@DataProvider
	public Object[][] getExcelData() throws IOException, InvalidFormatException{
		Object data[][] = TestUtils.dataSupplier("ManagePage",System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+ prop.getProperty("FallAlert"));
		return data;
	}
	
	@Test(dataProvider="getExcelData")
	@testrail(id = "16678")
	public void FilterAndSearchTest(Map<String,String> map) throws InterruptedException, IOException, AWTException {

		DataSet++;
		
		test = extent.createTest("Fall Alert Manage Page -- Filter and Search");
		test.assignCategory("Fall Alerts");

		loginPage.dashboardLink();
		mnPage.FAlert();
		mnPage.Manage();
		mnPage.FallPrev(map.get("FallPrev"));
		mnPage.FreeFall(map.get("FreeFall"));
		mnPage.search(map.get("Search"));
	}

}
