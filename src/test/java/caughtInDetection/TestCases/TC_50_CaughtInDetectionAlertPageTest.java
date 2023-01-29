package caughtInDetection.TestCases;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import fours.Testrail.testrail;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import caughtInDetection.Pages.CaughtInAlertCountPage;
import fours.base.BasePage;
import fours.utils.TestUtils;
import fours.utils.Utilities;
import login.Pages.LoginPage;
import workerTraking.Pages.OOGAlertPage;

public class TC_50_CaughtInDetectionAlertPageTest extends BasePage{
	
	LoginPage loginPage;
	CaughtInAlertCountPage caughtInAlert;
	TestUtils utils;
	Utilities utilize;

	public TC_50_CaughtInDetectionAlertPageTest() throws IOException {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {
		loginPage = new LoginPage();
		caughtInAlert = new CaughtInAlertCountPage();
		utils = new TestUtils();
		utilize = new Utilities();
	}

	/**
	 *
	 * @throws InterruptedException
	 * @throws IOException
	 */
	@testrail(id = "16709")
	@Test
	public void CaughtInDetectionAlertTest() throws InterruptedException, IOException {
		
		test = extent.createTest("Caught-In Detection -- Caught-In alerts");
		test.assignCategory("Caught in Detection");
		loginPage.dashboardLink();
		caughtInAlert.CaughtIn();
		test.pass("Navigate to Caught In detection page");
		String ele =  caughtInAlert.CaughtInCount();
		caughtInAlert.AlertMng();
		test.pass("Navigate to Alert Management page");
		caughtInAlert.AlertType();
		test.pass("Filter Caughr In detection Alerts ");
		driver.findElement(By.xpath("//li[@class='ant-pagination-total-text']")).click();
		utilize.todayDate();
		test.pass("Filter Today Alerts ");
		if(ele.equalsIgnoreCase("0"))
		{
			if(utilize.NoData().equals("No Data")) {
				String text ="Alert Management has No Data and there is no Caught-In Alert in Caught-In Detection Page";
				utils.ExcelWrite(text,3,1,"Alerts",System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+ prop.getProperty("CaughtInDetection"));
				test.pass("Alert Management has No Data and there is no Caught-In Alert in Caught-In Detection Page");
			}
		}
		
		else if (ele.equalsIgnoreCase(utilize.TotalCount()))
		{	
			String text = "Alerts are matching. Caught-In Alerts in Caught-In Detection and Alert Management Page -- ";
			utilize.TotalCount();
			utils.ExcelWrite(text+utilize.TotalCount(),3,1,"Alerts",System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+prop.getProperty("CaughtInDetection"));
			test.pass("Alerts are matching");
		}
		else
		{
			String text1 = "Alerts are not matching. Caught-In Alert in Caught-In Detection Page -- ";
			String text2 = ", Caught-In Alert in Alert Management Page -- ";
			String ele2 =  utilize.TotalCount();
			String tx = text1 +""+ ele +""+ text2 +""+ ele2;
			utils.ExcelWrite(tx,3,1,"Alerts",System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+prop.getProperty("CaughtInDetection"));
			test.fail("Alerts are not matching");
		}
		
	}

}
