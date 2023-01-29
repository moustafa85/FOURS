package workerTracking.TestCases;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import fours.Testrail.testrail;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import fours.base.BasePage;
import fours.utils.TestUtils;
import fours.utils.Utilities;
import login.Pages.LoginPage;
import workerTraking.Pages.OOGAlertPage;

public class TC_37_OOGAlertPageTest extends BasePage{
	
	LoginPage loginPage;
	OOGAlertPage oogAlert;
	TestUtils utils;
	Utilities utilize;

	public TC_37_OOGAlertPageTest() throws IOException {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {

		loginPage = new LoginPage();
		oogAlert = new OOGAlertPage();
		utils = new TestUtils();
		utilize = new Utilities();
	}
	
	@Test
	@testrail(id = "16686")
	public void AlertTest() throws InterruptedException, IOException {
		
		test = extent.createTest("Worker Tracking -- OOG alerts");
		test.assignCategory("Worker Tracking");

		loginPage.dashboardLink();
		
		oogAlert.WT();
		String ele =  oogAlert.OOGCount();
		oogAlert.AlertMng();
		oogAlert.AlertType();
		driver.findElement(By.xpath("//li[@class='ant-pagination-total-text']")).click();
		if (!utilize.todayDate()) {
			test.fail("Date filter is failed");
			Assert.fail();
		}
		if(ele.equalsIgnoreCase("0"))
		{
			if(utilize.NoData().equals("No Data")) {
				String text ="Alert Management has No Data and there is no OOG Alert in Worker Tracking Page";
				utils.ExcelWrite(text,3,1,"Alerts",System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+  prop.getProperty("workerTracking"));
				test.pass("Alert Management has No Data and there is no OOG Alert in Worker Tracking Page");
			}
		}
		
		else if (ele.equalsIgnoreCase(utilize.TotalCount()))
		{	
			String text = "Alerts are matching. OOG Alerts in Worker Tracking and Alert Management Page -- ";
			utilize.TotalCount();
			utils.ExcelWrite(text+utilize.TotalCount(),3,1,"Alerts",System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+ prop.getProperty("workerTracking"));
			test.pass("Alerts are matching");
		}
		else
		{
			String text1 = "Alerts are not matching. OOG Alert in Worker Tracking Page -- ";
			String text2 = ", OOG Alert in Alert Management Page -- ";
			String ele2 =  utilize.TotalCount();
			String tx = text1 +""+ ele +""+ text2 +""+ ele2;
			utils.ExcelWrite(tx,3,1,"Alerts",System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+  prop.getProperty("workerTracking"));
			test.pass("Alerts are not matching");
		}
		
	}

}
