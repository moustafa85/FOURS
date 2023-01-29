package siteMonitoring.TestCases;

import java.io.IOException;

import fours.Testrail.testrail;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import fours.base.BasePage;
import fours.utils.Utilities;
import login.Pages.LoginPage;
import siteMonitoring.Pages.MapEnlarge;

public class TC_72_MapEnlargeTest extends BasePage{
	
	LoginPage loginPage;
	MapEnlarge enlarge;
	Utilities utilize;

	public TC_72_MapEnlargeTest() throws IOException {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {

		loginPage = new LoginPage();
		enlarge = new MapEnlarge();
		utilize = new Utilities();
	}
	
	@Test
	@testrail(id = "16698")
	public void MapEnlargeTest() throws InterruptedException, IOException {
		
		test = extent.createTest("Site Monitoring -- Map Enlarge");
		test.assignCategory("Site Monitoring");

		loginPage.dashboardLink();
		
		////loginPage.login(prop.getProperty("username"), prop.getProperty("password"));;		//Thread.sleep(2000);
		enlarge.SM();
		Thread.sleep(2000);
		WebElement Element = driver.findElement(By.xpath("//div[@class='separator'][contains(.,'Mapped Alerts')]"));
		//Thread.sleep(2000);
		utilize.ScrollToLocation(Element);
		//Thread.sleep(2000);
		enlarge.MapEnlargeButton();
		//Thread.sleep(2000);
		enlarge.MapCloseButton();
	}

}
