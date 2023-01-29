package fallAlert.TestCases;

import java.io.IOException;

import fours.Testrail.testrail;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import fallAlert.Pages.EnlargePage;
import fours.base.BasePage;
import fours.utils.Utilities;
import login.Pages.LoginPage;

public class TC_25_EnlargePageTest extends BasePage{
	
	LoginPage loginPage;
	EnlargePage enlarge;
	Utilities utilize;

	public TC_25_EnlargePageTest() throws IOException {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {
		
		loginPage = new LoginPage();
		enlarge = new EnlargePage();
		utilize = new Utilities();
	}
	
	@Test
	@testrail(id = "16676")
	public void EnlargeTest() throws InterruptedException, IOException {
		
		test = extent.createTest("Fall Alerts -- Enlarge");
		test.assignCategory("Fall Alerts");

		loginPage.dashboardLink();
		enlarge.FAlert();
		Thread.sleep(2000);
		WebElement Element = driver.findElement(By.xpath("//div[@class='separator'][contains(.,'Mapping Alerts')]"));
		utilize.ScrollToLocation(Element);
		enlarge.MapEnlarge();
		enlarge.MapEnlargeClose();
		WebElement Element2 = driver.findElement(By.xpath("//div[@class='separator'][contains(.,'Analytics')]"));
		utilize.ScrollToLocation(Element2);
		enlarge.FallAlertMapEnlarge();
		enlarge.FallAlertMapEnlargeClose();
		enlarge.WorkerTypeMapEnlarge();
		enlarge.WorkerTypeMapEnlargeClose();
		enlarge.WorkerMapEnlarge();
		enlarge.WorkerMapEnlargeClose();
		enlarge.SiteMapEnlarge();
		enlarge.SiteMapEnlargeClose();

	}

}
