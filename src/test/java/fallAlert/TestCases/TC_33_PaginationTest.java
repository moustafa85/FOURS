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

public class TC_33_PaginationTest extends BasePage{
	
	LoginPage loginPage;
	Utilities utilize;
	ManagePage mPage;
	
	public int DataSet = -1;

	public TC_33_PaginationTest() throws IOException {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {
		
		loginPage = new LoginPage();
		utilize = new Utilities();
		mPage = new ManagePage();
	}
	
	@DataProvider
	public Object[][] getExcelData() throws IOException, InvalidFormatException{
		Object data[][] = TestUtils.dataSupplier("Pagination",System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+ prop.getProperty("FallAlert"));
		return data;
	}
	
	@Test(dataProvider ="getExcelData")
	@testrail(id = "16679")
	public void Pagination(Map<String,String> map) throws InterruptedException, IOException {
		
		DataSet++;
		
		test = extent.createTest("Fall Alerts -- Pagination");
		test.assignCategory("Fall Alerts");

		loginPage.dashboardLink();
		
		mPage.FAlert();
		mPage.Manage();

		if(utilize.Pagination(map.get("PageType"), map.get("PageNo"),map.get("LastPageNo")))
			test.pass("Verify Pagination functionality ");
		else
			test.fail("Pagination Functionality failed");

}

}
