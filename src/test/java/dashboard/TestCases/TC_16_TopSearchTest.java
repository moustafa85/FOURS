package dashboard.TestCases;

import java.io.IOException;
import java.util.Map;

import fours.Testrail.testrail;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Dashboard.Pages.TopSearch;
import fours.base.BasePage;
import fours.utils.TestUtils;
import fours.utils.Utilities;
import login.Pages.LoginPage;

public class TC_16_TopSearchTest extends BasePage{
	
	LoginPage loginPage;
	TopSearch topSearch;
	TestUtils utils;
	Utilities utilize;
	
	public int DataSet = -1;

	public TC_16_TopSearchTest() throws IOException {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {
		
		loginPage = new LoginPage();
		topSearch = new TopSearch();
		utils = new TestUtils();
		utilize = new Utilities();
	}
	
	@DataProvider
	public Object[][] getExcelData() throws IOException, InvalidFormatException{
		Object data[][] = TestUtils.dataSupplier("TopSearch", System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+prop.getProperty("Dashboard"));
		return data;
	}
	@testrail(id = "")
	@Test(dataProvider ="getExcelData")
	public void TopSearch(Map<String,String> map) throws InterruptedException, IOException {
		
		DataSet++;
		
		test = extent.createTest("Dashboard -- Top Search");
		test.assignCategory("Dashboard");
		loginPage.dashboardLink();
		topSearch.Search(map.get("AlertId"));
}

}
