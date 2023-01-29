package workerTracking.TestCases;

import java.io.IOException;

import fours.Testrail.testrail;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import fours.base.BasePage;
import fours.utils.Utilities;
import login.Pages.LoginPage;
import workerTraking.Pages.MapEnlarge;

public class TC_40_MapEnlargeTest extends BasePage {
	
	LoginPage loginPage;
	MapEnlarge enlarge;
	Utilities utilize;

	public TC_40_MapEnlargeTest() throws IOException {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {
		
		loginPage = new LoginPage();
		enlarge = new MapEnlarge();
		utilize = new Utilities();
	}
	
	@Test
	@testrail(id = "16687")
	public void MapEnalrgeTest() throws InterruptedException, IOException {
		
		test = extent.createTest("Worker Tracking -- Map Enlarge");
		test.assignCategory("Worker Tracking");

		loginPage.dashboardLink();
		enlarge.WT();
		Thread.sleep(4000);
		WebElement Element = driver.findElement(By.xpath("//div[@class='separator'][contains(.,'System Alerts')]"));
		utilize.ScrollToLocation(Element);
		enlarge.MapEnlargeButton();
		enlarge.MapCloseButton();
	}

}
