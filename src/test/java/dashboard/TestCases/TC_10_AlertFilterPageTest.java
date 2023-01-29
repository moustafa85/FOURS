package dashboard.TestCases;

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

import Dashboard.Pages.AlertFilterPage;
import Dashboard.Pages.EnlargePage;
import fours.base.BasePage;
import fours.utils.TestUtils;
import fours.utils.Utilities;
import login.Pages.LoginPage;

public class TC_10_AlertFilterPageTest extends BasePage{
	
	LoginPage loginPage;
	AlertFilterPage alert;
	TestUtils utils;
	Utilities utilize;
	
	public int DataSet = -1;

	public TC_10_AlertFilterPageTest() throws IOException {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {
		
		loginPage = new LoginPage();
		alert = new AlertFilterPage();
		utils = new TestUtils();
		utilize = new Utilities();
	}
	
	@DataProvider
	public Object[][] getExcelData() throws IOException, InvalidFormatException{
		Object data[][] = TestUtils.dataSupplier("AlertsFilter",System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+prop.getProperty("Dashboard"));
		return data;
	}
	@testrail(id = "16677")
	@Test(dataProvider ="getExcelData")
	public void AlertFilter(Map<String,String> map) throws InterruptedException, IOException {
		
		DataSet++;
		
		test = extent.createTest("Dashboard -- Alerts Filter");
		test.assignCategory("Dashboard");
		loginPage.dashboardLink();
		Thread.sleep(4000);

		WebElement Element = driver.findElement(By.xpath("(//label[contains(.,'Site')])[2]"));
		
		utilize.ScrollToLocation(Element);
		

		alert.SelectSite(map.get("Site"));
		alert.Status(map.get("Status"));
		alert.AlertType(map.get("Types"));
		alert.TotalAlert();
		utils.WriteInExcel("Alerts after filter -- "+alert.TotalAlert(), DataSet+1, "AlertsFilter","TotalAlerts",System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+ prop.getProperty("Dashboard"));
		test.pass("Alert filter");
		alert.ClearFilter();

}

}
