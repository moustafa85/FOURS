package fallAlert.TestCases;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import fours.Testrail.testrail;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import fallAlert.Pages.FallPreventionAlertPage;
import fallAlert.Pages.FreeFallAlertPage;
import fours.base.BasePage;
import fours.utils.TestUtils;
import fours.utils.Utilities;
import login.Pages.LoginPage;

public class TC_22_FreeFallAlertPageTest extends BasePage{
	
	LoginPage loginPage;
	FreeFallAlertPage freeFallAlert;
	TestUtils utils;
	Utilities utilize;

	public TC_22_FreeFallAlertPageTest() throws IOException {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {

		loginPage = new LoginPage();
		freeFallAlert = new FreeFallAlertPage();
		utils = new TestUtils();
		utilize = new Utilities();
	}
	
	@Test
	@testrail(id = "16674")
	public void AlertTest() throws InterruptedException, IOException {
		
		test = extent.createTest("Fall Alerts -- Free Fall alerts");
		test.assignCategory("Fall Alerts");

		loginPage.dashboardLink();
		
		freeFallAlert.FAlert();
		String ele =  freeFallAlert.FreeFallAlertCount();
		freeFallAlert.AlertMng();
		freeFallAlert.AlertType();
		driver.findElement(By.xpath("//li[@class='ant-pagination-total-text']")).click();
		utilize.todayDate();
		if(ele.equalsIgnoreCase("0"))
		{
			if(utilize.NoData().equals("No Data")) {
				String text ="Alert Management has No Data and there is no Free Fall Alert in Fall Alerts Page";
				utils.ExcelWrite(text,4,1,"FallAlerts",System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+prop.getProperty("FallAlert"));
				test.pass("Alert Management has No Data and there is no Free Fall Alert in Fall Alerts Page");
			}
		}
		
		else if (ele.equalsIgnoreCase(utilize.TotalCount()))
		{	
			String text = "Alerts are matching. Free Fall Alerts in Fall Alerts and Alert Management Page -- ";
			utilize.TotalCount();
			utils.ExcelWrite(text+utilize.TotalCount(),4,1,"FallAlerts",System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+prop.getProperty("FallAlert"));
			test.pass("Alerts are matching");
		}
		else
		{
			String text1 = "Alerts are not matching. Free Fall Alert in Fall Alerts Page -- ";
			String text2 = ", Free Fall Alert in Alert Management Page -- ";
			String ele2 =  utilize.TotalCount();
			String tx = text1 +""+ ele +""+ text2 +""+ ele2;
			utils.ExcelWrite(tx,4,1,"FallAlerts",System.getProperty("user.dir")+"\\"+prop.getProperty("Environment")+prop.getProperty("FallAlert"));
			test.pass("Alerts are not matching");
		}
		
	}

}
