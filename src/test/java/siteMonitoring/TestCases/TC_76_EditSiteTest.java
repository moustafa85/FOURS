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

public class TC_76_EditSiteTest extends BasePage{

	public TC_76_EditSiteTest() throws IOException {
		super();
	}
	
	LoginPage loginPage;
	EditSite editSite;
	TestUtils utils;
	Utilities utilize;
	
	public int DataSet = -1;
	
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {
		
		loginPage = new LoginPage();
		editSite = new EditSite();
		utils = new TestUtils();
		utilize = new Utilities();
	}
	
	@DataProvider
	public Object[][] getExcelData() throws IOException, InvalidFormatException{
		Object data[][] = TestUtils.dataSupplier("EditSite", System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+prop.getProperty("SiteMonitoring"));
		return data;
	}
	
	@Test(dataProvider ="getExcelData")
	@testrail(id = "16695")
	public void EditSiteTest(Map<String,String> map) throws InterruptedException, IOException {
		
		DataSet++;
		
		test = extent.createTest("Site Monitoring --  Edit Site");
		test.assignCategory("Site Monitoring");

		loginPage.dashboardLink();
		editSite.SM();
		editSite.SelectSite(map.get("SelectSite"));
		editSite.Edit();
		editSite.EditSite();
		editSite.EditName(map.get("Name"));
		editSite.editSiteBoundary(map.get("SiteBoundary"));
		editSite.SaveSite();
		if(utilize.getConfirmMsg().equals("Successfully updated Site"))
		{
			
				utils.WriteInExcel(utilize.getConfirmMsg(), DataSet+1, "EditSite","Status",System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+ prop.getProperty("SiteMonitoring"));
				test.pass("Site is edited successfully");
			
		}
		else
		{
			utils.WriteInExcel(utilize.getConfirmMsg(), DataSet+1, "EditSite","Status",System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+ prop.getProperty("SiteMonitoring"));
			test.pass("Site is not edited successfully");
		}
		
	}

}
