package siteMonitoring.TestCases;

import java.io.IOException;
import java.util.Map;

import fours.Testrail.testrail;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import fours.base.BasePage;
import fours.utils.TestUtils;
import fours.utils.Utilities;
import login.Pages.LoginPage;
import siteMonitoring.Pages.EditSite;

public class TC_77_ChildSiteFilterTest extends BasePage{

	public TC_77_ChildSiteFilterTest() throws IOException {
		super();
	}
	
	LoginPage loginPage;
	EditSite editSite;
	
	public int DataSet = -1;
	
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {

		loginPage = new LoginPage();
		editSite = new EditSite();
	}
	
	@DataProvider
	public Object[][] getExcelData() throws IOException, InvalidFormatException{
		Object data[][] = TestUtils.dataSupplier("FilterSite", System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+prop.getProperty("SiteMonitoring"));
		return data;
	}
	@testrail(id = "16693")
	@Test(dataProvider ="getExcelData")
	public void FilterSiteTest(Map<String,String> map) throws InterruptedException, IOException {
		
		DataSet++;
		
		test = extent.createTest("Site Monitoring --  Filter Site");
		test.assignCategory("Site Monitoring");
		loginPage.dashboardLink();
		editSite.SM();
		editSite.SelectSite(map.get("SelectSite"));
	}

}
