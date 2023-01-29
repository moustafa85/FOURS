package siteMonitoring.TestCases;

import java.io.IOException;
import java.util.Map;

import fours.Testrail.testrail;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import fours.base.BasePage;
import fours.utils.TestUtils;
import fours.utils.Utilities;
import login.Pages.LoginPage;
import siteMonitoring.Pages.AddNewChildSite;

public class TC_75_AddChildSiteTest extends BasePage{

	public TC_75_AddChildSiteTest() throws IOException {
		super();
	}

	LoginPage loginPage;
	AddNewChildSite childSite;
	TestUtils utils;
	Utilities utilize;
	
	public int DataSet = -1;
	
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {

		loginPage = new LoginPage();
		childSite = new AddNewChildSite();
		utils = new TestUtils();
		utilize = new Utilities();
	}
	
	@DataProvider
	public Object[][] getExcelData() throws IOException, InvalidFormatException{
		Object data[][] = TestUtils.dataSupplier("NewChild", System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+prop.getProperty("SiteMonitoring"));
		return data;
	}
	
	@Test(dataProvider ="getExcelData")
	@testrail(id = "16693")
	public void AddChildSiteTest(Map<String,String> map) throws InterruptedException, IOException {
		
		DataSet++;
		
		test = extent.createTest("Site Monitoring -- Add New Child Site");
		test.assignCategory("Site Monitoring");

		loginPage.dashboardLink();
		childSite.SM();
		childSite.SelectSite(map.get("SelectSite"));
		childSite.AddSite();
		childSite.Name(map.get("Name"));
		childSite.SiteBoundary(map.get("SiteBoundary"));
		childSite.SitePlan();
		childSite.SaveSite();
		if(utilize.getConfirmMsg().equals("Successfully added Site"))
		{

				utils.WriteInExcel(utilize.getConfirmMsg(), DataSet+1, "NewChild","Status",System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+ prop.getProperty("SiteMonitoring"));
				test.pass("Child Site is created successfully");
			
		}
		else
		{
			utils.WriteInExcel(utilize.getConfirmMsg(), DataSet+1, "NewChild","Status",System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+ prop.getProperty("SiteMonitoring"));
			test.pass("Child Site is not created successfully");
		}
		
	}
}
