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

import Dashboard.Pages.AlertFilterPage;
import Dashboard.Pages.AlertPage;
import fours.base.BasePage;
import fours.utils.TestUtils;
import fours.utils.Utilities;
import login.Pages.LoginPage;

public class TC_11_AlertPageTest extends BasePage{

	LoginPage loginPage;
	AlertPage alert;
	TestUtils utils;
	Utilities utilize;
	
	public int DataSet = -1;
	
	public TC_11_AlertPageTest() throws IOException {
		super();
	}

	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {
		
		loginPage = new LoginPage();
		alert = new AlertPage();
		utils = new TestUtils();
		utilize = new Utilities();
	}
	
	@DataProvider
	public Object[][] getExcelData() throws IOException, InvalidFormatException{
		Object data[][] = TestUtils.dataSupplier("Alert",System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+ prop.getProperty("Dashboard"));
		return data;
	}
	@testrail(id = "16669")
	@Test(dataProvider ="getExcelData")
	public void AlertPage(Map<String,String> map) throws InterruptedException, IOException {
		
		DataSet++;
		
		test = extent.createTest("Dashboard -- Alerts Click Test");
		test.assignCategory("Dashboard");
		loginPage.dashboardLink();
		Thread.sleep(4000);

		WebElement Element = driver.findElement(By.xpath("(//div[contains(.,'Alerts')])[13]"));
		
		utilize.ScrollToLocation(Element);
		alert.AlertClick(map.get("AlertId"));
//todo
}
}
