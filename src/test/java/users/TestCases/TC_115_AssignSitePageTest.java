package users.TestCases;

import java.awt.AWTException;
import java.io.IOException;
import java.util.Map;

import fours.Testrail.testrail;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import fours.base.BasePage;
import fours.utils.TestUtils;
import fours.utils.Utilities;
import login.Pages.LoginPage;
import users.Pages.AssignSitePage;
import users.Pages.UserBasePage;

public class TC_115_AssignSitePageTest extends BasePage{
	
	LoginPage loginPage;
	TestUtils utilswrite;
	AssignSitePage assignSite;
	UserBasePage userBasePage;
	Utilities utilize;
	
	public int DataSet = -1;

	public TC_115_AssignSitePageTest() throws IOException {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {
		
		loginPage = new LoginPage();
		utilswrite = new TestUtils();
		assignSite = new AssignSitePage();
		userBasePage = new UserBasePage();
		utilize = new Utilities();
	}
	
	@DataProvider
	public Object[][] getExcelData() throws IOException, InvalidFormatException{
		Object data[][] = TestUtils.dataSupplier("AssignSite", System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+prop.getProperty("FilePathUser"));
		return data;
	}
	@testrail(id = "19246")
	@Test(dataProvider="getExcelData")
	public void AssignSiteTesting(Map<String,String> map) throws IOException, InterruptedException, AWTException {

			DataSet++;	
			
			test = extent.createTest("User -- Assign site");
			test.assignCategory("Users");

			loginPage.dashboardLink();
			userBasePage.User();
			userBasePage.Search(map.get("Email"));
			assignSite.Site();
			assignSite.ClearAssignSite();
			assignSite.ClickonForm();
			assignSite.selectSiteByName(map.get("Sites"));
			assignSite.ClickonForm();
			assignSite.Submit();
			if(utilize.getConfirmMsg().equalsIgnoreCase("Site assigned successfully"))
			{
				utilswrite.WriteInExcel(utilize.getConfirmMsg(), DataSet+1, "AssignSite","Status",System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+ prop.getProperty("FilePathUser"));
				test.pass("Site is assigned");
			}
			else
			{
				utilswrite.WriteInExcel("Site is not assigned to user", DataSet+1, "AssignSite", "Status",System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+ prop.getProperty("FilePathUser"));
				test.pass("Site is not assigned");
			}

	}

}



